import days.DayOne;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AdventOfCodeMain {
    public static void main(String[] args) {
        String expensesPath = "D:\\AdventOfCode\\AdventOfCode2020\\src\\days\\expenses.txt";
        Set<Integer> inputSet = new HashSet<>();
        try {
            inputSet = DayOne.getExpenses(expensesPath);
            ArrayList<Integer> result = DayOne.findTwoElementsWithGivenSum(inputSet, 2020);
            System.out.println("Result for two numbers is: " + result.get(0) * result.get(1));
            result = DayOne.findThreeElementsWithGivenSum(inputSet, 2020);
            System.out.println("Result for three numbers is: " + result.get(0) * result.get(1) * result.get(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
