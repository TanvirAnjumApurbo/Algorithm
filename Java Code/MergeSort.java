import java.util.Scanner;

public class MergeSort {
  public static void main(String args[]) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter the size of the array");
    int n = input.nextInt();
    int[] array = new int[n];

    System.out.println("Enter the elements of the array");
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }

    mergeSort(array);

    System.out.println("The sorted array is:");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }

    input.close();
  }

  private static void mergeSort(int[] array) {

    int length = array.length;
    if (length <= 1)
      return; // base case

    int middle = length / 2;
    int[] leftArray = new int[middle];
    int[] rightArray = new int[length - middle];

    int i = 0; // left array
    int j = 0; // right array

    for (; i < length; i++) {

      if (i < middle) {
        leftArray[i] = array[i];
      } else {
        rightArray[j] = array[i];
        j++;
      }
    }

    mergeSort(leftArray);
    mergeSort(rightArray);
    merge(leftArray, rightArray, array);
  }

  private static void merge(int[] leftArray, int[] rightArray, int[] array) {

    int leftSize = array.length / 2;
    int rightSize = array.length - leftSize;
    int i = 0, l = 0, r = 0; // indices

    // check the conditions for merging
    while (l < leftSize && r < rightSize) {

      if (leftArray[l] < rightArray[r]) {
        array[i] = leftArray[l];
        i++;
        l++;
      } else {
        array[i] = rightArray[r];
        i++;
        r++;
      }
    }

    while (l < leftSize) {
      array[i] = leftArray[l];
      i++;
      l++;
    }

    while (r < rightSize) {
      array[i] = rightArray[r];
      i++;
      r++;
    }
  }
}