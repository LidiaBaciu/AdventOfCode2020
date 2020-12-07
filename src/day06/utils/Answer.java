package day06.utils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Answer {
    private Set<Character> characterSet;
    private String answerString;
    private long id;

    public Answer(String answerString){
        characterSet = new HashSet<>();
        this.id = 0;
        this.answerString = answerString;
        this.getAnswers();
    }


    private void getAnswers(){
        for(char character: answerString.toCharArray()){
            id += character;
            characterSet.add(character);
        }
    }

    public Set<Character> getCharacterSet() {
        return characterSet;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "characterSet=" + characterSet +
                ", answerString='" + answerString + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id;
    }
}
