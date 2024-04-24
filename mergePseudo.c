mergeSort(A, lb, ub)
{
  if (lb < ub)
  {
    mid = (lb + ub) / 2;
    mergeSort(A, lb, mid);
    mergeSort(A, mid + 1, ub);
    merge(A, lb, mid, ub);
  }
}

merge(A, lb, mid, ub)
{
  i = lb;
  j = mid + 1;
  k = lb;

  while (i <= mid && j <= ub)
  {
    if (A[i] <= A[j])
    {
      B[k] = A[i];
      i++;
    }
    else
    {
      B[k] = A[j];
      j++;
    }
    k++;
  }

  if (i > mid)
  {
    while (j <= ub)
    {
      B[k] = A[j];
      j++;
      k++;
    }
  }
  else
  {
    while (i <= mid)
    {
      B[k] = A[i];
      i++;
      k++;
    }
  }

  for (k = lb; k <= ub; k++)
  {
    A[k] = B[k];
  }
}
