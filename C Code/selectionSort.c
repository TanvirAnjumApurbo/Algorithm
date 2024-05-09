#include <stdio.h>
#include <stdlib.h>

void selectionSort(int array[], int n);

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

  selectionSort(array, n);

  printf("Sorted array:\n");
  for (int i = 0; i < n; i++)
  {
    printf("%d ", array[i]);
  }

  free(array);
  return 0;
}

void selectionSort(int array[], int n)
{
  for (int i = 0; i < n - 1; i++)
  {
    int min = i;

    for (int j = i + 1; j < n; j++)
    {
      if (array[min] > array[j])
      {
        min = j;
      }
    }

    int temp = array[i];
    array[i] = array[min];
    array[min] = temp;
  }
}
