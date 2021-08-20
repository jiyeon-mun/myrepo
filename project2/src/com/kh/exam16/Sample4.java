package com.kh.exam16;

public class Sample4 {

	public static void main(String[] args) {
		/* StrinBuffer / StringBuilder
		 * 		- 두 클래스의 기능은 동일하나 멀티쓰레드의 안정성을 제공하는지 제공하지 않는지에 대한
		 * 		  차이만을 가진다.(StringBuffer가 멀티쓰레드의 안정성을 제공한다.)
		 */
		StringBuilder sb = new StringBuilder();
		// 하나의 객체에 대해 진행한다. 새로운 객체를 생성하지 않음.
		
		// 기존 문자열 뒤에 데이터 삽입
		sb.append("StringBuilder의 메서드");
		sb.append(" append() 는 기존 문자열 뒤에 추가 합니다.\n");
		System.out.println(sb);
		
		// 지정한 위치에 데이터 삽입. 기존 문자열이 삽딥된 데이터 뒤로 밀림.
		sb.insert(0, "StrinBuffer/");
		// StrinBuffer/StringBuilder의 메서드 append() 메서드는 기존 문자열 뒤에 추가 합니다.
		// indexOf() 메서드: 지정한 문자열의 위치 찾기
		sb.insert(sb.indexOf("append()")+9,"메서드");
		System.out.println(sb);
		
		// 수정: 수정할 문자열의 위치를 작성하여 수정
//		int sbIdx = sb.indexOf("메서드");
//		//		   시작위치, 종료위치, 	변경문자열
//		sb.replace(sbIdx, sbIdx+3, "method");
//		System.out.println(sb);
		
		// 수정 처리를 할 때 동일한 문자열에 대해 전부 수정될 수 있도록 반복문을 활용해 본다.
		int idx = -1;
		String find = "메서드";
		while(true) {
			idx=sb.indexOf(find,idx+1); // 찾는 문자열 0번 위치부터 차례로 찾으며, 반복할 때마다 다음 위치부터 찾을 수 있도록
			if(idx!=-1) {
				sb.replace(idx, idx+find.length(), "method");
			} else {
				break;
			}
		}
		System.out.println(sb);

		// 삭제
//		sbIdx = sb.indexOf("method");
//		sb.delete(sbIdx, sbIdx+7);
//		System.out.println(sb);
		
		// 삭제 처리를 할 때 동일한 문자열에 대해 전부 삭제될 수 있도록 반복문을 활용해 본다.
		idx = -1;
		find = " "
				+ "method";
		while(true) {
			idx=sb.indexOf(find,idx+1);
			if(idx!=-1) {
				sb.delete(idx, idx+find.length());
			} else {
				break;
			}
		}
		System.out.println(sb);
		
	}

}
