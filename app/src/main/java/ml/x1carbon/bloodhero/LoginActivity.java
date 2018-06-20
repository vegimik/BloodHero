package ml.x1carbon.bloodhero;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG=RegistrationActivity.class.getSimpleName();
     TextView forgotPass;
     Button createNewAccount;
     EditText email;
     EditText password;
     Button btnLogin;
    List<AddUser> shfrytezuesit;
    DatabaseReference databaseUsers;
    String teksti="";
    String permbajtjaDatabaze="";
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPass=(TextView) findViewById( R.id.txtViewForgotPassword );
        email=(EditText) findViewById( R.id.ETemail );
        password=(EditText) findViewById( R.id.ETpassword );
        btnLogin=(Button) findViewById( R.id.btnLogin );
        createNewAccount=(Button) findViewById( R.id.btnCreate_new_Account );

        Runnable r=new Runnable() {
            @Override
            public void run() {
                createNewAccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(), RegistrationActivity.class);
                        startActivity(intent);
                    }
                });
            }
        };
        Thread t1=new Thread(r);
        t1.start();


        SQLiteDatabase db=(new Databaza(LoginActivity.this)).getReadableDatabase();
        Cursor c=db.rawQuery("select* from Perdoruesit3 where Aktiv="+1, null);
        c.moveToLast();
        counter=c.getCount();
        Log.i("Userat",String.valueOf(counter));
        if (counter==1)
        {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }
        else
        {

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (email.getText().toString().equals("")) {
                        email.setError("Username is required!");
                        email.requestFocus();
                        return;
                    }
                    if (password.getText().toString().equals("")) {
                        password.setError("Password is required!");
                        password.requestFocus();
                        return;
                    }

                    SQLiteDatabase db=(new Databaza(LoginActivity.this)).getReadableDatabase();
                    Cursor c_2=db.rawQuery("select* from Perdoruesit3 where Perdoruesi='"+email.getText().toString()+"' and Passwordi='"+password.getText().toString()+"'", null);
                    c_2.moveToLast();
                    int counter_2=c_2.getCount();
                    if (counter_2>0)
                    {
                        ContentValues contentValues=new ContentValues();
                        contentValues.put("Aktiv",1);
                        db.update("Perdoruesit3",contentValues,"Perdoruesi='"+email.getText().toString()+"' and Passwordi='"+password.getText().toString()+"'",null);
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Username or Password, or both of them are wrong.", Toast.LENGTH_LONG).show();
                    }

                }
            });

        }



    }



    @Override
    public void onStart() {
        super.onStart();



        /*
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
        */
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_HOME:
                Toast.makeText(getApplicationContext(), "Home button presed", Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_BACK:
                MainActivity ma=new MainActivity();
                ma.setStop();
                Toast.makeText(getApplicationContext(), "Back button presed", Toast.LENGTH_LONG).show();
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;

        }
        return super.onKeyDown(keyCode, event);
    }

    private void updateUI(FirebaseUser currentUser) {
    }


    //Nje metode per autentikim me Firebase-method
    private void logimi(String semail, String spassword)//po se ato i marr prej textboxave op qe man
    { mAuth.signInWithEmailAndPassword(semail, spassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {//prit ni form tjeter
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

}










//  ***   =>  Ketu eshte njer pjese e Loginit me FireBase


//
//     Intent intent=getIntent();// kta mos e prek se um vyn ne firebase, ma heret nuk e jepke null se bojke
//     String name=intent.getStringExtra( "name" );
//        if (name==null){
//                name="Friend";
//                }
//                Log.d( TAG,name );
//
//                mAuth=FirebaseAuth.getInstance();
//
//final String semail="";//email.getText().toString().trim();
//final String spassword=""; // po eci edh une e ti provo mu regjistru se bon ajo register activity
//        // edhe kqyrim tani se deka per buk spo bon kryt ahah ok bonja kcommit
//
//
//
//
//
//        btnLogin.setOnClickListener( new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        if (semail.isEmpty()){
//        email.setError( "Email is required" );
//        email.requestFocus();
//        }
//        if(spassword.isEmpty()){
//        password.setError( "Password is required!" );
//        password.requestFocus();
//        }
//        logimi( semail,spassword );
//        }
//        } );
//
//
//
//        forgotPass.setOnClickListener( new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        Intent intenti=new Intent( getApplicationContext(),ResetPasswordActivity.class );
//        startActivity( intenti );// kta e boj ma vone po logini qysh mu qel se, spo qelet,e bana
//        }
//        } );