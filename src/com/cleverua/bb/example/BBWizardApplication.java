package com.cleverua.bb.example;

import net.rim.device.api.ui.UiApplication;

public class BBWizardApplication extends UiApplication {
    private static BBWizardApplication app;
    private UserInfo userInfo;
    
    public static void main(String[] args) {
        app = new BBWizardApplication();
        
        DemoScreen demoScreen = new DemoScreen();
        app.pushScreen(demoScreen);
        app.enterEventDispatcher();
    }
    
    public static BBWizardApplication instance() {
        return app;
    } 
    
    public UserInfo getUserInfo() {
        return userInfo;
    }
    
    public void setUserInfo(UserInfo uInfo) {
        userInfo = uInfo;
    }
    
    private BBWizardApplication() {
        userInfo = new UserInfo();
    }
}
