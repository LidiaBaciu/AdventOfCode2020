package day05.utils;

public class BoardingPass {
    private String code;
    private int row;
    private int column;
    private int id;
    public static int maximum = 0;

    public BoardingPass(String code){
        this.code = code;
        this.findRow();
        this.findColumn();
        this.findId();
    }

    public int getId(){
        return id;
    }
    private void findRow(){
        int lowerBorder = 0;
        int upperBorder = 127;
        for(Character character: code.toCharArray()){
            if(character == 'F'){
                upperBorder = (lowerBorder + upperBorder +1)/2 -1;
            } else if(character == 'B'){
                lowerBorder = (lowerBorder + upperBorder + 1)/2;
            } else {
                break;
            }
        }
        char decidingCharacter = code.charAt(code.length() -4);
        if(decidingCharacter == 'F'){
            row = lowerBorder;
        } else if(decidingCharacter == 'B'){
            row = upperBorder;
        }
    }

    private void findColumn(){
        int lowerBorder = 0;
        int upperBorder = 7;
        char decidingCharacter = code.charAt(code.length() -1);
        for(int index = code.length() -3; index < code.length(); index++){
            if(code.charAt(index) == 'R'){
                lowerBorder = (lowerBorder + upperBorder +1)/2;
            } else if(code.charAt(index) == 'L'){
                upperBorder = (lowerBorder + upperBorder )/2;
            }
        }
        if(decidingCharacter == 'R'){
            column = upperBorder;
        } else if(decidingCharacter == 'L'){
            column = lowerBorder;
        }
    }

    private void findId(){
        id = row * 8 + column;
        if(id > maximum){
            maximum = id;
        }
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
                "code='" + code + '\'' +
                ", row=" + row +
                ", column=" + column +
                ", id=" + id +
                '}';
    }
}
