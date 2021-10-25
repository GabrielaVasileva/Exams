films = {}
highest = -1
average = 0.0
lowest = 11.0
num = int(input())

for i in range(0, num):
    key = input()
    value = float(input())
    films[key] = value

for key, value in films.items():
    average = average + value
    if highest < value:
        highest = value
    if lowest > value:
        lowest = value

average = average / num

for key, value in films.items():
    if value == highest:
        print(key + " is with highest rating: %.1f" % highest)
    if value == lowest:
        print(key + " is with lowest rating: %.1f" % lowest)

print("Average rating: %.1f" % average)
