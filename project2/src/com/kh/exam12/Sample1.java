package com.kh.exam12;

class Person{
	protected String name; // 부모클래스 내 protected 접근제한자를 갖는 멤버변수는 상속받은 자식클래스에서 직접적으로 접근하여 사용할 수 있다.
	private int age; // private 멤버에 대해서는 직접 접근이 불가하며 setter, getter이용해 접근
	
	public Person() {}
	
	// 매개변수 생성자 작성하면 기본생성자는 자동으로 생성되지 않음
	public Person(String name, int age) {
		this.name="부모: "+name;
		this.age=age;
	}

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

	// 객체 내용 출력 도와주는 toString()메서드
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}


// 자식클래스(Student)는 부모클래스(Person)를 상속받음
// 멤버함수, 변수 모든 내용 상속받으나(단, 생성자는 상속불가)
// private 멤버에 대해서는 직접 접근이 불가하며 setter, getter이용해 접근
class Student extends Person {
	/*
	 * 클래스 생성하면 기본생성자가 자동적으로 생성됨(암시적)
	 * 매개변수 생성자를 작성하면 기본생성자는 자동적으로 생성되지 않는데
	 * 이 때 명시적으로 기본생성자를 작성해야 한다.
	 * 
	 * 부모클래스를 상속받는 자식클래스 생성 시 자식클래스에는 기본생성자가 자동으로 생성되는데
	 * 이 때 부모클래스에는 명시적으로 기본생성자를 정의해야 한다.
	 * 자식클래스 생성 시, 부모 클래스가 먼저 실행됨
	 */
	
	public Student(String name, int age) {
		
		super(name, age);
		// 부모클래스의 String, int형 2개의 매개변수를 갖는 생성자 호출
		// 기본적으로 자식생성자에 부모생성자가 포함되어 있음
		// 자식클래스 생성자 안에는 부모생성자를 호출하는 super()는 첫 줄에 존재함
		
		// super.키워드;
		// 상속을 통한 자식클래스 정의 시, 해당 자식클래스의 부모객체를 가리키는 참조변수로
		// 자식클래스 내에서 부모클래스 객체에 접근하여 필드나 메소드 호출 시 사용
		
		
//		this.setAge(age); 	private 멤버에 대해서는 직접 접근이 불가하며 setter, getter이용해 접근
//		this.name=name; 	부모클래스 내 protected 접근제한자를 갖는 멤버변수는 상속받은 자식클래스에서 직접적으로 접근하여 사용할 수 있다.
		
	}

	/*
	 * 오버라이딩(Overriding)
	 * 자식클래스가 상속받은 부모 클래스의 메소드를 재정의하는 것
	 * 자식 객체를 통한 실행 시 후손 것이 우선권을 가짐.
	 * 
	 * 특징
	 * 		메소드 헤드라인 위에 반드시 @Override 표시
	 * 		접근제어자를 부모의 것보다 같거나 넓은 범위로 변경 가능
	 * 성립조건
	 * 		부모클래스 메서드와 자식클래스 메서드를 비교하는데
	 * 		메소드명, 매개변수 타입과 개수가 동일
	 * 		리턴타입(반환형) 동일
	 * 		private, final 메서드는 오버라이딩 불가
	 * 				(final은 상수지정이 아닌, '프로그램 실행 후 한 번만 초기화한다'의 의미)
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + getAge() + "]";
	}
	
	
}



public class Sample1 {
	
	public static void main(String[] args) {
		Student s = new Student("홍길동", 30);
		// s.setName("홍길동");	s.setAge(30);
		System.out.println(s);
		// 모든 클래스는 Object클래스를 기본적으로 상속받는다.
		// println에 Subject클래스 타입을 넣을 수 있다.
		// 기본으로는 클래스 인스턴스 주소 출력하나
		// 클래스 내 toString 메서드 사용하면 객체 내용 출력
		
		
	}

}
