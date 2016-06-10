package com.example.apurvasharma.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.freshdesk.mobihelp.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startChat;
    Button showConversation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMobiHelp();
    }

    private void initView(){

        startChat = (Button)findViewById(R.id.start_chat);
        startChat.setOnClickListener(this);

        showConversation = (Button)findViewById(R.id.show_conversation);
        showConversation.setOnClickListener(this);

    }

    private void initMobiHelp() {
        MobihelpConfig config = new MobihelpConfig("<your freshdesk url>","app-key","app-secret");

        Mobihelp.init(this, config);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_chat:
                Mobihelp.showSupport(this);
                break;
            case R.id.show_conversation:
                Mobihelp.showConversations(this);
                break;
        }
        }
}
