# Natural Number Calculator

## Description
The **Natural Number Calculator** is a Java application featuring a graphical user interface (GUI) that performs exact arithmetic operations on natural numbers (non-negative integers) of unlimited size. The application is implemented using the **Model-View-Controller (MVC)** design pattern and the **Swing framework**.

This project demonstrates the integration of GUI development with precise arithmetic operations using the `NaturalNumber` component family.

---

## Objectives
1. Develop a Java application using the **Swing framework**.
2. Implement the **Model-View-Controller (MVC)** design pattern.
3. Handle precise arithmetic computations with the `NaturalNumber` component.
4. Ensure robustness and usability for real-world inputs.

---

## Features
### 1. Arithmetic Operations
- **Supported operations**:
  - Addition
  - Subtraction
  - Multiplication
  - Division
  - Power
  - Root (limited to smaller inputs for efficiency)

### 2. Graphical User Interface
- A user-friendly GUI built with the Swing framework.
- Real-time updates to the calculator display based on user input.

### 3. Unlimited Precision
- Operates on natural numbers with no explicit size bounds.
- Handles computations involving very large numbers, except in cases where recursion depth limits are exceeded.

### 4. Error Handling
- Prevents crashes due to invalid operations or user inputs.
- Includes safeguards against stack overflow for deeply nested recursive calls.

---

## Technologies Used
- **Java Swing**: For GUI development.
- **NaturalNumber** component family: For exact arithmetic with natural numbers.
- **Model-View-Controller (MVC)**: For modular and maintainable code.

---

## How to Run
### Prerequisites
- Java Development Kit (JDK)
- Eclipse IDE or any Java-compatible IDE

### Steps
1. Clone the repository:
   ```bash
   git clone [repository URL]
