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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener, EssemmessListener {

	Essemmess mServer;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		mServer = EssemmessHelper.getServer(this);
		mServer.addEssemmessEventListener(this);

				Button loginbutton = (Button) findViewById(R.id.butt_login);
		loginbutton.setOnClickListener(this);
	}

	
	public void onClick(View v) {

		EditText text1 = (EditText) findViewById(R.id.login);
		EditText text2 = (EditText) findViewById(R.id.key);

		String username = text1.getText().toString();
		String password = text2.getText().toString();

		mServer.login(username, password);

	};

	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		
		}
	

	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		if (evt.getLoggedin() == true) {
			Intent explicit = new Intent(Login.this, Write.class);
			startActivity(explicit);
		}
		
	}

	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		
	}



}