package com.kh.exam12;

class Person{
	protected String name; // protected접근제한자 부모클래스 멤버변수는 상속받은 자식클래스에서 직접접근하여 사용할 수 있다.
	private int age;
	
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


//자식클래(Student)는 부모클래스(Person)을 상속받음
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
		// super(); 부모생성자 호출
		// 기본적으로 자식생성자에 부모생성자가 포함되어 있음
		// 자식클래스 생성자 안에는 부모생성자를 호출하는 super()는 첫 줄에 존재함
		// 매개변수가 있는 부모생성자 호출은 super(매개변수...);
		
		// super.키워드;
		// 상속을 통한 자식클래스 정의 시, 해당 자식클래스의 부모객체를 가리키는 참조변수로
		// 자식클래스 내에서 부모클래스 객체에 접근하여 필드나 메소드 호출 시 사용
		
		
//		this.setAge(age);
//		this.name=name; // protected접근제한자 부모클래스 멤버변수는 상속받은 자식클래스에서 직접접근하여 사용할 수 있다.
		
	}

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
