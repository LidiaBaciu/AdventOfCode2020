package day06;

import day06.utils.GroupAnswer;
import day06.utils.InputFileReader;
import java.util.ArrayList;

public class DaySix {
    public static void solveDaySix(){
        String inputFile = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day06\\input.txt";
        InputFileReader inputFileReader = new InputFileReader(inputFile);
        ArrayList<GroupAnswer> groupAnswerArrayList = inputFileReader.readSetFromInputFile();
        int sum = 0;
        for(GroupAnswer groupAnswer: groupAnswerArrayList){
            System.out.println(groupAnswer.toString());
//            sum += groupAnswer.getNumberOfYes();
            sum += groupAnswer.getNumberOfQuestionsEveryoneSayYes();
        }
        System.out.println("sum = " + sum);
    }

}
