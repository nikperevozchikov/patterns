package cor;

import factory_method.Vehicle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Column implements ChainOfResponsibility {
    private Row row;

//    public void setNext(Row chainRow){
//        this.chainRow = chainRow;
//    }

    public void write(Vehicle vehicle) throws IOException {
        if (vehicle.getModelLength() > 3) {
            try (FileWriter writer = new FileWriter(new File("src/textchaincolumn.txt"))) {
                writer.write(vehicle.getMark() + "\n");
                writer.write(String.valueOf(vehicle.getModelLength()) + "\n");
                String[] arrN = vehicle.getAllModelNames();
                double[] arrP = vehicle.getAllModelPrices();
                for (int i = 0; i < arrN.length; i++) {
                    writer.write(arrN[i] + "\n");
                    writer.write(String.valueOf(arrP[i]) + "\n");
                }
            }
        } else {
            next(vehicle);
        }
    }

    @Override
    public void next(Vehicle vehicle) throws IOException {
        row = new Row();
        row.write(vehicle);
    }
}
