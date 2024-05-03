import numpy as np


def gauss_seidel(A, B, max_iterations, tolerance=1e-10):
    n = len(B)
    X = np.zeros(n)
    prev_X = np.zeros(n)

    for k in range(max_iterations):
        prev_X[:] = X[:]  # Copy current solution to prev_X

        for i in range(n):
            sum_ = sum(A[i][j] * X[j] for j in range(n) if j != i)
            X[i] = (B[i] - sum_) / A[i][i]

        # Check for division by zero
        if any(X == 0):
            print("Error: Division by zero encountered.")
            return

        # Calculate error percentage
        errors = [abs((X[i] - prev_X[i]) / X[i]) * 100 if X[i]
                  != 0 else 0 for i in range(n)]

        # Check for convergence
        if max(errors) < tolerance:
            print("Solution (Iteration {}):".format(k + 1))
            for i in range(n):
                print("X[{}] = {:.6f}, Error: {:.6f}%".format(
                    i + 1, X[i], errors[i]))
            return

    print("The method did not converge within the specified number of iterations.")


# Input
n = int(input("Enter the number of equations: "))
A = [[0] * n for _ in range(n)]
B = [0] * n

print("Enter the coefficients of the equations (A matrix):")
for i in range(n):
    A[i] = list(map(float, input(
        "Equation {} coefficients (space-separated): ".format(i + 1)).split()))

print("Enter the constants (B matrix):")
for i in range(n):
    B[i] = float(input("Constant for equation {}: ".format(i + 1)))

max_iterations = int(input("Enter the number of iterations: "))

# Solve
gauss_seidel(A, B, max_iterations)
