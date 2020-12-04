package day04;

import day04.utils.InputFileReader;
import day04.utils.Passport;

import java.util.ArrayList;

public class DayFour {
    public static void solveDayFour(){
        String inputFile = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day04\\input.txt";
        InputFileReader inputFileReader = new InputFileReader(inputFile);
        ArrayList<Passport> passports = inputFileReader.readSetFromInputFile();
        int countValidPassports = 0;
        for (Passport passport: passports) {
            if(passport.checkIfIsValid() && passport.checkIfValuesAreCorrect()){
                countValidPassports++;
            }
        }
        System.out.println("There are " + countValidPassports + " passports valid.");
    }
}
