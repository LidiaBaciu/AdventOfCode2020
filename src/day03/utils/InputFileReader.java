package day03.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class InputFileReader {
    private String inputFilePath;

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
    }

    public List<String> readSetFromInputFile(){
        List<String> map = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNext())
            {
                map.add(inFile.nextLine());
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }
}
