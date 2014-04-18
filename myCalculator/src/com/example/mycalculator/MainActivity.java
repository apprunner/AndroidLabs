package com.example.mycalculator;

import com.example.mycalculator.R.id;

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
            
            //建立OnClickListener按鈕監聽事件，計算結果值
            //1.抓et1值
            //2.抓et2值
            //3.顯示結果值
            
            Button btnSubmit = (Button)rootView.findViewById(id.btnSubmit);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					EditText et1 = (EditText)getActivity().findViewById(id.et1);
					EditText et2 = (EditText)getActivity().findViewById(id.et2);
					
					int arg1 = Integer.parseInt(et1.getText().toString());
					int arg2 = Integer.parseInt(et2.getText().toString());
					
					TextView tvResult = (TextView)getActivity().findViewById(id.tvResult);
					tvResult.setText("結果是： " + String.valueOf(arg1 * arg2));
				}
			});
            
            
            
            
            return rootView;
        }
    }

}
