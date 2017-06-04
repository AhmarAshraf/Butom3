package com.codemonkeys.ahmar.butom3.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codemonkeys.ahmar.butom3.R;

/**
 * Created by Ahmar on 09/05/2017.
 */

public class FrangmentUserListing extends Fragment implements View.OnClickListener {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    private String mText;
    private int mColor;

    private View mContent;
    private TextView mTextView;

    public static android.app.Fragment newInstance(String text) {
        Fragment frag = new FrangmentUserListing();
       /* Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_COLOR, color);
        frag.setArguments(args);*/
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_all_user_listing, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text_view_user_alphabet1) {
            Toast.makeText(getActivity(), "Hey I am Ahmar", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.text_view_user_alphabet) {
            Toast.makeText(getActivity(), "Hey I am Ahmar", Toast.LENGTH_SHORT).show();
        }

    }
}
