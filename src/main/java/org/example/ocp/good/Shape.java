package org.example.ocp.good;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface Shape {
    double area();
}

@AllArgsConstructor
@Getter
class Circle implements Shape {
    private double radius;
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

@AllArgsConstructor
@Getter
class Rectangle implements Shape {
    private double width, height;
    @Override
    public double area() {
        return width * height;
    }
}

@AllArgsConstructor
@Getter
class Triangle implements Shape {
    private double base, height;
    @Override
    public double area() {
        return (base * height) / 2;
    }
}

class AreaCalculator {
    // 어떠한 도형의 면적을 계산하는 클라이언트 클래스는 이 코드를 절대 변경할 필요가 없다.
    public double calculateArea(Shape shape) {
        return shape.area();
    }

    // 테스트 코드
    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(4.0);
        Triangle triangle = new Triangle(10, 2);

        System.out.println(new AreaCalculator().calculateArea(triangle));

    }
}





