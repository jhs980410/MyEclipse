package hk.exam.eight;

import java.util.IllegalFormatCodePointException;
import java.util.Set;

// 면세점
public class FreeShop {

	// 면세점이 열리면 책, 컴퓨터, Tv, 스마트폰을 한개 판매 가능하다
	// 상품을 한번 판매한 경우 해당 상품은 존재하지 않는다. ex) 책을 팔았으면 책은 존재하지 않음 하지만 나머지 상품은 존재한다.

	double storeMoney = 0; // 주인장의 소지금
	private Book book = null; // 책 한권
	private Computer computer = null; // 컴퓨터 한개
	private Tv tv = null; // Tv 한개
	private SmartPhone smartPhone = null; // 스마트폰 한개

	public FreeShop() {
		super();
	}

	public FreeShop(Book book, Computer computer, Tv tv, SmartPhone smartPhone) {
		this.storeMoney = 100000; // 초기자금은 무조건 10만원
		this.book = book;
		this.computer = computer;
		this.tv = tv;
		this.smartPhone = smartPhone;
	}

	// 물건 구입
	// 메서드명 buy로 작성하시오
	/**
	 * @param customer 고객
	 * @param ??       어떤 상품을 살까
	 * @throws CloneNotSupportedException
	 */

	// 물건이 존재하는지 여부

	// 물건이 존재하면 구매 가능여부 확인
	// 나의 소지금으로 해당 상품의 구매가 가능하면

	// 나의 소지금으로 해당 상품의 구매가 불가능하면

	public void buy(Customer customer, Product product) {
		if (product instanceof Book && this.book == null) {
			System.out.println(product.name+"은 팔렸습니다.");
			return;
		} else if (product instanceof Computer && this.computer == null) {
			System.out.println(product.name+"은 팔렸습니다.");
			return;
		} else if (product instanceof SmartPhone && this.smartPhone == null) {
			System.out.println(product.name+"은 팔렸습니다.");
			return;
		} else if (product instanceof Tv && this.tv == null) {
			System.out.println(product.name+"은 팔렸습니다.");
			return;
		}
		if (customer.getMoney() > product.price) {

			if (product instanceof Book && this.book != null) {

				storeMoney += product.price;
				customer.setMoney(customer.getMoney() - product.price);
				double bonusPoints = product.price * 0.0713; // 7.13% 계산
				customer.setMyBonusPoint(customer.getMyBonusPoint() + bonusPoints); //
				customer.setProductList(product);
				System.out.println(product.name + "을 구매하셨습니다.");
				this.book = null;
			} else if (product instanceof Computer && this.computer != null) {

				storeMoney += product.price;
				customer.setMoney(customer.getMoney() - product.price);
				double bonusPoints = product.price * 0.0713; // 7.13% 계산
				customer.setMyBonusPoint(customer.getMyBonusPoint() + bonusPoints); //
				customer.setProductList(product);
				System.out.println(product.name + "을 구매하셨습니다.");
				this.computer = null;
			} else if (product instanceof SmartPhone && this.smartPhone != null) {

				storeMoney += product.price;
				customer.setMoney(customer.getMoney() - product.price);
				double bonusPoints = product.price * 0.0713; // 7.13% 계산
				customer.setMyBonusPoint(customer.getMyBonusPoint() + bonusPoints); //
				customer.setProductList(product);
				System.out.println(product.name + "을 구매하셨습니다.");
				this.smartPhone = null;
			} else if (product instanceof Tv && this.tv != null) {

				storeMoney += product.price;
				customer.setMoney(customer.getMoney() - product.price);
				double bonusPoints = product.price * 0.0713; // 7.13% 계산
				customer.setMyBonusPoint(customer.getMyBonusPoint() + bonusPoints); //
				customer.setProductList(product);
				System.out.println(product.name + "을 구매하셨습니다.");
				this.tv = null;
			}
		}

		if (product == null) {
			System.out.println(product.name + "은 다팔렸습니다");
			return;
		} else if (customer.getMoney() < product.price) {
			System.out.println(product.name + "을 구매하기에");
			System.out.println((product.price - customer.getMoney()) + "가 부족합니다");
		}

	}

	@Override
	public String toString() {
		return "FreeShop 상태 = 매진: [storeMoney=" + storeMoney + ", book=" + book + ", computer=" + computer + ", tv="
				+ tv + ", smartPhone=" + smartPhone + "]";
	}

}
