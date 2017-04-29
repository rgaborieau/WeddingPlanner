package com.atoukprod.weddingplanner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.atoukprod.weddingplanner.adapter.GuestListAdapter;
import com.atoukprod.weddingplanner.utils.WeddingAPI;

import java.util.ArrayList;

public class GuestList extends ListView {
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
        setAdapter(new GuestListAdapter(WeddingAPI.getGuests()));
    }
}
