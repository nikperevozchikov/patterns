package adapter;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Adapter {
    public void writeByte(String[] strings) {
        try (DataOutputStream dataOutputStream = new DataOutputStream((new FileOutputStream("src/file.txt")))) {
            dataOutputStream.writeInt(strings.length);
            for (String s : strings) {
                dataOutputStream.writeInt(s.length());
                dataOutputStream.write(s.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

        //            public void readByte() throws IOException {
//        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/file.txt"))) {
//            while (dataInputStream.available() > 0) {
//                byte num;
//                try {
//                    num = dataInputStream.readByte();
//                    System.out.println("Reading from file: " + num);
//                } catch (EOFException ex1) {
//                    break; //EOF reached.
//                } catch (IOException ex2) {
//                    System.err.println("An IOException was caught: " + ex2.getMessage());
//                    ex2.printStackTrace();
//                }
//
//            }
//
//        }
//   }


        public String[] readByte () throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/file.txt"));
            String[] strings = new String[dataInputStream.readInt()];
            for (int i = 0; i < strings.length; i++) {
                byte[] string = new byte[dataInputStream.readInt()];
                for (int j = 0; j < string.length; j++) {
                    string[j] = dataInputStream.readByte();
                }
                strings[i] = new String(string);
            }
            return strings;

        }
    }