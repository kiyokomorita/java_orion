package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Apartment;
import dto.ApartmentSearch;

public class ApartmentDAO extends DAO {

	/**
	 * 物件一覧
	 */
    public List<ApartmentSearch> apartmentList() throws Exception {
        List<ApartmentSearch> returnList  = new ArrayList<ApartmentSearch>();

        String sql = "SELECT  apCode,  apName, apDescription,  apNumber,  apPrice, apPet, apLayout, "
                + " apImage, apAddress1, apAddress2, apStatus  FROM apartment ";

        //プリペアステートメントを取得し、実行SQLを渡す
        PreparedStatement statement = getPreparedStatement(sql);

        //SQLを実行してその結果を取得する
        ResultSet rs = statement.executeQuery();
        rs.last();
        int count = rs.getRow();
        rs.beforeFirst();

        //検索結果の行数文フェッチを行い、取得結果をApartmentインスタンスへ格納する
        while (rs.next()) {
            ApartmentSearch dto = new ApartmentSearch();

            //クエリー結果をVOへ格納（あらかじめクエリー結果とdtoの変数名は一致させている）
            dto.setApartmentCode(rs.getInt("apCode"));
            dto.setApartmentName(rs.getString("apName"));
            dto.setApartmentDescription(rs.getString("apDescription"));
            dto.setApartmentNumber(rs.getInt("apNumber"));
            dto.setApartmentPrice(rs.getInt("apPrice"));
            dto.setApartmentPet(rs.getString("apPet"));
            dto.setApartmentLayout(rs.getString("apLayout"));
            dto.setApartmentImage(rs.getString("apImage"));
            dto.setApartmentAddress1(rs.getString("apAddress1"));
            dto.setApartmentAddress2(rs.getString("apAddress2"));
            dto.setApartmentStatus(rs.getString("apStatus"));
            dto.setCount(count);

            returnList.add(dto);
        }

        return returnList;
    }


	/**
	 * 物件削除
	 */
	public int apartmentDelete(int apCode) throws Exception {
		//実行するSQLの作成
		String sql = "delete apartment from apartment where apCode = ?";
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


	/**
	 * 物件追加メソッド
	 */
	public int apartmentAdd(Apartment dto) throws Exception {

		int result = 0;

		//実行するSQLの作成
		String sql= "insert into apartment (apName, apDescription, apNumber, apPrice, apPet, apLayout, apImage, apAddress1, apAddress2, apStatus)"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";

		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement = getPreparedStatement(sql);

			//プレースホルダーに値をセット
			statement.setString(1, dto.getApartmentName());
			statement.setString(2, dto.getApartmentDescription());
			statement.setInt(3, dto.getApartmentNumber());
			statement.setInt(4, dto.getApartmentPrice());
			statement.setString(5, dto.getApartmentPet());
			statement.setString(6, dto.getApartmentLayout());
			statement.setString(7, dto.getApartmentImage());
			statement.setString(8, dto.getApartmentAddress1());
			statement.setString(9, dto.getApartmentAddress2());
			statement.setString(10, dto.getApartmentStatus());

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
	 * 物件更新メソッド
	 */
	public int apartmentUpdate(Apartment dto) throws Exception {

		int result = 0;

		//実行するSQLの作成
		String sql= "update apartment set apName=?, apDescription=?, apNumber=?, apPrice=?, apPet=?, apLayout=?, apImage=?, apAddress1=?, apAddress2=?, apStatus=? where apCode=?";

		try {
			//PreparedStatementを取得し、実行SQLを格納
			PreparedStatement statement = getPreparedStatement(sql);

			//プレースホルダーに値をセット
			statement.setString(1, dto.getApartmentName());
			statement.setString(2, dto.getApartmentDescription());
			statement.setInt(3, dto.getApartmentNumber());
			statement.setInt(4, dto.getApartmentPrice());
			statement.setString(5, dto.getApartmentPet());
			statement.setString(6, dto.getApartmentLayout());
			statement.setString(7, dto.getApartmentImage());
			statement.setString(8, dto.getApartmentAddress1());
			statement.setString(9, dto.getApartmentAddress2());
			statement.setString(10, dto.getApartmentStatus());
			statement.setInt(11, dto.getApartmentCode());

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
	 * 物件詳細メソッド
	 */
	public Apartment apartmentDetail(int apCode) throws Exception {
		//Apartmentインスタンスを生成
		Apartment dto = new Apartment ();
		//実行するSQLの作成
		String sql = "select apCode, apName, apDescription, apNumber, apPrice, apPet, apLayout, " +
				 		" apImage, apAddress1, apAddress2, apStatus " +
				 			"from apartment where apCode = ?";

		//PreparedStatementを取得し、実行SQLを格納
		PreparedStatement statement = getPreparedStatement(sql);

		//プレースホルダーに物件コードをセット
		statement.setInt(1, apCode);

		//SQLを実行
		ResultSet rs = statement.executeQuery();
		//検索結果から1行ずつデータを取り出し、Apartmentインスタンスへ格納
		while (rs.next()) {
			dto.setApartmentCode(rs.getInt("apCode"));
            dto.setApartmentName(rs.getString("apName"));
            dto.setApartmentDescription(rs.getString("apDescription"));
            dto.setApartmentNumber(rs.getInt("apNumber"));
            dto.setApartmentPrice(rs.getInt("apPrice"));
            dto.setApartmentPet(rs.getString("apPet"));
            dto.setApartmentLayout(rs.getString("apLayout"));
            dto.setApartmentImage(rs.getString("apImage"));
            dto.setApartmentAddress1(rs.getString("apAddress1"));
            dto.setApartmentAddress2(rs.getString("apAddress2"));
            dto.setApartmentStatus(rs.getString("apStatus"));
		}
		return dto;
	}

    /**
     * 物件絞り込み検索
     */
    public List<ApartmentSearch> apartmentSearchSelect(ApartmentSearch formDto) throws Exception {
        List<ApartmentSearch> apartmentDto  = new ArrayList<ApartmentSearch>();

        String sql = "SELECT  apCode,  apName, apDescription,  apNumber,  apPrice, apPet, apLayout, apImage, apAddress1, apAddress2, apStatus  "
                + "FROM apartment "
                + "WHERE 1=1 ";

        ArrayList<String> flag = new ArrayList<String>();

        //リクエストパラメータの値を確認し、equals()以外の値の場合はWHERE箇所を追加する
        if (!formDto.getApartmentNumber().equals(0) && !formDto.getApartmentNumber().equals(5)) {
            sql += " AND apNumber = ? ";
            flag.add("Number");
        }
        if (formDto.getApartmentNumber().equals(5)) {
            sql += " AND apNumber >= ?";
            flag.add("Number5");
        }
        if (!formDto.getApartmentPet().equals("null")) {
            sql += " AND apPet = ? ";
            flag.add("Pet");
        }
        if (!formDto.getApartmentLayout().equals("null")) {
            sql += " AND apLayout = ? ";
            flag.add("Layout");
        }
        if (!formDto.getApartmentAddress1().equals("null")) {
            sql += " AND apAddress1 = ? ";
            flag.add("Address1");
        }
        if (!formDto.getApartmentPrice1().equals(-1)) {
            sql += " AND apPrice >= ? ";
            flag.add("Price1");
        }
        if (!formDto.getApartmentPrice2().equals(-1)) {
            sql += " AND apPrice <= ? ";
            flag.add("Price2");
        }
        if (!formDto.getApartmentStatus().equals("null")) {
            sql += " AND apStatus = ? ";
            flag.add("Status");
        }

        if (!formDto.getApartmentFreeword().equals("null")) {
        	if (!formDto.getApartmentFreeword().equals("")) {
        		String[] freewords =  formDto.getApartmentFreeword().split("　+| +",0);
        		sql += " INTERSECT SELECT * FROM apartment WHERE CONCAT(apCode,apName,apDescription,apLayout,apAddress1,apAddress2) LIKE";

        		for(int i = 0 ; i < freewords.length ; i ++) {
        			sql += " ?";
        		}

        	}


        }

        //並び替え取得
        int sorttype = Integer.parseInt(formDto.getApartmentSort());
        //並び替えに応じてSQL追加
        switch(sorttype) {
        case 0:
        	break;
        case 1:
        	sql += " ORDER BY apCode DESC";
        	break;
        case 2:
        	sql += " ORDER BY apPrice ASC";
        	break;
        case 3:
        	sql += " ORDER BY apPrice DESC";
        	break;
        default:
        }

        //プリペアステートメントを取得し、実行SQLを渡す
        PreparedStatement statement = getPreparedStatement(sql);

        //プレースホルダーの番号
        int index = 0;

        //プレースホルダーに値をセット
        if (flag.contains("Number")) {
            statement .setInt(++index, formDto.getApartmentNumber());
        }
        if (flag.contains("Number5")) {
            statement .setInt(++index, formDto.getApartmentNumber());
        }
        if (flag.contains("Pet")) {
            statement .setString(++index, formDto.getApartmentPet());
        }
        if (flag.contains("Layout")) {
            statement .setString(++index, formDto.getApartmentLayout());
        }
        if (flag.contains("Address1")) {
            statement .setString(++index, formDto.getApartmentAddress1());
        }
        if (flag.contains("Price1")) {
            statement .setInt(++index, formDto.getApartmentPrice1());
        }
        if (flag.contains("Price2")) {
            statement .setInt(++index, formDto.getApartmentPrice2());
        }
        if (flag.contains("Status")) {
            statement .setString(++index, formDto.getApartmentStatus());
        }

        if (!formDto.getApartmentFreeword().equals("null")) {
        	if (!formDto.getApartmentFreeword().equals("")) {
        		String[] freewords =  formDto.getApartmentFreeword().replaceAll("%","\\\\%").replaceAll("_","\\\\_").split("　+| +",0);

        		for(String freeword : freewords) {
        			statement .setString(++index, "%"+ freeword + "%");
        		}

        	}
        }

        //SQLを実行してその結果を取得する
        ResultSet rs = statement.executeQuery();
        rs.last();
        int count = rs.getRow();
        rs.beforeFirst();

        //検索結果の行数文フェッチを行い、取得結果をApartmentSearchインスタンスへ格納する
        while (rs.next()) {
            ApartmentSearch dto = new ApartmentSearch();

        //クエリー結果をVOへ格納（あらかじめクエリー結果とdtoの変数名は一致させている）
        dto.setApartmentCode(rs.getInt("apCode"));
        dto.setApartmentName(rs.getString("apName"));
        dto.setApartmentDescription(rs.getString("apDescription"));
        dto.setApartmentNumber(rs.getInt("apNumber"));
        dto.setApartmentPrice(rs.getInt("apPrice"));
        dto.setApartmentPet(rs.getString("apPet"));
        dto.setApartmentLayout(rs.getString("apLayout"));
        dto.setApartmentImage(rs.getString("apImage"));
        dto.setApartmentAddress1(rs.getString("apAddress1"));
        dto.setApartmentAddress2(rs.getString("apAddress2"));
        dto.setApartmentStatus(rs.getString("apStatus"));
        dto.setCount(count);

        apartmentDto.add(dto);
    }

        return apartmentDto;
    }

}