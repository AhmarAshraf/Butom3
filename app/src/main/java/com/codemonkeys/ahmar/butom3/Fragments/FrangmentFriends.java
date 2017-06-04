package com.codemonkeys.ahmar.butom3.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codemonkeys.ahmar.butom3.Adapter.AllUsersAdapter;
import com.codemonkeys.ahmar.butom3.Adapter.MyCustomAdapter;
import com.codemonkeys.ahmar.butom3.Model.User;
import com.codemonkeys.ahmar.butom3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmar on 08/05/2017.
 */

public class FrangmentFriends extends Fragment{
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    private String mText;
    private int mColor;

    private View mContent;
    private TextView mTextView;
    RecyclerView recyclerView;

    MyCustomAdapter adapter;

    public static Fragment newInstance(String text) {
        Fragment frag = new FrangmentFriends();
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
        return inflater.inflate(R.layout.frangment_friends, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        /*adapter = new MyCustomAdapter(getActivity(), Data.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); //*/
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AllUsersAdapter allUsersAdapter = new AllUsersAdapter(getUserInformation(),getActivity());
        recyclerView.setAdapter(allUsersAdapter);

     /*  // retrieve text and color from bundle or savedInstanceState
        if (savedInstanceState == null) {
            Bundle args = getArguments();
            mText = args.getString(ARG_TEXT);
            mColor = args.getInt(ARG_COLOR);
        } else {
            mText = savedInstanceState.getString(ARG_TEXT);
            mColor = savedInstanceState.getInt(ARG_COLOR);
        }

        // initialize views
        mContent = view.findViewById(R.id.fragment_content);
        mTextView = (TextView) view.findViewById(R.id.text);

        // set text and background color
        mTextView.setText(mText);
        mContent.setBackgroundColor(mColor);*/
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
       /* outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);*/
    }
    private List<User> getUserInformation() {

        List<User> userList = new ArrayList<>();
        userList.add(new User(R.mipmap.ic_launcher,
                "Ahmar", "9988776655",
                "ahmar@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "ahli", "9988776655",
                "ahmar@sonevalley.com"));

        userList.add(new User(R.mipmap.ic_launcher,
                "umer", "9988776655",
                "ahmar@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "awais", "9988776655",
                "ahmar@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "munib", "9988776655",
                "ahmar@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "Manu", "9988776655",
                "ahmar@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "akash", "9988776655",
                "ahmar@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "mubeen", "9988776655",
                "ahmar@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "hamaz", "9988776655",
                "hamza@sonevalley.com"));
        userList.add(new User(R.mipmap.ic_launcher,
                "Alii", "9988776655",
                "ahmar@sonevalley.com"));

        return userList;
    }

}


