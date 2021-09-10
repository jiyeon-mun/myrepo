package com.kh.exam1;

import java.io.*;
import java.util.*;

public class Sample5 {

	public static void main(String[] args) {
		/*
		 * 키와 값을 문자열로만 사용할 수 있도록 제한한 Map 객체
		 * 프로퍼티 파일을 쉽게 읽고 쓸 수 있는 기능 제공.
		 */
		Properties p = new Properties();
		p.setProperty("key1", "val1");
		p.setProperty("key2", "val2");
		p.setProperty("key3", "val3");
		p.put("key4", "val4");
		
		System.out.println(p);
		System.out.println(p.getProperty("key1"));
		
		try {
			// 현재 위치에서 prop 파일을 만들어라
			// 현재 위치: Sample5를 실행하는 위치 = project3
			p.store(new FileWriter("prop"), "My Properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Properties p2 = new Properties();
		
		try {
			p2.load(new FileReader("prop")); // prop 파일 읽어서(FileReader) 불러오기(load)
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p2);
	}

}
