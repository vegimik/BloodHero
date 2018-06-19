package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
     TextView forgotPass;//=findViewById( R.id.txtViewForgotPassword );
     EditText email;//=findViewById( R.id.ETemail );
     EditText password;//=findViewById( R.id.ETpassword );
     Button btnLogin;
    List<AddUser> shfrytezuesit;
    DatabaseReference databaseUsers;
    String teksti="";
    String permbajtjaDatabaze="";
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPass=(TextView) findViewById( R.id.txtViewForgotPassword );
        email=(EditText) findViewById( R.id.ETemail );
        password=(EditText) findViewById( R.id.ETpassword );
        btnLogin=(Button) findViewById( R.id.btnLogin );



        SQLiteDatabase db=(new Databaza(LoginActivity.this)).getReadableDatabase();
        Cursor c=db.rawQuery("select* from Perdoruesit3 where Aktiv="+1, null);
        c.moveToLast();
        int counter=c.getCount();
        Log.i("Userat",String.valueOf(counter));
        if (counter>0)
        {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }
        else
        {

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SQLiteDatabase db=(new Databaza(LoginActivity.this)).getReadableDatabase();
                    Cursor c_2=db.rawQuery("select* from Perdoruesit3 where Perdoruesi='"+"vegimik_1"+"' and Passwordi='"+"123456"+"'", null);
                    c_2.moveToLast();
                    int counter_2=c_2.getCount();
                    if (counter_2>0)
                    {
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
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

    private void updateUI(FirebaseUser currentUser) {
    }



    //Nje metode per autentikim me Firebase
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