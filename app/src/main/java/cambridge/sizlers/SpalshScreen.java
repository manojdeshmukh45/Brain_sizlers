package cambridge.sizlers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SpalshScreen extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash_screen);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(SpalshScreen.this,LoginActivity.class);
                SpalshScreen.this.startActivity(mainIntent);
                SpalshScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
