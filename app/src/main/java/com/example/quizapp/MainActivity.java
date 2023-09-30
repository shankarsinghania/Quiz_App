package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView option_A,option_B,option_C,option_D;
    private  TextView questionNumber,question,score;
    private TextView checkout1,checkout2;
    int currentIndex, mscore=0,qn=1;
    ProgressBar progressBar;

    int currentquestion,currentoptionA,currentoptionB,currentoptionC,currentoptionD;

    private answerClass[] questionbank =new answerClass[]{
            new answerClass(R.string.question1,R.string.question1_a,R.string.question1_b,R.string.question1_c,R.string.question1_d,R.string.answer_1),
            new answerClass(R.string.question2,R.string.question2_a,R.string.question2_b,R.string.question2_c,R.string.question2_d,R.string.answer_2),
            new answerClass(R.string.question3,R.string.question3_a,R.string.question3_b,R.string.question3_c,R.string.question3_d,R.string.answer_3),
            new answerClass(R.string.question4,R.string.question4_a,R.string.question4_b,R.string.question4_c,R.string.question4_d,R.string.answer_4),
            new answerClass(R.string.question5,R.string.question5_a,R.string.question5_b,R.string.question5_c,R.string.question5_d,R.string.answer_5),
            new answerClass(R.string.question6,R.string.question6_a,R.string.question6_b,R.string.question6_c,R.string.question6_d,R.string.answer_6),
            new answerClass(R.string.question7,R.string.question7_a,R.string.question7_b,R.string.question7_c,R.string.question7_d,R.string.answer_7),
            new answerClass(R.string.question8,R.string.question8_a,R.string.question8_b,R.string.question8_c,R.string.question8_d,R.string.answer_8),

    };
    final int PROGRESS_BAR = (int)Math.ceil(100/questionbank.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option_A=findViewById(R.id.optionA);
        option_B=findViewById(R.id.optionB);
        option_C=findViewById(R.id.optionC);
        option_D=findViewById(R.id.optionD);

        question=findViewById(R.id.question);
        score=findViewById(R.id.score);
        questionNumber=findViewById(R.id.QuestionNo);
        checkout1=findViewById(R.id.selectOption);
        checkout2=findViewById(R.id.correctAnswer);
        progressBar=findViewById(R.id.progressBar);

        currentquestion=questionbank[currentIndex].getQuestionid();
        question.setText(currentquestion);
        currentoptionA=questionbank[currentIndex].getOptionA();
        option_A.setText(currentoptionA);
        currentoptionB=questionbank[currentIndex].getOptionB();
        option_B.setText(currentoptionB);
        currentoptionC=questionbank[currentIndex].getOptionC();
        option_C.setText(currentoptionC);
        currentoptionD=questionbank[currentIndex].getOptionD();
        option_D.setText(currentoptionD);

        option_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionA);
                updateQuestion();
            }
        });
        option_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionB);
                updateQuestion();
            }
        });
        option_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionC);
                updateQuestion();
            }
        });
        option_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(currentoptionD);
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        currentIndex=(currentIndex+1)%questionbank.length;
        if(currentIndex == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("YOUR SCORE :"+mscore);
            alert.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNegativeButton("Restart Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score"+mscore+"/"+questionbank.length);
                    questionNumber.setText("Question :"+qn+"/"+questionbank.length);
                }
            });
            alert.show();
        }

        currentquestion=questionbank[currentIndex].getQuestionid();
        question.setText(currentquestion);
        currentoptionA=questionbank[currentIndex].getOptionA();
        option_A.setText(currentoptionA);
        currentoptionB=questionbank[currentIndex].getOptionB();
        option_B.setText(currentoptionB);
        currentoptionC=questionbank[currentIndex].getOptionC();
        option_C.setText(currentoptionC);
        currentoptionD=questionbank[currentIndex].getOptionD();
        option_D.setText(currentoptionD);
        qn=qn+1;
        if(qn<questionbank.length){
            questionNumber.setText("Question :"+qn+"/"+questionbank.length);
        }
        score.setText("Score"+mscore+"/"+questionbank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);


    }

    private void checkAnswer(int userSelection) {
        int correctAnswer=questionbank[currentIndex].getAnswerid();
        checkout1.setText(userSelection);
        checkout2.setText(correctAnswer);

        String m = checkout1.getText().toString().trim();
        String n = checkout2.getText().toString().trim();
        if(m.equals(n)){
            Toast.makeText(getApplicationContext(),"Right",Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
        }


    }
}