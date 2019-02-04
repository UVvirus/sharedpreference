package com.android.sharedprefs;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity 
{  private TextView textView;
   private EditText editText;
   private Button button1,button2;
   
   public static final String SHARED_PREFS="sharedprefs";
   public static final String TEXT="text";
   public String text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   
		textView=(TextView)findViewById(R.id.textView);
		editText=(EditText)findViewById(R.id.editText);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		loadData();
		updateData();
		} 
		 
		public void applyText(View v){
			textView.setText(editText.getText().toString());
		}
		public void saveData(View v){
			saveTheData();
		}  
		

		private void saveTheData()
		{ SharedPreferences sharedpreference=getSharedPreferences
		                                 (SHARED_PREFS,MODE_PRIVATE);
		SharedPreferences.Editor editor=sharedpreference.edit();
			editor.putString(TEXT,textView.getText().toString());
			editor.apply();
			Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show();
		}
		public void loadData(){
			SharedPreferences sharedpreference=getSharedPreferences
			                             (SHARED_PREFS,MODE_PRIVATE);
			text=sharedpreference.getString(TEXT,"");
		}
		public void updateData(){
			textView.setText(text);
		}
	
		}

