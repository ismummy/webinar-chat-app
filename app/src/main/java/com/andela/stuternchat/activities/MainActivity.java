package com.andela.stuternchat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andela.stuternchat.R;
import com.andela.stuternchat.activities.chat.ChatActivity;

public class MainActivity extends AppCompatActivity {
  private EditText username;
  private TextView validate;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button joinBtn = (Button) findViewById(R.id.joinbtn);
    username = (EditText) findViewById(R.id.username);

    joinBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        processUserInfo();
      }
    });
  }

  private void processUserInfo() {
    if (username.getText().toString().length() != 0) {
      switchToChat();
    } else {
      validate.setText("Username is needed");
    }
  }

  private void switchToChat() {
    Intent intent = new Intent(this, ChatActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
  }
}
