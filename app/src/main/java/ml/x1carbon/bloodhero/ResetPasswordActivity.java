package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPasswordActivity extends AppCompatActivity {
    public static final String TAG=RegistrationActivity.class.getSimpleName();

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent=getIntent();
        String name=intent.getStringExtra( "name" );
        if (name==null){
            name="Friend";
        }
        Log.d( TAG,name );

        mAuth=FirebaseAuth.getInstance();

    }
}
