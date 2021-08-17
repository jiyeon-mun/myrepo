package com.kh.exam12.prac;

class Person {
	private String name;
	private int age;
	
	// 부모-자식 상속관계에서
	// 부모클래스에서 반드시 기본생성자를 작성한다.
	public Person() {}
//	public Person(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personal [name=" + this.name + ", age=" + this.age + "]";
	}
}

/*
 * 학생의 정보가 있는 Student 클래스가 있다.
 * 		해당 클래스에 학년, 반, 학번, 성적을 나타내는 필드를 선언하여라.
 *      해당 클래스에 이름, 나이를 초기화하는 생성자를 작성하여라.
 *      해당 클래스에 이름, 나이 정보를 출력하는 메소드를 작성하여라.
 */
class Student extends Person{
	private int grade; // 학년
	private int group; // 반
	private int stuNum; // 번호
	private int record; // 성적점수
	
	// main()에서 호출한 매개변수가 있는 생성자 정의
	public Student(String name, int age) {
		// 매개변수 초기화
		// 부모메서드 상속받아 재사용함
		this.setName(name);
		this.setAge(age);
	}

	@Override
	public String toString() {
		return "Students [getName()=" + super.getName() + ", getAge()=" + this.getAge() + "]";
	}
}

/* 
 * 군인의 정보가 있는 Soldier 클래스가 있다.
 * 		해당 클래스에 사단, 중대, 소대, 군번, 종과를 나타내는 필드를 선언하여라.
 * 		해당 클래스에 생성자를 작성하여라.
 * 		해당 클래스에 필드 정보를 출력하는 메소드를 작성하여라.
 */
class Soldier extends Person {
	private String sadan; // 사단
	private String jungde; // 중대
	private String sode; // 소대
	private int solNum; // 군번
	private String jongrhk; // 종과
	
	// 매개변수 생성자 이용하여 자식클래스 내 생성한 멤버변수 초기화; setter, getter 생략가능
	// 이름, 나이 필드는 상속받아 사용
	public Soldier(String name, int age, String sadan, String jungde, String sode, int solNum, String jongrhk) {
		this.setName(name);
		this.setAge(age);
		this.sadan=sadan;
		this.jungde=jungde;
		this.sode=sode;
		this.solNum=solNum;
		this.jongrhk=jongrhk;
	}

	@Override
	public String toString() {
		return "Soldier\n" + "[사단=" + this.sadan + "\n중대=" + this.jungde + "\n소대=" + this.sode + "\n군번=" + this.solNum
				+ "\n종과=" + this.jongrhk + "\n이름=" + super.getName() + "\n나이=" + super.getAge() + "]";
	}
}

/*
 * 직원의 정보가 있는 Employee 클래스가 있다.
 * 		해당 클래스에 회사, 직급, 부서를 나타내는 필드를 선언하여라.
 * 		해당 클래스에 생성자를 작성하여라.
 *		해당 클래스에 필드 정보를 출력하는 메소드를 작성하여라. 
 */
class Employee extends Person {
	private String company;
	private String pos; // 직급
	private String dept; // 부서
	
	// 자식클래스 각 멤버변수 setter, getter 이용하여 전달받은 매개변수 초기화
	// 이름, 나이 필드는 부모클래스 내 접근하여 사용(상속)
	public Employee(String name, int age, String company, String pos, String dept) {
		super.setName(name);
		super.setAge(age);
		this.setCompany(company);
		this.setPos(pos);
		this.setDept(dept);
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee\n[회사=" + this.getCompany() + "\n직급=" + this.getPos() + "\n부서=" + this.getDept() + "\n이름="
				+ this.getName() + "\n나이=" + this.getAge() + "]";
	}
}

public class Prac {

	public static void main(String[] args) {

		// 자식클래스 객체s 생성 및 문자형과 정수형 2개의 매개변수를 갖는 자식생성자 호출
		Student s = new Student("홍길동",30);
		
		// 클래스 인스턴스 출력
		// 인스턴스명=>주소를 의미하지만,
		// 클래스 상속을 이용한 toString()메서드를 사용하여 어느 클래스의 어떤 값이 출력되는지 확인
		System.out.println(s);
		
		System.out.println("====군인정보====");
		Soldier sd = new Soldier("홍길영",24,"사단","중대","소대",123456,"종과");
		System.out.println(sd);
		
		System.out.println("====직원정보====");
		Employee e = new Employee("홍길순",22,"카카오","팀장","인사부");
		System.out.println(e);
	}

}