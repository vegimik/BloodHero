package ml.x1carbon.bloodhero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartApp extends AppCompatActivity {

    Boolean vlera=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start_app );
//pe la niher qat sen poe startoj


        if (vlera==true)
        {
            //Pjesa e logini
            Intent intent=new Intent( getApplicationContext(), LoginActivity.class );
            startActivity( intent );
        }
        else
        {
            //Pjesa e regjistrimit
            Intent intent=new Intent( getApplicationContext(), RegistrationActivity.class );
            startActivity( intent );
        }



    }
}
