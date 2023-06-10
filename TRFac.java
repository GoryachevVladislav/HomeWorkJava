public class TRFac {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();
        
        int triangularNumber = calculateTriangularNumber(n);
        System.out.println("Треугольное число " + n + ": " + triangularNumber);
        
        long factorial = calculateFactorial(n);
        System.out.println("Факториал " + n + ": " + factorial);
    }
    
    public static int calculateTriangularNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
