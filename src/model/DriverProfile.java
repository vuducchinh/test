package model;

public class DriverProfile {
    private int id; // unique
    private String name;
    private String surName;
    private String email;
    private String vehicleType;
    private Float baseFarePrice;
    private Float baseFareDistance;

    public DriverProfile(int id, String name, String surName, String email, String vehicleType, Float baseFarePrice, Float baseFareDistance) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.vehicleType = vehicleType;
        this.baseFarePrice = baseFarePrice;
        this.baseFareDistance = baseFareDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Float getBaseFarePrice() {
        return baseFarePrice;
    }

    public void setBaseFarePrice(Float baseFarePrice) {
        this.baseFarePrice = baseFarePrice;
    }

    public Float getBaseFareDistance() {
        return baseFareDistance;
    }

    public void setBaseFareDistance(Float baseFareDistance) {
        this.baseFareDistance = baseFareDistance;
    }

    @Override
    public String toString() {
        return "DriverProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", baseFarePrice=" + baseFarePrice +
                ", baseFareDistance=" + baseFareDistance +
                '}';
    }
}
