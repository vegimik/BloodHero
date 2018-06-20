package ml.x1carbon.bloodhero;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;




public class BloodModel extends ArrayAdapter<AddEntry> {

    private Activity context;
    List<AddEntry> user_d_r;

    public BloodModel(Activity context, List<AddEntry> usersL) {
        super(context, R.layout.activity_blood_model, usersL);
        this.context = context;
        this.user_d_r = usersL;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_blood_model, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.mtext);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.mDate);
        TextView textViewTag = (TextView) listViewItem.findViewById(R.id.Tags);

        AddEntry artist = user_d_r.get(position);
        textViewName.setText(artist.getmAName());
        textViewGenre.setText(artist.getmDBlood());
        textViewTag.setText(artist.getmBPhone());
        return listViewItem;
    }
}
