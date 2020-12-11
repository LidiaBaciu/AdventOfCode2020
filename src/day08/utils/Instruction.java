package day08.utils;

public class Instruction {
    private String operation;
    private int argument;
    private int numberOfVisits;

    public Instruction(String line){
        this.splitLine(line);
        numberOfVisits = 0;
    }

    private void splitLine(String line){
        this.operation = line.split(" ")[0];
        this.argument = Integer.parseInt(line.split(" ")[1]);
    }

    public void markAsVisited(){
        numberOfVisits++;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getArgument() {
        return argument;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setArgument(int argument) {
        this.argument = argument;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "operation='" + operation + '\'' +
                ", argument=" + argument +
                ", numberOfVisits=" + numberOfVisits +
                '}';
    }
}
