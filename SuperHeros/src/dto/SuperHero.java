package dto;

import java.util.ArrayList;

public class SuperHero {
    private String superName;
    private String realName;
    private ArrayList<String> powers;
    private int age;
    private double height;
    private double weight;
    private char sex;
    private SuperTeam team;

    public SuperHero(){
        super();
    }

    public SuperHero(String superName, String realName, ArrayList<String> powers, int age, double height, double weight, char sex, SuperTeam team) {
        this.superName = superName;
        this.realName = realName;
        this.powers = powers;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.team = team;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public ArrayList<String> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<String> powers) {
        this.powers = powers;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public SuperTeam getTeam() {
        return team;
    }

    public void setTeam(SuperTeam team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return superName + ": " + team.getTeamName();
    }
}
