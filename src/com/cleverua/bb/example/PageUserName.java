package com.cleverua.bb.example;

import java.util.Vector;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.EmailAddressEditField;

public class PageUserName extends Page {
    private static final String NAME_LABEL      = "Name";
    private static final String SURNAME_LABEL   = "Surname";
    private static final String EMAIL_LABEL     = "E-mail";
    private static final String LABEL_SUFFIX    = ": ";
    private static final String INVALID_FIELDS_MSG = "Please, fill the obligatory fields:\n";
    
    private EditField name;
    private EditField surname;
    private EmailAddressEditField email;
    
    private Vector invalidFields;
    
    public PageUserName(UserInfo uInfo) {
        super(uInfo);
        
        invalidFields = new Vector();
        name = new EditField(NAME_LABEL + LABEL_SUFFIX, uInfo.getName());
        surname = new EditField(SURNAME_LABEL + LABEL_SUFFIX, uInfo.getSurname());
        email = new EmailAddressEditField(EMAIL_LABEL + LABEL_SUFFIX, uInfo.getEmail());
        add(name);
        add(surname);
        add(email);
    }
    
    public Field getContent() {
        return this;
    }

    public boolean isValid() {
        invalidFields.removeAllElements();
        
        if (StringUtils.isBlank(name.getText())) {
            invalidFields.addElement(NAME_LABEL);
        }
        if (StringUtils.isBlank(surname.getText())) {
            invalidFields.addElement(SURNAME_LABEL);
        }
        return invalidFields.isEmpty();
    }

    public void onPageInvalid() {
        StringBuffer errorMessage = new StringBuffer(INVALID_FIELDS_MSG);
        final int size = invalidFields.size();
        errorMessage.append(invalidFields.elementAt(0));
        for (int i = 1; i < size; i++) {
            errorMessage.append(',').append(invalidFields.elementAt(i));
        }
        Dialog.alert(errorMessage.toString());
    }

    public void onPageValid() {
        uInfo.setName(name.getText());
        uInfo.setSurname(surname.getText());
        uInfo.setEmail(email.getText());
    }

}
