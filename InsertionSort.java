import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of elements: ");
    int n = input.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }

    insertionSort(arr);

    System.out.println("Sorted array:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void insertionSort(int[] arr) {
    int n = arr.length;

    for (int i = 1; i < n; i++) {
      int temp = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > temp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = temp;
    }
  }
}
