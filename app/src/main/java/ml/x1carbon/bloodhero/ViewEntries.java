package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewEntries extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Button _btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entries);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        toolbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ViewEntries.this, "Ketu wego in this bitch", Toast.LENGTH_SHORT).show();
//            }
//        });

        t1= (TextView) findViewById(R.id.blood);
        t2= (TextView) findViewById(R.id.name);
        t3=(TextView)findViewById(R.id.phone);
        t4= (TextView) findViewById(R.id.city);
        t5= (TextView) findViewById(R.id.desc);
        _btnCall= (Button) findViewById(R.id.btnCall);

        Intent i=this.getIntent();
        final String na=i.getExtras().getString("NAME");
        final String ph=i.getExtras().getString("PHONE");
        final String cit=i.getExtras().getString("CITY");
        final String bl=i.getExtras().getString("BLOOD");
        final String de=i.getExtras().getString("DESC");
        t1.setText(bl);
        t2.setText(na);
        t3.setText(ph);
        t4.setText(cit);
        t5.setText(de);


        _btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Intent.ACTION_DIAL);
                if (!ph.equals(""))
                {
                    intent1.setData(Uri.parse("tel:"+ph));
                }
                startActivity(intent1);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ph));
                if (!ph.equals(""))
                {
                    intent.setData(Uri.parse("tel:"+ph));
                }
                startActivity(intent);
            }
        });


    }
}
