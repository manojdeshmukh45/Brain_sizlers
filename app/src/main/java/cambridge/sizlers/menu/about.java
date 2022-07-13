package cambridge.sizlers.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import cambridge.sizlers.R;

public class about extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        tv=(TextView)findViewById(R.id.textView16);
        tv.setText("Brain Sizzlers is a quiz app which is developed as mini project for Exam purpose. " +
                "This application contains quiz regarding Computer Science which contains 10 questions " +
                "each question waits of 10 Marks and  contain 4 options for each " +
                "wrong answer 3 marks will reduse, and total marks will out of 100.");
     getIntent();

    }
}

