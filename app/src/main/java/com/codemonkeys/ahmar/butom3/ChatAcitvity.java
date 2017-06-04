package com.codemonkeys.ahmar.butom3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.codemonkeys.ahmar.butom3.Adapter.MessageAdapter;
import com.codemonkeys.ahmar.butom3.Model.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class ChatAcitvity extends AppCompatActivity {
    private ListView listView;
    private View btnSend;
    private EditText editText;
    boolean isMine = true;
    private List<ChatMessage> chatMessages;
    private ArrayAdapter<ChatMessage> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_acitvity);
        chatMessages = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_msg);
        btnSend = findViewById(R.id.btn_chat_send);
        editText = (EditText) findViewById(R.id.msg_type);

        //set ListView adapter first
        adapter = new MessageAdapter(this, R.layout.item_chat_left, chatMessages);
        listView.setAdapter(adapter);
setUpDummyText();




        //event for button SEND
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input some text...", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    ChatMessage chatMessage = new ChatMessage(editText.getText().toString(), isMine);
                    chatMessages.add(chatMessage);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    if (isMine) {
                        isMine = false;
                    } else {
                        isMine = true;
                    }
                }
            }
        });
    }

    private void setUpDummyText() {
        ChatMessage chatMessage = new ChatMessage("hey I need our help please try contact me ", isMine);
        chatMessages.add(chatMessage);
        adapter.notifyDataSetChanged();
        ChatMessage chatMessage1 = new ChatMessage("Islamabad Golra mor I14 ", isMine);
        chatMessages.add(chatMessage);
        adapter.notifyDataSetChanged();
    }
}

