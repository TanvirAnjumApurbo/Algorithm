import java.util.Scanner;

public class MergeSort {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter the size of the array");
    int n = input.nextInt();

    int arr[] = new int[n];

    System.out.println("Enter the elements of the array");
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }

    divide(arr, 0, n - 1);

    System.out.println("The sorted array is: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void divide(int arr[], int si, int ei) {

    if (si >= ei) {
      return;
    }

    int mid = si + (ei - si) / 2;
    divide(arr, si, mid);
    divide(arr, mid + 1, ei);
    conquer(arr, si, mid, ei);
  }

  public static void conquer(int arr[], int si, int mid, int ei) {

    int merged[] = new int[ei - si + 1];
    int idx1 = si; // track first array
    int idx2 = mid + 1; // track second array
    int x = 0;

    while (idx1 <= mid && idx2 <= ei) {
      if (arr[idx1] <= arr[idx2]) {
        merged[x] = arr[idx1];
        x++;
        idx1++;
      }

      else {
        merged[x] = arr[idx2];
        x++;
        idx2++;
      }
    }

    while (idx1 <= mid) {
      merged[x] = arr[idx1];
      x++;
      idx1++;
    }

    while (idx2 <= ei) {
      merged[x] = arr[idx2];
      x++;
      idx2++;
    }

    for (int i = 0, j = si; i < merged.length; i++, j++) {
      arr[j] = merged[i];
    }
  }
}