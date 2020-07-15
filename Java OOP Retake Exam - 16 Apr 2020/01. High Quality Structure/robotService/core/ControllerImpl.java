package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.interfaces.Procedure;

public class ControllerImpl implements Controller {

    private Garage garage ;
    private Procedure charge ;
    private Procedure repair ;
    private Procedure work ;

    public ControllerImpl(Garage garage, Procedure charge, Procedure repair, Procedure work) {
        this.garage = garage;
        this.charge = charge;
        this.repair = repair;
        this.work = work;
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        return null;
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        return null;
    }

    @Override
    public String work(String robotName, int procedureTime) {
        return null;
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        return null;
    }

    @Override
    public String sell(String robotName, String ownerName) {
        return null;
    }

    @Override
    public String history(String procedureType) {
        return null;
    }
}
