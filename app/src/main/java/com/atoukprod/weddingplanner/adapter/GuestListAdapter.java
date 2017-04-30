package com.atoukprod.weddingplanner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.atoukprod.weddingplanner.R;
import com.atoukprod.weddingplanner.model.Guest;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class GuestListAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Guest> guestList;

    public GuestListAdapter(Context context, ArrayList<Guest> guestList) {
        this.context = context;
        this.guestList = guestList;
    }

    @Override
    public int getCount() {
        return (guestList!=null) ? guestList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return guestList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if(convertView==null){
            v = LayoutInflater.from(context).inflate(R.layout.guest_list_item,parent, false);
        }

        ViewHolder viewHolder = (ViewHolder) v.getTag();

        if(viewHolder==null){
            viewHolder = new ViewHolder();
            viewHolder.present = (CheckBox) v.findViewById(R.id.present);
            viewHolder.name = (TextView) v.findViewById(R.id.name);
            v.setTag(viewHolder);
        }

        viewHolder.name.setText(guestList.get(position).getFirstname() + " " + guestList.get(position).getLastname());
        viewHolder.present.setChecked(guestList.get(position).isPresent());

        return v;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guestList = guests;
    }

    private class ViewHolder{
        CheckBox present;
        TextView name;
    }
}
