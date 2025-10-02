package org.example.srp.good;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// ------------------------------
// 데이터 클래스들

@Getter
@RequiredArgsConstructor
class Order {
    private final String menuName;
}

@Getter
@RequiredArgsConstructor
class Coffee {
    private final String name;
}


// --------------------------------------
// 역할 클래스들

/**
 * 역할 : 주문 담당
 */
class Kiosk {

    private PosSystem posSystem;

    public Kiosk(PosSystem posSystem) {
        this.posSystem = posSystem;
    }

    public void startOrderProcess() {
        // 1. 주문을 직접 받는다.
        Order order = takeOrder();
        // 2. 결제 PG사 한테 위임한다. -> 너가 대신 결제
        posSystem.processPayment(order);
    }

    public Order takeOrder() {
        System.out.println("손님, 아메리카노 주문을 받았습니다.");
        return  new Order("아메리카노");
    }



}

/**
 *  커피 제조
 */
class Barista {
    public Coffee makeCoffee(Order order) {
        System.out.println(order.getMenuName() + " 주문 확인 ");
        System.out.println("바리스타가 제조 ..... ");
        return new Coffee(order.getMenuName());
    }
}

/**
 * 결제 처리기
 */
class PosSystem {
    public void processPayment(Order order) {
        System.out.println(order.getMenuName() + " 주문 금액이 ??? 입니다");
        System.out.println("영수증 출력");
    }
}


public class CafeSimulation {

    public static void main(String[] args) {

        Barista barista = new Barista();
        PosSystem posSystem = new PosSystem();
        Kiosk kiosk = new Kiosk(posSystem);

        System.out.println("커피숍 영업 시작 ");

        org.example.srp.good.Order order = kiosk.takeOrder();

        System.out.println("-------------------------------");

        org.example.srp.good.Coffee coffee = barista.makeCoffee(order);

        System.out.println("-------------------------------");
        
        posSystem.processPayment(order);

        System.out.println("-------------------------------");

        System.out.println("손님 주문하신 " + coffee.getName() + " 이 나왔습니다");
        System.out.println("영업 종료");

    }
}
