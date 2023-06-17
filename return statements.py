def cube(num):
   return num*num*num
result = cube(5)
print(result)

# if statements

is_male = False
is_short = False

if is_male or is_short:
    print("You are a male")

else:
    print("You are a female")

if is_male and is_short:
    print("You are a male")

else:
    print("You are a female")


if is_male and is_short:
    print("You are a male")

elif is_male and not(is_short):
    print("You are a short Male")

else:
    print("You are a female")


if is_male and is_short:
    print("You are a male")
elif is_male and not(is_short):
    print("You are a short Male")
elif not(is_male) and not(is_short):
    print("You are not a Male but are tall")
else:
    print("You are a female")

# if statements and comparison operators
num1 = input("Enter first number")
num2 = input("Enter second number")
num3 = input("Enter third number")
def max_num(num1, num2, num3):

    if num1 >= num2 and num1>= num3:
        return num1
    elif num2>= num1 and num2 >= num3:
        return  num2
    else:
        return num3

print(max_num(num1, num2, num3))

# while loops

i = 1
while i <= 15:
    print(i)
    i += 2
    # or
    i = i + 2

print("Done with loop!")

