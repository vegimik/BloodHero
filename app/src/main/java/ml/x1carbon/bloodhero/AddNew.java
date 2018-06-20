package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddNew extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabase;
    List<AddUser> users_d;
    AddUser userActiv;
    DatabaseReference databaseUSERS_D;
    String pershkrimi="";
    private String userNAME="";
    Button btnTestFetch;
    EditText name,phone,city,desc;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        getSupportActionBar().setTitle("Register as Donar");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseUSERS_D = FirebaseDatabase.getInstance().getReference("user");
        users_d = new ArrayList<>();
        databaseUSERS_D.keepSynced(true);
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("messages");
        FloatingActionButton save= (FloatingActionButton) findViewById(R.id.save);
        name= (EditText) findViewById(R.id.name);
        phone= (EditText) findViewById(R.id.phone);
        city= (EditText) findViewById(R.id.city);
        desc= (EditText) findViewById(R.id.desc);
        spinner= (Spinner) findViewById(R.id.blood);
        btnTestFetch=(Button)findViewById(R.id.btnTestFeatch);

        btnTestFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(userActiv.getmUname());
                phone.setText(userActiv.getmUphone());
                spinner.setSelection(calculateSpinnerPosition(userActiv.getmUspinner()));
                city.setText(userActiv.getmUcity());
                phone.setText(userActiv.getmUphone());
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname=name.getText().toString();
                String sblood=spinner.getSelectedItem().toString();
                String sphone=phone.getText().toString();
                String scity=city.getText().toString();
                String sdesc=desc.getText().toString();

                if (sname.equals(""))
                {
                    name.setError("Name is required!");
                    name.requestFocus();
                    return;
                }

               String id = mFirebaseDatabase.push().getKey();
                AddEntry artist = new AddEntry(sname,sphone,scity,sblood,sdesc,id);
                mFirebaseDatabase.child(id).setValue(artist);
                Snackbar snackbar= Snackbar.make(findViewById(R.id.listAddNew), "Registered", Snackbar.LENGTH_LONG).setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Write Your Code here
                    }
                });
                snackbar.show();
                Intent home=new Intent(AddNew.this,MainActivity.class);
                startActivity(home);

                finish();
            }
        });
    }

    @Override
    protected void onStart() {

        String username="";
        SQLiteDatabase database=(new Databaza(AddNew.this)).getReadableDatabase();
        Cursor cursor=database.rawQuery("select* from Perdoruesit3 where Aktiv="+1, null);
        cursor.moveToFirst();
        username=cursor.getString(1);


        final String u_aktiv=username;
        databaseUSERS_D.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users_d.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AddUser user_d = postSnapshot.getValue(AddUser.class);
                    //adding artist to the list
                    users_d.add(user_d);//e pa nevojshme
                    if (user_d.getmUloginname().equals(u_aktiv))
                        userActiv=user_d;

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        super.onStart();
    }


    public int calculateSpinnerPosition(String spinVlera)
    {
        int i=0;
        switch (spinVlera)
        {
            case "A+": i=0;break;
            case "A-": i=1;break;
            case "B+": i=2;break;
            case "B-": i=3;break;
            case "O+": i=4;break;
            case "O-": i=5;break;
            case "AB+": i=6;break;
            case "AB-": i=7;break;
        }
        return i;
    }



    public class TaskUpload extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
            SystemClock.sleep(3000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
        }
    }


}
