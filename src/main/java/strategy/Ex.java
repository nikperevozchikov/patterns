package strategy;

public class Ex {
    private Strategy parser;

    public void setParser(Strategy parser) {
        this.parser = parser;
    }

    public void execute(String inputFile, String outputFile) {
        parser.parsing(inputFile, outputFile);
    }
}
