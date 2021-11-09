package com.yedam.app.reserve;

import java.util.List;

public interface reserveDAO {

	// 예약 기능
	public int insert(Reserve reserve);

	// 예약 조회
	public Reserve selectOne(String userId);

	// 예약 전체 조회
	public List<Reserve> selectAll();

	// 예약 취소
	public int delete(String userId);

	// 예약 대기??
}
