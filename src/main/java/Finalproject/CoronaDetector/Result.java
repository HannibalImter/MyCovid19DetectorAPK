package Finalproject.CoronaDetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {


    private TextView text3;
    private TextView text4;
    private TextView text5;

    private Button bu4;

    private ImageView imageView;


    static private int[] results = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageView=(ImageView)findViewById(R.id.imageView3) ;
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.advice);

        bu4 = (Button) findViewById(R.id.bu4);
        bu4();


        addingPoints();

        int total = totalPoints();

        text3.setText("The possibilities of you having\nthe Covid-19 are:");
        text4.setText(finalResult(total));

    }


    public static void getAnswerFromUser(int result, int currentIndex) {

        results[currentIndex] = result;


    }


    private int totalPoints() {


        int i, total = 0;

        for (i = 0; i < 7; i++) {

            total += results[i];

        }

        return total;
    }

    void addingPoints() {

        results[0] *= 2;
        results[1] *= 2;
        results[2] *= 3;
        results[3] *= 2;
        results[4] *= 1;
        results[5] *= 2;
        results[6] *= 2;


    }


    private String finalResult(int total) {

        if (total == 0) {
            textcolor(1);
            return "VERY LOW";
        } else if (total <= 3) {
            textcolor(2);
            return "LOW";

        } else if (total > 3 && total <= 7) {
            textcolor(3);
            return "POTENTIAL";
        } else {
            textcolor(4);
            return "HIGH!";
        }
    }

    void textcolor(int color)
    {

        if (color==1) {
            text4.setBackgroundColor(Color.GREEN);
            imageView.setImageResource(R.drawable.happy);
            text5.setText("Your Safe!");

        }

        else if (color==2) {
            text4.setBackgroundColor(Color.parseColor("#03DAC5"));
            imageView.setImageResource(R.drawable.confused);
            text5.setText("But, be cautious for any\nsymptoms that might\nhappen to appear soon! ");


        }
        else if (color==3){
            text4.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.caution);
            text5.setText("Inform your Local Doctor\nabout your symptoms!");

        }

        else {
             text4.setBackgroundColor(Color.RED);
             imageView.setImageResource(R.drawable.caution);
           //  text4.setTextSize();
             text5.setText("Contact the nearest\nHospital immediately!");

        }




    }

    void bu4(){


        bu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}