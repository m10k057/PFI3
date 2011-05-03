package org.task2;

import java.util.ArrayList;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import se.k3.goransson.andreas.essemmesslib.Post;
import se.mah.k3.grimberg.essemmess2.R;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class read extends Activity implements EssemmessListener, OnClickListener {
	
	ListView listview;
	Essemmess mServer = EssemmessHelper.getServer(this);
	ArrayList <String> Posts;
	ArrayAdapter<String> adapter;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);
        
        Posts = new ArrayList<String>();
        
        mServer.addEssemmessEventListener(this);

        listview = (ListView) findViewById(R.id.listViewupdate);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Posts);

        listview.setAdapter(adapter);


        
        //datatyp namn;
        Button updatebutton = (Button) findViewById(R.id.update);
        updatebutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mServer.read("");
			}});

				
			}

			@Override
			public void NewEssemmessPosts(EssemmessReadEvent evt) {
				// TODO Auto-generated method stub
				
				ArrayList<Post> newposts = evt.getPosts();

				for( Post p : newposts ){
				Posts.add(p.user + "-" + p.tag + "-" + p.message);


				}

				adapter.notifyDataSetChanged();
				
			}

			@Override
			public void NewEssemmessLogin(EssemmessLoginEvent evt) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void NewEssemmessPublish(EssemmessPublishEvent evt) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			};
}
