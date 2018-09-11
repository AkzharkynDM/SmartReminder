package com.example.android.smartreminder;

/**
 * Created by samir692 on 3/10/18.
 */

public class QuestionLibrary {

//    upholder : respond readily to outer and inner expectations
//    Questioners: question all expectations; they’ll meet an expectation if they think it makes sense (my husband is a Questioner); essentially, they make all expectations into inner expectations
//    Rebels :resist all expectations, outer and inner alike
//    Obligers: meet outer expectations, but struggle to meet expectations they impose on themselves
        private String mQuestions [] = {

            "Can you keep promises that you give to others?",
            "Are you responsible for duties for yourself?",
            "Do you need somebody to remind what you are required to do?",
            "Can you set goals and promises to yourself and keep it?",
            "Does it bother you when things are unfair or arbitrary?",
            "Don't you doubt the opinion of experts in some fields?"
    };
    private String mChoices[][] = {
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"},
            {"Yes", "No"}
    };


//    private String mCorrectAnswers[] = {"Upholder","Questioner","Obliger","Rebel"};

    public String getQuestion(int i){
        return mQuestions[i];
    };

    public String getChoice1(int i){
        return mChoices[i][0];
    };

    public String getChoice2(int i){
        return mChoices[i][1];
    };

//    public String getChoice3(int i){
//        return mChoices[i][2];
//    };
//
//    public String getChoice4(int i){
//        return mChoices[i][3];
//    };

//    public String getCorrectAnswer(int i){
//        return mCorrectAnswers[i];
//    }
}
