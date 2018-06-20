package ml.x1carbon.bloodhero;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StartApp extends AppCompatActivity {

    Button btn1;
    Boolean vlera=true;
    List<AddUser> shfrytezuesit;
    DatabaseReference databaseUsers;
    String teksti="";
    String permbajtjaDatabaze="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
//        setContentView( R.layout.activity_start_app );

        btn1=(Button)findViewById(R.id.button2);

        SQLiteDatabase db=(new Databaza(StartApp.this)).getReadableDatabase();
        Cursor c=db.rawQuery("select* from Perdoruesit3 ", null);
        c.moveToLast();
        final int counter=c.getCount();
        c.moveToFirst();


        do {
            permbajtjaDatabaze=permbajtjaDatabaze+", "+c.getString(0)+", "+c.getString(1)+", "+c.getString(2)+", "+c.getString(3);
        }while (c.moveToNext());


        if (counter>0)
        {
            Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent=new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(intent);
        }



/*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Toast.makeText(getApplicationContext(), permbajtjaDatabaze+", "+counter, Toast.LENGTH_LONG).show();

            }
        });


*/


        databaseUsers = FirebaseDatabase.getInstance().getReference("user");
        shfrytezuesit = new ArrayList<>();
        databaseUsers.keepSynced(true);

    }

    @Override
    protected void onResume() {
//        Intent intent=new Intent(getApplicationContext(), StartApp.class);
//        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Vegimi qetu duhet me punu", Toast.LENGTH_LONG).show();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //clearing the previous artist list
                shfrytezuesit.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    AddUser shfrytezuesi = postSnapshot.getValue(AddUser.class);
                    //adding artist to the list
//                    if(shfrytezuesi.getmDBlood().equals(name))
//                        artists.add(artist);
                    teksti=teksti+", "+shfrytezuesi.getmUpassword();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






    }
}
