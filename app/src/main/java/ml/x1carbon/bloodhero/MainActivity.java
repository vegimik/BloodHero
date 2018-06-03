package ml.x1carbon.bloodhero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ListView resultview;
    List<AddEntry> artists;
    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        databaseArtists = FirebaseDatabase.getInstance().getReference("messages");
        artists = new ArrayList<>();
        databaseArtists.keepSynced(true);
        resultview = (ListView) findViewById(R.id.listView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),AddNew.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
                    AddEntry artist = postSnapshot.getValue(AddEntry.class);
                    //adding artist to the list
                    artists.add(artist);
                }

                //creating adapter
                BloodModel artistAdapter = new BloodModel(MainActivity.this, artists);
                //attaching adapter to the listview
                resultview.setAdapter(artistAdapter);
                resultview.post(new Runnable() {
                    @Override
                    public void run() {
                        resultview.setSelection(resultview.getCount() + 1);
                    }
                });
                // resultview.setStackFromBottom(true);
                // resultview.smoothScrollToPosition(artistAdapter.getCount()-1);
                resultview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //getting the selected artist
                        AddEntry artist = artists.get(i);

                        //creating an intent
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.dashboard_amd:
                Intent home=new Intent(MainActivity.this, Dashboard.class);
                startActivity(home);
                break;
            case R.id.ap:
                Intent pt=new Intent(MainActivity.this,Tags.class);
                pt.putExtra("tag","A+");
                break;
            case R.id.an:
                Intent gen=new Intent(MainActivity.this,Tags.class);
                gen.putExtra("tag","A-");
                startActivity(gen);
                break;
            case R.id.bp:
                Intent fun=new Intent(MainActivity.this,Tags.class);
                fun.putExtra("tag","B+");
                startActivity(fun);
                break;
            case R.id.bn:
                Intent dress=new Intent(MainActivity.this,Tags.class);
                dress.putExtra("tag","B-");
                startActivity(dress);
                break;
            case R.id.op:
                Intent furniture=new Intent(MainActivity.this,Tags.class);
                furniture.putExtra("tag","O+");
                startActivity(furniture);
                break;
            case R.id.on:
                Intent place=new Intent(MainActivity.this,Tags.class);
                place.putExtra("tag","O-");
                startActivity(place);
                break;
            case R.id.abp:
                Intent con=new Intent(MainActivity.this,Tags.class);
                con.putExtra("tag","AB+");
                startActivity(con);
                break;
            case R.id.abn:
                Intent feed=new Intent(MainActivity.this,Tags.class);
                feed.putExtra("tag","AB-");
                startActivity(feed);
                break;
            case R.id.notifications_amd:
                Toast.makeText(getApplicationContext(),"Ska ende Notfication", Toast.LENGTH_LONG).show();
//                Intent notify=new Intent(MainActivity.this,Notifications.class);
//                startActivity(notify);
                break;
            case R.id.useradd_amd:
                Intent useradd=new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(useradd);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
