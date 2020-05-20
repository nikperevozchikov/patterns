package cor;

import factory_method.Vehicle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Row implements ChainOfResponsibility {
    private Column column;

//    public void setNext(Column chainRow){
//        this.column = chainRow;
//    }

    @Override
    public void write(Vehicle vehicle) throws IOException {
        if (vehicle.getModelLength() <= 3) {
            try (FileWriter writer = new FileWriter(new File("src/textchainrow.txt"))) {
                writer.write(vehicle.getMark() + " ");
                writer.write(String.valueOf(vehicle.getModelLength()) + " ");
                String[] arrN = vehicle.getAllModelNames();
                double[] arrP = vehicle.getAllModelPrices();
                for (int i = 0; i < arrN.length; i++) {
                    writer.write(arrN[i] + " ");
                    writer.write(String.valueOf(arrP[i]) + " ");
                }
            }
        } else {
            next(vehicle);
        }
    }

    @Override
    public void next(Vehicle vehicle) throws IOException {
        column = new Column();
        column.write(vehicle);
    }
}
