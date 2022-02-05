package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ApartmentDAO;
import dto.Apartment;

/**
 * Servlet implementation class ApartmentUpdateImageServlet
 */
@WebServlet("/account/apartmentupdateimage")
@MultipartConfig(location="//PC3119/images2")
public class ApartmentUpdateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
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
		//String apartmentImage = request.getParameter("apImage");
		String apartmentAddress1 = request.getParameter("apAddress1");
		String apartmentAddress2 = request.getParameter("apAddress2");
		String apartmentStatus = request.getParameter("apStatus");

		//Apartmentインスタンスを生成
		Apartment dto = new Apartment ();

		//取得したパラメータとファイル名をフィールドに格納
		dto.setApartmentCode (apartmentCode);
		dto.setApartmentName (apartmentName);
		dto.setApartmentDescription (apartmentDescription);
		dto.setApartmentNumber (apartmentNumber);
		dto.setApartmentPrice (apartmentPrice);
		dto.setApartmentPet (apartmentPet);
		dto.setApartmentLayout (apartmentLayout);
		dto.setApartmentAddress1 (apartmentAddress1);
		dto.setApartmentAddress2 (apartmentAddress2);
		dto.setApartmentStatus (apartmentStatus);

		request.setAttribute("dto", dto);

		//<input type="file" name="uploadfile"/>からMultipart形式のアップロードコンテンツの内容を取得
		Part part = request.getPart("uploadfile");

		//アップロードされたコンテンツ(Part)からファイル名部分を解析し、取得する
		String filename = null;
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			cd = cd.trim();
			log(cd);

			if (cd.startsWith("filename")) {
				//ファイル名は=の右側以降の文字列。
				//ただし利用環境によってはダブルクォーテーションが含まれているので、取り除く
				filename = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
				log("upload file:" + filename);
				break;
			}
		}

		//アップロードしたファイルを書き出す
		String message = null;
		if (filename != null) {
			log(">> file write start.");

			//アップロードされたファイル名は、OS依存のファイルパスなどを含んでいるので置換する。
			//\は/に置換し、その後ファイル名のみ抽出する。
			filename = filename.replace("\\", "/");

			int pos = filename.lastIndexOf("/");
			if (pos >= 0) {
				filename = filename.substring(pos + 1);
			}
			log("filename : " + filename);

			//ファイルの書き出し。書き出し先は@MultipartConfigのlocation属性で指定した場所。
			part.write(filename);


			//取得したパラメータとファイル名をフィールドに格納
			dto.setApartmentImage(filename);
			request.setAttribute("dto", dto);

			try (ApartmentDAO dao = new ApartmentDAO()) {
				//更新処理
				dao.apartmentUpdate(dto);

				//完了メッセージの作成
				message = "更新が完了しました";
				setMessage(request, message);
			} catch (Exception e) {
				//throw new ServletException(e);
				//エラーメッセージの作成
				message = "【エラー発生】入力内容を確認し、再度登録してください";
				setMessage(request, message);
			}

			//message = "[ " + filename + " ]のアップロードが完了しました";
		} else {
			log("upload filename is brank.");
			message = "【エラー発生】入力内容を確認し、再度登録してください";
			setMessage(request, message);
		}

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
