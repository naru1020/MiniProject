package com.yedam.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.yedam.app.reserve.Reserve;
import com.yedam.app.reserve.ReserveDAOImpl;
import com.yedam.app.reserve.reserveDAO;
import com.yedam.java.app.common.Frame;
import com.yedam.java.app.login.User;
import com.yedam.java.app.login.userDAO;

public class ReserveFrame implements Frame {

	// 필드
	Scanner scanner = new Scanner(System.in);
	userDAO dao = new userDAO();
	reserveDAO rdao = ReserveDAOImpl.getInstance();
	int vipSeat = 5;
	int sSeat = 5;
	int aSeat = 5;
	int bSeat = 5;
	String userId;

	// 메소드
	// 실행 메소드
	public void run(String userId) {
		this.userId = userId;

		while (true) {
			menuPrint();
			int menuNo = menuSelect();

			if (menuNo == 1) {
				// 공연 예매
				concertReserve();
			} else if (menuNo == 2) {
				// 예약 조회
				selectOne();
			} else if (menuNo == 3) {
				// 전체 조회
				selectAll();
			} else if (menuNo == 4) {
				// 취소
				cancelReserve();
			} else if (menuNo == 5) {
				// 대기
			} else if (menuNo == 9) {
				end();
				break;
			}
		}
	}

	// 메뉴를 출력하는 메소드
	void menuPrint() {
		System.out.println("");
		System.out.println("=================================================================");
		System.out.println("== 1. 공연 예약  2. 예약 조회  4. 예약 전체 조회  5. 예약 취소  6. 예약 대기 ==");
		System.out.println("=================================================================");
		System.out.println("선택>>");
	}

	// 메뉴를 선택하는 메소드
	int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다. 다시 선택하세요");
		}
		return menuNo;
	}

	// 종료
	void end() {
		System.out.println("프로그램을 종료합니다.");
	}

	// 공연 예약
	User concertReserve() {
		try {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡ<좌석 현황>ㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println(" VIP(" + vipSeat + ")석 ");
			System.out.println(" S(" + sSeat + ")석    ");
			System.out.println(" A(" + aSeat + ")석    ");
			System.out.println(" B(" + bSeat + ")석    ");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println();
			System.out.println("예매하고자 하는 좌석 타입에 맞는 번호를 입력하세요.");
			System.out.println("VIP석<1번>  S석<2번>  A석<3번>  B석<4번>");
			System.out.println();
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			int inputSeat = scanner.nextInt();

			switch (inputSeat) {
			case 1:
				if (vipSeat < 1) {
					System.out.println("매진된 좌석입니다.");
				} else {
					

					System.out.println("성공적으로 예매되었습니다.");
					vipSeat -= 1;
				}
				break;

			case 2:
				if (sSeat < 1) {
					System.out.println("매진된 좌석입니다.");
				} else {

					System.out.println("성공적으로 예매되었습니다.");
					sSeat -= 1;
				}
				break;

			case 3:
				if (aSeat < 1) {
					System.out.println("매진된 좌석입니다.");
				} else {

					System.out.println("성공적으로 예매되었습니다.");
					aSeat -= 1;
				}
				break;

			case 4:
				if (bSeat < 1) {
					System.out.println("매진된 좌석입니다.");
				} else {

					System.out.println("성공적으로 예매되었습니다.");
					bSeat -= 1;
				}
				break;
			}

		} catch (Exception e) {
			System.out.println("존재하지 않는 좌석입니다. 다시 시도해주세요.");
		}

		return null;
	}

	// 전체조회
	void selectAll() {
		if (userId.equals("admin")) {
			List<Reserve> list = rdao.selectAll();
			for (Reserve resv : list) {
				System.out.println(resv);
			}
		} else {
			System.out.println("관리자 기능입니다. 관리자로 로그인하세요.");
		}
	}

	// 단건조회
	void selectOne() {
		Reserve resv = rdao.selectOne(userId);
		System.out.println(resv);
	}

	// 삭제
	void cancelReserve() {
		rdao.delete(userId);
	}
}
