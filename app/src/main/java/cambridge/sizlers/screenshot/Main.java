package cambridge.sizlers.screenshot;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import cambridge.sizlers.R;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Main extends AppCompatActivity {

Button button;
TextView tvResponse1;
    PieChartView pieChartView;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.result);

        pieChartView=(PieChartView)findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(55,Color.GREEN));
        pieData.add(new SliceValue(25, Color.RED));
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);



        //Screen Shot
    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    != PackageManager.PERMISSION_GRANTED) {
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
    }
    else
    {

    }

    button=(Button)findViewById(R.id.button5);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View rootView =getWindow().getDecorView().findViewById(android.R.id.content);
            Bitmap bitmap=getScreenShot(rootView);
            store(bitmap,"ScreenShot.png");


        }
    });
}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1000){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Permission Denine",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public static Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap=Bitmap.createBitmap(screenView.getDrawingCache());
        return  bitmap;
    }

    public void  store(Bitmap bm, String fileName){
    String dirPath= Environment.getExternalStorageDirectory()+"/MyFies";
        File dir=new File(dirPath);
    if(!dir.exists()){
        dir.mkdirs();
    }
    File file=new File(dirPath,fileName);
    try{
        FileOutputStream fos=new FileOutputStream(file);
        bm.compress(Bitmap.CompressFormat.PNG,100,fos);
        fos.flush();
        fos.close();
    }catch (Exception e){
        e.printStackTrace();
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
    }
    }
}
