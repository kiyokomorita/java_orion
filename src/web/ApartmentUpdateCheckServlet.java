package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Apartment;

/**
 * Servlet implementation class ApartmentUpdateCheckServlet
 */
@WebServlet("/account/apartmentupdatecheck")
public class ApartmentUpdateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentUpdateCheckServlet() {
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
		int apartmentCode = Integer.parseInt(request.getParameter("apCode"));
		String apartmentName = request.getParameter("apName");
		String apartmentDescription = request.getParameter("apDescription");
		int apartmentNumber = Integer.parseInt(request.getParameter("apNumber"));
		int apartmentPrice = Integer.parseInt(request.getParameter("apPrice"));
		String apartmentPet = request.getParameter("apPet");
		String apartmentLayout = request.getParameter("apLayout");
		String apartmentImage = request.getParameter("apImage");
		String apartmentAddress1 = request.getParameter("apAddress1");
		String apartmentAddress2 = request.getParameter("apAddress2");
		String apartmentStatus = request.getParameter("apStatus");

		//Accountインスタンスを生成
		Apartment dto = new Apartment ();

		//取得したパラメータを各フィールドに格納
		dto.setApartmentCode (apartmentCode);
		dto.setApartmentName (apartmentName);
		dto.setApartmentDescription (apartmentDescription);
		dto.setApartmentNumber (apartmentNumber);
		dto.setApartmentPrice (apartmentPrice);
		dto.setApartmentPet (apartmentPet);
		dto.setApartmentLayout (apartmentLayout);
		dto.setApartmentImage (apartmentImage);
		dto.setApartmentAddress1 (apartmentAddress1);
		dto.setApartmentAddress2 (apartmentAddress2);
		dto.setApartmentStatus (apartmentStatus);

		request.setAttribute("dto", dto);

		RequestDispatcher rd =request.getRequestDispatcher("/account/apartment_update_check.jsp");
		rd.forward(request, response);
	}

}
