#include <stdio.h>
#include <stdlib.h>

void mergeSort(int array[], int length);
void merge(int leftArray[], int rightArray[], int array[], int leftSize, int rightSize);

int main()
{
  int n;
  printf("Enter the size of the array: ");
  scanf("%d", &n);

  int *array = (int *)malloc(n * sizeof(int));

  printf("Enter the elements of the array: ");
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &array[i]);
  }

  mergeSort(array, n);

  printf("The sorted array is: ");
  for (int i = 0; i < n; i++)
  {
    printf("%d ", array[i]);
  }

  free(array);
  return 0;
}

void mergeSort(int array[], int length)
{
  if (length <= 1)
    return;

  int middle = length / 2;
  int *leftArray = (int *)malloc(middle * sizeof(int));
  int *rightArray = (int *)malloc((length - middle) * sizeof(int));

  for (int i = 0; i < middle; i++)
  {
    leftArray[i] = array[i];
  }
  for (int i = middle; i < length; i++)
  {
    rightArray[i - middle] = array[i];
  }

  mergeSort(leftArray, middle);
  mergeSort(rightArray, length - middle);
  merge(leftArray, rightArray, array, middle, length - middle);

  free(leftArray);
  free(rightArray);
}

void merge(int leftArray[], int rightArray[], int array[], int leftSize, int rightSize)
{
  int i = 0, l = 0, r = 0;

  while (l < leftSize && r < rightSize)
  {
    if (leftArray[l] < rightArray[r])
    {
      array[i] = leftArray[l];
      i++;
      l++;
    }
    else
    {
      array[i] = rightArray[r];
      i++;
      r++;
    }
  }

  while (l < leftSize)
  {
    array[i] = leftArray[l];
    i++;
    l++;
  }

  while (r < rightSize)
  {
    array[i] = rightArray[r];
    i++;
    r++;
  }
}