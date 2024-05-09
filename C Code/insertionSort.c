#include <stdio.h>
#include <stdlib.h>

void insertionSort(int array[], int n);

int main()
{
  int n;
  printf("Enter the number of elements: ");
  scanf("%d", &n);

  int *array = (int *)malloc(n * sizeof(int));

  printf("Enter the elements:\n");
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &array[i]);
  }

  insertionSort(array, n);

  printf("Sorted array:\n");
  for (int i = 0; i < n; i++)
  {
    printf("%d ", array[i]);
  }

  free(array);
  return 0;
}

void insertionSort(int array[], int n)
{
  for (int i = 1; i < n; i++)
  {
    int temp = array[i];
    int j = i - 1;

    while (j >= 0 && array[j] > temp)
    {
      array[j + 1] = array[j];
      j--;
    }

    array[j + 1] = temp;
  }
}
