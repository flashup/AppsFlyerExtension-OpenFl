package;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android && openfl)
import lime.system.JNI;
#end


class AppsFlyerExtension {

	#if (ios)
		private static var appsflyerextension_trackAppLaunch = Lib.load ("appsflyerextension", "appsflyerextension_trackAppLaunch", 0);
		private static var appsflyerextension_trackEvent = Lib.load ("appsflyerextension", "appsflyerextension_trackEvent", 2);
		private static var appsflyerextension_addConversionListenerCallback = Lib.load ("appsflyerextension", "appsflyerextension_addConversionListenerCallback", 2);
	#end
	#if (android && openfl)
		public var onSuccess_jni:String -> Void;
		public var onError_jni:Void -> Void;
		private static var appsflyerextension_addConversionListenerCallback_jni = JNI.createStaticMethod ("org.haxe.extension.AppsFlyerExtension", "addConversionListenerCallback", "(Lorg/haxe/lime/HaxeObject;)V");
		private static var appsflyerextension_trackEvent_jni = JNI.createStaticMethod ("org.haxe.extension.AppsFlyerExtension", "trackEvent", "(Ljava/lang/String;Ljava/lang/String;)V");
	#end

	private static var instance:AppsFlyerExtension;

	private function new()
	{}

	public static function getInstance():AppsFlyerExtension
	{
		if (instance == null)
		{
			instance = new AppsFlyerExtension();
		}

		return instance;
	}
	
	public static function startTracking (devKey:String, appId:String = ""):Void {
		#if (ios)
		var appsflyerextension_startTracking:Dynamic = Lib.load ("appsflyerextension", "appsflyerextension_startTracking", 2);
		appsflyerextension_startTracking(devKey, appId);
		#end
	}

	public static function trackAppLaunch():Void {
		#if (ios)
			appsflyerextension_trackAppLaunch();
		#end
	}

	public static function trackEvent (eventName:String, eventData:String):Void {
		#if (android)

			appsflyerextension_trackEvent_jni(eventName, eventData);

		#end
		#if (ios)

			appsflyerextension_trackEvent(eventName, eventData);

		#end

	}

	public static function addConversionListenerCallback(onSuccess:String -> Void, onError:Void -> Void):Void {
		#if (android)

			getInstance().onSuccess_jni = onSuccess;
			getInstance().onError_jni = onError;
			appsflyerextension_addConversionListenerCallback_jni(getInstance());

		#end
		#if (ios)

			appsflyerextension_addConversionListenerCallback(onSuccess, onError);

		#end
	}
	
}