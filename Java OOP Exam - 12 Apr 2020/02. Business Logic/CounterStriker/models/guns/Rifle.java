package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int BULLETS_AT_A_TIME = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() > BULLETS_AT_A_TIME){
            decreasesBulletsCount(BULLETS_AT_A_TIME);
            return BULLETS_AT_A_TIME;
        }
        return 0;
    }
}
