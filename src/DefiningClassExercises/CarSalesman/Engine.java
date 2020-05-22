package DefiningClassExercises.CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacements="n/a";
    private String efficiency="n/a";


    public void setDisplacements(String displacements) {
        this.displacements = displacements;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacements() {
        return displacements;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
