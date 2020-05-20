package dao;

import factory_method.Auto;
import factory_method.exceptions.DuplicateModelNameException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextView implements IAutoDAO{
    public void write(Auto auto) throws IOException {
        FileWriter fileWriter = new FileWriter("text.txt");
        fileWriter.write(auto.getMark() + "\n");
        fileWriter.write(auto.getModelLength() + "\n");
        String[] arrN = auto.getAllModelNames();
        double[] arrP = auto.getAllModelPrices();
        for (int i = 0; i < arrN.length; i++) {
            fileWriter.write(arrN[i] + "\n");
            fileWriter.write(arrP[i] + "\n");
        }
        fileWriter.close();
    }

    public Auto read() throws IOException, DuplicateModelNameException {
        FileReader fileReader = new FileReader("text.txt");
        Scanner scan = new Scanner(fileReader);
        String name = scan.nextLine();
        int length = Integer.parseInt(scan.nextLine());
        Auto auto = new Auto(name, 0);
        for (int i = 0; i < length; i++) {
            String nameModel = scan.nextLine();
            double priceModel = Double.parseDouble(scan.nextLine());
            auto.addNameModelAndPrice(nameModel, priceModel);
        }

        fileReader.close();
        return auto;
    }
}
