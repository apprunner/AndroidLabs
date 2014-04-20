package com.example.myradiogroup;

import java.util.List;

import com.example.myradiogroup.R.id;

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
import android.app.*;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        	
        if (savedInstanceState == null) {
        	
        	/*
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
            
            */
            
        	
            /*
             * 以上寫法等同以下
             * 之所以使用getSupportFragmentManager()方法的原因，
             * 是因為Android有歷史版本的緣故,請參考getSupportFragmentManager()文件說明
             */
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();           
            android.support.v4.app.FragmentTransaction ft= fm.beginTransaction();
            PlaceholderFragment pf= new PlaceholderFragment();
            String fragmentname=pf.getTag();
            ft.add(R.id.container, pf);
            ft.commit();
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
            final TextView tvResult = (TextView)rootView.findViewById(id.tvResult);
            //取得RadioGroup
            RadioGroup rg = (RadioGroup)rootView.findViewById(id.radioGroup1);
            
            //註冊OnCkeckedChangListner()事件
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					// TODO Auto-generated method stub	
					int checkedid = arg0.getCheckedRadioButtonId();
					RadioButton rb = (RadioButton)arg0.findViewById(arg1);
					tvResult.setText(rb.getText());
				}
			});
            
            
            return rootView;
        }
    }

}
