package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import dto.Review;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/account/reviewupdate")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
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
		String reviewApartmentName = request.getParameter("reApartmentName");
		String reviewUserLoginId = request.getParameter("reUserLoginId");
		String reviewContent = request.getParameter("reContent");
		String reviewName = request.getParameter("reName");

		//Reviewインスタンスを生成
		Review dto = new Review ();

		//取得したパラメータを各フィールドに格納
		dto.setReviewCode(reviewCode);
		dto.setReviewApartmentCode (reviewApartmentCode);
		dto.setReviewApartmentName (reviewApartmentName);
		dto.setReviewUserLoginId (reviewUserLoginId);
		dto.setReviewContent (reviewContent);
		dto.setReviewName (reviewName);

		request.setAttribute("dto", dto);

		String message;

		//ReviewDAOのインスタンス生成
		try (ReviewDAO dao = new ReviewDAO()) {
			//データベースの更新処理
			dao.reviewUpdate(dto);

			//完了メッセージの作成
			message = "口コミの更新が完了しました";
			setMessage(request, message);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		//Reviewインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("reviewUpdateList", dto);

        // 画面遷移
		if(request.getParameter("reFlag").equals("")) {
			String code = String.valueOf(reviewApartmentCode);
	        RequestDispatcher rd = request.getRequestDispatcher("/apartmentdetail?apCode=" + code);
	        rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher(request.getParameter("reFlag"));
			rd.forward(request, response);
		}
        }

	//完了のメッセージをリクエスト属性に格納
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}

}