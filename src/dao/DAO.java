package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO implements AutoCloseable {
	protected Connection connection = null;
	/**
	 *データベースとの接続を取得する。もし取得していた場合には既存の接続を利用し、取得していない場合は新たにコンテナから取得する。
	 *
	 *@return
	 *@throws Exception
	 */
	public Connection getConnection() throws Exception {
		//NamingException, SQLExceptionがスローされる
		try {
			if (connection == null || connection.isClosed()) {
				InitialContext initCtx = new InitialContext();
				DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/localDB");

				//データベース接続をする
				connection = ds.getConnection();
			}
		} catch (NamingException | SQLException e) {
			//もし接続取得で例外が出た場合はconnection=nullにし、
			//発生した例外はそのまま送出する。
			e.printStackTrace();
			connection = null;
			throw e;
		}
		return connection;
	}


	/**
	 * 接続を閉じる。確実に接続を解放するためにfinallyでconnection=nullを行う。
	 */
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection = null;
		}
	}

	/**
	 * PreparedStatementを返す。
	 *
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public PreparedStatement getPreparedStatement(String sql) throws Exception {
		return getConnection().prepareStatement(sql);
	}


	/**
	 * トランザクションのコミットを行う。
	 *
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		connection.commit();
	}

	/**
	 * トランザクションのロールバックを行う。
	 *
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		connection.rollback();
	}

	/*
	 * 接続を閉じる
	 */
	@Override
	public void close() {

		System.out.println("close connection ------------------------------------------------------------------>");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection = null;
		}
	}

}
