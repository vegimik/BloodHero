package ml.x1carbon.bloodhero;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 */
@IgnoreExtraProperties
public class AddUser {


//    private String mUName;
//    private String mUSurname;
//    private String mBPhone;
//    private String mCCity;
//    private String mDBlood;
//    private String mEDescription;

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
//    public String getmAName() {return mAName;}
//    public String getmASurname() {return mASurname;}
//    public String getmBPhone() {return mBPhone;}
//    public String getmCCity() {return mCCity;  }
//    public String getmDBlood() {
//        return mDBlood;
//    }
//    public String getmEDescription() {return mEDescription;}
//    public String getmId(){return mFId;}



//    private String mAgivenname;
//    private String mBsurname;
//    private String mCdob;
////    private String mDgender;
//    private String mEbloodgroup;
//    private String mFphone;
//    private String mGemail;
//    private String mHstreetname;
//    private String mIsuburb;
//    private String mJcity;
//    private String mKpostcode;
//    private String mLloginname;
//    private String mMpassword;
//    private String mNID;
//
//    public AddUser() {
//
//    }
//
//    public AddUser(String mAgivenname, String mBsurname, String mNID) {
//        this.mAgivenname = mAgivenname;
//        this.mBsurname = mBsurname;
//        this.mNID = mNID;
//    }
//    public AddUser(String mAgivenname, String mBsurname, String mCdob,  String mEbloodgroup, String mFphone, String mGemail, String mHstreetname, String mIsuburb, String mJcity, String mKpostcode, String mLloginname, String mMpassword, String mNID) {
//        this.mAgivenname = mAgivenname;
//        this.mBsurname = mBsurname;
//        this.mCdob = mCdob;
////        this.mDgender = mDgender;
//        this.mEbloodgroup = mEbloodgroup;
//        this.mFphone = mFphone;
//        this.mGemail = mGemail;
//        this.mHstreetname = mHstreetname;
//        this.mIsuburb = mIsuburb;
//        this.mJcity = mJcity;
//        this.mKpostcode = mKpostcode;
//        this.mLloginname = mLloginname;
//        this.mMpassword = mMpassword;
//        this.mNID = mNID;
//    }
//
//
//    public String getmAgivenname() {
//        return mAgivenname;
//    }
//
//    public String getmBsurname() {
//        return mBsurname;
//    }
//
//    public String getmCdob() {
//        return mCdob;
//    }
//
////    public String getmDgender() {
////        return mDgender;
////    }
//
//    public String getmEbloodgroup() {
//        return mEbloodgroup;
//    }
//
//    public String getmFphone() {
//        return mFphone;
//    }
//
//    public String getmGemail() {
//        return mGemail;
//    }
//
//    public String getmHstreetname() {
//        return mHstreetname;
//    }
//
//    public String getmIsuburb() {
//        return mIsuburb;
//    }
//
//    public String getmJcity() {
//        return mJcity;
//    }
//
//    public String getmKpostcode() {
//        return mKpostcode;
//    }
//
//    public String getmLloginname() {
//        return mLloginname;
//    }
//
//    public String getmMpassword() {
//        return mMpassword;
//    }
//    public String getmNID() {
//        return mNID;
//    }
//
//
//

}