package day02;

import day02.utils.InputFileReader;
import day02.utils.Password;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwo {
    public static void solveDayTwo(){
        String passwordsPath = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day02\\passwords.txt";
        InputFileReader inputFileReader = new InputFileReader(passwordsPath);
        List<Password> passwords = inputFileReader.getPasswordsFromInputFile();
        int numberOfValidPasswordOld = passwords.stream().filter(password -> password.isValidOld() == true).collect(Collectors.toList()).size();
        int numberOfValidPasswordNew = passwords.stream().filter(password -> password.isValidNew() == true).collect(Collectors.toList()).size();
        System.out.println("Number of valid passwords based on the old rule: " + numberOfValidPasswordOld);
        System.out.println("Number of valid passwords based on the new rule: " + numberOfValidPasswordNew);
    }
}
