#include <stdio.h>

void quickSort(int array[], int start, int end);
int partition(int array[], int start, int end);

int main()
{
  int n;
  printf("Enter the size of the array: ");
  scanf("%d", &n);

  int array[n];

  printf("Enter the elements of the array: ");
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &array[i]);
  }

  quickSort(array, 0, n - 1);

  printf("The sorted array is: ");
  for (int i = 0; i < n; i++)
  {
    printf("%d ", array[i]);
  }

  return 0;
}

void quickSort(int array[], int start, int end)
{
  if (end <= start)
    return;

  int pivotIndex = partition(array, start, end);
  quickSort(array, start, pivotIndex - 1);
  quickSort(array, pivotIndex + 1, end);
}

int partition(int array[], int start, int end)
{
  int pivot = array[end];
  int i = start - 1;

  for (int j = start; j <= end; j++)
  {
    if (array[j] < pivot)
    {
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
