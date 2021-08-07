package com.kh.exam10;

class Student{
	// 클래스 캡술화
	// 멤버변수 접근권한 private
	// 멤버함수 접근권한 public으로 하여 멤버변수에 대해 접근
	private String name;
	private int age;
	private char gender;
	private int rank;
	
	public Student() {} // 기본생성자
	
	// 매개변수가 있는 생성자
	public Student(String name) {
		this.name=name;
	}
	
	// this.을 이용해 상위개념에 접근한다. 호출을 통해 받아온 매개변수를 멤버변수에 저장하여 결과로서 보여준다.
	public void setName(String name) {this.name=name;}
	public void setAge(int age) {this.age=age;}
	public void setGender(char gender) {this.gender=gender;}
	public void setRank(int rank) {this.rank=rank;}
	
	public String getName() {
		return name;
	}
	public int getNum() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public int getRank() {
		return rank;
	}
	
	// 결과출력
	public String info() {
		// +연산자는 문자열을 연결한다.
		String text = "";
		text += "이름: " + this.name + "(" + this.age + " 세)\n";
		text += "성별: " + this.gender + "\n";
		text += "성적 순위: " + this.rank + "\n";
		return text;
	}
	
	public void RankUp(int up) {
		this.rank-=up;
	}
	public void RankDown(int down) {
		this.rank+=down;
	}
	
	// 클래스를 매개변수로 가지는 멤버함수. student는 s2클래스 매개변수를 의미한다.
	public boolean isHigh(Student student) {
		// this.rank는 박지은의 등수, student.rank는 홍길동의 등수.
		if(this.rank>student.rank) {
			return true;
		}
		return false;
	}
	public boolean isLow(Student student) {
		if(this.rank<student.rank) {
			return true;
		}
		return false;
	}

}

public class Sample2 {

	public static void main(String[] args) {
		/*
		 * 클래스를 사용하여 인스턴스를 만들고 만들어진 인스턴스를 사용하는 코드를
		 * 보고 해당 코드에 적합한 클래스를 작성해보도록 한다.
		 * (단, 이 클래스는 캡슐화를 적용한다.)
		 * 캡슐화-> 변수는 private, 메서드는 public. 메서드 내 this.를 사용하여 변수에 접근한다.
		 */
		
		// 기본생성자로 접근.
		// 클래스 캡슐화로 멤버함수를 통해 멤버변수에 접근한다.
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setAge(21);
		s1.setGender('남');
		s1.setRank(100);

		/*
		 * 이름 : 홍길동(21 세)
		 * 성별 : 남
		 * 성적 순위 : 100 등
		 */
		System.out.println(s1.info());

		s1.RankUp(5);

		/*
		 * 이름 : 홍길동(21 세)
		 * 성별 : 남
		 * 성적 순위 : 95 등
		 */
		System.out.println(s1.info());

		s1.RankDown(3);

		/*
		 * 이름 : 홍길동(21 세)
		 * 성별 : 남
		 * 성적 순위 : 98 등
		 */
		System.out.println(s1.info());

		// 매개변수가 있는 생성자로 접근.
		Student s2 = new Student("박지은");
		s2.setAge(20);
		s2.setGender('여');
		s2.setRank(90);

		/*
		 * 이름 : 박지은(20 세)
		 * 성별 : 여
		 * 성적 순위 : 90 등
		 */
		System.out.println(s2.info());

		// s2는 박지은의 등수, s1은 홍길동의등수
		// 매개변수로 클래스를 가지는 멤버함수 호출
		if(s2.isHigh(s1)) {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 높습니다.");
		} else {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 높진 않습니다.");
		}

		if(s2.isLow(s1)) {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 낮습니다.");
		} else {
			System.out.println(s2.getName() + "님의 등수가 " + s1.getName() + " 님의"
					+ " 등수보다 낮진 않습니다.");
		}
	}

}
