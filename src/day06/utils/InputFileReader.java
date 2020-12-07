package day06.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFileReader {
    private String inputFilePath;

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
    }

    public ArrayList<GroupAnswer> readSetFromInputFile(){
        ArrayList<GroupAnswer> groupAnswers = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);
            GroupAnswer groupAnswer = new GroupAnswer();
            while (inFile.hasNext())
            {
                String currentLine = inFile.nextLine();
                if(currentLine.trim().isEmpty() || currentLine == null){
                    groupAnswers.add(groupAnswer);
                    groupAnswer = new GroupAnswer();
                } else {
                    Answer currentAnswer = new Answer(currentLine);
                    groupAnswer.addAnswer(currentAnswer);
                }
            }
            //add the last answer too
            groupAnswers.add(groupAnswer);
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return groupAnswers;
    }
}
