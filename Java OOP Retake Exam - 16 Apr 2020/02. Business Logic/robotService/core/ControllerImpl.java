package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.garages.interfaces.Garage;
import robotService.models.garages.interfaces.GarageImpl;
import robotService.models.procedures.interfaces.*;
import robotService.models.robots.interfaces.Cleaner;
import robotService.models.robots.interfaces.Housekeeper;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Garage garage ;
//    private Procedure charge ;
//    private Procedure repair ;
//    private Procedure work ;


    private BaseProcedure charge ;
    private BaseProcedure repair ;
    private BaseProcedure work ;


    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        if (!robotType.equals("Cleaner") && !robotType.equals("Housekeeper")){
            throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE,name));
        }
        Robot robot;
        if (robotType.equals("Cleaner")){
            robot = new Cleaner(name,energy,happiness,procedureTime);
        }else {
            robot = new Housekeeper(name,energy,happiness,procedureTime);
        }

        garage.manufacture(robot);
        return String.format(ROBOT_MANUFACTURED,robot.getName());
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        Robot robot = this.garage.getRobots().get(robotName);
        this.repair.doService(robot,procedureTime);
        this.repair.addRobot(robot);

        return String.format(REPAIR_PROCEDURE,robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        Robot robot = this.garage.getRobots().get(robotName);
        this.work.doService(this.garage.getRobots().get(robotName),procedureTime);
        this.work.addRobot(robot);

        return String.format(REPAIR_PROCEDURE,robotName);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        Robot robot = this.garage.getRobots().get(robotName);
        this.charge.doService(this.garage.getRobots().get(robotName),procedureTime);
        this.charge.addRobot(robot);

        return String.format(REPAIR_PROCEDURE,robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        this.garage.sell(robotName,ownerName);
        return String.format(SELL_ROBOT,ownerName,robotName);
    }

    @Override
    public String history(String procedureType) {
        String info;
        switch (procedureType) {
            case "Charge":
                info = this.charge.history();
                break;
             case "Repair":
                 info = this.repair.history();
            break;
             case "Work":
                 info = this.work.history();
            break;
            default:
                info = null;
        }
        return info;
    }
}
