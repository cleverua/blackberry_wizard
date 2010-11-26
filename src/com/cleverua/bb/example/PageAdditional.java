package com.cleverua.bb.example;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.EditField;

public class PageAdditional extends Page {
    private static final String ADDITIONAL_INFO_LABEL = "Additional Info: ";
    
    private EditField additionalInfo;
    
    public PageAdditional(UserInfo uInfo) {
        super(uInfo);
        additionalInfo = new EditField(ADDITIONAL_INFO_LABEL, uInfo.getAdditionalInfo());
        add(additionalInfo);
    }
    
    public Field getContent() {
        return this;
    }

    public boolean isValid() {
        return true;
    }

    public void onPageInvalid() {
        // do nothing
    }

    public void onPageValid() {
        uInfo.setAdditionalInfo(additionalInfo.getText());
    }

}
