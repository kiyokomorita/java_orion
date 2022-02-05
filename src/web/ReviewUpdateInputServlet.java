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
 * Servlet implementation class ReviewUpdateInputServlet
 */
@WebServlet("/account/reviewupdateinput")
public class ReviewUpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//日本語が使用できるように文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//フォームに入力されたパラメータを取得
		int reviewCode = Integer.parseInt(request.getParameter("reCode"));
		int reviewApartmentCode = Integer.parseInt(request.getParameter("reApartmentCode"));
		String reviewApartmentName = request.getParameter("reApartmentName");
		String reviewContent = request.getParameter("reApartmentContent");
		String reviewFlag = request.getParameter("reFlag");

		//Reviewインスタンスを生成
		Review dto = new Review();

		//取得したパラメータを各フィールドに格納
		dto.setReviewCode(reviewCode);
		dto.setReviewApartmentCode(reviewApartmentCode);
		dto.setReviewApartmentName(reviewApartmentName);
		dto.setReviewContent(reviewContent);
		dto.setReviewFlag(reviewFlag);

		//Reviewインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("dto", dto);

		//確認画面へフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/account/review_update_input.jsp");
		rd.forward(request, response);
	}

}
