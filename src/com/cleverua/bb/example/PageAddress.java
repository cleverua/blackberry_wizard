package com.cleverua.bb.example;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;

public class PageAddress extends Page {
    private static final String COMPANY_LABEL = "Company: ";
    private static final String ADDRESS_LABEL = "Address: ";
    private static final String INVALID_FIELD_MSG = "Please, fill the Address field!";
    
    private EditField address;
    private EditField company;
    
    public PageAddress(UserInfo uInfo) {
        super(uInfo);
        address = new EditField(ADDRESS_LABEL, uInfo.getAddress());
        company = new EditField(COMPANY_LABEL, uInfo.getCompany());
        add(address);
        add(company);
    } 
    
    public Field getContent() {
        return this;
    }
    public boolean isValid() {
        return StringUtils.isNotBlank(address.getText());
    }
    public void onPageInvalid() {
        Dialog.alert(INVALID_FIELD_MSG);
    }
    public void onPageValid() {
        uInfo.setAddress(address.getText());
        uInfo.setCompany(company.getText());
    }
}
