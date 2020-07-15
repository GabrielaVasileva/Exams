package robotService.models.procedures.interfaces;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;

public class Repair extends BaseProcedure {
    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.isRepaired()){
            throw new IllegalArgumentException(ALREADY_REPAIRED);
        }
        super.doService(robot, procedureTime);
        robot.setHappiness(robot.getHappiness() - 5);
        robot.setRepaired(true);
    }
}
