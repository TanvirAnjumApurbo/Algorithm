import java.util.Scanner;

public class QuickSort {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter the size of the array");
    int n = input.nextInt();

    int arr[] = new int[n];

    System.out.println("Enter the elements of the array");
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }

    quicksort(arr, 0, n - 1);

    System.out.println("The sorted array is: ");
    for (int num:arr) {
      System.out.print(num + " ");
    }
  }

  public static void quicksort(int arr[], int low, int high) {

    if (low < high) {
      int pIdx = partition(arr, low, high);
      quicksort(arr, low, pIdx - 1);
      quicksort(arr, pIdx + 1, high);
    }
  }

  public static int partition(int arr[], int low, int high) {

    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    i++;
    int temp = arr[i];
    arr[i] = pivot;
    arr[high] = temp;

    return i;
  }
}