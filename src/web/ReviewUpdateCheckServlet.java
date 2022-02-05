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
 * Servlet implementation class ReviewUpdateCheckServlet
 */
@WebServlet("/account/reviewupdatecheck")
public class ReviewUpdateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateCheckServlet() {
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
		int reviewCode = Integer.parseInt(request.getParameter("reCode"));
		int reviewApartmentCode = Integer.parseInt(request.getParameter("reApartmentCode"));
		String reviewUserLoginId = request.getParameter("reUserLoginId");
		String reviewContent = request.getParameter("reContent");
		String reviewName = request.getParameter("reName");
		String reviewApartmentName = request.getParameter("reApartmentName");
		String reviewFlag = request.getParameter("reFlag");

		//Reviewインスタンスを生成
		Review dto = new Review ();

		//取得したパラメータを各フィールドに格納
		dto.setReviewCode(reviewCode);
		dto.setReviewApartmentCode (reviewApartmentCode);
		dto.setReviewUserLoginId (reviewUserLoginId);
		dto.setReviewContent (reviewContent);
		dto.setReviewName (reviewName);
		dto.setReviewApartmentName (reviewApartmentName);
		dto.setReviewFlag (reviewFlag);

		request.setAttribute("dto", dto);

		//確認画面へフォワードする
		RequestDispatcher rd =request.getRequestDispatcher("review_update_check.jsp");
		rd.forward(request, response);
	}

}
