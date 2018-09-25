package com.example.intenselearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecieveMessageActivity extends AppCompatActivity {

    private TextView textViewDisplayMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);

        textViewDisplayMessage = findViewById(R.id.textView_recieveMessage_displayMessage);
        textViewDisplayMessage.setText(getIntent().getStringExtra("themessage"));
    }
}
