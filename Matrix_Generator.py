import numpy as np


def generate_symmetric_positive_definite_matrix(n):
    while True:

        A = np.random.randint(-10, 10, size=(n, n))

        A = (A + A.T) / 2

        if np.all(np.linalg.eigvals(A) > 0):
            return A.astype(int)


n = 5  # Size of the matrix
sym_pos_def_matrix = generate_symmetric_positive_definite_matrix(n)
print("Symmetric Positive Definite Matrix:")
print(sym_pos_def_matrix)
