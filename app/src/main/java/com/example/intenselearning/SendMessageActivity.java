package com.example.intenselearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SendMessageActivity extends AppCompatActivity {

    private Button buttonSend;
    private EditText editTextMessage;
    public static final String EXTRA_SENT_MESSAGE = "the message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from editText
                String message = editTextMessage.getText().toString();

                //create intent
                //parameters: where are u coming from, where are u going
                Intent intentSendMessage = new Intent(SendMessageActivity.this, RecieveMessageActivity.class);

                //package the text into the intent
                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE,message);

                //start the new activity
                startActivity(intentSendMessage);
            }
        });
    }

    private void wireWidgets() {
        buttonSend = findViewById(R.id.button_main_identification);
        editTextMessage = findViewById(R.id.editText_sendMessage_msg);
    }
}
