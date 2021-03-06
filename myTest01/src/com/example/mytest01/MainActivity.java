package com.example.mytest01;

import com.example.mytest01.R.id;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.*;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        //findViews();	//There are some errors.
        	
        
        
    }
       
    private void findViews(){
    	TextView tvMsg = (TextView)findViewById(R.id.tvMsg);
    	
    	tvMsg.setText("Good！");
    }
    
    public void sendMessage(View view){
    	TextView tvMsg = (TextView)findViewById(R.id.tvMsg);
    	tvMsg.setText("哈囉!!!");
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            //setUI(rootView);
            
            return rootView;
        }
        
        
        public void setUI(View view){
        	TextView tvMsg = (TextView)view.findViewById(R.id.tvMsg);
        	tvMsg.setText("大家好！onCreateView");
        }
        
        @Override
        public void onActivityCreated(Bundle savedInstanceState) { 
            super.onActivityCreated(savedInstanceState);
            
        		TextView tvMsg = (TextView)getView().findViewById(R.id.tvMsg);
        		tvMsg.setText("大家好！onActivityCreated");
        }
        
    }

}
