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
    private Button buttonShare;
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

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make intent with action
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                //set the data type of the stuff we are packaging away
                intentShare.setType("text/plain");
                //put the extra with the message
                intentShare.putExtra(EXTRA_SENT_MESSAGE, editTextMessage.getText().toString());
                //start activity
                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets() {
        buttonSend = findViewById(R.id.button_main_identification);
        buttonShare = findViewById(R.id.button_sendMessage_shareButton);
        editTextMessage = findViewById(R.id.editText_sendMessage_msg);
    }
}
