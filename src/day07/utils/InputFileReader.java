package day07.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFileReader {

    private String inputFilePath;
    private HashMap<String, String> hashMap;
    private HashMap<String, HashMap<String, Integer>> bagMaps;

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
        hashMap = new HashMap<>();
        bagMaps = new HashMap<>();
    }

    public HashMap<String, HashMap<String, Integer>> readSetFromInputFile(){
        FileReader fr;
        try {
            fr = new FileReader(inputFilePath);
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNext())
            {
                getBagDetails(inFile.nextLine());
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bagMaps;
    }

    private void getBagDetails(String line){
        HashMap<String, Integer> canHold = new HashMap<>();
        String color = line.split("bags contain")[0].trim();
        line = line.replace("bags", "bag");
        String insideBags = line.split("contain")[1].replace(".", "");
        String[] arrOfStr = insideBags.split(",");
        for (String currentBag: arrOfStr){
            canHold.put(getColor(currentBag), getQuantity(currentBag));
        }
        bagMaps.put(color, canHold);
    }

    private int getQuantity(String currentLine){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(currentLine);
        if(m.find()) {
            return Integer.parseInt(m.group());
        }
        return 0;
    }

    private String getColor(String currentLine){
        currentLine = currentLine.replace("bag", "");
        String[] arr = currentLine.split(" ");
        String result = "";
        for(String string:arr){
            if(!string.matches(".*\\d.*") && !string.isEmpty()){
                result += string + " ";
            }
        }
        return result.trim();
    }
}
