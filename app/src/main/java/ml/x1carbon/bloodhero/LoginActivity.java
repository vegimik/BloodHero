package ml.x1carbon.bloodhero;

import android.content.Intent;
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

 public class LoginActivity extends AppCompatActivity {
    public static final String TAG=RegistrationActivity.class.getSimpleName();
     TextView forgotPass;//=findViewById( R.id.txtViewForgotPassword );
     EditText email;//=findViewById( R.id.ETemail );
     EditText password;//=findViewById( R.id.ETpassword );
     Button btnLogin;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPass=findViewById( R.id.txtViewForgotPassword );
        email=findViewById( R.id.ETemail );
        password=findViewById( R.id.ETpassword );
        btnLogin=findViewById( R.id.btnLogin );

        Intent intent=getIntent();// kta mos e prek se um vyn ne firebase, ma heret nuk e jepke null se bojke
        String name=intent.getStringExtra( "name" );
        if (name==null){
            name="Friend";
        }
        Log.d( TAG,name );

        mAuth=FirebaseAuth.getInstance();

         final String semail="";//email.getText().toString().trim();
         final String spassword=""; // po eci edh une e ti provo mu regjistru se bon ajo register activity
        // edhe kqyrim tani se deka per buk spo bon kryt ahah ok bonja kcommit





        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semail.isEmpty()){
                    email.setError( "Email is required" );
                    email.requestFocus();
                }
                if(spassword.isEmpty()){
                    password.setError( "Password is required!" );
                    password.requestFocus();
                }
                logimi( semail,spassword );
            }
        } );



        forgotPass.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenti=new Intent( getApplicationContext(),ResetPasswordActivity.class );
                startActivity( intenti );// kta e boj ma vone po logini qysh mu qel se, spo qelet,e bana
            }
        } );

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

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
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
