package cordova.check.phone.calls;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

public class CheckPhonePlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        PluginResult pluginResult = null;

        try {

            Context context = this.cordova.getActivity().getApplicationContext();
            String phoneNumber = args.getString(0);
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
            boolean phoneCallsSupported = canOpenIntent(context, intent);

            JSONObject result = new JSONObject();
            result.put("success", true);
            result.put("phoneCallsSupported", phoneCallsSupported);

            //Build the cordova plugin response
            pluginResult = new PluginResult(PluginResult.Status.OK, result);
        }
        catch (Exception e) {
            JSONObject json = new JSONObject();
            json.put("success", false);
            json.put("message", e.getMessage());
            pluginResult = new PluginResult(PluginResult.Status.ERROR, json);
        }

        callbackContext.sendPluginResult(pluginResult);
        return true;
    }

    public static boolean canOpenIntent(Context context, Intent intent) {
        boolean canOpenUrl = false;
        PackageManager    packageManager     = context.getPackageManager();
        List<ResolveInfo> resolvedActivities = packageManager.queryIntentActivities(intent, PackageManager.GET_RESOLVED_FILTER);
        return resolvedActivities.size() > 0;
    }
}
