partition(A, l, h)
{
  pivot = A[l];
  i = l;
  j = h;
  while (i < j)
  {
    do
    {
      i++;
    } while (A[i] <= pivot);
    do
    {
      j--;
    } while (A[j] > pivot);
    if (i < j)
    {
      swap(A[i], A[j]);
    }
  }
  swap(A[l], A[j]);
  return j;
}

quickSort(A, l, h)
{
  if (l < h)
  {
    j = partition(A, l, h);
    quickSort(A, l, j);
    quickSort(A, j + 1, h);
  }
}