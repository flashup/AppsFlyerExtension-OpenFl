package org.haxe.extension;


import android.app.Activity;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.util.Log;
import com.appsflyer.AppsFlyerLib;
import android.app.Application;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class AppsFlyerExtension extends Extension {
	
	public static void startTracking (String devKey, String appId) {
		
		Log.v("AppsFlyerExtension", "startTracking");
		AppsFlyerLib.getInstance().startTracking(Extension.mainActivity.getApplication(),devKey);
	}

	public static void trackEvent (String eventName, String eventData) {

		Log.v("AppsFlyerExtension", "Trying to send. trackEvent: " + eventName + ", data: " + eventData);
		Map<String, Object> eventValue = new HashMap<String, Object>();
		if (eventData != null) {
			try {
				JSONObject jObject = new JSONObject(eventData);

				Iterator<String> keys = jObject.keys();

				while (keys.hasNext()) {
					String key = (String) keys.next();
					eventValue.put(key,jObject.get(key));
				}
				AppsFlyerLib.getInstance().trackEvent(Extension.mainContext, eventName, eventValue);
				Log.v("AppsFlyerExtension", "Success!");
			} catch (final JSONException e) {
				Log.e("AppsFlyerExtension", "Json parsing error: " + e.getMessage());
			}
		}
	}
	
	
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
	public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		
		return true;
		
	}
	
	
	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {

		//Log.v("AppsFlyerExtension", "onCreate");
	}
	
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	
}