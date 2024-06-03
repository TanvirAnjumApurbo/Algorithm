import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter size of the array");
    int n = input.nextInt();

    int array[] = new int[n];

    System.out.println("Enter the element of the array");
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }

    selectionSort(array);
    for (int num : array) {
      System.out.print(num + " ");
    }
    input.close();
  }

  public static void selectionSort(int array[]) {
    for (int i = 0; i < array.length - 1; i++) {

      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[min] > array[j])
          min = j;
      }
      int temp = array[i];
      array[i] = array[min];
      array[min] = temp;
    }
  }
}
