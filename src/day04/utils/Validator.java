package day04.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private String key;
    private String value;

    public Validator(String key, String value){
        this.key = key;
        this.value = value;
    }

    public boolean checkCase(){
        if(key.equalsIgnoreCase("byr") || key.equalsIgnoreCase("iyr") || key.equalsIgnoreCase("eyr")){
            if(!isYearValid()){
                return false;
            }
        }
        if(key.equalsIgnoreCase("hgt")){
            if(!isHeightValid()) {
                return false;
            }
        }
        if(key.equalsIgnoreCase("hcl")){
            if(isHairColorValid() == false){
                return false;
            }
        }
        if(key.equalsIgnoreCase("ecl")){
            if(!isEyeColorValid()){
                return false;
            }
        }
        if(key.equalsIgnoreCase("pid")){
            if(!isPassportValid()){
                return false;
            }
        }
        return true;
    }


    private boolean isYearValid(){
        int lowerLimit = 0;
        int upperLimit = 0;
        if(key.equalsIgnoreCase("byr")){
            lowerLimit = 1920;
            upperLimit = 2002;
        } else if(key.equalsIgnoreCase("iyr")){
            lowerLimit = 2010;
            upperLimit = 2020;
        } else if(key.equalsIgnoreCase("eyr")){
            lowerLimit = 2020;
            upperLimit = 2030;
        }
        int year = Integer.parseInt(value);
        if(year < lowerLimit || year > upperLimit) {
            return false;
        }
        return true;
    }

    private boolean isHeightValid(){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(value);
        int number = 0;
        while(matcher.find()) {
            number = Integer.parseInt(matcher.group());
            break;
        }
        if(value.contains("cm")){
            if(number < 150 || number > 193){
                return false;
            }
        } else if(value.contains("in")){
            if(number < 59 || number > 76){
                return false;
            }
        } else if(!value.contains("cm") && !value.contains("in")){
            return false;
        }

        return true;
    }

    private boolean isHairColorValid(){
        return value.matches("(^#[0-9a-f]{6})");
    }

    private boolean isEyeColorValid(){
        List<String> possibleValues = new ArrayList<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
        return possibleValues.contains(value);
    }

    private boolean isPassportValid(){
        return value.matches("\\d{9}");
    }

}
