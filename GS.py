def is_diagonally_dominant(x):
    n = len(x)
    for i in range(n):
        total = 0
        for j in range(n):
            if i != j:
                total += abs(x[i][j])
        if abs(x[i][i]) < total:
            return False
    return True


def seidel(a, x, b):
    n = len(a)
    for j in range(0, n):
        d = b[j]
        for i in range(0, n):
            if j != i:
                d -= a[j][i] * x[i]
        x[j] = d / a[j][j]
    return x


def calculate_error(previous, current):
    error = max([abs((current[i] - previous[i]) / current[i])
                * 100 for i in range(len(current))])
    return error


n = 4  # Number of variables
a = [[900, 7, 5, 8],
     [11, 1700, 100, -20],
     [17, -2, 600, -7],
     [6, 7, 110, 1100]]  # Coefficient matrix
b = [-70, 100, 60, 20]  # Constants matrix

x = [0, 0, 0, 0]  # Initial solution

print("Initial Solution:", x)

if is_diagonally_dominant(a):
    previous_x = x[:]
    for i in range(0, 300000):
        x = seidel(a, x, b)
        error = calculate_error(previous_x, x)
        print("Iteration", i + 1, ":", x, "Error:", error, "%")
        previous_x = x[:]
else:
    print("The matrix is not diagonally dominant. The Gauss-Seidel method may not converge.")
