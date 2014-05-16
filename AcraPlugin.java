package com.zengularity.acraplugin;

import android.util.Log;
import android.webkit.ConsoleMessage;
import org.acra.ACRA;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

public class AcraPlugin extends CordovaPlugin {

    class AcraChromeClient extends CordovaChromeClient {
        public AcraChromeClient(CordovaInterface cordova, CordovaWebView webView) {
            super(cordova, webView);
        }
        @Override
        public boolean onConsoleMessage(ConsoleMessage message) {
            if (message.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                ACRA.getErrorReporter().putCustomData("line", "" + message.lineNumber());
                ACRA.getErrorReporter().putCustomData("message", "" + message.message());
                ACRA.getErrorReporter().putCustomData("sourceId", "" + message.sourceId());
                ACRA.getErrorReporter().handleSilentException(new RuntimeException("Javascript Error"));
            }
            return super.onConsoleMessage(message);
        }
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        webView.setWebChromeClient(new AcraChromeClient(cordova, webView){});
    }

}
