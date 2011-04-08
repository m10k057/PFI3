package org.task2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class Assignment2 extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button submitButton = (Button) findViewById(R.id.button1);
        submitButton.setOnClickListener(this);
        
        Tag = (EditText) findViewById(R.id.editText1);
        Message = (EditText) findViewById(R.id.editText2);
    }
    
    EditText Tag;
    EditText Message;
    
    public void onClick(View v){
    	String myTag = Tag.getText().toString();
    	String myMessage = Message.getText().toString();
    	Toast.makeText(this, myTag + " " + myMessage, Toast.LENGTH_SHORT).show();
    	
    	//Toast.makeText(this, myMessage, Toast.LENGTH_SHORT).show();
    }
}