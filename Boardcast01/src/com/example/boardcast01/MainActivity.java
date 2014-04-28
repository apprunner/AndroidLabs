package com.example.boardcast01;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
    public static final String myAction = "com.example.boardcast01"; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //register a Broadcast Receiver
        IntentFilter filter = new IntentFilter(myAction);
        BroadcastReceiver receiver = new BroadcastReceiver(){
			@Override
			public void onReceive(Context context, Intent intent) {
				//receive the broadcast information
				
				String action = intent.getAction();	//get intent action
				String data = intent.getExtras().getString("data");	//get intent data
				
				if (action.equals(myAction))
				{
			        //setting the Basic Toast information
			        Context ctx = getApplicationContext();
			        CharSequence info = "接收到廣播:" + action + ",資料的內容是:" + data;
			        int duration = Toast.LENGTH_SHORT;
			        
			        Toast toast = Toast.makeText(ctx, info, duration);
			        toast.show();
				}
				
			}
        };
        
        this.registerReceiver(receiver, filter);
        
        //sending broadcast
        Button btnSend = (Button)findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//setting the Intent
				Intent intent = new Intent(myAction);
				intent.putExtra("data", "這是我自訂的Action!");
				// sending the broadcast
				sendBroadcast(intent);		
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
