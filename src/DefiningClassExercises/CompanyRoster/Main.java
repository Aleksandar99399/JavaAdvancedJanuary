package DefiningClassExercises.CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        Map<String,Map<Integer,Double>>map=new HashMap<>();

        List<Employee>employees=new ArrayList<>();


        for (int i = 0; i < n; i++) {

            String[] arr = scanner.nextLine().split("\\s+");
            String name = arr[0];
            double salary = Double.parseDouble(arr[1]);
            String position = arr[2];
            String departmentt = arr[3];

            Employee employee = new Employee(name, salary, position, departmentt);

            if (arr.length == 5) {

                try {
                    int num = Integer.parseInt(arr[4]);
                    employee.setAge(num);
                } catch (Exception e) {
                    String word = arr[4];
                    employee.setEmail(word);
                }

            } else if (arr.length > 5) {
                employee.setEmail(arr[4]);
                employee.setAge(Integer.parseInt(arr[5]));
            }
            employees.add(employee);
        }
            List<String> departmentsList = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

            List<Department> departments = new ArrayList<>();
            for (String department : departmentsList) {
                departments.add(new Department(department,
                        employees.stream().filter(employe-> employe.getDepartment().equals(department)).collect(Collectors.toList())));
            }
            departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
            Department department = departments.get(0);
            department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

            System.out.printf("Highest Average Salary: %s%n", department.getName());
            for (Employee employ : department.getEmployee()) {
                System.out.printf("%s %.2f %s %d%n", employ.getName(), employ.getSalary(), employ.getEmail(), employ.getAge());
            }
            //int ex=1;
            //int count=1;
            //if (map.containsKey(department)){
            //    ex++;
//
            //    map.get(department).put(ex,map.get(department).get(count)+salary);
//
//
            //}else {
//
            //    map.put(department,new HashMap<>());
//
            //    map.get(department).put(count,salary);
            //}



    }
}
