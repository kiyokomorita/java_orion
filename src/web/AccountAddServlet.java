package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dto.Account;
/**
 * Servlet implementation class AccountAddServlet
 */
@WebServlet("/accountadd")
public class AccountAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountAddServlet() {
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
		String accountLoginId = request.getParameter("acLoginId");
		String accountPassword = request.getParameter("acPassword");
		String accountMail = request.getParameter("acMail");
		String accountName = request.getParameter("acName");
		String accountRoll = request.getParameter("acRoll");

		//Accountインスタンスを生成
		Account dto = new Account ();

		//取得したパラメータを各フィールドに格納
		dto.setAccountLoginId (accountLoginId);
		dto.setAccountPassword (accountPassword);
		dto.setAccountMail (accountMail);
		dto.setAccountName (accountName);
		dto.setAccountRoll (accountRoll);

		String message;

		//AccountDAOのインスタンス生成
		try (AccountDAO dao = new AccountDAO ()) {

			//新規登録処理
			dao.accountAdd(dto);

			if(request.isUserInRole("admin")) {
				//完了メッセージの作成
				message = "新規登録が完了しました";
				setMessage(request, message);
			} else {
				//完了メッセージの作成
				message = "アカウント新規登録が完了しました";
				setMessage(request, message);
			}

		} catch (Exception e) {
			//throw new ServletException(e);
			//エラーメッセージの作成
			message = "【エラー発生】入力内容を確認し、再度入力してください";
			setMessage(request, message);
		}

		//Accountインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("dto", dto);

        // 遷移先
        String url = null;

        switch(message){
        	case "新規登録が完了しました":    // アカウント一覧ページに移動
            url = "/account/accountsearch";
            break;
        	case "アカウント新規登録が完了しました":    // トップページに移動
                url = "/index.jsp";
                break;
            default:    // 上記以外の場合は入力画面に移動
                url = "/account_add_input.jsp";
                break;
        }

        // 画面遷移
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}


	//完了のメッセージをリクエスト属性に格納
	protected void setMessage(HttpServletRequest request, String message) {
		if(message == "アカウント新規登録が完了しました") {
			request.setAttribute("navMessage", message);
		} else {
			request.setAttribute("message", message);
		}
	}
}
