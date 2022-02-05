package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApartmentDAO;
import dto.Apartment;

/**
 * Servlet implementation class ApartmentUpdateInputServlet
 */
@WebServlet("/account/apartmentupdateinput")
public class ApartmentUpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentUpdateInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータか選択したタスク番号を取得する
		String paramId = request.getParameter("apartmentCode");

		//Apartmentインスタンスを生成
		Apartment dto = new Apartment ();

		//ApartmentDAOインスタンスの生成
		try (ApartmentDAO dao = new ApartmentDAO()) {
			//取得したタスク番号をint型に変換
			int id = Integer.parseInt(paramId);

			//タスク番号を指定して詳細検索
			dto = dao.apartmentDetail(id);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//検索結果をリクエスト属性に格納
		request.setAttribute("dto", dto);

		RequestDispatcher rd =request.getRequestDispatcher("/account/apartment_update_input.jsp");
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
