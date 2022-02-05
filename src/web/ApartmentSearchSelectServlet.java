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

/**
 * Servlet implementation class ApartmentSearchSelectServlet
 */
@WebServlet("/apartmentsearchselect")
public class ApartmentSearchSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentSearchSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //日本語が使用できるように文字コードを指定
        request.setCharacterEncoding("UTF-8");

        //フォームに入力されたパラメータを取得
        int apartmentPrice1 = Integer.parseInt(request.getParameter("apartmentPrice1"));
        int apartmentPrice2 = Integer.parseInt(request.getParameter("apartmentPrice2"));
        int apartmentNumber =Integer.parseInt(request.getParameter("apartmentNumber"));
        String apartmentPet = request.getParameter("apartmentPet");
        String apartmentLayout = request.getParameter("apartmentLayout");
        String apartmentAddress1 = request.getParameter("apartmentAddress1");
        String apartmentStatus = request.getParameter("apartmentStatus");
        String apartmentFreeword = request.getParameter("apartmentFreeword");
        String apartmentSort = request.getParameter("apartmentSort");

        if(apartmentPrice1 > apartmentPrice2) {
        	int test = apartmentPrice1;
        	apartmentPrice1 = apartmentPrice2;
        	apartmentPrice2 = test;
        }

         //ApartmentSearchインスタンスを生成
        ApartmentSearch formDto = new ApartmentSearch();

        //取得したパラメータを各フィールドに格納
        formDto.setApartmentPrice1(apartmentPrice1);
        formDto.setApartmentPrice2(apartmentPrice2);
        formDto.setApartmentNumber(apartmentNumber);
        formDto.setApartmentPet(apartmentPet);
        formDto.setApartmentLayout(apartmentLayout);
        formDto.setApartmentAddress1(apartmentAddress1);
        formDto.setApartmentStatus(apartmentStatus);
        formDto.setApartmentFreeword(apartmentFreeword);
        formDto.setApartmentSort(apartmentSort);

        //ApartmentDAOインスタンスの生成
        try (ApartmentDAO dao = new ApartmentDAO()) {
            //タスクのリストを一覧で取得
            List<ApartmentSearch> apartmentDto = dao.apartmentSearchSelect(formDto);

            //検索結果をリストに格納
            request.setAttribute("apartmentList",  apartmentDto);

            //検索後の結果を保持する用
            request.setAttribute("apartmentInput", formDto);


        } catch (Exception e) {
            throw new ServletException(e);
        }

        //一覧画面(apartment_search.jsp)へフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/apartment_search.jsp");
        rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void setMessage(HttpServletRequest request, String message) {
			request.setAttribute("message", message);
	}
}
