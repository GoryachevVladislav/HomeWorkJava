package test;

import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {9999, 8888, 7777, 6666, 5555};
        bubbleSort(array);
        
        System.out.println("Отсортированный массив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        try (FileWriter writer = new FileWriter("log.txt")) {
            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }

                writeLog(writer, array);

                if (!swapped) {
                    break; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLog(FileWriter writer, int[] array) throws IOException {
        for (int num : array) {
            writer.write(num + " ");
        }
        writer.write("\n");
    }
}
