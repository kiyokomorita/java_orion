package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApartmentDAO;
import dao.ReviewDAO;

/**
 * Servlet implementation class ApartmentDeleteServlet
 */
@WebServlet("/account/apartmentdelete")
public class ApartmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String paramId = request.getParameter("apartmentCode");

		//ApartmentDAOインスタンスの生成
		try (ApartmentDAO apartmentDAO = new ApartmentDAO()) {
			//intへ変換※NumberFormatExceptionが発生する可能性あり。チェック対象。
			int id = Integer.parseInt(paramId);

			//指定したタスクを1件削除
			apartmentDAO.apartmentDelete(id);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		try (ReviewDAO reviewDAO = new ReviewDAO()) {
			//intへ変換※NumberFormatExceptionが発生する可能性あり。チェック対象。
			int id = Integer.parseInt(paramId);

			//指定したタスクを1件削除
			reviewDAO.reviewApDelete(id);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//処理完了のメッセージをリクエスト属性に格納
		setMessage(request, "物件[ " + paramId + " ]の削除処理が完了しました。");

		//一覧画面を表示するためにSearchServletへフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/apartmentsearch");
		rd.forward(request, response);
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
