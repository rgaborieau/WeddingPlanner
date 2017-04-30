package com.atoukprod.weddingplanner.view;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.ListView;

import com.atoukprod.weddingplanner.adapter.GuestListAdapter;
import com.atoukprod.weddingplanner.model.Guest;
import com.atoukprod.weddingplanner.utils.WeddingAPI;

import java.net.URL;
import java.util.ArrayList;

public class GuestList extends ListView {
    private GuestListAdapter guestListAdapter;

    public GuestList(Context context) {
        super(context);
        init(context);
    }

    public GuestList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GuestList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        guestListAdapter = new GuestListAdapter(context, new ArrayList<Guest>());
        setAdapter(guestListAdapter);
        new RetrieveGuests().execute();
    }

    class RetrieveGuests extends AsyncTask<String, Void, Void> {

        private Exception exception;
        private ArrayList<Guest> guests;

        protected Void doInBackground(String... urls) {
            guests = WeddingAPI.getGuests();
            return null;
        }

        protected void onPostExecute(Void v) {
            guestListAdapter.setGuests(guests);
            guestListAdapter.notifyDataSetChanged();
        }
    }

}
