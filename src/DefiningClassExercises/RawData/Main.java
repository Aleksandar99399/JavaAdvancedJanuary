package DefiningClassExercises.RawData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            double one = Double.parseDouble(input[5]);
            double two = Double.parseDouble(input[7]);
            double three = Double.parseDouble(input[9]);
            double four = Double.parseDouble(input[11]);
            Tires tires = new Tires(one, two, three, four);

            Car cars = new Car(model, engine, cargo, tires);
            carArrayList.add(cars);
        }
        String command = scanner.nextLine();

        if ("fragile".equals(command)) {
            carArrayList.stream()
                    .filter(e -> e.getCargo().getCargoType().equals(command))
                    .filter(e -> e.getTires().getTire1Pressure() < 1.00
                            || e.getTires().getTire4Pressure() < 1.00
                            || e.getTires().getTire2Pressure() < 1.00
                            || e.getTires().getTire3Pressure() < 1.00)
                    .forEach(e-> System.out.println(e.getModel()));

        }else {
            carArrayList.stream()
                    .filter(e->e.getCargo().getCargoType().equals(command))
                    .filter(car->car.getEngine().getEnginePower()>250)
                    .forEach(e-> System.out.println(e.getModel()));

        }

    }
}
