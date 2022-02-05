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
import dto.ApartmentSearch;

@WebServlet("/apartmentsearch")


public class ApartmentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try(ApartmentDAO dao = new ApartmentDAO()) {
	        List<ApartmentSearch> list = dao.apartmentList();

	        request.setAttribute("apartmentList", list);

	    } catch (Exception e) {
            throw new ServletException(e);
        }
	  //検索一覧を表示する
	    RequestDispatcher rd = request.getRequestDispatcher("/apartment_search.jsp");
	    rd.forward(request,  response);
	}
	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}