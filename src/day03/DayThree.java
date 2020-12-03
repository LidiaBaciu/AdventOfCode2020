package day03;

import day03.utils.InputFileReader;
import day03.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThree {
    private static char tree = '#';
    private static List<String> paths;

    public static void solveDayThree(){
        String mapPath = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day03\\input.txt";
        InputFileReader inputFileReader = new InputFileReader(mapPath);
        paths = inputFileReader.readSetFromInputFile();
        System.out.println("There are " + countEncounteredTrees(3, 1) + " encountered trees." );
        System.out.println("The product is: " + multiplyNumberOfTrees());
    }

    private static int countEncounteredTrees(int rightShift, int downShift){
        int encounteredTrees = 0;
        int xCoordinate = 0;
        int yCoordinate = 0;

        for(int i = 0; i < paths.size(); i++){
            xCoordinate += rightShift;
            yCoordinate += downShift;
            if(yCoordinate >= paths.size()){
                break;
            }
            if(getCharAtCoordinate(xCoordinate, yCoordinate) == tree){
                encounteredTrees++;
            }
        }
        return encounteredTrees;
    }

    private static char getCharAtCoordinate(int column, int line){
        String currentLine = paths.get(line);
        while(currentLine.length() - 1 < column){
            currentLine += paths.get(line);
        }
        return currentLine.charAt(column);
    }

    private static int multiplyNumberOfTrees(){
        int product = 1;
        List<Pair> pairs = new ArrayList<>(Arrays.asList(new Pair(1,1), new Pair(3,1),
                new Pair(5,1), new Pair(7,1), new Pair(1,2)));
        for (Pair pair:pairs) {
            product *= countEncounteredTrees((int)pair.getItem1(), (int)pair.getItem2());
        }
        return product;
    }
}
