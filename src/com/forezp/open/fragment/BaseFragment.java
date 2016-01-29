package com.forezp.open.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public  abstract class BaseFragment extends Fragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setUpView();
	}


	 /**
	  * 设置属性，监听等
	  */
	 protected abstract void setUpView();

}
