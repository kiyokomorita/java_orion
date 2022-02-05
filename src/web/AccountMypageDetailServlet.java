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
 * Servlet implementation class AccountMypageDetailServlet
 */
@WebServlet("/account/accountmypagedetail")
public class AccountMypageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//認証された情報（レルム）からログインIDを取得する
		String accountId = request.getRemoteUser();

		Account accountDto;

		//AccountDAOインスタンスの生成
		try (AccountDAO dao = new AccountDAO()) {

			//ログインIDを指定して詳細検索(DBからアカウント情報1行分をaccountDtoに格納)
			accountDto = dao.accountLogin(accountId);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//Accountインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("accountList", accountDto);

		//フォワード
		RequestDispatcher rd = request.getRequestDispatcher("/account/account_mypage_update_input.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}