package ml.x1carbon.bloodhero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BloodChartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_charts);

        getSupportActionBar().setTitle("Blood Charts");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}
