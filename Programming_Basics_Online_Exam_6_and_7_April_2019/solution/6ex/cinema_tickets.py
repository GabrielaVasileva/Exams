total_tickets = 0
student_tickets = 0
standard_tickets = 0
kids_tickets = 0


# •	След всеки филм да се отпечата, колко процента от кино залата е пълна
# "{името на филма} - {процент запълненост на залата}% full."
# •	При получаване на командата "Finish" да се отпечатат четири реда:
# o	"Total tickets: {общият брой закупени билети за всички филми}"
# o	"{процент на студентските билети}% student tickets."
# o	"{процент на стандартните билети}% standard tickets."
# o	"{процент на детските билети}% kids tickets."

def percentage(part, whole):
    percentage = 100 * float(part) / float(whole)
    return str(percentage) + "%"


inputRow = input()
while inputRow != "Finish":
    num = int(input())
    total_local = 0
    for i in range(0, num):
        ticket = input()
        if ticket == "End":
            break
        if ticket == "student":
            student_tickets += 1
        if ticket == "standard":
            standard_tickets += 1
        if ticket == "kid":
            kids_tickets += 1
        total_tickets += 1
        total_local += 1
    print("%s - "%inputRow+"%.2f" % (100 * float(total_local) / float(num)) + "% full.")
    inputRow = input()

print(f"Total tickets: {total_tickets}")

print("%.2f" % (100 * float(student_tickets) / float(total_tickets)) + "% student tickets.")
print("%.2f" % (100 * float(standard_tickets) / float(total_tickets)) + "% standard tickets.")
print("%.2f" % (100 * float(kids_tickets) / float(total_tickets)) + "% kids tickets.")
