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
		
		// 임시로 전달받은 매개변수가 잘 저장됐는지 확인
//		for(Subject s:this.subjects) {
//			System.out.print(s.getName()+":"+s.getJumsu()+" ");
//		}
//		System.out.println();
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
	
	// subjects 객체배열에 저장된 과목 점수 반환
	// 과목명으로 검색하여 반환 (없는 과목명의 경우 -1 반환)
	public String getSubjectName(String subjectName) {
		return "";
	}
	
	// subjects 객체배열에 저장된 과목명을 반환
	// 위치값으로 과목의 정보를 반환할 수 있게 한다. (잘못된 인덱스 번호 사용하면 null 반환)
	public String getSubjectName(int index) {
		return "";
	}

}
