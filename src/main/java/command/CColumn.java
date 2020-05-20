package command;

import factory_method.Auto;

import java.io.FileWriter;
import java.io.IOException;

public class CColumn implements Command {
    public void write(Auto auto, FileWriter writer) throws IOException {
        try {
            writer.write(auto.getMark() + "\n");
            writer.write(auto.getModelLength() + "\n");
            String[] arrN = auto.getAllModelNames();
            double[] arrP = auto.getAllModelPrices();
            for (int i = 0; i < arrN.length; i++) {
                writer.write(arrN[i] + "\n");
                writer.write(arrP[i] + "\n");
            }
        } finally {
            writer.close();
        }
    }
}
