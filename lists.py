num = [6, 4, 2, 10, 20, 5, 4]
friends = ["Kevin", "Kaen", "Tommy", "John", "Kate", "Paul", "Andy"]

print(friends[1])
print(friends[0])
print(friends[-2])
print(friends[1:])   # to show data from the given index onwards
print(friends[2:5])  # to show data in a specified range
friends[3] = "Annie"
print(friends[3])
 # lists_functions

friends.extend(num)  # to combine both the lists.
friends.append("Creed")  # to add something at the end of the list.
friends.insert(1, "Allen")  # to add an element to the given position
friends.remove("Kaen")  # to remove an element.
friends.pop()  # it deletes the last element from a list.
friends.clear()  # to clear everything in a list.

friends = ["Kevin", "Kaen", "Tommy", "John", "Kate", "Paul", "Andy"]

print(friends)
print(friends.index("Kevin"))  # to check if the element is in the list

print(friends.count("Andy"))  # it tells us how many times this element is preset.

friends.sort()
print(friends)

num.sort()
print(num)

friends.reverse()
print(friends)
num.reverse()
print(num)

friend = friends.copy()

print(friend)