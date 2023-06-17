num1 = int(input("Enter first number: "))
num2 =int(input("Enter second number: "))
operator = input("Enter the operator sign: ")

if operator == "+":
    print(num1 + num2)

elif operator == "*":
    print(num1 * num2)

elif operator == "-":
    print(num1 - num2)

elif operator == "/":
    print(num1 / num2)

else:
    print("Invalid Number")
    