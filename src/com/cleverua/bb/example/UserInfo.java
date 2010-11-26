package com.cleverua.bb.example;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class UserInfo {
    private static final String NAME_LABEL      = "Name: ";
    private static final String SURNAME_LABEL   = "Surname: ";
    private static final String EMAIL_LABEL     = "E-mail: ";
    private static final String ADDRESS_LABEL   = "Address: ";
    private static final String COMPANY_LABEL   = "Company: ";
    
    private static final String ADDITIONAL_INFO_LABEl = "Additional info: ";
    
    private String name;
    private String surname;
    private String email;
    private String address;
    private String company;
    private String additionalInfo;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    public Field getContent() {
        VerticalFieldManager manager = new VerticalFieldManager();
        EditField nameField = new EditField(NAME_LABEL, name);
        EditField surnameField = new EditField(SURNAME_LABEL, surname);
        EditField emailField = new EditField(EMAIL_LABEL, email);
        EditField addressField = new EditField(ADDRESS_LABEL, address);
        EditField companyField = new EditField(COMPANY_LABEL, company);
        EditField additionalField = new EditField(ADDITIONAL_INFO_LABEl, additionalInfo);
        nameField.setEditable(false);
        surnameField.setEditable(false);
        emailField.setEditable(false);
        addressField.setEditable(false);
        companyField.setEditable(false);
        additionalField.setEditable(false);
        
        manager.add(nameField);
        manager.add(surnameField);
        manager.add(emailField);
        manager.add(addressField);
        manager.add(companyField);
        manager.add(additionalField);
        return manager;
    }
    
    protected Object clone() {
        UserInfo uInfo = new UserInfo();
        uInfo.setName(name);
        uInfo.setSurname(surname);
        uInfo.setAddress(address);
        uInfo.setEmail(email);
        uInfo.setCompany(company);
        uInfo.setAdditionalInfo(additionalInfo);
        return uInfo;
    }
}
