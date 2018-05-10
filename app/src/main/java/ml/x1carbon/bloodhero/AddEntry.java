package ml.x1carbon.bloodhero;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 */
@IgnoreExtraProperties
public class AddEntry {
    private String mAName;
    private String mBPhone;
    private String mCCity;
    private String mDBlood;
    private String mEDescription;
    private String mFId;

    public AddEntry(){
        //this constructor is required
    }

    public AddEntry(String mAName, String mBPhone, String mCCity, String mDBlood , String mEDescription, String mFId) {
        this.mAName = mAName;
        this.mBPhone = mBPhone;
        this.mCCity = mCCity;
        this.mDBlood=mDBlood;
        this.mEDescription=mEDescription;
        this.mFId=mFId;
    }

    public String getmAName() {return mAName;}

    public String getmBPhone() {return mBPhone;}
    public String getmCCity() {return mCCity;  }
    public String getmDBlood() {
        return mDBlood;
    }
    public String getmEDescription() {return mEDescription;}
    public String getmId(){return mFId;}

}