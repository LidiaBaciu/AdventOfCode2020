package day04.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

    private HashMap<String, String> fields;
    private ArrayList<String> infoList;
    private String regex = " ";
    private List<String> mandatoryKeys = new ArrayList<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
    private String optionalKey = "cid";

    public Passport(){
        fields = new HashMap<>();
        infoList = new ArrayList<>();
    }

    private void addFields(String key, String value){
        if(!fields.containsKey(key)){
            fields.put(key, value);
        } else {
            System.out.println("The key is already present. ");
        }
    }

    public void addInfo(String info){
        infoList.add(info);
    }

    private void parseInfo(){
        Pattern pattern = Pattern.compile(regex);
        for(String currentLine: infoList){
            String[] result = pattern.split(currentLine);
            for(String data : result){
                Pattern internPattern = Pattern.compile(":");
                String[] internResult = internPattern.split(data);
                addFields(internResult[0], internResult[1]);
            }
        }
    }

    public boolean checkIfIsValid(){
        parseInfo();
        System.out.println(fields.toString());
        for(String key: mandatoryKeys){
            if(!fields.containsKey(key)){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfValuesAreCorrect(){
        for(Map.Entry<String, String> entry : fields.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Validator validator = new Validator(key, value);
            if(validator.checkCase() == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "fields=" + fields +
                ", infoList=" + infoList +
                '}';
    }
}
