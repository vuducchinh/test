import dto.FareDto;
import model.DriverProfile;
import model.FareInfo;
import service.DriverService;
import service.Utils;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // đầu bài cho CT : Distance Traveled Units = Base Fare Distance - Distance traveled nhưng ví dụ lại là Distance Traveled Units = Distance traveled - Base Fare Distance
        // Fare = Base Fare Price + (Distance Traveled Units * Cost Per Distance Traveled) nhưng ví dụ lại có tỷ lệ = 50/50 = 1 chưa rõ => confused

//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("input info ");
//        System.out.println("Distance Traveled : ");
//        float a = sc.nextFloat();
//        System.out.println("Traveled Unit : ");
//        float b = sc.nextFloat();
//        System.out.println("Cost Per Distance Traveled : ");
//        float c = sc.nextFloat();
        List<FareInfo> inputData = new ArrayList<>();
        try {
            FileReader fr = new FileReader("fare_info.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null) {
                FareInfo info = new FareInfo();
                info.setDistanceTraveled(Float.parseFloat(line.split(",")[0]));
                info.setTraveledUnit(Float.parseFloat(line.split(",")[1]));
                info.setCostPerDistanceTraveled(Float.parseFloat(line.split(",")[2]));
                inputData.add(info);
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

//        FareInfo info = new FareInfo();
//        info.setDistanceTraveled(a);
//        info.setTraveledUnit(b);
//        info.setCostPerDistanceTraveled(c);
//
        DriverProfile driverA = new DriverProfile(1,"Driver A", "Nguyen Van", "nvA@gmail.com","bus", (float)200, (float)150);
        DriverProfile driverB = new DriverProfile(1,"Driver B", "Nguyen Van", "nvB@gmail.com","train", (float)300, (float)250);

        DriverService service = new DriverService();
        service.registerDriver(driverA);
        service.registerDriver(driverB);

        List<DriverProfile> list = service.getListDriver();
        List<FareDto> fares = new ArrayList<>();
        for (DriverProfile driver: list) {
            FareDto dto = new FareDto();
            dto.setDriverId(driver.getId());
            dto.setName(driver.getName());
            dto.setCostFare(Arrays.toString(service.calculated(driver,inputData)));
            fares.add(dto);
        }

        for (FareDto dto: fares) {
            System.out.println(dto.getCostFare());
        }

        // Question 3
        FileWriter fileWriter = null;
        try {
            File csvFile = new File("result.csv");
            String[] headerLines = {"id driver", "name", "price"};
            fileWriter = new FileWriter(csvFile);
            fileWriter.write(Utils.makeFile(fares, 1, headerLines));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
