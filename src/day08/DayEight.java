package day08;

import day08.utils.InputFileReader;
import day08.utils.Instruction;

import java.util.ArrayList;
import java.util.List;

public class DayEight {
    private static List<Instruction> instructionList;

    public static void solveDayEight(){
        String inputFile = "D:\\AdventOfCode\\AdventOfCode2020\\src\\day08\\input.txt";
        InputFileReader inputFileReader = new InputFileReader(inputFile);
        instructionList = inputFileReader.readSetFromInputFile();
//        System.out.println(isNotLoop());
        getAccumulatorValue();
    }

    private static boolean isNotLoop(){
        int counter = 0;
        List<Integer> usedIndex = new ArrayList<>();
        for(int i = 0; i < instructionList.size(); i++){
            System.out.println(instructionList.get(i));
            if(usedIndex.contains(i)){
                System.out.println(counter);
                return false;
            }
            usedIndex.add(i);
            Instruction currentInstruction = instructionList.get(i);
            String operation = currentInstruction.getOperation();
            switch(operation) {
                case "nop": break;
                case "acc": {
                    counter += currentInstruction.getArgument();
                    break;
                }
                case "jmp": {
                    i += currentInstruction.getArgument() - 1;
                    break;
                }
            }
        }
        System.out.println(counter);
        return true;
    }

    private static void reset(){
        for(Instruction instruction:instructionList){
            instruction.setNumberOfVisits(0);
        }
    }

    private static void getAccumulatorValue(){
       // reset();
        for(int i = 0; i < instructionList.size(); i++){
            Instruction currentInstruction = instructionList.get(i);
            if(swapJmpNop(currentInstruction)){
                if(isNotLoop()){
                    break;
                }
            }
            swapJmpNop(currentInstruction);
        }
    }

    private static boolean swapJmpNop(Instruction instruction){
        if(instruction.getOperation().equalsIgnoreCase("jmp")
                || instruction.getOperation().equalsIgnoreCase("nop")){
            String changed = instruction.getOperation().equalsIgnoreCase("jmp") ? "nop" : "jmp";
            instruction.setOperation(changed);
            return true;
        }
        return false;
    }
}
