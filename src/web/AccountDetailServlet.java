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
 * Servlet implementation class AccountDetailServlet
 */
@WebServlet("/accountdetail")
public class AccountDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータか選択したタスク番号を取得する
				String paramId = request.getParameter("acId");

				Account dto;

				//AccountDAOインスタンスの生成
				try (AccountDAO dao = new AccountDAO()) {
					//取得したタスク番号をint型に変換
					int id = Integer.parseInt(paramId);

					//タスク番号を指定して詳細検索
					dto = dao.accountDetail(id);
				} catch (Exception e) {
					throw new ServletException(e);
				}

				//検索結果をリクエスト属性に格納
				request.setAttribute("dto", dto);

				//詳細画面(detail.jsp)へフォワード
				RequestDispatcher rd = request.getRequestDispatcher("/account/account_new.jsp");
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
