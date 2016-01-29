package com.forezp.open.adapter;

import com.forezp.open.fragment.HomeFragment;
import com.forezp.open.fragment.CommunityFragment;
import com.forezp.open.fragment.ExpressageFragment;
import com.forezp.open.fragment.ShoppingFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class FragmentAdapter extends FragmentStatePagerAdapter{
	
	public final static int TAB_COUNT = 3;
	
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int id) {
		switch (id) {
		case 0:
			HomeFragment nf = new HomeFragment();
			return nf;
		case 1:
			ExpressageFragment nf1 = new ExpressageFragment();
			return nf1;
		case 2:
			CommunityFragment nf2 = new CommunityFragment();
			return nf2;
		case 3:
            ShoppingFragment nf3 = new ShoppingFragment();
            return nf3;
		
			default:
				break;
		}
		return null;
	}

	@Override
	public int getCount() {
		return TAB_COUNT;
	}
	
}
