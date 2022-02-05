package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import dto.Review;

/**
 *口コミ検索一覧機能。タスク一覧を取得し、一覧結果へフォワードする。
 */
@WebServlet("/account/reviewsearch")
public class ReviewSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    //認証された情報（レルム）からログインIDを取得する
        String reviewUserLoginId = request.getRemoteUser();

         //インスタンスを生成
        Review apartmentDto = new Review();

        //取得したパラメータを各フィールドに格納
        apartmentDto.setReviewUserLoginId(reviewUserLoginId);

        //インスタンスの生成
        try (ReviewDAO dao = new ReviewDAO()) {
            //タスクのリストを一覧で取得
            List<Review> list = dao.reviewList(apartmentDto);

            //検索結果をリストに格納
            request.setAttribute("reviewList", list);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        //一覧画面(review_search.jsp)へフォワード
        RequestDispatcher rd = request.getRequestDispatcher("review_search.jsp");
        rd.forward(request, response);
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
