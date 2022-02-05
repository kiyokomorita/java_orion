package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;

/**
 * Servlet implementation class AccountAddCheckServlet
 */
@WebServlet("/accountaddcheck")
public class AccountAddCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountAddCheckServlet() {
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
		//int accountId = Integer.parseInt(request.getParameter("acId"));
		String accountLoginId = request.getParameter("acLoginId");
		String accountPassword = request.getParameter("acPassword");
		String accountMail = request.getParameter("acMail");
		String accountName = request.getParameter("acName");
		String accountRoll = request.getParameter("acRoll");

		//Accountインスタンスを生成
		Account dto = new Account ();

		//取得したパラメータを各フィールドに格納
		//dto.setAccountId (accountId);
		dto.setAccountLoginId (accountLoginId);
		dto.setAccountPassword (accountPassword);
		dto.setAccountMail (accountMail);
		dto.setAccountName (accountName);
		dto.setAccountRoll (accountRoll);

		request.setAttribute("dto", dto);

		RequestDispatcher rd =request.getRequestDispatcher("/account_add_check.jsp");
		rd.forward(request, response);
	}

}
