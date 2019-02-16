import java.util.Scanner;

class UseRange {
    public static void main(String[] args) {
        double from = 5;
        double to = 10;
        double x = 7;

        Range range = new Range(from, to);

        System.out.println("Длинна диапозона = " + range.getLength());

        if (range.isInside(x)) {
            System.out.println("Число лежит в диапозоне");
        } else {
            System.out.println("Число не лежит в диапозоне");
        }
    }
}

