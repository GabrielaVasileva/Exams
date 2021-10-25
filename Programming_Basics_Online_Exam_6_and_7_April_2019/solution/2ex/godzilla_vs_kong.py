film_budget = float(input())
extras_num = int(input())
clothing_price = float(input())

film_set = (0.10 * film_budget)

if extras_num > 150:
    clothing_price = clothing_price - (0.10*clothing_price)


if clothing_price * extras_num + film_set > film_budget:
    print("Not enough money!")
    print("Wingard needs %.2f leva more." %((film_budget - (clothing_price*extras_num + film_set))*(-1)))
else:
    print("Action!")
    print("Wingard starts filming with %.2f leva left." %(film_budget - (clothing_price*extras_num + film_set)))