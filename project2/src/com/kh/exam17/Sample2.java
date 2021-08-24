package com.kh.exam17;

import java.text.SimpleDateFormat;
import java.util.*;

class RNumber {
	private int number;
	private Date date;
	
	public RNumber(int number, Date date) {
		this.number=number;
		this.date=date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date; // Sat Aug 21 12:36:35 KST 2021 형식
	}

	SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
	@Override
	public String toString() {
		return "RNumber [number=" + number + ", date=" + df.format(date) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	
	// 객체와 객체간의 비교는 .equals() 사용
	// equals()가 사용되면 Override하여 정의한다.
	@Override
	public boolean equals(Object obj) {
		// 객체비교
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		// ArrayList안에 객체의 속성 랜덤정수값의 비교
		RNumber other = (RNumber) obj;
		return number == other.number;
	}
	
}

public class Sample2 {

	public static void main(String[] args) {
		// 클래스 타입 객체를 갖는 ArrayList
		
		System.out.println(new Date()); // 현재시간 출력
		
		GregorianCalendar gcStart = new GregorianCalendar();
		GregorianCalendar gcEnd = null;
		Random rd = new Random();
		List<RNumber> iList = new ArrayList<RNumber>(); // 클래스 사용; 랜덤정수값과 시간 한 번에 저장

		while(iList.size() < 10) {
			gcEnd = new GregorianCalendar();
			if(((gcStart.get(Calendar.SECOND) + 3) % 60) == gcEnd.get(Calendar.SECOND)) {
				// ArrayList에 RNumber클래스의 RNumber(랜덤정수값, new Date())객체를 요소로 넣음
				// 객체 비교는 .equals() 사용; contains안에서 객체 비교 작업이 수행됨.
				RNumber temp = new RNumber(rd.nextInt(15) + 1, gcEnd.getTime());
				if(!iList.contains(temp)) {
					iList.add(temp);
					System.out.println(iList);
				}
				gcStart = gcEnd;
				// 한 개의 객체 생성할 때마다 3초의 시간이 걸림.
				// 생성된 랜덤값이 중복값인 경우 다시 3초 후 생서됨.
			}
		}

	}

}
