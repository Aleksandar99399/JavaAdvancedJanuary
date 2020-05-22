package DefiningClassExercises.CarSalesman;

public class Car {
    private String model;
    private String engModel;
    private Engine engine;
    private String weight="n/a";
    private String color="n/a";

    public String getEngModel() {
        return engModel;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngModel(String engModel) {
        this.engModel = engModel;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return  getModel()+ ": \r\n"+
                getEngModel()+": \r\n"+
                "Power: "+engine.getPower()+"\r\n"+
                "Displacement: "+engine.getDisplacements()+"\r\n"+
                "Efficiency: "+engine.getEfficiency()+ "\r\n"+
                "Weight: "+getWeight()+"\r\n"+
                "Color: "+getColor()+"\r\n";
    }
}
