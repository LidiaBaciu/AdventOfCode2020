package day04.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class InputFileReader {
    private String inputFilePath;

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
    }

    public ArrayList<Passport> readSetFromInputFile(){
        ArrayList<Passport> passports = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);
            Passport passport = new Passport();
            while (inFile.hasNext())
            {
                String currentLine = inFile.nextLine();
                if(currentLine.trim().isEmpty() || currentLine == null){
                    passports.add(passport);
                    passport = new Passport();
                } else {
                    passport.addInfo(currentLine);
                }
            }
            //add the last passport too
            passports.add(passport);
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passports;
    }
}
