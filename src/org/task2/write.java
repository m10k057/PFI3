package org.task2;

import se.mah.k3.grimberg.essemmess2.Essemmess;
import se.mah.k3.grimberg.essemmess2.EssemmessListener;
import se.mah.k3.grimberg.essemmess2.EssemmessLoginEvent;
import se.mah.k3.grimberg.essemmess2.EssemmessPublishEvent;
import se.mah.k3.grimberg.essemmess2.EssemmessReadEvent;
import se.mah.k3.grimberg.essemmess2.R;
import se.mah.k3.grimberg.essemmess2.Read;
import se.mah.k3.grimberg.essemmess2.Submit;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class write extends Activity implements EssemmessListener, OnClickListener {
	
	Essemmess mServer = EssemmessHelper.getServer(this);

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //datatyp namn;
        Button submitbutton = (Button) findViewById(R.id.submit);
        submitbutton.setOnClickListener(this);
        
        mServer.addEssemmessEventListener(this);
    }

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText text1 = (EditText) findViewById(R.id.tag);
				EditText text2 = (EditText) findViewById(R.id.message);
				
				String msg = text1.getText().toString();
				String tag = text2.getText().toString();
				
				mServer.post(tag, msg);
				
			//	Toast t= Toast.makeText(this, msg +"\n"+ tag, Toast.LENGTH_LONG);
			//	t.show();


			}

			@Override
			public void NewEssemmessPosts(EssemmessReadEvent evt) {
				// TODO Auto-generated method stub

			}

			@Override
			public void NewEssemmessLogin(EssemmessLoginEvent evt) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void NewEssemmessPublish(EssemmessPublishEvent evt) {
				// TODO Auto-generated method stub
				
				if (evt.getMessage().length() > 0) {
					Intent implicit = new Intent(Submit.this, Read.class);
					this.startActivity(implicit);
				
			}
}
}
