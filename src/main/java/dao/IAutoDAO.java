package dao;

import factory_method.Auto;
import factory_method.exceptions.DuplicateModelNameException;

import java.io.IOException;

public interface IAutoDAO {

    void write(Auto auto) throws IOException;
    Auto read() throws IOException, DuplicateModelNameException;
}
