package org.example.srp.bad;

public class BadBarista  {

    public void handleOrder() {
        // 역할 1의 책임: 주문 받기
        System.out.println("손님, 아메리카노 한 잔 주문받았습니다.");

        // 역할 2의 책임: 커피 제조
        System.out.println("원두를 갈고, 에스프레소를 추출합니다...");
        System.out.println("뜨거운 물을 추가하여 아메리카노를 완성합니다.");

        // 역할 3의 책임: 결제 처리
        System.out.println("5000원입니다. 카드로 결제 처리합니다.");
        System.out.println("결제가 완료되었습니다.");
    }

    public static void main(String[] args) {
        new BadBarista().handleOrder();
    }

}
