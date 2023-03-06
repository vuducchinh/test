package model;

public class FareInfo {
    private float distanceTraveled;
    private float traveledUnit;
    private float costPerDistanceTraveled;

    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(float distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public float getTraveledUnit() {
        return traveledUnit;
    }

    public void setTraveledUnit(float traveledUnit) {
        this.traveledUnit = traveledUnit;
    }

    public float getCostPerDistanceTraveled() {
        return costPerDistanceTraveled;
    }

    public void setCostPerDistanceTraveled(float costPerDistanceTraveled) {
        this.costPerDistanceTraveled = costPerDistanceTraveled;
    }
}
