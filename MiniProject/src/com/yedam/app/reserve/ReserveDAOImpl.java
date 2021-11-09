package com.yedam.app.reserve;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveDAOImpl extends DAO implements reserveDAO {

	// 사용할 sql문 정리
	private final String INSERT = "INSERT INTO reservelist VALUES(?,?,?)";
	private final String SELECT_ONE = "SELECT * FROM reservelist WHERE userId = ? AND reserveNo = ?";
	private final String SELECT_ALL = "SELECT * FROM reservelist";
	private final String DELETE = "DELETE from reservelist WHERE reserveNo = ?";

	// 싱글톤
	private static reserveDAO instance = new ReserveDAOImpl();

	public static reserveDAO getInstance() {
		return instance;
	}

	// 예약 기능 - insert
	@Override
	public int insert(Reserve reserve) {

		int result = 0;

		try {
			connect();

			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, reserve.getUserId());
			pstmt.setString(2, reserve.getReserveType());
			pstmt.setDate(3, reserve.getReserveDate());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 예약 조회 기능(단건)
	@Override
	public Reserve selectOne(String userId) {
		Reserve reserve = null;
		try {
			connect();
			pstmt = conn.prepareStatement(SELECT_ONE);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				reserve = new Reserve();
				reserve.setUserId(rs.getString("userId"));
				reserve.setReserveType(rs.getString("reserveType"));
				reserve.setReserveDate(rs.getDate("reserveDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return reserve;
	}

	// 예약 조회 기능(전체)
	@Override
	public List<Reserve> selectAll() {
		List<Reserve> list = new ArrayList<>();
		try {
			connect();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Reserve reserve = new Reserve();
				reserve.setUserId(rs.getString("userId"));
				reserve.setReserveType(rs.getString("reserveType"));
				reserve.setReserveDate(rs.getDate("reserveDate"));

				list.add(reserve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 예약 취소 기능
	@Override
	public int delete(String userId) {
		int result = 0;
		try {
			connect();

			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
}
