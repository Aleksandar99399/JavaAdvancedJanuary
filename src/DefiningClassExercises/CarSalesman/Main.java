package DefiningClassExercises.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car>saveCar=new ArrayList<>();
        List<Engine>saveEngine=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] eng = scanner.nextLine().split("\\s+");

            Engine engine=new Engine();

            engine.setModel(eng[0]);
            engine.setPower(eng[1]);
            if (eng.length==3){
                if (Character.isDigit(eng[2].charAt(0))){
                    engine.setDisplacements(eng[2]);
                }else {
                    engine.setEfficiency(eng[2]);
                }
            }
            if (eng.length==4){
                engine.setDisplacements(eng[2]);
                engine.setEfficiency(eng[3]);
            }
            saveEngine.add(engine);
        }

        int m=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] inpCar=scanner.nextLine().split("\\s+");

            Car car=new Car();

            car.setModel(inpCar[0]);
            car.setEngModel(inpCar[1]);

            if (inpCar.length==3){
                if (Character.isDigit(inpCar[2].charAt(0))){
                    car.setWeight(inpCar[2]);
                }else {
                    car.setColor(inpCar[2]);
                }
            }
            if (inpCar.length==4){
                car.setWeight(inpCar[2]);
                car.setColor(inpCar[3]);
            }
            saveCar.add(car);
        }

        for (Car car : saveCar) {
            for (Engine engine : saveEngine) {
                if (engine.getModel().equals(car.getEngModel())){
                    System.out.println(car.getModel()+":");
                    System.out.println(engine.getModel()+":");
                    System.out.printf("Power: %s%n",engine.getPower());
                    System.out.printf("Displacement: %s%n",engine.getDisplacements());
                    System.out.printf("Efficiency: %s%n",engine.getEfficiency());
                    System.out.printf("Weight: %s%n",car.getWeight());
                    System.out.printf("Color: %s%n",car.getColor());
                }
            }

        }


    }
}
