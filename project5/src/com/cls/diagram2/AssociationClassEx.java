package com.cls.diagram2;

import java.util.ArrayList;
import java.util.List;

class A {
	private B b;
	private List<C> c;
	
	public void method(B b) {
		this.b = b;
		b.method();
	}
	
	public void method2(List<C> c) {
		this.c = c;
	}
	
	// 의존; class A 안에서 만들어지고, 동작이 되며, class A 의 method3() 이 끝나면 D 가 사라진다.
	// 단, A 는 존재한다. method3() 만 끝난다.
	public void method3() {
		D d = new D();
		d.method();
	}
	
	public void method4(D d) {
		d.method();
	}
}

class B {
	public void method() {}
}

class C {
	public void method() {}
}

class D {
	public void method() {}
}

public class AssociationClassEx {
	// 클래스 다이어그램 연관관계 샘플용.
	
	public static void main(String[] args) {
		A a = new A();
		
		// 연관; 직접적으로 생성하지 않고 외부에서 받아옴.
		B b = new B();
		C c = new C();
		
		List<C> cArr = new ArrayList<C>();
		cArr.add(c);
		
		a.method(b);
		a.method2(cArr);
	}
}