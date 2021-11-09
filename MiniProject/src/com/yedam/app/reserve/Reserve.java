package com.yedam.app.reserve;

import java.sql.Date;

public class Reserve {
	private String userId;
	private String reserveType;
	private Date reserveDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReserveType() {
		return reserveType;
	}
	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	
	@Override
	public String toString() {
		return "아이디 : " + userId + ", 좌석 타입 : " + reserveType + ", 예약일시 : " + reserveDate;
	}

}
