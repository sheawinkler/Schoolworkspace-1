package bander.notepad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by oscar on 12/8/14.
 */
public class PrivateContactAdapter extends ArrayAdapter<PrivateContact> {

    private ArrayList<PrivateContact> contacts;

    public PrivateContactAdapter(Context context, int textViewResourceId, ArrayList<PrivateContact> objects) {
        super(context, textViewResourceId, objects);
        this.contacts = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

        PrivateContact contact = contacts.get(position);

        if (contact != null) {
            TextView nameTV = (TextView) v.findViewById(R.id.nameTV);
            TextView phoneNumberTV = (TextView) v.findViewById(R.id.phoneNumberTV);
            TextView emailTV = (TextView) v.findViewById(R.id.emailTV);
            TextView addressTV = (TextView) v.findViewById(R.id.addressTV);

            if (nameTV != null) {
                nameTV.setText(contact.getName());
            }

            if (phoneNumberTV != null) {
                phoneNumberTV.setText(contact.getPhoneNumber());
            }

            if (emailTV != null) {
                emailTV.setText(contact.getEmail());
            }

            if (addressTV != null) {
                addressTV.setText(contact.getAddress());
            }

        }

        return v;

    }
}
