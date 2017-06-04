package com.codemonkeys.ahmar.butom3.Fragments;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.codemonkeys.ahmar.butom3.Activitys.EmmergencyContactsAuthorties;
import com.codemonkeys.ahmar.butom3.Activitys.SpecificAlert;
import com.codemonkeys.ahmar.butom3.ChatAcitvity;
import com.codemonkeys.ahmar.butom3.MainActivity;
import com.codemonkeys.ahmar.butom3.Activitys.PinActivity;
import com.codemonkeys.ahmar.butom3.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Ahmar on 07/05/2017.
 */

public class MenuFragmentThree extends Fragment implements View.OnClickListener {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    private String mText;
    private int mColor;
    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int notification_id;
    private RemoteViews remoteViews;
    private Context context;
    private View mContent;
    private TextView mTextView;
    private Button mAlertButton;
    private Button mSpecificAlertButton;
    private Button mEmmergencies_number_button;
    private Button kinapping_button;


    public static Fragment newInstance(String text) {
        Fragment frag = new MenuFragmentThree();

        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getActivity());

        remoteViews = new RemoteViews(getActivity().getPackageName(), R.layout.custom_notification);
        remoteViews.setImageViewResource(R.id.notif_icon, R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.notif_title, "HI there how r u fine ");
        remoteViews.setProgressBar(R.id.progressBar, 100, 40, true);

        mAlertButton = (Button) view.findViewById(R.id.GeneralAlertButton);
        mSpecificAlertButton = (Button) view.findViewById(R.id.specific_alert_button);
        mEmmergencies_number_button = (Button) view.findViewById(R.id.emmergencies_number_button);
        kinapping_button = (Button) view.findViewById(R.id.kinapping_button);

        mAlertButton.setOnClickListener(this);
        mSpecificAlertButton.setOnClickListener(this);
        mEmmergencies_number_button.setOnClickListener(this);
        kinapping_button.setOnClickListener(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        /*outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);*/
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.kinapping_button) {

            step1();
            step2();
            Toast.makeText(getActivity(), "KinappingButton", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "Location sent", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "audio Sent", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "Enter pin to stop", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getActivity(), PinActivity.class);
            startActivity(i);

        }
        if (v.getId() == R.id.GeneralAlertButton) {

            step1();
            step2();
            Toast.makeText(getActivity(), "GeneralAlertButton", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "Location sent", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "audio Sent", Toast.LENGTH_SHORT).show();
           /* Intent i = new Intent(getActivity(), ChatAcitvity.class);
            startActivity(i);*/

        }
        if (v.getId() == R.id.specific_alert_button) {

            step1();
            Toast.makeText(getActivity(), "GeneralAlertButton", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), SpecificAlert.class);
            startActivity(i);

        }
        if (v.getId() == R.id.emmergencies_number_button) {

            step1();

            Toast.makeText(getActivity(), "GeneralAlertButton", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), EmmergencyContactsAuthorties.class);
            startActivity(i);

        }
        if (v.getId() == R.id.emmergencies_number_button) {

            step1();

            Toast.makeText(getActivity(), "GeneralAlertButton", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), EmmergencyContactsAuthorties.class);
            startActivity(i);

        }
    }

    private void step2() {
        //Getting intent and PendingIntent instance
        Intent intent = new Intent(getActivity(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getActivity(), 0, intent, 0);
        String number = "+923331591977";
        //Get the SmsManager instance and call the sendTextMessage method to send message
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, "hey i need your help please contact me ", pi, null);

        Toast.makeText(getActivity(), "Message Sent successfully!",
                Toast.LENGTH_LONG).show();
    }

    private void step1() {
        notification_id = (int) System.currentTimeMillis();

        Intent button_intent = new Intent("button_click");
        button_intent.putExtra("id", notification_id);
        PendingIntent button_pending_event = PendingIntent.getBroadcast(context, notification_id,
                button_intent, 0);

        remoteViews.setOnClickPendingIntent(R.id.button, button_pending_event);

        Intent notification_intent = new Intent(context, ChatAcitvity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notification_intent, 0);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setCustomBigContentView(remoteViews)
                .setContentIntent(pendingIntent);

        notificationManager.notify(notification_id, builder.build());
    }
}


