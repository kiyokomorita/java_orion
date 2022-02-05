package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApartmentDAO;
import dao.ReviewDAO;
import dto.Apartment;
import dto.Review;

/**
 * Servlet implementation class ApartmentDetailServlet
 */
@WebServlet("/apartmentdetail")
public class ApartmentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータから選択した物件コードを取得する
		String apartmentCode = request.getParameter("apCode");

		Apartment apartmentDto;


		//ApartmentDaoインスタンスの生成
		try (ApartmentDAO dao = new ApartmentDAO()) {

			//取得した物件コードをint型に変換
			int code = Integer.parseInt(apartmentCode);

			//物件コードを指定して詳細検索(DBから物件情報1行分をaccountDtoに格納)
			apartmentDto = dao.apartmentDetail(code);

			//Apartmentインスタンスの参照をリクエスト属性へ格納
			request.setAttribute("apartmentList", apartmentDto);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		//ReviewDAOインスタンス生成
		try (ReviewDAO dao = new ReviewDAO()) {

			//取得した物件コードをint型に変換
			int code = Integer.parseInt(apartmentCode);

			//物件コードを指定して対応する口コミを取得
			List<Review> list = dao.reviewDetail(code);
			//情報をリクエスト属性へ格納
			request.setAttribute("reviewList", list);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//物件詳細画面(apartment_detail.jsp)へフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/apartment_detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
