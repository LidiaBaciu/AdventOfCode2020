package days;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DayOne {
    public static Set<Integer> getExpenses(String expensesPath) throws FileNotFoundException {
        FileReader fr = new FileReader(expensesPath);
        Scanner inFile = new Scanner(fr);
        Set<Integer> integerSet = new HashSet<>();

        while (inFile.hasNext())
        {
            int currentNumber = Integer.parseInt(inFile.nextLine());
            if(currentNumber <= 2020){
                integerSet.add(currentNumber);
            }
        }

        inFile.close();
        return integerSet;
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
