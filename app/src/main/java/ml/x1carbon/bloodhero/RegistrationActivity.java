package ml.x1carbon.bloodhero;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegistrationActivity extends Activity {
    public static final String TAG=RegistrationActivity.class.getSimpleName();

    private DatabaseReference mFirebaseDatabase;
    Button register;
    CheckBox checkBoxDev;
    RadioGroup gender;
    RadioButton male, female, otherratio;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        Intent intent=getIntent();
//        String name=intent.getStringExtra( "name" );
//        if (name==null){
//            name="Friend";
//        }
//        Log.d( TAG,name );

        register    =(Button)findViewById(R.id.register);
        checkBoxDev    =(CheckBox) findViewById(R.id.chbTestim);
        gender      =(RadioGroup)findViewById(R.id.gender);
        male        =(RadioButton)findViewById(R.id.maleradio);
        female      =(RadioButton)findViewById(R.id.femaleradio);
        otherratio  =(RadioButton)findViewById(R.id.otherradio);

//        mAuth = FirebaseAuth.getInstance();

        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("user");
//        FloatingActionButton save= (FloatingActionButton) findViewById(R.id.save);
        final EditText givenname= (EditText) findViewById(R.id.givenname);
        final EditText surname= (EditText) findViewById(R.id.surname);
        //final EditText dob= (EditText) findViewById(R.id.dob);
        final Spinner bloodgroup= (Spinner) findViewById(R.id.bloodgroup);
        final EditText phone= (EditText) findViewById(R.id.phone);
        final EditText email= (EditText) findViewById(R.id.email);
        final EditText streetname= (EditText) findViewById(R.id.streetname);
        final EditText suburb= (EditText) findViewById(R.id.suburb);
        final EditText city= (EditText) findViewById(R.id.city);
        final EditText postcode= (EditText) findViewById(R.id.postcode);
        final EditText loginName= (EditText) findViewById(R.id.loginName);
        final EditText password= (EditText) findViewById(R.id.password);
        final EditText confirmPassword=(EditText) findViewById(R.id.confirmpass);
        final EditText dateOfBirth=(EditText) findViewById(R.id.datePicker);






        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String sname = givenname.getText().toString().trim();
                String ssurname = surname.getText().toString().trim();
                //String sdob= dob.getText().toString().trim();
                String genderMF = "";

                if (gender.getCheckedRadioButtonId() == male.getId()) {
                    genderMF = male.getText().toString().trim();
                } else if (gender.getCheckedRadioButtonId() == female.getId()) {
                    genderMF = female.getText().toString().trim();
                } else {
                    genderMF = otherratio.getText().toString().trim();
                }
                String sspinner = bloodgroup.getSelectedItem().toString().trim();
                String sphone = phone.getText().toString().trim();
                String semail = email.getText().toString().trim();
                String sstreetname = streetname.getText().toString().trim();
                String ssuburb = suburb.getText().toString().trim();
                String scity = city.getText().toString().trim();
                String spostcode = postcode.getText().toString().trim();
                String sloginname = loginName.getText().toString().trim();
                String spassword = password.getText().toString().trim();
                String sconfirmPass=confirmPassword.getText().toString().trim();


                if (checkBoxDev.isChecked())
                {
                    Intent home=new Intent(RegistrationActivity.this,MainActivity.class);
                    startActivity(home);
                    finish();

                }
                else
                {
                    if (sname.isEmpty()) {
                    givenname.setError("Name is required!");
                    givenname.requestFocus();
                    return;

                }

                if (ssurname.isEmpty()) {
                    surname.setError("Surname is required");
                    surname.requestFocus();
                    return;
                }

                if (sphone.isEmpty())
                {
                    phone.setError("Phone number is required!");
                    phone.requestFocus();
                    return;
                }

                if (semail.isEmpty())
                {
                    email.setError("Email credentials are required!");
                    email.requestFocus();
                    return;
                }



                if (!Patterns.EMAIL_ADDRESS.matcher( semail ).matches()) {

                email.setError("Email format is not correct");
                email.requestFocus();

                }

                 if (sloginname.isEmpty())
                 {
                    loginName.setError("Login credentials are required!");
                    loginName.requestFocus();
                    return;
                 }
                 if (spassword.isEmpty())
                 {
                    password.setError("Login credentials are required!");
                    password.requestFocus();
                    return;
                 }

//                        if (!spassword.isEmpty()) {
//                        Pattern regexPattern;
//                        Matcher regMatcher;
//                        regexPattern = Pattern.compile("(?=.*[a-z])(?=.*d)(?=.*[~!@#$%^&*_])(?=.*[A-Z]).{6,16}");
//                        regMatcher = regexPattern.matcher(spassword);
//                        if (!regMatcher.matches()) {
//                        password.setError("Passord must be 6-16 characters,must contain at least one capital letter, a number and a special character (ex:~!@#$%^&*_)");
//                        password.requestFocus();
//                        return;
//                        }
//                        } else

                        if (spassword.isEmpty()) {
                        password.setError("Password is required!");
                        password.requestFocus();
                        return;
                        }

                        if(!spassword.equals(sconfirmPass))
                        {
                        confirmPassword.setError("Password is not confirmed!");
                        confirmPassword.requestFocus();
                        return;
                        }

                if (sconfirmPass.isEmpty()|| !sconfirmPass.equals(spassword))
                {
                    confirmPassword.setError("Login credentials are required or isnt valid!");
                    confirmPassword.requestFocus();
                    return;
                }

                    String id = mFirebaseDatabase.push().getKey();

                    AddUser useri=new AddUser(sname, ssurname, "10/10/2018", genderMF, sspinner, sphone, semail, sstreetname, ssuburb, scity, spostcode, sloginname, spassword, id);
                    mFirebaseDatabase.child(id).setValue(useri);

                    //SQLite Database
                    SQLiteDatabase db=(new Databaza(RegistrationActivity.this)).getWritableDatabase();
                    ContentValues cv = new ContentValues();
                    cv.put("Perdoruesi", sloginname);
                    cv.put("Passwordi", spassword);
                    cv.put("Aktiv", "0");
                    long rezultati = db.insert("Perdoruesit3",null,cv);
                    if(rezultati>0)
                        Toast.makeText(RegistrationActivity.this, "Te dhenat u ruajten me sukses ne SQLiteDatabase!", Toast.LENGTH_LONG).show();



                    final ProgressDialog progressDialog = new ProgressDialog(RegistrationActivity.this, R.style.AppTheme);//nderrova AppTheme_Dark_Dialog);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setTitle("Connecting..");
                    progressDialog.setMessage("Authenticating...");
                    progressDialog.show();

                    Intent home=new Intent(RegistrationActivity.this,LoginActivity.class);
                    startActivity(home);
                    finish();
                }

            }
        });



}




}





//*****   =>>   Pjesa ku kemi nje pjese te pune me poshte **********




/*


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

*/

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






//
//
//
//                if (sname.isEmpty()) {
//                    givenname.setError("Name is required!");
//                    givenname.requestFocus();
//                    return;
//
//                }
//
//                if (ssurname.isEmpty()) {
//                    surname.setError("Surname is required");
//                    surname.requestFocus();
//                    return;
//                }
//
//                /*if(sdob.isEmpty()){
//                    dob.setError("Date of birth is required!");
//                    dob.requestFocus();
//                    return;
//                }*/
//
//                if (sphone.isEmpty()) {
//                        phone.setError("Phone number is required!");
//                        phone.requestFocus();
//                        return;
//                        }
//
//                        if (semail.isEmpty()) {
//                        email.setError("Email is required!");
//                        email.requestFocus();
//                        return;
//                        }
//
//                        if (!Patterns.EMAIL_ADDRESS.matcher( semail ).matches()) {
//
//                        email.setError("Email format is not correct");
//                        email.requestFocus();
//
//                        }
//
//
//
//                        if (sstreetname.isEmpty()) {
//                        streetname.setError("Streetname is required!");
//                        streetname.requestFocus();
//                        return;
//                        }
//
//                        if (scity.isEmpty()) {
//                        city.setError("Email is required!");
//                        city.requestFocus();
//                        return;
//                        }
//
//                /*if (sloginname.isEmpty()) {
//                    loginname.setError("Login credentials are required!");
//                    loginname.requestFocus();
//                    return;
//                }*/
//
//                        if(!semail.equals(sconfirmEmail)){
//                        confirmEmail.setError( "Email is not confirmed,please check!" );
//                        confirmEmail.requestFocus();
//                        return;
//                        }
//
//                        if (!spassword.isEmpty()) {
//                        Pattern regexPattern;
//                        Matcher regMatcher;
//                        regexPattern = Pattern.compile("(?=.*[a-z])(?=.*d)(?=.*[~!@#$%^&*_])(?=.*[A-Z]).{6,16}");
//                        regMatcher = regexPattern.matcher(spassword);
//                        if (!regMatcher.matches()) {
//                        password.setError("Passord must be 6-16 characters,must contain at least one capital letter, a number and a special character (ex:~!@#$%^&*_)");
//                        password.requestFocus();
//                        return;
//                        }
//                        } else if (spassword.isEmpty()) {
//                        password.setError("Password is required!");
//                        password.requestFocus();
//                        return;
//                        }
//
//                        if(!spassword.equals(sconfirmPass))
//                        {
//                        confirmPassword.setError("Password is not confirmed!");
//                        confirmPassword.requestFocus();
//                        return;
//                        }
//
//                        mAuth.createUserWithEmailAndPassword( semail,spassword ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//@Override
//public void onComplete(@NonNull Task<AuthResult> task) {
//        if (task.isSuccessful()) {
//        Toast.makeText( getApplicationContext(),"Registration is completed",Toast.LENGTH_SHORT).show();
//        }
//        }
//        } );
//
//
// */
