package day05.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class InputFileReader {
    private String inputFilePath;
    private HashSet<Integer> idSet = new HashSet<>();

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
    }

    public void readSetFromInputFile(){
        ArrayList<BoardingPass> passes = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);

            while (inFile.hasNext())
            {
                String currentLine = inFile.nextLine();
                BoardingPass boardingPass = new BoardingPass(currentLine);
                passes.add(boardingPass);
                idSet.add(boardingPass.getId());
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getMyPassId(){
        for (Integer id: idSet) {
            if(idSet.contains(id) && idSet.contains(id+2) && !idSet.contains(id+1)){
                return id+1;
            }
        }
        return -1;
    }
}
