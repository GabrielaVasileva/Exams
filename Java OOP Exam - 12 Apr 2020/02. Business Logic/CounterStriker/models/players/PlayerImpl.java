package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
//    •	username - String
//o	If the username is null or whitespace, throw a NullPointerException with message: "Username cannot be null or empty."
//o	All names are unique
//•	health -  int
//o	If the health is below 0, throw an IllegalArgumentException with message: "Player health cannot be below 0."
//•	armor -  int
//o	If the armor is below 0, throw an IllegalArgumentException with message: "Player armor cannot be below 0."
//•	isAlive -  boolean
//o	If the health is above zero
//•	gun -  Gun
//o	If the gun is null, throw a NullPointerException with message:
// "Gun cannot be null."

    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setAlive();
        setGun(gun);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health<0){
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor<0){
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setAlive() {
        this.isAlive = health > 0;
    }

    private void setGun(Gun gun) {
        if (gun == null){
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.health;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
//        this.isAlive = health > 0;
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (armor > 0){
            this.armor-=points;
        }else if (health > 0){
            this.health-=points;
        }else {
            this.isAlive = false;
        }
    }
    //    "{player type}: {player username}
//   --Health: {player health}
//   --Armor: {player armor}
//   --Gun: {player gun name}
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s: %s",this.getClass().getSimpleName(),this.getUsername()))
                .append(System.lineSeparator())
                .append(String.format("--Health: %s",this.getHealth()))
                 .append(System.lineSeparator())
                .append(String.format("--Armor: %s",this.getArmor()))
                 .append(System.lineSeparator())
                .append(String.format("--Gun: %s",this.getGun()));


        return info.toString();
    }
}
