package com.arax.motorcalc;









import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;
import android.content.Context;





public class MotorCalcApplication extends Application  {


	private static Context appContext;
	
	
	
	

	    public void onCreate(){
	        super.onCreate();
	     
	        appContext=this.getApplicationContext();
	    //  Binder.init(this);
	        File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
	        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
	        .diskCache(new UnlimitedDiscCache(cacheDir)) 
	        .build();

	        ImageLoader.getInstance().init(config);
	    }





		public static Context getAppContext() {
			return appContext;
		}





	


	


	

	 
	  
	
}
