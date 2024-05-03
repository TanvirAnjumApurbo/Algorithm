import numpy as np


def is_symmetric(matrix):
    return np.array_equal(matrix, matrix.T)


def is_positive_definite(matrix):
    if not is_symmetric(matrix):
        return False

    eigenvalues = np.linalg.eigvals(matrix)
    if all(eigenvalues > 0):
        return True
    return False


def cholesky_decomposition(matrix):
    if not is_positive_definite(matrix):
        print("The matrix is not symmetric positive definite. Cholesky decomposition cannot be performed.")
        return None
    else:
        L = np.linalg.cholesky(matrix)
        return L


def main():
    rows = int(input("Enter the number of rows: "))
    cols = int(input("Enter the number of columns: "))

    print("Enter the elements of the matrix row-wise:")
    matrix = []
    for i in range(rows):
        row = list(map(float, input().split()))
        matrix.append(row)

    matrix = np.array(matrix)

    if not is_symmetric(matrix):
        print("The matrix is not symmetric. Cholesky decomposition cannot be performed.")
    else:
        L = cholesky_decomposition(matrix)
        if L is not None:
            print("Lower triangular matrix after Cholesky decomposition:")
            print(L)


if __name__ == "__main__":
    main()
