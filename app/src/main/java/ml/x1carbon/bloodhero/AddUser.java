package ml.x1carbon.bloodhero;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class AddUser {


    private String mUname;
    private String mUsurname;
    private String mUdob;
    private String mUgenderMF;
    private String mUspinner;
    private String mUphone;
    private String mUemail;
    private String mUstreetname;
    private String mUsuburb;
    private String mUcity;
    private String mUpostcode;
    private String mUloginname;
    private String mUpassword;
    private String mFId;

    public AddUser(){
        //this constructor is required
    }

//    public AddUser(String mAName, String mBPhone, String mCCity, String mDBlood , String mEDescription, String mFId) {
//        this.mAName = mAName;
////        this.mASurname = mASurname;
//        this.mBPhone = mBPhone;
//        this.mCCity = mCCity;
//        this.mDBlood=mDBlood;
//        this.mEDescription=mEDescription;
//        this.mFId=mFId;
//    }

    public AddUser(String mUname, String mUsurname, String mUdob, String mUgenderMF, String mUspinner, String mUphone, String mUemail, String mUstreetname, String mUsuburb, String mUcity, String mUpostcode, String mUloginname, String mUpassword, String mFId) {
        this.mUname = mUname;
        this.mUsurname = mUsurname;
        this.mUdob = mUdob;
        this.mUgenderMF = mUgenderMF;
        this.mUspinner = mUspinner;
        this.mUphone = mUphone;
        this.mUemail = mUemail;
        this.mUstreetname = mUstreetname;
        this.mUsuburb = mUsuburb;
        this.mUcity = mUcity;
        this.mUpostcode = mUpostcode;
        this.mUloginname = mUloginname;
        this.mUpassword = mUpassword;
        this.mFId = mFId;
    }

    public String getmUname() {
        return mUname;
    }

    public String getmUsurname() {
        return mUsurname;
    }

    public String getmUdob() {
        return mUdob;
    }

    public String getmUgenderMF() {
        return mUgenderMF;
    }

    public String getmUspinner() {
        return mUspinner;
    }

    public String getmUphone() {
        return mUphone;
    }

    public String getmUemail() {
        return mUemail;
    }

    public String getmUstreetname() {
        return mUstreetname;
    }

    public String getmUsuburb() {
        return mUsuburb;
    }

    public String getmUcity() {
        return mUcity;
    }

    public String getmUpostcode() {
        return mUpostcode;
    }

    public String getmUloginname() {
        return mUloginname;
    }

    public String getmUpassword() {
        return mUpassword;
    }

    public String getmFId() {
        return mFId;
    }

}