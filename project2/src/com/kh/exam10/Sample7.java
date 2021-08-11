package com.kh.exam10;

class Lotto{
	public Lotto() {}
}

public class Sample7 {

	public static void main(String[] args) {
		/*
		 * 클래스를 사용하여 인스턴스를 만들고 만들어진 인스턴스를 사용하는 코드를
		 * 보고 해당 코드에 적합한 클래스를 작성해보도록 한다.
		 * (단, 이 클래스는 캡슐화를 적용한다.)
		 * 
		 * 로또 번호는 1 ~ 45 까지 6개의 번호를 맞추어 등수를 정하는 복권이다.
		 */
		// 1 ~ 45 범위의 번호 6개를 생성해준다.
		Lotto lot1 = new Lotto();
		Lotto lot2 = new Lotto();
		
		// 1 ~ 45 범위의 번호 6개를 생성해준다.
		lot1.generate();
		lot2.generate();

		// 1 ~ 45 범위의 번호 6개를 생성하나 4, 6, 14 는 반드시 들어간다.
		lot1.generate(4, 6, 14);

		// 1 ~ 45 범위의 번호 6개를 생성하나 34, 31, 40 은 반드시 들어간다.
		lot2.generate(34, 21, 40);

		// 생성된 번호를 확인할 수 있다.
		lot1.getNumbers();
		lot2.getNumbers();

		// 당첨번호를 통해 등수를 확인한다.(당첨번호가 등록되지 않았기 때문에 -1을 반환하게 해야 한다.)
		lot1.getRank();
		lot2.getRank();

		int[] nums = new int[] {1, 2, 3, 4, 5, 6};
		int bonus = 7;
		// 당첨번호를 통해 등수를 확인한다.(당첨번호를 전달하여 등수를 확인한다.)
		lot1.getRank(nums, bonus);
		lot2.getRank(nums, bonus);

		// 1 ~ 45 범위의 번호 7개를 생성해준다.(이 번호는 당첨 번호로 사용할 것이다.)
		int[] numbers = Lotto.createWinnerNumbers();

		// 위에서 생성된 로또 번호를 공유 변수에 저장한다.(당첨 번호를 등록하는 것이다.)
		Lotto.setWinnerNumbers(numbers);

		// 당첨 번호를 확인할 수 있다.(보너스 포함)
		Lotto.getWinnerNumbers();

		// 당첨번호를 통해 등수를 확인한다.(당첨번호를 공유변수에 등록하여 확인한다.)
		lot1.getRank();
		lot2.getRank();
	}

}
