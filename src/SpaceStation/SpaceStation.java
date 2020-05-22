package SpaceStation;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class SpaceStation {
    private LinkedList<Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new LinkedList<Astronaut>();
    }

    public int getCount(){
        return this.data.size();
    }

    public void add(Astronaut astronaut){
        if (this.data.size()<getCapacity()) {
            data.add(astronaut);
        }

    }

    public boolean remove(String name){
        return this.data.removeIf(e->e.getName().equals(name));
    }

    public Astronaut getOldestAstronaut(){
        return this.data.stream().max(Comparator.comparingInt(Astronaut::getAge)).orElse(null);
        //Astronaut astronaut = null;
        //int maxAge=Integer.MIN_VALUE;
//
        //for (Astronaut astronaut1 : this.data) {
//
        //    if (astronaut1.getAge()>maxAge){
        //        maxAge=astronaut1.getAge();
        //        astronaut=astronaut1;
//
        //    }
        //}
        //return astronaut;
    }

    public Astronaut getAstronaut(String name){
        for (Astronaut astronaut : this.data) {
            if (astronaut.getName().equals(name)){
                return astronaut;
            }
        }

        return null;
    }

    public String report(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:%n",getName().trim()));
        for (Astronaut astronaut : data) {
            sb.append(astronaut.toString()).append("\r\n");
        }

        return sb.toString().trim();

    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
