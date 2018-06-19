package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    Button amazingstories;
    Button _adBtnStatistic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        amazingstories=(Button)findViewById(R.id.amazingstories);
        amazingstories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent amzstory=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(amzstory);
            }
        });

        _adBtnStatistic=(Button)findViewById(R.id.adBtnStatistic);
        _adBtnStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BloodChartsActivity.class);
                startActivity(intent);
            }
        });



    }
}
