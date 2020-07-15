package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.HashMap;
import java.util.Map;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseProcedure implements Procedure {
    private Map<String, Robot> robots;

    public BaseProcedure() {
        this.robots = new HashMap<>();
    }

    public void addRobot(Robot robot){
        this.robots.put(robot.getName(),robot);
    }

    @Override
    public String history() {
//" Robot type: {robotType} - {robotName} - Happiness: {happiness} - Energy: {energy}"
        StringBuilder info = new StringBuilder();
        info.append(this.getClass().getSimpleName())
                .append(System.lineSeparator());
        robots.forEach((name, robot) ->
                info.append(String.format(" Robot type: %s - %s - Happiness: %d - Energy: %d",
                        robot.getClass().getSimpleName(),
                        robot.getName(),
                        robot.getHappiness(),
                        robot.getEnergy()))
                .append(System.lineSeparator()));
        return info.toString();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime){
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }

    }
}
