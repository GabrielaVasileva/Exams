voucher = int(input())

count_purchased_tickets = 0
number_purchased = 0

purchase = str(input())
while voucher > 0 and purchase != "End":
    if len(purchase) > 8:  # ticket
        price = 0
        for x in range(2):
            price = price + ord(purchase[x])
        voucher = voucher - price
        if voucher < 0:
            break
        count_purchased_tickets = count_purchased_tickets + 1
    else:
        voucher = voucher - ord(purchase[0])
        if voucher < 0:
            break
        number_purchased = number_purchased + 1
    purchase = str(input())

print(count_purchased_tickets)
print(number_purchased)
