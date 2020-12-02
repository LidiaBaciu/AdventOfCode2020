package day02.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFileReader {
    private String inputFilePath;

    public InputFileReader(String inputFilePath){
        this.inputFilePath = inputFilePath;
    }

    public List<Password> getPasswordsFromInputFile(){
        List<Password> passwords = new ArrayList<>();
        FileReader fileReader;
        try {
            fileReader = new FileReader(this.inputFilePath);
            Scanner inFile = new Scanner(fileReader);
            while (inFile.hasNext())
            {
                Password password = extractPasswordFromText(inFile.nextLine());
                passwords.add(password);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passwords;
    }

    private Password extractPasswordFromText(String line){
        Pattern pattern = Pattern.compile("\\d+");
        String rules = line.substring(0, line.indexOf(":"));
        String password = line.substring(line.indexOf(":") + 2);
        Matcher matcher = pattern.matcher(rules);
        int ruleOne = -1;
        int ruleTwo = -1;
        while(matcher.find()) {
            if(ruleOne != -1){
                ruleTwo = Integer.parseInt(matcher.group());
            } else {
                ruleOne = Integer.parseInt(matcher.group());
            }
        }
        Character character = rules.charAt(rules.length()-1);
        Password passwordRule = new Password(ruleOne, ruleTwo, character, password);
        return passwordRule;
    }
}
