package org.example.ocp.bad;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 도형에 면적을 계산하는 일을 한다.
// 만약 도형 삼각형이 추가 된다면, 팔각형 추가 된다면... 
public class AreaCalculator {

    public double calculateCircleArea(Circle circle) {
        return Math.PI * circle.getRadius() * circle.getRadius();
    }

    public double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.getWidth() * rectangle.getHeight();
    }
    // 삼각형 구하는 메서드
    // 팔각형 구하는 메서드
    // OCP(개방-패쇄 원칙) 위반 : 확장에는 열여 있지 않고, 변경에도 닫혀 있지 않음 (문제)
}

@AllArgsConstructor
@Getter
class Circle {
    private double radius;
}

@AllArgsConstructor
@Getter
class Rectangle {
    private double width;
    private double height;
}
