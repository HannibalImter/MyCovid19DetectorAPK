package Finalproject.CoronaDetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionsEntry extends AppCompatActivity {


    private TextView text2;
    private Button bu2;
    private Button bu3;
    private TextView QuestionNumber;
    private ImageView imageView;
    int currentCounter =0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_entry);

            imageView=(ImageView)findViewById(R.id.imageView2) ;
            text2 = (TextView) findViewById(R.id.textView2);
            QuestionNumber = (TextView) findViewById(R.id.questionNumber);
            bu2 = (Button) findViewById(R.id.bu2);
            bu3 = (Button) findViewById(R.id.bu3);

            DB.on();


            showNextQeustion(currentCounter);

            bu2.setText("YES");
            bu2();


            bu3.setText("NO");
            bu3();


        }

    //
    public void showNextQeustion(int currentCounter)

    {
        text2.setText(DB.getQuestion(currentCounter));
        imageView.setImageResource(getimage(currentCounter));
        setQuestionNumber();
    }


    public void bu2() //the Yes Button
    {
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Result.getAnswerFromUser(1, currentCounter);

                currentCounter++;

                if (currentCounter < 7)
                {

                    showNextQeustion(currentCounter);
                }

                else
                    {
                        Intent intent1 = new Intent(QuestionsEntry.this,Result.class);
                        startActivity(intent1);
                        finish();

                    }
            }
        });
    }

    public void bu3() // the No Button
    {
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Result.getAnswerFromUser(0, currentCounter);

                currentCounter++;

                if (currentCounter < 7) {

                    showNextQeustion(currentCounter);

                }
                else
                    {

                        Intent intent1 = new Intent(QuestionsEntry.this,Result.class);
                        startActivity(intent1);
                        finish();

                }

            }
        });

    }

    int getimage(int currentCounter) {

            if (currentCounter==0)
                      return R.drawable.fever;
            else  if (currentCounter==1)
                      return R.drawable.coughing;
            else  if (currentCounter==2)
                     return R.drawable.dbreathing;
            else  if (currentCounter==3)
                     return R.drawable.chestpain;
            else  if (currentCounter==4)
                     return R.drawable.headeach;
            else  if (currentCounter==5)
                     return R.drawable.dirhea;

            else   return R.drawable.loss;

    }

     void setQuestionNumber() {

        if(currentCounter==0)
        { currentCounter++;}

        QuestionNumber.setText("Question number:"+currentCounter+"/6");
    }
}