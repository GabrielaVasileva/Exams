package halfLife;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player

    @Test
    public void validateConstructorValid(){
        Player player = new Player("Player",10);

        String expectedName = "Player";
        int expectedHealth = 10;

        String actualName = player.getUsername();
        int actualCapacity = player.getHealth();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedHealth, actualCapacity);
    }

    @Test(expected = NullPointerException.class)
    public void validateConstructorInvalid1(){
        Player player = new Player(null,10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateConstructorInvalid2(){
        Player player = new Player("Player",-1);

    }

    @Test
    public void validateRemoveMethodInvalid() {
        Player player = new Player("Player",10);
        Gun pistol1 = new Gun("Pistol1", 10);
        Gun pistol2 = new Gun("Pistol2", 10);
        Gun pistol3 = new Gun("Pistol3", 10);
        player.addGun(pistol1);
        player.addGun(pistol2);
        player.addGun(pistol3);
        player.removeGun(pistol1);

        ArrayList guns = new ArrayList<>();
        guns.add(pistol1);
        guns.add(pistol2);
        guns.add(pistol3);
        guns.remove(pistol1);

        Assert.assertArrayEquals(guns.toArray() ,player.getGuns().toArray());


    }

    @Test
    public void validateAddMethodValid() {
        Player player = new Player("Player",10);
        Gun pistol = new Gun("Pistol", 10);
        player.addGun(pistol);

        int expectedSize = 1;
        int actualSize = player.getGuns().size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void validateGetHealthValid(){
        Player player = new Player("Player",10);

        int expectedHealth = 10;

        int actualCapacity = player.getHealth();
        Assert.assertEquals(expectedHealth, actualCapacity);
    }


    @Test
    public void validateGetUsernameValid(){
        Player player = new Player("Player",10);

        String expectedName = "Player";

        String actualName = player.getUsername();

        Assert.assertEquals(expectedName, actualName);
    }



    @Test
    public void validateAddGunsValid() {
        Player player = new Player("Player",10);
        Gun pistol1 = new Gun("Pistol1", 10);
        Gun pistol2 = new Gun("Pistol2", 10);
        Gun pistol3 = new Gun("Pistol3", 10);
        player.addGun(pistol1);
        player.addGun(pistol2);
        player.addGun(pistol3);

        ArrayList guns = new ArrayList<>();
        guns.add(pistol1);
        guns.add(pistol2);
        guns.add(pistol3);

        Assert.assertArrayEquals(guns.toArray() ,player.getGuns().toArray());
    }


    @Test(expected = NullPointerException.class)
    public void validateAddGunsInvalid() {
        Player player = new Player("Player",10);
        Gun pistol1 = new Gun("Pistol1", 10);
        player.addGun(null);

    }

    @Test(expected = IllegalStateException.class)
    public void validateTakeDamageInvalid() {
        Player player = new Player("Player",0);
        Gun pistol = new Gun("Pistol", 10);
        player.addGun(pistol);

        player.takeDamage(11);
    }

    @Test
    public void validateTakeDamageValid() {
        Player player = new Player("Player",10);
        Gun pistol = new Gun("Pistol", 10);
        player.addGun(pistol);

        player.takeDamage(5);

        int expectedHealth = 5;
        int actualHealth = player.getHealth();


        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test
    public void validateGetGunValid() {
        Player player = new Player("Player",10);
        Gun pistol1 = new Gun("Pistol1", 10);
        player.addGun(pistol1);

        ArrayList guns = new ArrayList<>();
        guns.add(pistol1);

        String expectedGun = "Pistol1";
        String actualGun = player.getGun("Pistol1").getName();

        Assert.assertEquals(expectedGun,actualGun);


    }
}
