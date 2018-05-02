package com.example.user.quizzapp;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * this is a quiz app and  displays  the name of the person,taking the quiz, the final score and a message
 *if there is a missing question
 */

public class MainActivity extends AppCompatActivity {
    int numberOfAnswers = 0;
    final int numberOfQuestions =4;
    Boolean question1=true;
    Boolean question2=true;
    Boolean question3=true;
    Boolean question4=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * this method is called when the RadioButton for question1 is clicked
     */
    public void clickq1(View view) {
        if (question1) {
            numberOfAnswers += 1;
        }
        question1=false;

    }

    /**
     * this method is called when the RadioButton for question2 is clicked
     */
    public void clickq2(View view) {
        if (question2) {
            numberOfAnswers += 1;
        }
        question2=false;


    }
    /**
     * this method is called when the CheckBox for question3 is clicked
     */
    public void clickq3(View view) {
        if (question3) {
            numberOfAnswers += 1;
        }
        question3=false;

    }
    /**
     * this method is called when the RadioButton for question4 is clicked
     */
    public void clickq4(View view) {
        if (question4) {
            numberOfAnswers += 1;
        }
        question4=false;


    }
    /**
     * calculates the  score from the first correct answer  and returns the total score
     */

    private int calculateScore (){

        int score=0;

        if ((((CheckBox) findViewById(R.id.q3_a1)).isChecked()) && !(((CheckBox) findViewById(R.id.q3_a2)).isChecked()) && (((CheckBox) findViewById(R.id.q3_a3)).isChecked()) && ! (((CheckBox) findViewById(R.id.q3_a4)).isChecked()))
            score += 1;

        if (((RadioButton) findViewById(R.id.q1_a1)).isChecked()){
            score+=1;
        }
        if (((RadioButton) findViewById(R.id.q1_a2)).isChecked()){
            score = score;
        }
        if (((RadioButton) findViewById(R.id.q2_a1)).isChecked()){
            score+=1;
        }
        if (((RadioButton) findViewById(R.id.q2_a2)).isChecked()){
            score = score;
        }
        if (((RadioButton) findViewById(R.id.q2_a1)).isChecked()){
            score+=1;
        }

        if (((RadioButton) findViewById(R.id.q4_a1)).isChecked()){
            score+=1;
        }
        if (((RadioButton) findViewById(R.id.q4_a2)).isChecked()){
            score = score;
        }
        return score;

    }
    /**
     * this method  displays  the name of the player, the final score and a message
     *if there is a missing question
     */
    public void finalScore(View view) {
        EditText nameField= (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        TextView missingView = (TextView) findViewById(R.id.missing_questions);
        if (numberOfAnswers==numberOfQuestions) {
            int score = calculateScore();
            TextView scoreText = (TextView) findViewById(R.id.summary_score);
            scoreText.setText(name  +   ",you have "+  score + " correct answers");
            missingView.setText("");

            if (score==numberOfQuestions){
                scoreText.setTextColor(Color.parseColor("#AA00FF"));

            }else{
                scoreText.setTextColor(Color.RED);
            }
        } else {
            if (numberOfQuestions- numberOfAnswers == 1) {
                missingView.setText(name + " ,be careful - there is a missing  question!");
            } else {
                missingView.setText(name + " ,you're missing " + (numberOfQuestions - numberOfAnswers) + " questions");
            }



        }

    }

}
