package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseProcedure implements Procedure{
    private Map<String,Robot> robots;

    public BaseProcedure() {
        this.robots = new HashMap<>();
    }

    @Override
    public String history() {
        return null;
    }

    @Override
    public void doService(Robot robot, int procedureTime) {

    }
}
