package day06.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnswer {
    private int numberOfYes;
    private Set<Answer> answers;
    private List<Character> characterSet;

    public GroupAnswer(){
        answers = new HashSet<>();
        characterSet = new ArrayList<>();
        numberOfYes = 0;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
        characterSet.addAll(answer.getCharacterSet());
    }

    public int getNumberOfYes(){
        return characterSet.size();
    }

    public int getNumberOfQuestionsEveryoneSayYes(){
        Set<Character> intersection = new HashSet<>(characterSet);
        for (Answer answer: answers) {
            intersection.retainAll(answer.getCharacterSet());
        }
        System.out.println(intersection);
        return intersection.size();
    }

    @Override
    public String toString() {
        return "GroupAnswer{" +
                "answers=" + answers +
                ", characterSet=" + characterSet +
                '}';
    }
}
