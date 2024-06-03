
import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter size of the array");
    int n = input.nextInt();
    int array[] = new int[n];

    System.out.println("Enter the elements of the array");
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }

    selectionSort(array);
    System.out.println("Sorted array is: ");
    for (int num : array) {
      System.out.print(num + " ");

    }
    input.close();
  }

  public static void selectionSort(int array[]) {
    for (int i = 1; i < array.length; i++) {
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
