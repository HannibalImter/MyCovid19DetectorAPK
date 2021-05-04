package Finalproject.CoronaDetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private Button bu1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1= (TextView) findViewById(R.id.textView1);
        text2= (TextView) findViewById(R.id.textView2);
        text3= (TextView) findViewById(R.id.textView3);
        text4= (TextView) findViewById(R.id.textView4);


        text3.setMovementMethod(LinkMovementMethod.getInstance());
        text4.setMovementMethod(LinkMovementMethod.getInstance());


        bu1= (Button) findViewById(R.id.bu1);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,QuestionsEntry.class);
                startActivity(intent);
            }
        });
    }

}