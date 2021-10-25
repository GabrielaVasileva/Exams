hall_rent = float(input())

statuette = hall_rent - (0.30 * hall_rent)
catering = statuette - (0.15 * statuette)
Sound = catering / 2
sm = hall_rent + statuette + catering + Sound
print("%.2f" %sm)
