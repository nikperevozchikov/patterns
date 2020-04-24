package dao;

import factory_method.Auto;

import java.io.*;

public class ByteView implements IAutoDAO {
    public void write(Auto auto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("au.bi"))) {
            oos.writeObject(auto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Auto read() {
        Auto auto = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("au.bi"))) {
            auto = (Auto) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return auto;
    }
}
