package web;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;

/**
 * Servlet implementation class AccountMypageUpdateCheckServlet
 */
@WebServlet("/account/accountmypageupdatecheck")
public class AccountMypageUpdateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//日本語が使用できるように文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//フォームに入力されたパラメータを取得
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		String accountLoginId = request.getParameter("accountLoginId");
		String accountPassword = request.getParameter("accountPassword");
		String accountMail = request.getParameter("accountMail");
		String accountName = request.getParameter("accountName");
		String recordDate = request.getParameter("accountAddDate");
		Timestamp accountAddDate = null;
		//日付文字列をTimestamp型に変換
		try {
			accountAddDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(recordDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String accountRoll = request.getParameter("accountRoll");


		//Accountインスタンスを生成
		Account accountDto = new Account();
		//取得したパラメータを各フィールドに格納
		accountDto.setAccountId(accountId);
		accountDto.setAccountLoginId(accountLoginId);
		accountDto.setAccountPassword(accountPassword);
		accountDto.setAccountMail(accountMail);
		accountDto.setAccountName(accountName);
		accountDto.setAccountAddDate(accountAddDate);
		accountDto.setAccountRoll(accountRoll);

		//Accountインスタンスの参照をリクエスト属性へ格納
		request.setAttribute("accountList", accountDto);

		//確認画面へフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/account/account_mypage_update_check.jsp");
		rd.forward(request, response);
	}

}