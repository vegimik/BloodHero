package ml.x1carbon.bloodhero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databaza extends SQLiteOpenHelper {
    public Databaza(Context context) {
        super(context, "perdoruesi3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//                db.execSQL("drop table if exists Perdoruesit");
        db.execSQL("create table Perdoruesit3 " +
                "(ID integer primary key AUTOINCREMENT, " +
                "Perdoruesi varchar(50), " +
                "Passwordi varchar(50), " +
                "Aktiv integer)");
        db.execSQL("insert into Perdoruesit3(Perdoruesi,Passwordi, Aktiv) values ('vegimik_1','123456','0')");
        db.execSQL("insert into Perdoruesit3(Perdoruesi,Passwordi, Aktiv) values ('vegimik_2','123456','0')");
        db.execSQL("insert into Perdoruesit3(Perdoruesi,Passwordi, Aktiv) values ('vegimik_3','123456','0')");
//                db.execSQL("delete from Perdoruesit1");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists Perdoruesit");

//        db.execSQL("delete from Perdoruesit1");

//        onCreate(db);
    }
}
