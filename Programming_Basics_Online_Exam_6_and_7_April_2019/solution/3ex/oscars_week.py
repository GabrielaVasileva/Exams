# Филм	            normal	    luxury	    ultra luxury
# A Star Is Born	7.50 лв.	10.50 лв.	13.50 лв.
# Bohemian Rhapsody	7.35 лв.	9.45 лв.	12.75 лв.
# Green Book	    8.15 лв.	10.25 лв.	13.25 лв.
# The Favourite	    8.75 лв.	11.55 лв.	13.95 лв.

movie_name = input()
hall = input()
num_tickets = float(input())

income = 0.0

if movie_name == "A Star Is Born":
    if hall == "normal":
        income = num_tickets * 7.50
    elif hall == "luxury":
        income = num_tickets * 10.50
    elif hall == "ultra luxury":
        income = num_tickets * 13.50
elif movie_name == "Bohemian Rhapsody":
    if hall == "normal":
        income = num_tickets * 7.35
    elif hall == "luxury":
        income = num_tickets * 9.45
    elif hall == "ultra luxury":
        income = num_tickets * 12.75
elif movie_name == "Green Book":
    if hall == "normal":
        income = num_tickets * 8.15
    elif hall == "luxury":
        income = num_tickets * 10.25
    elif hall == "ultra luxury":
        income = num_tickets * 13.25
elif movie_name == "The Favourite":
    if hall == "normal":
        income = num_tickets * 8.75
    elif hall == "luxury":
        income = num_tickets * 11.55
    elif hall == "ultra luxury":
        income = num_tickets * 13.95
else:
    print("error!")



print(movie_name + " -> %.2f lv." %  income)