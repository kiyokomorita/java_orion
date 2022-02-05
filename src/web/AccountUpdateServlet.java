package web;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dto.Account;

/**
 * Servlet implementation class AccountUpdateServlet
 */
@WebServlet("/account/accountupdate")
public class AccountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//日本語が使用できるように文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//フォームに入力されたパラメータを取得
		int accountId = Integer.parseInt(request.getParameter("acId"));
		String accountLoginId = request.getParameter("acLoginId");
		String accountPassword = request.getParameter("acPassword");
		String accountMail = request.getParameter("acMail");
		String accountName = request.getParameter("acName");
		String accountRoll = request.getParameter("acRoll");
		String recordDate = request.getParameter("acAddDate");
		Timestamp accountAddDate = null;
		//日付文字列をTimestamp型に変換
		try {
			accountAddDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(recordDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//Accountインスタンスを生成
		Account dto = new Account ();

		//取得したパラメータを各フィールドに格納
		dto.setAccountId(accountId);
		dto.setAccountLoginId (accountLoginId);
		dto.setAccountPassword (accountPassword);
		dto.setAccountMail (accountMail);
		dto.setAccountName (accountName);
		dto.setAccountRoll (accountRoll);
		dto.setAccountAddDate (accountAddDate);

		String message;

		//AccountDAOのインスタンス生成
		try (AccountDAO dao = new AccountDAO ()) {

			//更新登録処理
			dao.accountUpdate(dto);

			//完了メッセージの作成
			message = "更新登録処理が完了しました";
			setMessage(request, message);
		} catch (Exception e) {
			//エラーメッセージの作成
			message = "【エラー発生】入力内容を確認し、再度入力してください";
			setMessage(request, message);
		}

		//Accountインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("dto", dto);

        // 遷移先
        String url = null;

        switch(message){
            case "更新登録処理が完了しました":    // 検索ページに移動
            	url = "/account/accountsearch";
                break;
            default:    // message = "更新登録処理が完了しました";以外の場合は入力画面に移動
            	url = "/account/account_update_input.jsp";
                break;
        }

        // 画面遷移
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}


	//完了のメッセージをリクエスト属性に格納
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}


}