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
 * Servlet implementation class ApartmentDeleteCheckServlet
 */
@WebServlet("/account/apartmentdeletecheck")
public class ApartmentDeleteCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentDeleteCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String paramId = request.getParameter("apartmentCode");

		Apartment apartmentDto;

		//AccountDAOインスタンスの生成
		try (ApartmentDAO dao = new ApartmentDAO()) {
			int apCode = Integer.parseInt(paramId);
			apartmentDto = dao.apartmentDetail(apCode);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//Accountインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("apartmentList",apartmentDto);


		//フォワード
		RequestDispatcher rd = request.getRequestDispatcher("/account/apartment_delete_check.jsp");
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
