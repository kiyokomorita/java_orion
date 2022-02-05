package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.Account;

public class AccountDAO extends DAO {

	/**
	 * アカウント一覧
	 */
	public List<Account> accountSearch() throws Exception {

        List<Account> returnList = new ArrayList<Account>();

        String sql = "select acId, account.acLoginId, acPassword, acMail, acName, acAddDate, acRoll " +
        "from account inner join roll on account.acLoginId = roll.acLoginId";

        PreparedStatement statement = getPreparedStatement(sql);

        ResultSet rs = statement.executeQuery();
        rs.last();
        int count = rs.getRow();
        rs.beforeFirst();

        while (rs.next()) {
            Account dto = new Account();

            dto.setAccountId(rs.getInt("acId"));
            dto.setAccountLoginId(rs.getString("acLoginid"));
            dto.setAccountPassword(rs.getString("acPassword"));
            dto.setAccountMail(rs.getString("acMail"));
            dto.setAccountName(rs.getString("acName"));
            dto.setAccountAddDate(rs.getTimestamp("acAddDate"));
            dto.setAccountRoll(rs.getString("acRoll"));
            dto.setCount(count);

            returnList.add(dto);
        }

        return returnList;

    }

	/**
	 * アカウント検索
	 */
	public List<Account> accountSearch(Map<String, String> map) throws Exception {

        List<Account> returnList = new ArrayList<Account>();

        String sql = "select acId, account.acLoginId, acPassword, acMail, acName, acAddDate, acRoll " +
        "from account inner join roll on account.acLoginId = roll.acLoginId where 1 = 1";

        for (String key : map.keySet()) {
        	sql += " and account." + key + " like '%" + map.get(key) + "%'";
        }

        PreparedStatement statement = getPreparedStatement(sql);

        ResultSet rs = statement.executeQuery();
        rs.last();
        int count = rs.getRow();
        rs.beforeFirst();

        while (rs.next()) {
            Account dto = new Account();

            dto.setAccountId(rs.getInt("acId"));
            dto.setAccountLoginId(rs.getString("acLoginid"));
            dto.setAccountPassword(rs.getString("acPassword"));
            dto.setAccountMail(rs.getString("acMail"));
            dto.setAccountName(rs.getString("acName"));
            dto.setAccountAddDate(rs.getTimestamp("acAddDate"));
            dto.setAccountRoll(rs.getString("acRoll"));
            dto.setCount(count);

            returnList.add(dto);
        }

        return returnList;

    }

	/**
	 * ログイン完了画面
	 * セッションにログインしたアカウントの情報を格納後、すぐにトップページを表示させる。
	 * （ログインIDを指定して詳細検索。DBからアカウント情報1行分をaccountDtoに格納。）
	 */
	public Account accountLogin(String accountId) throws Exception {
		//検索結果を格納するためのAccountインスタンスの生成
		Account accountDto = new Account();

		//SQLの作成
		String sql = "SELECT acId, account.acLoginId, acPassword, acMail, acName, acAddDate, acRoll " +
				"FROM account INNER JOIN roll ON account.acLoginId = roll.acLoginId WHERE account.acLoginId = ?";

		//PreparedStatementを取得し、実行SQLを格納
		PreparedStatement statement = getPreparedStatement(sql);

		//プレースホルダーにログインIDをセット
		statement.setString(1, accountId);

		//SQLを実行してその結果を取得
		ResultSet rs = statement.executeQuery();

		//検索結果から1行ずつデータを取り出し、Accountインスタンスへ格納
		while (rs.next()) {
			accountDto.setAccountId(rs.getInt("acId"));
			accountDto.setAccountLoginId(rs.getString("acLoginId"));
			accountDto.setAccountPassword(rs.getString("acPassword"));
			accountDto.setAccountMail(rs.getString("acMail"));
			accountDto.setAccountName(rs.getString("acName"));
			accountDto.setAccountAddDate(rs.getTimestamp("acAddDate"));
			accountDto.setAccountRoll(rs.getString("acRoll"));
		}
		return accountDto;
	}

	/**
	 * アカウント追加メソッド
	 */
	public int accountAdd(Account dto) throws Exception {

		int result = 0;

		//実行するSQLの作成
		String sql1= "insert into account (acLoginId, acPassword, acMail, acName, acAddDate) values (?, ?, ?, ?, now()); ";
		String sql2= "insert into roll (acLoginId, acRoll) values (?, ?); ";

		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement1 = getPreparedStatement(sql1);

			//プレースホルダーに値をセット
			statement1.setString(1, dto.getAccountLoginId());
			statement1.setString(2, dto.getAccountPassword());
			statement1.setString(3, dto.getAccountMail());
			statement1.setString(4, dto.getAccountName());

			//SQLを実行
			result = statement1.executeUpdate();

			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement2 = getPreparedStatement(sql2);
			statement2.setString(1, dto.getAccountLoginId());
			statement2.setString(2, dto.getAccountRoll());

			//SQLを実行
			result = result + statement2.executeUpdate();

			//コミット
			super.commit();
		} catch (Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}

	/**
	 * アカウント更新メソッド
	 */
	public int accountUpdate(Account dto) throws Exception {

		int result = 0;

		//実行するSQLの作成
		String sql1= "update account set acPassword=?, acMail=?, acName=?, acAddDate=now() where acId=?";
		String sql2= "update roll set acRoll=? where acLoginId=?";

		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement1 = getPreparedStatement(sql1);

			//プレースホルダーに値をセット
			statement1.setString(1, dto.getAccountPassword());
			statement1.setString(2, dto.getAccountMail());
			statement1.setString(3, dto.getAccountName());
			statement1.setInt(4, dto.getAccountId());

			//SQLを実行
			result = statement1.executeUpdate();

			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement2 = getPreparedStatement(sql2);
			statement2.setString(1, dto.getAccountRoll());
			statement2.setString(2, dto.getAccountLoginId());

			//SQLを実行
			result = result + statement2.executeUpdate();

			//コミット
			super.commit();
		} catch (Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}

	/**
	 * アカウント詳細メソッド
	 */
	public Account accountDetail(int acId) throws Exception {
		//Todoインスタンスを生成
		Account dto = new Account ();

		//実行するSQLの作成
		String sql = "select acId, account.acLoginId, acPassword, acMail, acName, acAddDate, acRoll from account inner join roll on account.acLoginId = roll.acLoginId where acId = ?";

		//PreparedStatementを取得し、実行SQLを格納
		PreparedStatement statement = getPreparedStatement(sql);

		//プレースホルダーに値をセット
		statement.setInt(1, acId);

		//SQLを実行
		ResultSet rs = statement.executeQuery();

		//検索結果から1行ずつデータを取り出し、Accountインスタンスへ格納
		while (rs.next()) {
			dto.setAccountId(rs.getInt("acId"));
			dto.setAccountLoginId(rs.getString("acLoginId"));
			dto.setAccountPassword(rs.getString("acPassword"));
			dto.setAccountMail(rs.getString("acMail"));
			dto.setAccountName(rs.getString("acName"));
			dto.setAccountAddDate(rs.getTimestamp("acAddDate"));
			dto.setAccountRoll(rs.getString("acRoll"));
		}
		return dto;
	}

	public int accountDelete(int acId) throws Exception {
		//実行するSQLの作成
		String sql = "delete account, roll from account inner join roll on account.acLoginId = roll.acLoginId where acId = ?";
		int result = 0;
		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement = getPreparedStatement(sql);

			//プレースホルダーに値をセット
			statement.setInt(1, acId);

			//SQLを実行
			result = statement.executeUpdate();

			//コミット
			super.commit();
		} catch (Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}


	/**
	 * マイページ更新：確認画面「更新」ボタンを押した処理
	 */
	public int accountMypageUpdateCheck(Account accountDto) throws Exception {
		//実行するSQLの作成
		String sql = "UPDATE account SET acId = ?, account.acLoginId = ?, acPassword = ?, acMail = ?, acName = ?, acAddDate = ? WHERE acId = ?";

		int result = 0;
		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement = getPreparedStatement(sql);

			//プレースホルダーに値をセット
			statement.setInt(1, accountDto.getAccountId());
			statement.setString(2, accountDto.getAccountLoginId());
			statement.setString(3, accountDto.getAccountPassword());
			statement.setString(4, accountDto.getAccountMail());
			statement.setString(5, accountDto.getAccountName());
			statement.setTimestamp(6, accountDto.getAccountAddDate());
			statement.setInt(7, accountDto.getAccountId());

			//SQLを実行
			result = statement.executeUpdate();

			//コミット
			super.commit();
		} catch (Exception e) {
			super.rollback();
			throw e;
		}
		return result;
	}

}
