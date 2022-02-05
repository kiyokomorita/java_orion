package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet("/account/reviewdelete")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォームに入力されたパラメータを取得
		String paramId = request.getParameter("reviewCode");
		//int reviewApartmentCode = Integer.parseInt(request.getParameter("reApartmentCode"));

		//ReviewDAOインスタンスの生成
		try (ReviewDAO reviewDAO = new ReviewDAO()) {
			//intへ変換※NumberFormatExceptionが発生する可能性あり。チェック対象。
			int id = Integer.parseInt(paramId);

			//指定したタスクを1件削除
			reviewDAO.reviewDelete(id);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//処理完了のメッセージをリクエスト属性に格納
		setMessage(request, "口コミの削除処理が完了しました。");

		//一覧画面を表示するためにSearchServletへフォワード
		String param = request.getParameter("reApartmentCode");
		int code = Integer.parseInt(param);

		if(request.getParameter("reviewFlag").equals("")) {
		RequestDispatcher rd = request.getRequestDispatcher("/apartmentdetail?apCode=" + code);
		rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher(request.getParameter("reviewFlag"));
			rd.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}

}