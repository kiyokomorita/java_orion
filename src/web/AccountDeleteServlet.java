package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;

/**
 * Servlet implementation class AccountDeleteServlet
 */
@WebServlet("/account/accountdelete")
public class AccountDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		String sessionId = request.getParameter("sessionAccountId");

		String message;

		//AccountDAOインスタンスの生成
		try (AccountDAO accountDAO = new AccountDAO()) {
			//intへ変換※NumberFormatExceptionが発生する可能性あり。チェック対象。
			int id = Integer.parseInt(accountId);

			//指定したアカウントを1件削除
			accountDAO.accountDelete(id);

			//自身のIDを削除した場合はセッションの破棄
			if (accountId.equals(sessionId)) {
				HttpSession session = request.getSession(true);
			    session.invalidate();

			    // 退会メッセージを格納して、setMessageメソッドを実行
			    message = "退会処理が完了しました";
			    setMessage(request, message);
			} else {
				//処理完了のメッセージをリクエスト属性に格納
				message = "アカウント[ " + accountId + " ]の削除処理が完了しました";
				setMessage(request, message);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}

		// 遷移先
        String url = null;

        switch(message){
            case "退会処理が完了しました":    // トップページに移動
                url = "/index.jsp";
                break;
            default:    // 上記以外はアカウント一覧ページに移動
                url = "/account/accountsearch";
                break;
        }

        // 画面遷移
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//完了のメッセージをリクエスト属性に格納
	protected void setMessage(HttpServletRequest request, String message) {
		if(message == "退会処理が完了しました") {
			request.setAttribute("navMessage", message);
		} else {
			request.setAttribute("message", message);
		}
	}

}
