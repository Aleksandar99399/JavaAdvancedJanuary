package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class AppliedArithmetic {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        List<Integer>list= Arrays.stream(rd.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<Integer,Integer>add=e->e+1;
        Function<Integer,Integer>multiply=e->e*2;
        Function<Integer,Integer>subtract=e->e-1;
        Consumer<Integer>print= e-> System.out.print(e+" ");

        String comm=rd.readLine();

        while (!comm.equals("end")){

            if (comm.equals("add")){
                list=list.stream().map(e->add.apply(e)).collect(Collectors.toList());
            }else if (comm.equals("subtract")){
                list=list.stream().map(e->subtract.apply(e)).collect(Collectors.toList());
            }else if (comm.equals("multiply")){
                list=list.stream().map(e->multiply.apply(e)).collect(Collectors.toList());
            }else if (comm.equals("print")){
                list.forEach(e->print.accept(e));

            }

            comm=rd.readLine();
        }

    }
}
