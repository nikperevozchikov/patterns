package proxy;

import factory_method.Vehicle;
import factory_method.Vehicles;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket socket = new ServerSocket(5000)) {
            while (true) {
                System.out.println("Ожидание подключений...");
                Socket sock = socket.accept();
                System.out.println("Подключился клиент");
                DataInputStream inputStream = new DataInputStream(sock.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(sock.getOutputStream());

                outputStream.writeDouble(umn(inputStream.readDouble(), inputStream.readDouble()));
            }
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static double umn(double a, double b) {
        return a * b;
    }
}
