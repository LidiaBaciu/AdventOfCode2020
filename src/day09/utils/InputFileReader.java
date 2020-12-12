package day09.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileReader {

    private String inputFilePath;

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
    }

    public List<Long> readSetFromInputFile(){
        FileReader fr;
        List<Long> numberList = new ArrayList<>();
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNext())
            {
                long currentNumber = inFile.nextLong();
                numberList.add(currentNumber);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numberList;
    }

}
