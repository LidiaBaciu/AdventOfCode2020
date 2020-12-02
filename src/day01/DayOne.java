package day01;

import day01.utils.InputFileReader;
import java.util.ArrayList;
import java.util.Set;

public class DayOne {

    public static void solveDayOne(){
        String expensesPath = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day01\\expenses.txt";
        InputFileReader inputFileReader = new InputFileReader(expensesPath);
        Set<Integer> inputSet = inputFileReader.readSetFromInputFile();
        ArrayList<Integer> result = findTwoElementsWithGivenSum(inputSet, 2020);
        System.out.println("Result for two numbers is: " + result.get(0) * result.get(1));
        result = findThreeElementsWithGivenSum(inputSet, 2020);
        System.out.println("Result for three numbers is: " + result.get(0) * result.get(1) * result.get(2));
    }

    public static ArrayList<Integer> findTwoElementsWithGivenSum(Set<Integer> inputSet, int sum) {
        for (Integer currentNumber : inputSet) {
            if (inputSet.contains(sum - currentNumber)) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(currentNumber);
                result.add(sum - currentNumber);
                return result;
            }
        }
        return null;
    }

    public static ArrayList<Integer> findThreeElementsWithGivenSum(Set<Integer> inputSet, int sum){
        for (Integer currentNumber : inputSet) {
            ArrayList<Integer> partialResult = findTwoElementsWithGivenSum(inputSet, sum - currentNumber);
            ArrayList<Integer> result = new ArrayList<>();
            if(partialResult != null && !partialResult.isEmpty()){
                result.add(currentNumber);
                result.add(partialResult.get(0));
                result.add(partialResult.get(1));
                return result;
            }
        }
        return null;
    }
}
