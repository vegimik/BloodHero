package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;




public class Tags extends AppCompatActivity {
    private ArrayList<String> result=new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView resultview;
    List<AddEntry> artists;
    DatabaseReference databaseArtists;
    String name;

    public Tags() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);
        Intent i=this.getIntent();
        //-------------------add mob-------------------//

        //---------------------------------------------//
        name=i.getExtras().getString("tag");
        databaseArtists = FirebaseDatabase.getInstance().getReference("messages");
        artists = new ArrayList<>();
        databaseArtists.keepSynced(true);
        resultview= (ListView) findViewById(R.id.listView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artists.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    AddEntry artist = postSnapshot.getValue(AddEntry.class);
                    //adding artist to the list
                    if(artist.getmDBlood().equals(name))
                        artists.add(artist);
                }

                //creating adapter
                BloodModel artistAdapter = new BloodModel(Tags.this, artists);
                //attaching adapter to the listview
                resultview.setAdapter(artistAdapter);
                resultview.post(new Runnable() {
                    @Override
                    public void run() {
                        resultview.setSelection(resultview.getCount()+1);
                    }
                });
                resultview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //getting the selected artist
                        AddEntry artist = artists.get(i);

                        Intent intent = new Intent(getApplicationContext(), ViewEntries.class);

                        //putting artist name and id to intent
                        intent.putExtra("NAME", artist.getmAName());
                        intent.putExtra("PHONE", artist.getmBPhone());
                        intent.putExtra("CITY", artist.getmCCity());
                        intent.putExtra("BLOOD", artist.getmDBlood());
                        intent.putExtra("DESC", artist.getmEDescription());

                        //starting the activity with intent
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
