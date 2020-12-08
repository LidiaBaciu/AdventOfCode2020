package day07;

import day07.utils.InputFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaySeven {

    private static HashMap<String, HashMap<String, Integer>> bagMaps;
    private static ArrayList<String> bagList = new ArrayList<>();

    public static void solveDaySeven(){
        String inputFile = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day07\\input.txt";
        InputFileReader inputFileReader = new InputFileReader(inputFile);
        bagMaps = inputFileReader.readSetFromInputFile();
        System.out.println(containsBag("shiny gold", bagList));
        System.out.println(countBagsInside("shiny gold"));
    }

    private static int containsBag(String searched, ArrayList<String> bagList){
        for(Map.Entry<String, HashMap<String, Integer>> entry : bagMaps.entrySet())
        {
            String hashKey = entry.getKey();
            HashMap<String, Integer> hashValue = entry.getValue();
            if(hashValue.containsKey(searched) && !bagList.contains(hashKey)){
                bagList.add(hashKey);
                containsBag(hashKey, bagList);
            }
        }
        return bagList.size();
    }

    private static int countBagsInside(String searched){
        int sum = 0;
        for(Map.Entry<String, HashMap<String, Integer>> entry : bagMaps.entrySet())
        {
            String hashKey = entry.getKey();
            if(hashKey.equalsIgnoreCase(searched)){
                for(Map.Entry<String, Integer> innerBags : entry.getValue().entrySet())
                {
                    if(innerBags.getValue() != 0){
                        sum += innerBags.getValue() + innerBags.getValue() * countBagsInside(innerBags.getKey());
                    }
                }
            }
        }
        return sum;
    }
}
