package strategy;

public class Main {
    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFileDOM = args[1];
        String outputFileSAX = args[2];

        Ex ex = new Ex();
        ex.setParser(new StrategyDOM());
        ex.execute(inputFile, outputFileDOM);

        ex.setParser(new StrategySAX());
        ex.execute(inputFile, outputFileSAX);
    }
}
