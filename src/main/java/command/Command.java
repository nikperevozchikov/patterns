package command;

import factory_method.Auto;

import java.io.FileWriter;
import java.io.IOException;

public interface Command  {
    void write(Auto auto, FileWriter writer) throws IOException;
}

