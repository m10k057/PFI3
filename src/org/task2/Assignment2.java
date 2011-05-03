package org.task2;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import se.mah.k3.grimberg.essemmess2.R;
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

	Essemmess mServer = EssemmessHelper.getServer(this);

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		mServer.addEssemmessEventListener(this);

		// datatyp namn;
		Button loginbutton = (Button) findViewById(R.id.butt_login);
		loginbutton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText text1 = (EditText) findViewById(R.id.login);
		EditText text2 = (EditText) findViewById(R.id.key);

		String username = text1.getText().toString();
		String password = text2.getText().toString();

		mServer.login(username, password);

	}

	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		Log.i("login", "lyckades?" + evt.getLoggedin());
		// TODO Auto-generated method stub
		// evt.getLoggedin();
		if (evt.getLoggedin() == true) {
			Intent implicit = new Intent(Login.this, Submit.class);
			this.startActivity(implicit);
			
		//	if (evt.getLoggedin() == true) {
		//		Intent bytSkarm = new Intent(Login.this, Submit.class);
		//		this.startActivity(bytSkarm);
		}

	}

	// Intent bytSkarm = new Intent(Login.this,Submit.class);
	// this.startActivity(bytSkarm);

	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub

	};
}