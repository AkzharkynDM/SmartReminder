package com.example.android.smartreminder;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import com.example.android.smartreminder.R;
import com.example.android.smartreminder.database_sql.DatabaseHandler;

import static com.example.android.smartreminder.BooksListActivity.EXTRA_MESSAGE;

public class QuizActivity extends AppCompatActivity {

    private QuestionLibrary mQuestLib = new QuestionLibrary();
    private DatabaseHandler databaseHandler = new DatabaseHandler(QuizActivity.this);

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;

//    private String mAnswer;
//    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String username;
    private List<String> answers= new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionView = (TextView) findViewById(R.id.quiz_question);
        mButtonChoice1 = (Button) findViewById(R.id.quiz_answer1);
        mButtonChoice2 = (Button) findViewById(R.id.quiz_answer2);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            username = extras.getString(EXTRA_MESSAGE);
        }

        updateQuestion();


        //Button1 listener start
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for button

//                if (mButtonChoice1.getText() == mAnswer){
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//                }
//                updateQuestion();
                recordAnswers((String)mButtonChoice1.getText());
                System.out.println("choice : "+(String)mButtonChoice1.getText());
//                else{
                    if (mQuestionNumber >= 6){
                        String personality = "UPHOLDER";

                        //To define personality
                        personality = getPersonalityByQuiz();

                        System.out.println("Personality : "+personality);
                        Toast.makeText(QuizActivity.this, "Thanks for your quiz", Toast.LENGTH_LONG).show();

                        switch (personality){
                            case "UPHOLDER":
                                //databaseHandler.createUPHOLDERtable();
                                break;
                            case "OBLIGER":
                                //databaseHandler.createOBLIGERtable();
                                break;
                            case "REBEL":
                                //databaseHandler.createREBELtable();
                                break;
                            case "QUESTIONNER":
                                //databaseHandler.createQUESTIONERtable();
                                break;

                        }
                        Contacts user = new Contacts();
                        if(username != null) {
                            user.set_nick_name(username);
                            user.setFilled_quiz(1);
                            databaseHandler.addUserQuizValue(user);

                            user.set_personality_type(personality);
                            //add personality information
                            databaseHandler.addPersonalityTypeValue(user);

                            Intent intent = new Intent(QuizActivity.this, BooksListActivity.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        System.out.println("Question number = " + mQuestionNumber);
                        updateQuestion();
                    }
//                }
            }
        });

        //Button2 listener start
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logic for button

//                if (mButtonChoice2.getText() == mAnswer){
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//                }
//                updateQuestion();
                recordAnswers((String)mButtonChoice2.getText());
                System.out.println("choice : "+(String)mButtonChoice2.getText());
//                else{
                    if (mQuestionNumber >= 6){
                        String personality = "UPHOLDER";
                        personality = getPersonalityByQuiz();
                        System.out.println("Personality : "+personality);
                        Toast.makeText(QuizActivity.this, "Thanks for your quiz", Toast.LENGTH_LONG).show();

                        switch (personality){
                            case "UPHOLDER":
                                //databaseHandler.createUPHOLDERtable();
                                break;
                            case "OBLIGER":
                                //databaseHandler.createOBLIGERtable();
                                break;
                            case "REBEL":
                                //databaseHandler.createREBELtable();
                                break;
                            case "QUESTIONNER":
                                //databaseHandler.createQUESTIONERtable();
                                break;

                        }
                        Contacts user = new Contacts();
                        if(username != null) {
                            user.set_nick_name(username);
                            user.setFilled_quiz(1);
                            databaseHandler.addUserQuizValue(user);

                            user.set_personality_type(personality);
                            //add personality information
                            databaseHandler.addPersonalityTypeValue(user);

                            Intent intent = new Intent(QuizActivity.this, BooksListActivity.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        System.out.println("Question number = " + mQuestionNumber);
                        updateQuestion();
                    }
//                }
            }
        });


        //Button3 listener start
//        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //logic for button
//
//                if (mButtonChoice3.getText() == mAnswer){
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//                }
//                else{
//                    if (mQuestionNumber >= 3){
//                        Toast.makeText(QuizActivity.this, "Thanks for your quiz", Toast.LENGTH_LONG).show();
//                        String personality = "UPHOLDER";
//                        switch (personality){
//                            case "UPHOLDER":
//                                //databaseHandler.createUPHOLDERtable();
//                                break;
//                            case "OBLIGER":
//                                //databaseHandler.createOBLIGERtable();
//                                break;
//                            case "REBEL":
//                                //databaseHandler.createREBELtable();
//                                break;
//                            case "QUESTIONER":
//                                //databaseHandler.createQUESTIONERtable();
//                                break;
//
//                        }
//                        Contacts user = new Contacts();
//                        if(username != null) {
//                            user.set_nick_name(username);
//                            user.setFilled_quiz(1);
//                            databaseHandler.addUserQuizValue(user);
//
//                            user.set_personality_type(personality);
//                            //add personality information
//                            databaseHandler.addPersonalityTypeValue(user);
//
//                            Intent intent = new Intent(QuizActivity.this, BooksListActivity.class);
//                            startActivity(intent);
//                        }
//                    }
//                    else {
//                        System.out.println("Question number = " + mQuestionNumber);
//                        updateQuestion();
//                    }
//                }
//            }
//        });
//
//        //Button4 listener start
//        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //logic for button
//
//                if (mButtonChoice4.getText() == mAnswer){
//                    mScore = mScore + 1;
//                    updateScore(mScore);
//                    updateQuestion();
//                }
//                else{
//                    if (mQuestionNumber >= 3){
//                        Toast.makeText(QuizActivity.this, "Thanks for your quiz", Toast.LENGTH_LONG).show();
//                        String personality = "UPHOLDER";
//                        switch (personality){
//                            case "UPHOLDER":
//                                //databaseHandler.createUPHOLDERtable();
//                                break;
//                            case "OBLIGER":
//                                //databaseHandler.createOBLIGERtable();
//                                break;
//                            case "REBEL":
//                                //databaseHandler.createREBELtable();
//                                break;
//                            case "QUESTIONER":
//                                //databaseHandler.createQUESTIONERtable();
//                                break;
//
//                        }
//                        Contacts user = new Contacts();
//                        if(username != null) {
//                            user.set_nick_name(username);
//                            user.setFilled_quiz(1);
//                            databaseHandler.addUserQuizValue(user);
//
//                            user.set_personality_type(personality);
//                            //add personality information
//                            databaseHandler.addPersonalityTypeValue(user);
//
//                            Intent intent = new Intent(QuizActivity.this, BooksListActivity.class);
//                            startActivity(intent);
//                        }
//                    }
//                    else {
//                        System.out.println("Question number = " + mQuestionNumber);
//                        updateQuestion();
//                    }
//                }
//            }
//        });
    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestLib.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestLib.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestLib.getChoice2(mQuestionNumber));

//       mAnswer = mQuestLib.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }
    private void recordAnswers(String an){
        answers.add(an);
    }

    private String getPersonalityByQuiz(){
        //Here we will implement QuestionsAnswersAnalyzer
        //loading the training set for our J48 decision tree
        String pathToFile="/Users/akzharkynduisembiyeva/StudioProjects/SmartReminder/training_set/training_set.csv";
        QuestionAnswerAnalyzer analyzer=new QuestionAnswerAnalyzer(pathToFile);
        String rel = "UPHOLDER";

        int countOutterYes=0;
        int countOutterNo=0;
        int countInnterYes=0;
        int countInnterNo=0;

        // 0 - No  1 -Yes
        int outter=0;
        int inner =0;
        for(int i=0;i<(answers.size()-1)/2;i++){
            if(answers.get(i)=="Yes"){
                countOutterYes++;
            }else{
                countOutterNo++;
            }
        }
        for(int i=(answers.size()-1)/2;i<answers.size();i++){
            if(answers.get(i)=="Yes"){
                countInnterYes++;
            }else{
                countInnterNo++;
            }
        }
        System.out.println("outter: "+outter);
        System.out.println("inner: "+inner);
        if(countOutterYes>countOutterNo){
            outter=1;
        }else{
            outter=0;
        }

        if(countInnterYes>countInnterNo){
            inner=1;
        }else{
            inner=0;
        }

        if(outter ==1 & inner ==1){
            rel = "UPHOLDER";
        }else if(outter ==1 & inner==0){
            rel = "QUESTIONER";

        }else if(outter == 0 & inner ==1){
            rel = "OBLIGER";
        }else if(outter ==0 & inner ==0){
            rel = "REBEL";
        }
        return rel;

    }

    private void updateScore(int point){
        //can update Score in the view if you want
    }
}
