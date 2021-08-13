package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		// r.setX(x);	r.setY(y);	r.setHeight(height);	r.setWidth(width);
		r = new Rectangle(x, y, height, width);
		int area = height * width;
		return r.toString() + " / " + area;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);	r.setY(y);	r.setHeight(height);	r.setWidth(width);
		int perimeter = 2 * (height + width);
		return r.toString() + " / " + perimeter;
	}
	
	public String calcSplit(int x, int y, float height, float width, int split) {
		/*
		 * 사각형을 분리하고 분리된 사각형의 정보를 반환하는 메서드
		 */
		String ret = "";
		Rectangle[] rArr = new Rectangle[split];
		int mod = split % 2;
		split = split / 2;
		
		for(int i = 0; i < rArr.length; i++) {
			// 분할개수가 홀수이고 배열인덱스가 뒤에서 2번째일 때
			if(mod == 1 && i == rArr.length - 2) {
				
				rArr[i] = new Rectangle(x, y, width/split, height/4);
				rArr[i+1] = new Rectangle(x, y, width/split, height/4);
				break;
			}
			
			if(rArr.length - 1 == 0) {
				rArr[i] = new Rectangle(x, y, width, height);
			} else {
				rArr[i] = new Rectangle(x, y, width/split, height/2);
			}
			
		}
		
		for(Rectangle re: rArr) {
			ret += re.toString() + "/";
		}
		
		return ret;
	}
}
