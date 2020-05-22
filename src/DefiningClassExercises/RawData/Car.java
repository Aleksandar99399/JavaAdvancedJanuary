package DefiningClassExercises.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;


    public Car(String model, Engine engine, Cargo cargo, Tires tiresList) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tiresList;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tires getTires() {
        return tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }


    //private int engineSpeed;
    //private int enginePower;
    //private int cargoWeight;
    //private int cargoType;
    //private int tire1Pressure;
    //private int tire1Age;
    //private int tire2Pressure;
    //private int tire2Age;
    //private int tire3Pressure;
    //private int tire3Age;
    //private int tire4Pressure;
    //private int tire4Age;
}
