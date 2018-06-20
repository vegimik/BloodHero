package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    Button amazingstories;
    Button _adBtnStatistic;
    Button _whoCanDonate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        amazingstories=(Button)findViewById(R.id.amazingstories);
        _adBtnStatistic=(Button)findViewById(R.id.adBtnStatistic);
        _whoCanDonate=(Button)findViewById(R.id.whoCanDonate);

        amazingstories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent amzstory=new Intent(getApplicationContext(),amazing_stories.class);
                startActivity(amzstory);
//                Toast.makeText(getApplicationContext(),"We are working in this section!", Toast.LENGTH_LONG).show();
            }
        });


        _adBtnStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BloodChartsActivity.class);
                startActivity(intent);
            }
        });

        _whoCanDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),WhoCanDonate.class);
                startActivity(intent);
            }
        });






    }
}
