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
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dto.Account;

/**
 * Servlet implementation class AccountMypageUpdateServlet
 */
@WebServlet("/account/accountmypageupdate")
public class AccountMypageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//日本語が使用できるように文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//確認画面から引き継いだパラメータを取得
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		String accountLoginId = request.getParameter("accountLoginId");
		String accountPassword = request.getParameter("accountPassword");
		String accountMail = request.getParameter("accountMail");
		String accountName = request.getParameter("accountName");
		String recordDate = request.getParameter("accountAddDate");
		Timestamp accountAddDate = null;
		//日付文字列をTimestamp型に変換
		try {
			accountAddDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(recordDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String accountRoll = request.getParameter("accountRoll");


		//Accountインスタンスを生成
		Account accountDto = new Account();
		//取得したパラメータを各フィールドに格納
		accountDto.setAccountId(accountId);
		accountDto.setAccountLoginId(accountLoginId);
		accountDto.setAccountPassword(accountPassword);
		accountDto.setAccountMail(accountMail);
		accountDto.setAccountName(accountName);
		accountDto.setAccountAddDate(accountAddDate);
		accountDto.setAccountRoll(accountRoll);

		String message;

		//AccountDAOのインスタンス生成
		try (AccountDAO dao = new AccountDAO()) {
			//データベースの更新処理
			dao.accountMypageUpdateCheck(accountDto);

			//完了メッセージの作成
			message = "更新が完了しました";
			setMessage(request, message);

			//入力内容をセッションに格納
			HttpSession session = request.getSession();
			session.setAttribute("sessionAccountList", accountDto);
		} catch (Exception e) {
			//throw new ServletException(e);
			//エラーメッセージの作成
			message = "【エラー発生】入力内容を確認し、再度更新してください";
			setMessage(request, message);
		}

		//Accountインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("accountList", accountDto);

        // 遷移先
        String url = null;

        switch(message){
            case "更新が完了しました":    // マイページに移動
                url = "/account/account_mypage_detail.jsp";
                break;
            default:    // message = "更新が完了しました";以外の場合は入力画面に移動
                url = "/account/account_mypage_update_input.jsp";
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}