package robotService.models.garages.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static robotService.common.ExceptionMessages.*;

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
        return Collections.unmodifiableMap(this.robots);
    }

    @Override
    public void manufacture(Robot robot) {
        if (CAPACITY <= robots.size()){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        if (robots.containsKey(robot.getName())){
            throw new IllegalArgumentException(String.format(EXISTING_ROBOT,robot.getName()));
        }

        this.robots.put(robot.getName(),robot);
    }

    @Override
    public void sell(String robotName, String ownerName) {
        if (!this.robots.containsKey(robotName)){
            throw new IllegalArgumentException(String.format(EXISTING_ROBOT,robotName));
        }

        this.robots.get(robotName).setOwner(ownerName);
        this.robots.remove(robotName);
    }

    public Robot getRobot(String robotName){
        return this.robots.get(robotName);
    }


}
