package io.javabytes.mongo.cricinfo.models;

import java.util.List;

public class Player {

    private String name;
    private int age;
    private Role role;
    private Availability availability;
    private long runs;
    private int wickets;
    private int catches;
	private List<Match> matches;

    public Player(){

    }
    public Player(String name, int age, Role role, Availability availability, long runs, int wickets, int catches, List<Match> matches) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.availability = availability;
        this.runs = runs;
        this.wickets = wickets;
        this.catches = catches;
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public Availability getAvailability() {
        return availability;
    }

    public long getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    public int getCatches() {
        return catches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setRuns(long runs) {
        this.runs = runs;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public void setCatches(int catches) {
        this.catches = catches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
