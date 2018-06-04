package ml.x1carbon.bloodhero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databaza extends SQLiteOpenHelper {
    public Databaza(Context context) {
        super(context, "perdoruesi", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Perdoruesit " +
                "(ID integer primary key AUTOINCREMENT, " +
                "Perdoruesi varchar(50), Passwordi varchar(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
