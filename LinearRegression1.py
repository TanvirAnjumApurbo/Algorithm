import numpy as np
import matplotlib.pyplot as plt

# Data
x = np.array([1, 2, 3, 4, 5, 6, 7])
y = np.array([0.5, 2.5, 2, 4, 3.5, 6, 5.5])

# Perform linear regression
slope, intercept = np.polyfit(x, y, 1)

# Calculate best fit line
best_fit_line = slope * x + intercept

# Plot data and best fit line
plt.scatter(x, y, label='Data')

# Plot data points
plt.plot(x, best_fit_line, color='red', linestyle='--', label='Best Fit Line')

# Plot best fit line
plt.xlabel('X')
plt.ylabel('Y')
plt.title('Linear Regression')
plt.legend()
plt.grid(True)

# Show plot
plt.show()
