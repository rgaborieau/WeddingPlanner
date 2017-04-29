package com.atoukprod.weddingplanner.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.atoukprod.weddingplanner.model.Guest;

import java.util.ArrayList;

public class GuestListAdapter extends BaseAdapter {

    private ArrayList<Guest> guestList;

    public GuestListAdapter(ArrayList<Guest> guestList) {
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
        return null;
    }
}
