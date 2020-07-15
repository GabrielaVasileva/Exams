package robotService.models.garages.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarageImpl implements Garage {
//    CAPACITY – int with a constant value of 10
//    robots – Map with the robot's name as the key and the robot itself as the value
//    ou should keep robots in order of adding

    private static final int CAPACITY = 10;
    private Map<String,Robot> robots;

    public GarageImpl() {
        this.robots = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Robot> getRobots() {
        return null;
    }

    @Override
    public void manufacture(Robot robot) {

    }

    @Override
    public void sell(String robotName, String ownerName) {

    }
}
