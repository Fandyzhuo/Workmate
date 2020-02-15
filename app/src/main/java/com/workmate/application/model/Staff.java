package com.workmate.application.model;
public class Staff {

    private int id;
    private String title;
    private String description;
    private String wage_amount;
    private String wage_type;
    private String start_time;
    private String end_time;
    private Client client;
    private Location location;
    private Position position;
    private Manager manager;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWage_amount() {
        return wage_amount;
    }

    public void setWage_amount(String wage_amount) {
        this.wage_amount = wage_amount;
    }

    public String getWage_type() {
        return wage_type;
    }

    public void setWage_type(String wage_type) {
        this.wage_type = wage_type;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
