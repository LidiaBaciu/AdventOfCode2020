package day09;

import day09.utils.InputFileReader;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DayNine {

    private static List<Long> numberList;

    public static void solveDayEight(){
        String inputFile = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day09\\input.txt";
        InputFileReader inputFileReader = new InputFileReader(inputFile);
        numberList = inputFileReader.readSetFromInputFile();
        System.out.println(solve2(25));
    }

    private static Long solve1(int length){
        for(int i = 0; i < numberList.size() - length -1; i++){
            List<Long> preamble = numberList.subList(i, i+length);
            long testingNumber = numberList.get(i+length);
            if(!checkIfTwoNumbersHaveSum(preamble, testingNumber)){
                return testingNumber;
            }
        }
        return -1L;
    }

    private static Long solve2(int length){
        long number = solve1(length);
        for(int i = 0; i < numberList.size() - 2; i++){
            for(int j = i + 2; j < numberList.size(); j++){
                List<Long> range = numberList.subList(i, j);
                long sum = range.stream().collect(Collectors.summingLong(Long::longValue));
                if(sum == number){
                    Optional<Long> min = range.stream().min((a, b) -> a.compareTo(b));
                    Optional<Long> max = range.stream().max((a, b) -> a.compareTo(b));
                    return (min.get() + max.get());
                }
            }
        }
        return -1L;
    }

    public static boolean checkIfTwoNumbersHaveSum(List<Long> inputSet, Long sum) {
        for (Long currentNumber : inputSet) {
            if (inputSet.contains(sum - currentNumber)) {
                System.out.println(sum + " "  + (sum-currentNumber));
                return true;
            }
        }
        return false;
    }
}
