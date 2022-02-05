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
 * Servlet implementation class ApartmentUpdateServlet
 */
@WebServlet("/account/apartmentupdate")
public class ApartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//日本語を表示するために文字コードを設定
		request.setCharacterEncoding("UTF-8");

		//フォームに入力されたパラメータを取得
		int apartmentCode = Integer.parseInt(request.getParameter("apCode"));
		String apartmentName = request.getParameter("apName");
		String apartmentDescription = request.getParameter("apDescription");
		int apartmentNumber = Integer.parseInt(request.getParameter("apNumber"));
		int apartmentPrice = Integer.parseInt(request.getParameter("apPrice"));
		String apartmentPet = request.getParameter("apPet");
		String apartmentLayout = request.getParameter("apLayout");
		String apartmentAddress1 = request.getParameter("apAddress1");
		String apartmentAddress2 = request.getParameter("apAddress2");
		String apartmentImage = request.getParameter("apImage");
		String apartmentStatus = request.getParameter("apStatus");

		//インスタンスの生成
		Apartment dto = new Apartment();

		//取得したパラメータを各フィールドに格納
		dto.setApartmentCode(apartmentCode);
		dto.setApartmentName(apartmentName);
		dto.setApartmentDescription(apartmentDescription);
		dto.setApartmentNumber(apartmentNumber);
		dto.setApartmentPrice(apartmentPrice);
		dto.setApartmentPet(apartmentPet);
		dto.setApartmentLayout(apartmentLayout);
		dto.setApartmentAddress1(apartmentAddress1);
		dto.setApartmentAddress2(apartmentAddress2);
		dto.setApartmentImage(apartmentImage);
		dto.setApartmentStatus(apartmentStatus);

		String message;

		//インスタンスの生成
		try (ApartmentDAO dao = new ApartmentDAO()) {
			//更新処理
			dao.apartmentUpdate(dto);

			//完了メッセージの作成
			message = "更新が完了しました";
			setMessage(request, message);
		} catch (Exception e) {
			//エラーメッセージの作成
			message = "【エラー発生】入力内容を確認し、再度登録してください";
			setMessage(request, message);
		}

		//Apartmentインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("dto", dto);

		// 遷移先
        String url = null;

        switch(message){
            case "更新が完了しました":    // 物件検索ページに移動
            	String code = String.valueOf(apartmentCode);
            	url = "/apartmentdetail?apartmentCode=" + code;
                break;
            default:    // 上記以外は入力画面に移動
                url = "/account/apartment_update_input.jsp";
                break;
        }

        // 画面遷移
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

	//完了のメッセージをリクエスト属性に格納
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}
}
