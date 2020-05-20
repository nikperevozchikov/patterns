package command;

import factory_method.Auto;

import java.io.FileWriter;
import java.io.IOException;

public class CRow implements Command {
    public void write(Auto auto, FileWriter writer) throws IOException {
        try {
            writer.write(auto.getMark() + " ");
            writer.write(auto.getModelLength() + " ");
            String[] arrN = auto.getAllModelNames();
            double[] arrP = auto.getAllModelPrices();
            for (int i = 0; i < arrN.length; i++) {
                writer.write(arrN[i] + " ");
                writer.write(arrP[i] + " ");
            }
        } finally {
            writer.close();
        }
    }
}
