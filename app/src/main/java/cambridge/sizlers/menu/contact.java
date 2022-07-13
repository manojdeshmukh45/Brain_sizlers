package cambridge.sizlers.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cambridge.sizlers.R;

public class contact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        getIntent();
    }
}
