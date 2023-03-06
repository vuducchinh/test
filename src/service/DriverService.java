package service;

import model.DriverProfile;
import model.FareInfo;

import java.util.ArrayList;
import java.util.List;


public class DriverService {
    // Question 1
    public static List<DriverProfile> listDriver = new ArrayList<>();

    public List<DriverProfile> getListDriver() {
        return listDriver;
    }

    public void registerDriver(DriverProfile driverProfile) {
        listDriver.add(driverProfile);
    }

    public void deleteDriver(int id) {
        DriverProfile driver = listDriver.stream().filter(d -> id == d.getId()).findAny().orElse(null);
        if (driver != null) {
            listDriver.removeIf(x -> listDriver.contains(x));
        } else {
            System.out.println("driver does not exist !!");
        }
    }

    public void updateDriver(DriverProfile driverProfile) {
        boolean isExist = false;
        for (int i = 0; i < listDriver.size(); i++) {
            if (listDriver.get(i).getId() == driverProfile.getId()) {
                isExist = true;
                listDriver.get(i).setName(driverProfile.getName());
                listDriver.get(i).setEmail(driverProfile.getEmail());
                listDriver.get(i).setSurName(driverProfile.getSurName());
                listDriver.get(i).setVehicleType(driverProfile.getVehicleType());
                listDriver.get(i).setBaseFarePrice(driverProfile.getBaseFarePrice());
                listDriver.get(i).setBaseFareDistance(driverProfile.getBaseFareDistance());
            }
        }
        if (!isExist) {
            System.out.println("driver does not exist !!");
        }
    }

    // Question 2
    public float[] calculated (DriverProfile driverProfile, List<FareInfo> fareInfos) {
        float[] price = new float[fareInfos.size()];
        float diff;
        for (int i = 0; i < fareInfos.size(); i++) {
            if (fareInfos.get(i).getDistanceTraveled() > driverProfile.getBaseFareDistance()) {
                diff = fareInfos.get(i).getDistanceTraveled() - driverProfile.getBaseFareDistance();
                price[i] = driverProfile.getBaseFarePrice() + ((fareInfos.get(i).getTraveledUnit() / diff) * fareInfos.get(i).getCostPerDistanceTraveled());
            } else {
                price[i] = driverProfile.getBaseFarePrice();
            }
        }
        return price;
    }

}
