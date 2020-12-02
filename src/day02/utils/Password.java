package day02.utils;

public class Password {
    private int ruleOne;
    private int ruleTwo;
    private Character characterRule;
    private String password;
    private boolean isValidOld;
    private boolean isValidNew;

    public Password(int minimumOccurrences, int maximumOccurrences,Character characterRule, String password) {
        this.ruleOne = minimumOccurrences;
        this.ruleTwo = maximumOccurrences;
        this.password = password;
        this.characterRule = characterRule;
        this.isValidOld = this.getPasswordValidityOld();
        this.isValidNew = this.getPasswordValidityNew();
    }

    public boolean isValidOld() {
        return isValidOld;
    }

    public boolean isValidNew() {
        return isValidNew;
    }

    private boolean getPasswordValidityOld(){
        int occurrencesOfRule = countOccurrences(this.password, this.characterRule, 0);
        if(occurrencesOfRule <= this.ruleTwo && occurrencesOfRule >= this.ruleOne){
            return true;
        }
        return false;
    }

    private boolean getPasswordValidityNew(){
        if(password.charAt(ruleOne-1) == characterRule
                && password.charAt(ruleTwo -1) != characterRule){
            return true;
        } else if (password.charAt(ruleOne-1) != characterRule
                && password.charAt(ruleTwo-1) == characterRule){
            return true;
        }
        return false;
    }

    private int countOccurrences(String string, char searchedChar, int index) {
        if (index >= string.length()) {
            return 0;
        }

        int count = string.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurrences(
                string, searchedChar, index + 1);
    }

}
