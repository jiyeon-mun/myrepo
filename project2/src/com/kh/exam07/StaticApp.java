package com.kh.exam07;
/* 클래스와 인스턴스, static 유무에 대한 차이 알아보기
static 은 클래스의 소속을 의미하는데 
static 으로 선언된 메서드, 변수에 대해 클래스명을 이용하여 접근이 가능하다. */

class Foo {
	// 클래스 변수: static으로 선언된 클래스 변수의 값은 클래스를 이용해 생성된 인스턴스 변수의 값과 서로 영향을 끼친다.
  public static String classVar = "I class var";
  // 인스턴스 변수
  public String instanceVar = "I instance var";
  
  // 클래스 메소드(? static 이 존재함)
  public static void classMethod() {
      System.out.println(classVar); // Ok
//    System.out.println(instanceVar); // Error; 클래스 메소드 내에서 인스턴스 변수에 접근 불가능
  }
  
  // 인스턴스 메소드(? static 이 존재하지 않음)
  public void instanceMethod() {
      System.out.println(classVar); // Ok
      System.out.println(instanceVar); // Ok; 인스턴스 메소드 내에서 클래스 변수에 접근 가능
  }
}

public class StaticApp {

  public static void main(String[] args) {
      System.out.println(Foo.classVar); // OK (? Foo 클래스 내 classVar 변수는 static 으로 선언되어 클래스명을 이용해 접근가능함)
//    System.out.println(Foo.instanceVar); // Error (? 인스턴스 변수는 인스턴스를 통해 접근 가능하다.)
      
      Foo.classMethod();
//    Foo.instanceMethod(); // Error
      
      // 클래스를 이용해 인스턴스 생성
      Foo f1 = new Foo();
      Foo f2 = new Foo();
    
      System.out.println(f1.classVar); // I class var
      System.out.println(f1.instanceVar); // I instance var
    
      // classVar 는 static 으로 선언된 클래스 변수로 인스턴스 변수와 서로 영향을 끼친다.
      f1.classVar = "changed by f1";
      System.out.println(Foo.classVar); // changed by f1
      System.out.println(f2.classVar);  // changed by f1
    
      // instanceVar 는 인스턴스 변수로 f1 인스턴스 변수의 값을 바꿔도 f2 인스턴스의 변수의 값에는 영향을 미치지 않는다.
      f1.instanceVar = "changed by f1";
      System.out.println(f1.instanceVar); // changed by f1
      System.out.println(f2.instanceVar); // I instance var; f1 인스턴스와는 다른 독립적인 f2 인스턴스임.
  }

}
