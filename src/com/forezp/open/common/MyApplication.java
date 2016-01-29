package com.forezp.open.common;



/**
 * Created by b508a on 2015/12/28.
 */



import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.forezp.open.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;




public class MyApplication extends Application {


    private static MyApplication application;
    //一般的options

    //一般的options
    private static DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.icon_user_default).showImageForEmptyUri(R.drawable.icon_user_default).showImageOnFail(R.drawable.icon_user_default)
            .cacheInMemory(true).cacheOnDisc(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new RoundedBitmapDisplayer(10)).displayer(new FadeInBitmapDisplayer(100)).build();

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        application = this;
        initImageLoader(getApplicationContext());
    }


    public static MyApplication getApplication() {
        return application;
    }

    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }



    public static DisplayImageOptions getDefaultOptions() {
        return defaultOptions;
    }


    public static void setDefaultOptions(DisplayImageOptions defaultOptions) {
        MyApplication.defaultOptions = defaultOptions;
    }

}


