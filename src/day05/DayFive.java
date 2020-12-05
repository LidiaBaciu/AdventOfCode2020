package day05;

import day05.utils.BoardingPass;
import day05.utils.InputFileReader;

public class DayFive {
    public static void solveDayFive(){
        String inputFile = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day05\\input.txt";
        InputFileReader inputFileReader = new InputFileReader(inputFile);
        inputFileReader.readSetFromInputFile();
        System.out.println(BoardingPass.maximum);
        System.out.println(inputFileReader.getMyPassId());
    }
}
