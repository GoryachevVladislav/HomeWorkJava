
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Введите знак (+, -, *, /): ");
        String operator = scanner.next();
        
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        
        int result = 0;
        
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль");
                    return;
                }
                break;
            default:
                System.out.println("Ошибка: неверный знак операции");
                return;
        }
        
        System.out.println("Результат: " + result);
    }
}
