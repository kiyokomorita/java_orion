package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dto.Account;


/**
 * Servlet implementation class AccountSearchServlet
 */
@WebServlet("/account/accountsearch")
public class AccountSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Map<String, String> map = new HashMap<String, String>();

		if(!Objects.equals(request.getParameter("accountLoginId"), null)) {
				if(!request.getParameter("accountId").equals("")) {
					map.put("acId", request.getParameter("accountId"));
				}
		}

		if(!Objects.equals(request.getParameter("accountLoginId"), null)) {
			if(!request.getParameter("accountLoginId").equals("")) {
				map.put("acLoginId", request.getParameter("accountLoginId"));
			}
		}

		if(!Objects.equals(request.getParameter("accountMail"), null)) {
			if(!request.getParameter("accountMail").equals("")) {
				map.put("acMail", request.getParameter("accountMail"));
			}
		}

		if(!Objects.equals(request.getParameter("accountName"), null)) {
			if(!request.getParameter("accountName").equals("")) {
				map.put("acName", request.getParameter("accountName"));
			}
		}

		List<Account> list;

		try(AccountDAO dao = new AccountDAO()) {

			list = dao.accountSearch(map);
			//検索後のリストをリクエストに格納
		    request.setAttribute("accountList", list);
		    //検索後に選択を保存する用
		    request.setAttribute("accountInput", map);
		    } catch (Exception e) {
		    	throw new ServletException(e);
		    	}

			RequestDispatcher rd = request.getRequestDispatcher("/account/account_search.jsp");
			rd.forward(request,  response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
