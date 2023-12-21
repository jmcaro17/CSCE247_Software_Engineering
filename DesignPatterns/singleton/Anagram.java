package singleton;

import java.util.ArrayList;

/**
 * 
 * @author Jesse Caro
 */
public class Anagram {
    private String question;
    private ArrayList<String> answers;

    public Anagram(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isCorrect(String userAnswer) {
        for(int i = 0; i < answers.size(); i++) {
            if(userAnswer.equals(answers.get(i))) {
                return true;
            }
        }
        return false;
    }
    
}
