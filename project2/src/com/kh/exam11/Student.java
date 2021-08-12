package com.kh.exam11;

/*
 * 학생클래스
 * 		학생의 정보를 담아 관리하기 위한 객체로 사용하기 위한 틀래스
 * 		
 * 		속성(멤버 면수)
 * 			이름, 성별, 나이, 과목정보(Subject 클래스의 인스턴스가 담겨있는 객체배열)
 * 
 * 		기능(메서드)
 * 			setter/getter, 새로운 과목추가/수정/삭제, 전체과목점수확인, 총점확인, 평균확인 
 */

public class Student {
	private String name;
	private String gender;
	private int age;
	private Subject[] subjects; // Subject클래스의 subjects[] 객체배열 이용하여 과목정보 저장
	private int index;
	
	public Student(String name, int age) {
		this.name=name;
		this.age=age;
		this.subjects = new Subject[0]; // 동적배열; 배열형태만 존재
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * 과목추가 메서드 
	 */
	public void addSubject(Subject subject) {
		// 요청할 때마다 새로운 과목추가
		// 동적배열 생성 및 깊은복사, 얕은복사를 이용한다.
		Subject[] copy = new Subject[this.subjects.length+1];
		System.arraycopy(this.subjects, 0, copy, 0, this.subjects.length);
		copy[copy.length-1]=subject;
		this.subjects=copy;
	}

	
	// subjects 객체배열에 저장된 과목 점수 반환
	// 과목명으로 검색하여 반환 (없는 과목명의 경우 -1 반환)
	public int getSubjectJumsu(String subjectName) {
		for(Subject s: this.subjects) { // for(int i=0;i<this.subjects.length;i++)
			if(s.getName().equals(subjectName)) {
				return s.getJumsu();
			}
		}
		return -1;
	}
	
	// subjects 객체배열에 저장된 과목명을 반환
	// 위치값으로 과목의 정보를 반환할 수 있게 한다. (잘못된 인덱스 번호 사용하면 null 반환)
	public String getSubjectName(int index) {
		if (index >= 0 && index < subjects.length) {
			return this.subjects[index].getName();
		} else {
			return null;
		}
	}
	
	// 수정할 과목명 -> 변경할 과목명
	public String updateSubject(String find, String replace) {
		// 1. 수정할 과목명이 객체배열 내 있는지 확인
		for(Subject s:subjects) {
			// 1-1. 1번 확인 결과 존해
			if(find.equals(s.getName())) {
				// 변경작업 진행
				// 변경된 과목명 : 점수 반환
				s.setName(replace);
				return s.getName()+" : "+s.getJumsu();
			}
		}
		// 1-2. 1번 확인 결과 존재하지 않음
		//		for문 전체에 대해 비교 후 null 반환
		return null;
	}
	
	// 점수 변경할 과목명 찾아서 점수 변경하기
	public String updateSubject(String find, int num) {
		for(Subject s:subjects) {
			if(find.equals(s.getName())) {
				s.setJumsu(num);
				return s.getName()+" : "+s.getJumsu();
			}
		}
		return null;
	}
	
	// 과목명 수정, 변경한 과목명에 대해 점수도 수정
	public String updateSubject(String find, String replace, int num) {
		for(Subject s:subjects) {
			if(find.equals(s.getName())) {
				s.setName(replace);	s.setJumsu(num);
				return s.getName()+" : "+s.getJumsu();
			}
		}
		return null;
	}
	
	/*
	 *  과목 정보 삭제
	 */
	// 과목명으로 찾아서 제거
	public boolean deleteSubject(String find) {
		/*
		 * 1. 기존 객체배열 크기보다 작은 객체배열을 만든다.
		 * 2. 기존 객체배열의 데이터를 새로 생성한 객체배열에 깊은복사
		 * 3. 2번 과정에서 데이터를 객체배열에 복사할 때 삭제할 데이터를 제외하고 복사
		 * 4. 기존 객체배열이 저장된 변수를 새로 생성한 객체배열로 참조할 수 있게 얕은복사
		 */
		// 삭제할 데이터 값이 배열 내 존재하는지 확인하기 위해서
		// getSubjectJumsu()메서드 사용
		if (this.getSubjectJumsu(find) != -1) { // true인 경우; 객체배열 내 존재함
			Subject[] copy = new Subject[this.subjects.length - 1];
			int idx=0; // 삭제할 데이터의 인덱스의 요소는 새로운 객체배열 내 넣지 않기위해서
			// 삭제할 데이터는 빼고 나머지 데이터 새로 생성한 배열로 옮긴다.
			for(Subject s:this.subjects) {
				if(!find.equals(s.getName())) {
					copy[idx++]=s;
				}
			}
			this.subjects=copy;
			return true;
		}
		// 삭제할 데이터가 객체배열 내 존재하지 않는 경우
		// 객체배열에 변화 없음
		else {
			return false;
		}
	}
	
	// 인덱스위치로 찾아서 제거
	public boolean deleteSubject(int index) {
		if (this.getSubjectName(index) != null) { // true인 경우; 객체배열 내 존재함
			Subject[] copy = new Subject[this.subjects.length - 1];
			int idx=0;
			for(int i=0;i<subjects.length;i++) {
				if(index!=i) {
					copy[idx++]=this.subjects[i];
				}
			}
			this.subjects=copy;
			return true;
		}
		else {
			return false;
		}
	}
	
	// 등록된 과목 점수의 총합 반환
	public int total() {
		int tot=0;
		for(Subject s: this.subjects) {
			tot+=s.getJumsu();
		}
		return tot;
	}
	
	// subjects 객체배열에 저장된 과목들의 평균 구하기
	public double avg() {
		double avg=(double)(total())/this.subjects.length;
		return avg;
	}

}
