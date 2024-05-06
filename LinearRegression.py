import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

# Data
# Reshape to make it a column vector
x = np.array([1, 2, 3, 4, 5, 6, 7]).reshape(-1, 1)
y = np.array([0.5, 2.5, 2, 4, 3.5, 6, 5.5])

# Create and fit the model
model = LinearRegression()
model.fit(x, y)

# Calculate predictions
predictions = model.predict(x)

# Plot data and best fit line
plt.scatter(x, y, label='Data')

# Plot data points
plt.plot(x, predictions, color='red', linestyle='--', label='Best Fit Line')

# Plot best fit line
plt.xlabel('X')
plt.ylabel('Y')
plt.title('Linear Regression with scikit-learn')
plt.legend()
plt.grid(True)

# Show plot
plt.show()
