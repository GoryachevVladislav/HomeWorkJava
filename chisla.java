public class chisla {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 10, 7, 3};

        // Удаление чётных чисел
        int[] oddNumbers = removeEvenNumbers(numbers);

        // Найти минимальное значение
        int min = findMinimum(oddNumbers);
        System.out.println("Минимальное значение: " + min);

        // Найти максимальное значение
        int max = findMaximum(oddNumbers);
        System.out.println("Максимальное значение: " + max);

        // Найти среднее арифметическое значение
        double average = findAverage(oddNumbers);
        System.out.println("Среднее арифметическое значение: " + average);
    }

    public static int[] removeEvenNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 != 0) {
                count++;
            }
        }

        int[] oddNumbers = new int[count];
        int index = 0;
        for (int number : numbers) {
            if (number % 2 != 0) {
                oddNumbers[index] = number;
                index++;
            }
        }
        return oddNumbers;
    }

    public static int findMinimum(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static int findMaximum(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static double findAverage(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }
}
