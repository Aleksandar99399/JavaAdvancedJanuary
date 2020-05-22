package DefiningClassExercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon>pokemonList=new ArrayList<>();
    private List<Parents>parents=new ArrayList<>();
    private List<Children>children=new ArrayList<>();


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }



}
