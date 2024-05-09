import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of elements: ");
    int n = input.nextInt();

    int[] array = new int[n];

    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }

    insertionSort(array);

    System.out.println("Sorted array:");
    for (int num : array) {
      System.out.print(num + " ");
    }

    input.close();
  }

  public static void insertionSort(int[] array) {

    int n = array.length;

    for (int i = 1; i < n; i++) {
      int temp = array[i];
      int j = i - 1;

      while (j >= 0 && array[j] > temp) {
        array[j + 1] = array[j];
        j--;
      }

      array[j + 1] = temp;
    }
  }
}
