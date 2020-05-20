package command;

import cor.Column;
import cor.Row;
import factory_method.Auto;
import factory_method.Vehicles;
import factory_method.exceptions.DuplicateModelNameException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        try {
            Auto auto = new Auto("Toyota", 3);
            //Auto a = (Auto) auto.clone();
            //a.addNameModelAndPrice("vesta", 2600);
            //Command commandR = new CRow();
             Command commandC = new CColumn();
            auto.setPrintCommand(new CRow());
            auto.print(new FileWriter(new File("src/command.txt")));
            auto.setPrintCommand(commandC);
            auto.print(new FileWriter(new File("src/command1.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
