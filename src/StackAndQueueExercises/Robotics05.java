package StackAndQueueExercises;

import java.util.*;

import static java.lang.System.in;

public class Robotics05 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        String[]tokens=scanner.nextLine().split("[-;]");

        Stack<String>nameRobot=new Stack<>();
        Stack<Integer>times=new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (i%2==0){
                nameRobot.push(tokens[i]);
            }else {
                times.push(Integer.parseInt(tokens[i]));
            }
        }

        Map<String,String>save=new LinkedHashMap<>();

        String startTime=scanner.nextLine();
        String [] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int beginSeconds = hours*3600 + minutes*60 + seconds+1;

        ArrayDeque<String> product=new ArrayDeque<>();
        String products=scanner.nextLine();

        while (!"End".equals(products)){
            product.push(products);
            products=scanner.nextLine();
        }

        String name="";
        for (int i = 0; i < nameRobot.size(); i++) {
            name=nameRobot.get(i);
            String prod=product.removeLast();
            save.put(name,prod);

        }

        for (Map.Entry<String, String> entry : save.entrySet()) {
            printRobotData(entry.getKey(),entry.getValue(),beginSeconds++);

        }
        int cp=1;
        while (!product.isEmpty()){
            String pr=product.removeFirst();
            if (cp==1) {
                printRobotData(name, pr, beginSeconds + times.peek() - 1);
            }else {
                beginSeconds+=times.peek();
                printRobotData(name, pr, beginSeconds + times.peek() - 1);
            }
            cp++;
        }

    }
    private static void printRobotData(String robot, String product, int beginSeconds) {
        int hours = (beginSeconds / (60 * 60)) % 24;
        int minutes = (beginSeconds / 60) % 60;
        int seconds = beginSeconds % 60;


        System.out.println(robot + " - " + product + " " + String.format("[%02d:%02d:%02d]", hours, minutes, seconds));
    }
}
