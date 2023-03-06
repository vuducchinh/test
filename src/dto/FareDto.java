package dto;

public class FareDto {
    private int driverId;
    private String name;
    private String costFare;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostFare() {
        return costFare;
    }

    public void setCostFare(String costFare) {
        this.costFare = costFare;
    }
}
