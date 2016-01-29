package com.forezp.open.activity;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import com.forezp.open.R;
import com.forezp.open.adapter.FragmentAdapter;
import com.forezp.open.common.Constants;
import com.forezp.open.fragment.MenuLeftFragment;
import com.forezp.open.fragment.MenuRightFragment;
import com.forezp.open.slidelibarary.SlidingMenu;
import com.forezp.open.slidelibarary.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
	
	private ViewPager viewPager;
	//private FragmentPagerAdapter mAdapter;
	//private List<Fragment> mFragments = new ArrayList<Fragment>();
	@ViewInject(id = R.id.main_tab_home, click = "rbClick")
	RadioButton rb_home;
	@ViewInject(id = R.id.main_tab_expressage, click = "rbClick")
	RadioButton rb_expressage;
	@ViewInject(id = R.id.main_tab_community, click = "rbClick")
	RadioButton rb_community;
	@ViewInject(id = R.id.main_tab_shopping, click = "rbClick")
    RadioButton rb_shooping;
	private RadioButton[] rbs;
	//private static int[] selected_resID = new int[] { R.drawable.rb_home, R.drawable.rb_expressage, R.drawable.rb_community,R.drawable.rb_shopping};
	//private static int[] unselected_resID = new int[] { R.drawable.rb_home_us, R.drawable.rb_expressage_us, R.drawable.rb_community_us,R.drawable.rb_shopping_us };
	
	private static int[] selected_resID = new int[] { R.drawable.rb_weather_home, R.drawable.rb_weather_product, R.drawable.rb_weather_life,R.drawable.rb_weather_life};
    private static int[] unselected_resID = new int[] { R.drawable.rb_weather_home, R.drawable.rb_weather_product, R.drawable.rb_weather_life,R.drawable.rb_weather_life };
	public FragmentAdapter adapter;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		FinalActivity.initInjectedView(this);
		viewPager=(ViewPager) findViewById(R.id.id_viewpager);
		rbs = new RadioButton[] { rb_home, rb_expressage, rb_community,rb_shooping };
		adapter = new FragmentAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		addListener();
		rbClick(rb_home);
		// 初始化SlideMenu
		initRightMenu();
		//getAddress();
	}

	private void initRightMenu()
	{
		
		Fragment leftMenuFragment = new MenuLeftFragment();
		setBehindContentView(R.layout.left_menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_left_menu_frame, leftMenuFragment).commit();
		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT_RIGHT);	
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);	
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//		menu.setBehindWidth()	
		menu.setFadeDegree(0.35f);
		// menu.setBehindScrollScale(1.0f);
		menu.setSecondaryShadowDrawable(R.drawable.shadow);	
		menu.setSecondaryMenu(R.layout.right_menu_frame);
		Fragment rightMenuFragment = new MenuRightFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.id_right_menu_frame, rightMenuFragment).commit();
	}

	public void showLeftMenu(View view)
	{
		getSlidingMenu().showMenu();
	}

	public void showRightMenu(View view)
	{
		getSlidingMenu().showSecondaryMenu();
	}

	private void addListener() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int id) {
				switch (id) {
				case 0:
					rb_home.setChecked(true);
					break;
				case 1:
					rb_expressage.setChecked(true);
					break;
				case 2:
				    rb_community.setChecked(true);
					break;
					
				case 3:
                    rb_shooping.setChecked(true);
                    break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	public void rbClick(View v) {
		setRBstyle(v.getId());
		switch (v.getId()) {
		case R.id.main_tab_home:
			Constants.current_fragment_index = 0;
//			tvTitle.setVisibility(View.GONE);
//			llTitleCenter.setVisibility(View.VISIBLE);
//			divider.setVisibility(View.GONE);
			viewPager.setCurrentItem(0, false);
			break;
		case R.id.main_tab_expressage:
			Constants.current_fragment_index = 1;
//			llTitleCenter.setVisibility(View.GONE);
//			tvTitle.setText(R.string.menu2);
//			tvTitle.setVisibility(View.VISIBLE);
//			divider.setVisibility(View.VISIBLE);
			viewPager.setCurrentItem(1, false);
			break;
		case R.id.main_tab_community:
			Constants.current_fragment_index = 2;
//			llTitleCenter.setVisibility(View.GONE);
//			tvTitle.setText(R.string.menu3);
//			tvTitle.setVisibility(View.VISIBLE);
//			divider.setVisibility(View.VISIBLE);
			//viewPager.removeAllViews();
			//viewPager.setAdapter(adapter);
			viewPager.setCurrentItem(2, false);
			
		case R.id.main_tab_shopping:
            Constants.current_fragment_index = 3;
//          llTitleCenter.setVisibility(View.GONE);
//          tvTitle.setText(R.string.menu3);
//          tvTitle.setVisibility(View.VISIBLE);
//          divider.setVisibility(View.VISIBLE);
            //viewPager.removeAllViews();
            //viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(3, false);
			break;
		default:
			break;
		}
	}

	private void setRBstyle(int resID) {
		for (int i = 0; i < 4; i++) {
			if (rbs[i].getId() == resID) {
				Drawable drawable = getResources().getDrawable(selected_resID[i]);
				rbs[i].setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
				rbs[i].setTextColor(getResources().getColor(R.color.white));
				rbs[i].setBackgroundResource(R.color.botton_ratiobutton);
			} else {
				Drawable drawable = getResources().getDrawable(unselected_resID[i]);
				rbs[i].setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
				rbs[i].setTextColor(getResources().getColor(R.color.white));
				rbs[i].setBackgroundResource(R.color.transparent);
			}
		}
	}	
}
