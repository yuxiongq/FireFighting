package com.pighead.android.firefighting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class FireFragment extends Fragment {

    private Fire mStuff;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mCheckBox;

    public static final String EXTRA_FIRE_ID =
            "com.pighead.android.firefighting.fire_id";

    public FireFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID fireID = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_FIRE_ID);
        mStuff = FireLab.get(getActivity()).getFire(fireID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fire, container, false);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        mDateButton = (Button) v.findViewById(R.id.stuff_date);
        mDateButton.setText(dateFormat.format(mStuff.getDate()));
        mDateButton.setEnabled(false);

        mCheckBox = (CheckBox) v.findViewById(R.id.stuff_check);
        mCheckBox.setChecked(mStuff.isChecked());
        mCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mStuff.setChecked(mCheckBox.isChecked());
            }
        });

        mTitleField = (EditText)v.findViewById(R.id.stuff_title);
        mTitleField.setText(mStuff.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }


}
