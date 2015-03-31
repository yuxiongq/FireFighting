package com.pighead.android.firefighting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pighead on 3/25/15.
 */
public class FireListFragment extends ListFragment {

    private ArrayList<Fire> mFires;

    private static final String TAG = "FireListFragment";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.fire_stuff_title);
        mFires = FireLab.get(getActivity()).getFires();

        FireAdapter adapter = new FireAdapter(getActivity(), 0, mFires);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Fire f = ((FireAdapter) getListAdapter()).getItem(position);

        Intent i = new Intent(getActivity(), FireActivity.class);
        i.putExtra(FireFragment.EXTRA_FIRE_ID, f.getId());
        startActivity(i);
    }

    private class FireAdapter extends ArrayAdapter<Fire> {

        public FireAdapter(Context context, int resource, ArrayList<Fire> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_fire, null);
            }
            Fire fire = getItem(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.title_textView);
            titleTextView.setText(fire.getTitle());
            TextView dateTextView = (TextView) convertView.findViewById(R.id.date_textView);
            dateTextView.setText(fire.getDate().toString());
            CheckBox fireChecked = (CheckBox) convertView.findViewById(R.id.fire_checked);
            fireChecked.setChecked(fire.isChecked());

            return convertView;
        }
    }
}
