package day08.utils;

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

    public List<Instruction> readSetFromInputFile(){
        FileReader fr;
        List<Instruction> instructionList = new ArrayList<>();
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNext())
            {
                instructionList.add(new Instruction(inFile.nextLine()));
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return instructionList;
    }

}
