package com.cleverua.bb;

import net.rim.device.api.ui.Field;

public interface IPage {
    public Field getContent();
    public boolean isValid();
    public void onPageValid();
    public void onPageInvalid();
}
