package ml.x1carbon.bloodhero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WhoCanDonate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_can_donate);

        getSupportActionBar().setTitle("Who Can Donate");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
