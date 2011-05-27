package org.task2;


import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Write extends Activity implements EssemmessListener, OnClickListener {
	
	Essemmess mServer = EssemmessHelper.getServer(this);

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        
        //datatyp namn;
        final Button submitbutton = (Button) findViewById(R.id.submit);
        submitbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				switch(v.getId()){
				case R.id.submit:
					Intent explicit = new Intent(Write.this, Read.class);
					startActivity(explicit);
					break;
				}
								
		

			
				EditText tagText = (EditText) findViewById(R.id.tag);
				EditText medText = (EditText) findViewById(R.id.message);
				
				mServer.post(tagText.getText().toString(),medText.getText().toString());
				
				Toast toast = Toast.makeText(getApplicationContext(),
						tagText.getText() + "\n" + medText.getText(),
						Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();
				
				tagText.setText("");
				medText.setText("");
				
			}
        });
    }
				
				
			//	Toast t= Toast.makeText(this, msg +"\n"+ tag, Toast.LENGTH_LONG);
			//	t.show();


			

			public void NewEssemmessPosts(EssemmessReadEvent evt) {
				// TODO Auto-generated method stub

			}

			public void NewEssemmessLogin(EssemmessLoginEvent evt) {
				// TODO Auto-generated method stub
				
			}

			public void NewEssemmessPublish(EssemmessPublishEvent evt) {
			
			}


			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
}


			

