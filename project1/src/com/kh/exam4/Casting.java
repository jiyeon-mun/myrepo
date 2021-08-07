package com.kh.exam4;

public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 100;
		int y = 200;
		byte z = (byte) (x + y);
		System.out.println(z);

		float f1 = z;
		System.out.println(f1);

		int res = (int) f1 + 10;
		System.out.println(res);
	}

}
