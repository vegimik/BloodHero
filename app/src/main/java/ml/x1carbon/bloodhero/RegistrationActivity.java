package ml.x1carbon.bloodhero;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabase;
    Button register;
    RadioGroup gender;
    RadioButton male, female, otherratio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        register=(Button)findViewById(R.id.register);
        gender=(RadioGroup)findViewById(R.id.gender);
        male=(RadioButton)findViewById(R.id.maleradio);
        female=(RadioButton)findViewById(R.id.femaleradio);
        otherratio=(RadioButton)findViewById(R.id.otherradio);

        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("user");
//        FloatingActionButton save= (FloatingActionButton) findViewById(R.id.save);
        final EditText givenname= (EditText) findViewById(R.id.givenname);
        final EditText surname= (EditText) findViewById(R.id.surname);
        final EditText dob= (EditText) findViewById(R.id.dob);
        final Spinner bloodgroup= (Spinner) findViewById(R.id.bloodgroup);
        final EditText phone= (EditText) findViewById(R.id.phone);
        final EditText email= (EditText) findViewById(R.id.email);
        final EditText streetname= (EditText) findViewById(R.id.streetname);
        final EditText suburb= (EditText) findViewById(R.id.suburb);
        final EditText city= (EditText) findViewById(R.id.city);
        final EditText postcode= (EditText) findViewById(R.id.postcode);
        final EditText loginname= (EditText) findViewById(R.id.loginname);
        final EditText password= (EditText) findViewById(R.id.password);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                String sname=name.getText().toString();
//                String sblood=spinner.getSelectedItem().toString();
//                String sphone=phone.getText().toString();
//                String scity=city.getText().toString();
//                String sdesc=desc.getText().toString();

                String sname= givenname.getText().toString();
                String ssurname= surname.getText().toString();
                String sdob= dob.getText().toString();
                String genderMF="";
                if (gender.getCheckedRadioButtonId()==male.getId())
                {
                    genderMF= male.getText().toString();
                }
                else if (gender.getCheckedRadioButtonId()==female.getId())
                {
                    genderMF= female.getText().toString();
                }
                else
                {
                    genderMF= otherratio.getText().toString();
                }
                String sspinner= bloodgroup.getSelectedItem().toString();
                String sphone= phone.getText().toString();
                String semail= email.getText().toString();
                String sstreetname= streetname.getText().toString();
                String ssuburb= suburb.getText().toString();
                String scity= city.getText().toString();
                String spostcode= postcode.getText().toString();
                String sloginname= loginname.getText().toString();
                String spassword= password.getText().toString();


                String id = mFirebaseDatabase.push().getKey();
                AddUser useri=new AddUser(sname, ssurname, sdob, genderMF, sspinner, sphone, semail, sstreetname, ssuburb, scity, spostcode, sloginname, spassword, id);
                mFirebaseDatabase.child(id).setValue(useri);

                final ProgressDialog progressDialog = new ProgressDialog(RegistrationActivity.this, R.style.AppTheme);//nderrova AppTheme_Dark_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setTitle("Connecting..");
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();

                Intent home=new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(home);
                finish();
            }
        });


    }
}


//package ml.x1carbon.bloodhero;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RelativeLayout;
//import android.widget.Spinner;
//
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public class RegistrationActivity extends AppCompatActivity {
//    private DatabaseReference mFirebaseDatabase;
//    EditText givenname,surname,dob,phone,email,streetname, suburb, city,postcode,loginname, password;
//    Spinner bloodgroup;
//    Button register;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_registration);
//
//        mFirebaseDatabase=FirebaseDatabase.getInstance().getReference("user");
//
//
//        givenname=(EditText)findViewById(R.id.givenname);
//        surname=(EditText)findViewById(R.id.surname);
//        dob=(EditText)findViewById(R.id.dob);
//        bloodgroup=(Spinner) findViewById(R.id.bloodgroup);
//        phone=(EditText)findViewById(R.id.phone);
//        email=(EditText)findViewById(R.id.email);
//        streetname=(EditText)findViewById(R.id.streetname);
//        suburb=(EditText)findViewById(R.id.suburb);
//        city=(EditText)findViewById(R.id.city);
//        postcode=(EditText)findViewById(R.id.postcode);
//        loginname=(EditText)findViewById(R.id.loginname);
//        password=(EditText)findViewById(R.id.password);
//        register=(Button)findViewById(R.id.register);
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String sgivenname=givenname.getText().toString();
//                String ssurname=suburb.getText().toString();
//                String sdob=dob.getText().toString();
//                String sbloodgroup=bloodgroup.getSelectedItem().toString();
//                String sphone=phone.getText().toString();
//                String semail=email.getText().toString();
//                String sstreetname=streetname.getText().toString();
//                String ssuburb=suburb.getText().toString();
//                String scity=city.getText().toString();
//                String spostcode=postcode.getText().toString();
//                String sloginname=loginname.getText().toString();
//                String spassword=password.getText().toString();
//                String id=mFirebaseDatabase.push().getKey();
//                AddUser useri=new AddUser(sgivenname, ssurname, id);
////                AddUser useri=new AddUser(sgivenname,ssurname, sdob, sbloodgroup,sphone,semail,sstreetname,ssuburb,scity,spostcode,sloginname,spassword,id);
//
//
////                mFirebaseDatabase.child(id).setValue(useri);
//                Intent home=new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(home);
//                finish();
//            }
//
//
//
//        });
//
//    }
//}
