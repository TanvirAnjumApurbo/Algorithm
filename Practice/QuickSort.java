import java.util.Scanner;

public class QuickSort {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter the size of the array");
    int n = input.nextInt();

    int array[] = new int[n];

    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }

    quickSort(array, 0, n - 1);

    System.out.println("Sorted array is ");
    for (int num : array) {
      System.out.print(num + " ");
    }
  }

  public static void quickSort(int array[], int start, int end) {
    if (end <= start)
      return;

    int pivotIndex = partition(array, start, end);
    quickSort(array, start, pivotIndex - 1);
    quickSort(array, pivotIndex + 1, end);
  }

  public static int partition(int array[], int start, int end) {
    int pivot = array[end];
    int i = start - 1;

    for (int j = start; j <= end; j++) {
      if (array[j] < pivot) { 
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    i++;
    int temp = array[i];
    array[i] = array[end];
    array[end] = temp;

    return i;
  }
}
