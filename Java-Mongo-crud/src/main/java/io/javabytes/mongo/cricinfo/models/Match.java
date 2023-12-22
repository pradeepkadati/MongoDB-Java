package io.javabytes.mongo.cricinfo.models;

public class Match {

    private String type;
    private int count;
    private int Innings;

    public Match(){

    }
    public Match(String type, int count, int innings) {
        this.type = type;
        this.count = count;
        Innings = innings;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public int getInnings() {
        return Innings;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setInnings(int innings) {
        Innings = innings;
    }
}
