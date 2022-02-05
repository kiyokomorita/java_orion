package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Review;

/**
 * Servlet implementation class ReviewAddInputServlet
 */
@WebServlet("/account/reviewaddinput")
public class ReviewAddInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAddInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//日本語が使用できるように文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータから選択した物件コードを取得する
		int reviewApartmentCode = Integer.parseInt(request.getParameter("reApartmentCode"));
		String reviewApartmentName = request.getParameter("reApartmentName");


		//Reviewインスタンスを生成
		Review dto = new Review ();

		//取得したパラメータを各フィールドに格納
		dto.setReviewApartmentCode (reviewApartmentCode);
		dto.setReviewApartmentName (reviewApartmentName);


		request.setAttribute("dto", dto);

		RequestDispatcher rd =request.getRequestDispatcher("review_add_input.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
