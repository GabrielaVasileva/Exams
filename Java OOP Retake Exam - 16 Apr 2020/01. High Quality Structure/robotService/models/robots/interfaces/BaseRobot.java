package robotService.models.robots.interfaces;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {

//    name – String
//    happiness – int
//    can't be less than 0 or more than 100. In these cases throw IllegalArgumentException with
//    message "Invalid happiness."
//    energy – int
//    can't be less than 0 or more than 100. In these cases throw IllegalArgumentException with
//    message "Invalid energy."
//    procedureTime – int

//    owner – String
//    by default: "Service"
//    isBought – boolean
//    by default: false
//    isRepaired – boolean
//    by default: false


    private String name;
    private int happiness;
    private int energy;
    private int procedureTime;
    private String owner = "Service";
    private boolean isBought = false;
    private boolean isRepaired = false;

    public BaseRobot(String name, int energy, int happiness, int procedureTime) {
        this.name = name;
        setHappiness(happiness);
        setEnergy(energy);
        setProcedureTime(procedureTime);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHappiness() {
        return this.happiness;
    }

    @Override
    public void setHappiness(int happiness) {
        if (happiness < 0 || happiness > 100) {
            throw new IllegalArgumentException(INVALID_HAPPINESS);
        }

        this.happiness = happiness;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void setEnergy(int energy) {
        if (energy < 0 || energy > 100) {
            throw new IllegalArgumentException(INVALID_ENERGY);
        }

        this.energy = energy;
    }

    @Override
    public int getProcedureTime() {
        return this.procedureTime;
    }

    @Override
    public void setProcedureTime(int procedureTime) {
        if (procedureTime < 0) {
            throw new IllegalArgumentException();
        }
        this.procedureTime = procedureTime;

        //TODO
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void setBought(boolean bought) {
        this.isBought = bought;
    }

    @Override
    public boolean isRepaired() {
        return false;
    }

    @Override
    public void setRepaired(boolean repaired) {

    }

    @Override
    public String toString() {
        return String
                .format(" Robot type: %s - %s - Happiness: %d - Energy: %d",
                        this.getClass().getSimpleName(),
                        this.getName(),
                        getHappiness(),
                        getEnergy());
    }
}
