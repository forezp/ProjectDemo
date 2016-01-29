package com.forezp.open.activity;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//	fh=new FinalHttp();
		//ActivityCollector.addActivity(this);
		initViewAndData();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//ActivityCollector.removeActivity(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		//MobclickAgent.onPageStart(getClass().toString()); 
		//MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		//	MobclickAgent.onPageEnd(getClass().toString());
		//MobclickAgent.onPause(this);
	}
	protected void showToast(Context context,String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 初始化View  和数据。
	 */
	protected abstract void initViewAndData() ;
        
    

}
