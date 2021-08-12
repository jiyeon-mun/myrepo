package com.kh.exam12;

class Person{
	protected String name; // protected접근제한자 부모클래스 멤버변수는 상속받은 자식클래스에서 접근하여 사용할 수 있다.
	private int age;
	private char gender;
	
	public Person() {}
	
	// 매개변수 생성자 작성하면 기본생성자는 자동으로 생성되지 않음
	public Person(String name, int age, char gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
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
	 * 단, 자식클래스에서도 역시 매개변수 생성자를 작성하고 사용한다면
	 * 부모클래스에서 굳이 기본생성자를 만들 필요가 없다.
	 */
	
	public Student(String name, int age, char gender) {
		this.setGender(gender);
		this.setAge(age);
		this.name=name; // protected접근제한자 부모클래스 멤버변수는 상속받은 자식클래스에서 접근하여 사용할 수 있다.
	}
	
	
}



public class Sample1 {
	
	public static void main(String[] args) {
		Student s = new Student("홍길동", 30, 'm');
		// s.setName("홍길동");	s.setAge(30);
		System.out.println(s);
		// 모든 클래스는 Object클래스를 기본적으로 상속받는다.
		// println에 Subject클래스 타입을 넣을 수 있다.
		// 기본으로는 클래스 인스턴스 주소 출력하나
		// 클래스 내 toString 메서드 사용하면 객체 내용 출력
		
		
	}

}
