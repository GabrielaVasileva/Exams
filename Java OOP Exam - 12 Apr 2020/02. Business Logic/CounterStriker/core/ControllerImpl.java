package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {

//    •	guns - GunRepository
//•	players – PlayerRepository
//•	field - Field

    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (!(type.equals("Pistol") || type.equals("Rifle"))) {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name, bulletsCount);
        } else {
            gun = new Rifle(name, bulletsCount);
        }

        this.guns.add(gun);

        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }


//    Creates a Player of the given type and adds it to the PlayerRepository.
//    Valid types are: "Terrorist" and "CounterTerrorist".
//    If the gun is not found throw NullPointerException with message:
//            •	"Gun cannot be found!"
//    If the player type is invalid, throw an IllegalArgumentException with message:
//            •	"Invalid player type!"
//    The method should return the following String if the operation is successful:
//            •	"Successfully added player {playerUsername}."

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = guns.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        if (!(type.equals("Terrorist") || type.equals("CounterTerrorist"))) {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        Player player;
        if (type.equals("Terrorist")) {
            player = new Terrorist(username, health, armor, gun);
        }else {
            player = new CounterTerrorist(username, health, armor, gun);
        }

        this.players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(this.players.getModels());
    }


    @Override
    public String report() {
        StringBuilder info = new StringBuilder();

        this.players.getModels()
                .stream()
                .sorted((object1, object2) ->
                        object1.getClass().getSimpleName().compareTo(object2.getClass().getSimpleName()));

        this.players.getModels()
                .stream()
                .sorted((object1, object2) -> Integer.compare(object1.getHealth(), object2.getHealth()));


        this.players.getModels()
                .stream()
                .sorted((object1, object2) -> object1.getUsername().compareTo(object2.getUsername()));

        this.players.getModels().forEach(p ->
        {
            info.append(p.toString())
            .append(System.lineSeparator());
        });

        String report = info.toString();
        return report;
    }
}
