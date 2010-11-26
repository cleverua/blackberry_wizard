package com.cleverua.bb.example;

import com.cleverua.bb.IPage;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class Page extends VerticalFieldManager implements IPage {
    protected UserInfo uInfo;
    
    public Page(UserInfo uInfo) {
        super();
        this.uInfo = uInfo;
    }
    
    public Field getContent() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void onPageInvalid() {
        // do nothing        
    }

    public void onPageValid() {
        // do nothing
    }

}
