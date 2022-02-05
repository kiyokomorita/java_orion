package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Review;

public class ReviewDAO extends DAO {

	/**
	 * 口コミ削除
	 */
	public int reviewDelete(int reCode) throws Exception {
		//実行するSQLの作成
		String sql = "delete review from review where reCode = ?";
		int result = 0;
		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement = getPreparedStatement(sql);

			//プレースホルダーに値をセット
			statement.setInt(1, reCode);

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
	 * 口コミ新規登録
	 */
	public int reviewAdd(Review dto) throws Exception {

		int result = 0;

		//実行するSQLの作成
		String sql= "insert into `review` ( `reApartmentCode`, `reUserLoginId`, `reContent`, `reName`, `reAddDate` " + ") values (?, ?, ?, ?, now());";

		//PreparedStatementを取得し、実行SQLを格納
		try {
			PreparedStatement statement = getPreparedStatement(sql);

			//プレースホルダーに値をセット
			statement.setInt(1, dto.getReviewApartmentCode());
			statement.setString(2, dto.getReviewUserLoginId());
			statement.setString(3, dto.getReviewContent());
			statement.setString(4, dto.getReviewName());

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
	 * 口コミ一覧（口コミ投稿履歴ページ）
	 */
	public List<Review> reviewList(Review apartmentDto) throws Exception {
		//検索結果を入れるリストの準備
        List<Review> returnList  = new ArrayList<Review>();


        String sql = "SELECT  * " +
                "FROM review inner join apartment on review.reApartmentCode = apartment.apCode WHERE reUserLoginId = ? ";

        //プリペアステートメントを取得し、実行SQLを渡す
        PreparedStatement statement = getPreparedStatement(sql);

        //プレースホルダーに値をセット
        statement.setString(1, apartmentDto.getReviewUserLoginId());

        //SQLを実行してその結果を取得する
        ResultSet rs = statement.executeQuery();
        rs.last();
        int count = rs.getRow();
        rs.beforeFirst();

		//検索結果から1行ずつデータを取り出し、インスタンスへ格納
        while (rs.next()) {
            Review dto = new Review();


            //クエリー結果をVOへ格納（あらかじめクエリー結果とdtoの変数名は一致させている）
            dto.setReviewCode(rs.getInt("reCode"));
            dto.setReviewApartmentCode(rs.getInt("reApartmentCode"));
            dto.setReviewUserLoginId(rs.getString("reUserLoginId"));
            dto.setReviewContent(rs.getString("reContent"));
            dto.setReviewAddDate(rs.getTimestamp("reAddDate"));
            dto.setReviewName(rs.getString("reName"));
            dto.setReviewApartmentName(rs.getString("apName"));
            dto.setCount(count);
            returnList.add(dto);
        }

            return returnList;
	}

	/**
	 * 口コミ更新
	 */
	public int reviewUpdate(Review dto) throws Exception {

		int result = 0;

		//実行するSQLの作成
		String sql= "UPDATE `review` SET `reContent` = ? ,`reAddDate` = now() WHERE `reCode` = ? ;";

		//PreparedStatementを取得し、実行SQLを格納
		try {
			PreparedStatement statement = getPreparedStatement(sql);

			//プレースホルダーに値をセット
			statement.setString(1, dto.getReviewContent());
			statement.setInt(2, dto.getReviewCode());

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
	 * 物件詳細の中での口コミ表示用
	 */
	public List<Review> reviewDetail(int apCode) throws Exception {
		//検索結果を入れるリストの準備
        List<Review> returnList  = new ArrayList<Review>();

        String sql = "select  reCode, reApartmentCode, reUserLoginId, reContent, reAddDate, `reName` from review where reApartmentCode = ?";

        //プリペアステートメントを取得し、実行SQLを渡す
        PreparedStatement statement = getPreparedStatement(sql);

        statement.setInt(1, apCode);


        //SQLを実行してその結果を取得する
        ResultSet rs = statement.executeQuery();
        rs.last();
        int count = rs.getRow();
        rs.beforeFirst();

		//検索結果から1行ずつデータを取り出し、インスタンスへ格納
        while (rs.next()) {
            Review dto = new Review();

            //クエリー結果をVOへ格納（あらかじめクエリー結果とdtoの変数名は一致させている）
            dto.setReviewCode(rs.getInt("reCode"));
            dto.setReviewApartmentCode(rs.getInt("reApartmentCode"));
            dto.setReviewUserLoginId(rs.getString("reUserLoginId"));
            dto.setReviewContent(rs.getString("reContent"));
            dto.setReviewAddDate(rs.getTimestamp("reAddDate"));
            dto.setReviewName(rs.getString("reName"));
            dto.setCount(count);
            returnList.add(dto);
        }

            return returnList;
	}

	/**
	 * 物件削除の際、紐づいた口コミも削除する
	 */
	public int reviewApDelete(int apCode) throws Exception {
		String sql = "delete review from review where reApartmentCode = ?";
		int result = 0;
		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement = getPreparedStatement(sql);
			//プレースホルダーに値をセット
			statement.setInt(1, apCode);

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