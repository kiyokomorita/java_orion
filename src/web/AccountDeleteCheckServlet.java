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
 * Servlet implementation class AccountDeleteCheckServlet
 */
@WebServlet("/account/accountdeletecheck")
public class AccountDeleteCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String paramId = request.getParameter("accountId");

		Account accountDto;

		//AccountDAOインスタンスの生成
		try (AccountDAO dao = new AccountDAO()) {
			int accountId = Integer.parseInt(paramId);
			accountDto = dao.accountDetail(accountId);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//Accountインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("accountList", accountDto);


		//トップページへフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/account/account_delete_check.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
