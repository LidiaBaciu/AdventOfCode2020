package day01.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputFileReader {
    private String inputFilePath;

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
    }

    public Set<Integer> readSetFromInputFile(){
        Set<Integer> integerSet = new HashSet<>();
        FileReader fr;
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNext())
            {
                int currentNumber = Integer.parseInt(inFile.nextLine());
                if(currentNumber <= 2020){
                    integerSet.add(currentNumber);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return integerSet;
    }
}
