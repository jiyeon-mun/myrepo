package com.kh.exam1;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleCloudConnect;

class StudentAvg{
	private String stdNo;
	private String stdName;
	private String stdPoint;
	
	public StudentAvg(String stdNo, String stdName, String stdPoint) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdPoint= stdPoint;
	}
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPoint() {
		return stdPoint;
	}
	public void setStdPoint(String stdPoint) {
		this.stdPoint = stdPoint;
	}

	@Override
	public String toString() {
		return "StudentAvg [학번=" + this.stdNo + ", 이름=" + this.stdName + ", 평균학점=" + this.stdPoint + "]";
	}	
}

class DeptInfo{
	private String deptCode;
	private String deptName;
	private int stdCnt;
	private int proCnt;
	
	public DeptInfo(String deptCode, String deptName, int stdCnt, int proCnt) {
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.stdCnt = stdCnt;
		this.proCnt = proCnt;
	}
	
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getStdCnt() {
		return stdCnt;
	}
	public void setStdCnt(int stdCnt) {
		this.stdCnt = stdCnt;
	}
	public int getProCnt() {
		return proCnt;
	}
	public void setProCnt(int proCnt) {
		this.proCnt = proCnt;
	}

	@Override
	public String toString() {
		return "DeptInfo [학과코드=" + this.deptCode + ", 학과명=" + this.deptName
				+ ", 학생수=" + this.stdCnt + ", 교수인원=" + this.proCnt
				+ "]";
	}
}

public class Sample7 {

	public static void main(String[] args) {
		OracleCloudConnect occ;
		try {
			occ = new OracleCloudConnect();
			occ.connection();
			
			/*
				3. 1, 2번에서 생성한 테이블을 사용하여 Java OJDBC 로 조회하여 출력하는 코드를 만든다.
					- [StudentAvg [번호="A000000", 이름="홍길동", 평균학점=3.7], StudentAvg [ ... ], ...]
					- [DeptInfo [학과코드="001", 학과명="XXXX학과", 학생수=25, 교수인원=5], DeptInfo [ ... ], ...]
		    */
			// 1번
			String query = ""
					+ "SELECT *"
					+ "  FROM STD_AVG_POINT"
					+ " ORDER BY 이름";
			ResultSet res = occ.sendQuery(query);
			// 클래스타입 리스트 객체
			List<StudentAvg> sList = new ArrayList<StudentAvg>();
			while(res.next()) {
										// 숫자는 DB에 저장된 테이블 컬럼 순서를 의미한다. (1부터 시작)
										// 출력문에서 '년도'컬럼이 생략되었기 때문에 '학번'컬럼부터 시작한다; 2
										// 각 컬럼 타입에 맞춰서 조회하여 출력한다.
										// VARCHAR -> getString, NUMBER -> getInt
				sList.add(new StudentAvg(res.getString(2), res.getString(3), res.getString(4)));
			}
			System.out.println(sList);
			
			// 2번
			query = ""
					+ "SELECT *"
					+ "  FROM DEPT_CNT"
					+ " ORDER BY 1";
			res = occ.sendQuery(query);
			
			List<DeptInfo> dList = new ArrayList<DeptInfo>();
			while(res.next()) {
				dList.add(new DeptInfo(res.getString(1), res.getString(2), res.getInt(3), res.getInt(4)));
			}
			System.out.println(dList);
			
			res.close();
			occ.close();
			occ.connectionClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
