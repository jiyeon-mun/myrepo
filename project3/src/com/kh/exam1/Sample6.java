package com.kh.exam1;

import java.sql.*;
import java.util.*;

import com.db.conn.OracleCloudConnect;

public class Sample6 {

	public static void main(String[] args) {
		/* TB_STUDENT 테이블에서 학번, 이름, 주민번호, 학과명, 휴학유무에 대한 데이터를 조회하여
		 * 컬렉션 객체 저장을 하도록 한다.
		 * 	- 주민등록번호는 생년월일과 성별 구분을 제외하고는 나머지 번호에 대해
		 * 	  숨김(*)처리를 하도록 한다.
		 * 	- 휴학유무는 N, Y 가 아닌 휴학중, 재학중으로 변경되도록 한다.
		 * 	- List 컬렉션에 Map 컬렉션이 저장되는 형태로 만든다.
		 * 	- Map 컬렉션에는 데이터베이스에서 조회한 컬럼명은 Map의 키로
		 * 	  컬럼값은 Map의 값으로 저장되게 한다.
		 * 	- 컬럼이름은 반드시 위에서 제시한 한글명으로 별칭을 부여하도록 만든다.
		 */
		OracleCloudConnect occ;
		try {
			occ = new OracleCloudConnect();
			occ.connection();
			
			// EMPLOYEES 테이블을 사용하여 부서별 인원수를 구하여 본다.
			String query = ""
					+ "SELECT A.STUDENT_NO AS 학번"
					+ "     , A.STUDENT_NAME AS 이름"
					+ "     , REPLACE(A.STUDENT_SSN, SUBSTR(A.STUDENT_SSN,9),'*****') AS 주민번호"
					+ "     , B.DEPARTMENT_NAME AS 학과명"
					+ "     , DECODE(A.ABSENCE_YN,'Y','재학중','N','휴학중','기타') AS 휴학유무"
					+ "  FROM TB_STUDENT A JOIN TB_DEPARTMENT B"
					+ "    ON A.DEPARTMENT_NO = B.DEPARTMENT_NO";
			ResultSet res = occ.sendQuery(query);
			
			List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
			
			// Map 에 저장 후
			// Map 저장 방법 1 : 컬럼명 String 배열 이용
			String[] cols = new String[] {"", "학번", "이름", "주민번호", "학과명", "휴학유무"};
			while(res.next()) {
				Map<String, String> m = new HashMap<String, String>();
				
				for(int i=1; i<cols.length;i++) {
					m.put(cols[i], res.getString(i));
				}
				
//				// Map 저장 방법 2 : 숫자는 query의 컬럼 순서
//				m.put("학번", res.getString(1));
//				m.put("이름", res.getString(2));
//				m.put("주민번호", res.getString(3));
//				m.put("학과명", res.getString(4));
//				m.put("휴학유무", res.getString(5));
//				
//				// Map 저장 방법 3 : 별칭명 직접 이용
//				m.put("학번", res.getString("학번"));
//				m.put("이름", res.getString("이름"));
//				m.put("주민번호", res.getString("주민번호"));
//				m.put("학과명", res.getString("학과명"));
//				m.put("휴학유무", res.getString("휴학유무"));
				
				// List 에 저장
				datas.add(m);
			}
			System.out.println(datas);
			System.out.println(datas.size()+" 개의 조회 결과가 있습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
