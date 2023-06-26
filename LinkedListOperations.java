public class LinkedListOperations {
    public static void main(String[] args) {
        int[] num1 = {3, 2, 1};
        int[] num2 = {5, 4, 3};

        // Умножение двух чисел
        int[] multiplicationResult = multiplyNumbers(num1, num2);
        System.out.print("Умножение: ");
        printArray(multiplicationResult);

        // Сложение двух чисел
        int[] additionResult = addNumbers(num1, num2);
        System.out.print("Сложение: ");
        printArray(additionResult);
    }

    public static int[] multiplyNumbers(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        int carry = 0;

        for (int i = 0; i < num1.length; i++) {
            int carryMultiply = 0;

            for (int j = 0; j < num2.length; j++) {
                int multiply = (num1[i] * num2[j]) + carryMultiply;
                result[i + j] += multiply % 10;
                carryMultiply = multiply / 10;
            }

            if (carryMultiply > 0) {
                result[i + num2.length] += carryMultiply;
            }
        }

        int carrySum = 0;
        for (int i = 0; i < result.length; i++) {
            int sum = result[i] + carrySum;
            result[i] = sum % 10;
            carrySum = sum / 10;
        }

        return reverseArray(result);
    }

    public static int[] addNumbers(int[] num1, int[] num2) {
        int[] result = new int[Math.max(num1.length, num2.length) + 1];
        int carry = 0;

        for (int i = 0; i < result.length; i++) {
            int digit1 = i < num1.length ? num1[i] : 0;
            int digit2 = i < num2.length ? num2[i] : 0;

            int sum = digit1 + digit2 + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }

        return reverseArray(result);
    }

    public static int[] reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
