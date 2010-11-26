package com.cleverua.bb.example;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

import com.cleverua.bb.IPage;
import com.cleverua.bb.WizardScreen;

public class DemoScreen extends MainScreen {
    private static final String TITLE = "Wizard Demo";
    private static final String WIZARD_BUTTON_LABEL = "Edit";

    private IPage[] pages;
    private WizardScreen wizard;
    private VerticalFieldManager userInfoHolder;
    private UserInfo uInfo;
    
    
    public DemoScreen() {
        super();
        setTitle(TITLE);

        uInfo = (UserInfo) BBWizardApplication.instance().getUserInfo().clone();
        initPages();
        wizard = new WizardScreen(TITLE, pages);
        wizard.setChangeListener(wizardListener);

        initUI();
        updateUI();
    }

    protected void onUiEngineAttached(boolean attached) {
        super.onUiEngineAttached(attached);
        if (attached) {
            openWizard();
        }
    }
    
    public boolean onMenu(int instance) {
        if (instance == Menu.INSTANCE_CONTEXT) {
            return true;
        }
        return super.onMenu(instance);
    }

    protected boolean onSavePrompt() {
        return true;
    }

    public void pageComplete(IPage page) {
        add(page.getContent());
    }
    
    private void initPages() {
        pages = new IPage[3];
        pages[0] = new PageUserName(uInfo);
        pages[1] = new PageAddress(uInfo);
        pages[2] = new PageAdditional(uInfo);
    }

    private void initUI() {
        userInfoHolder = new VerticalFieldManager();
        add(userInfoHolder);
        
        ButtonField btnWizard = new ButtonField(WIZARD_BUTTON_LABEL, FIELD_HCENTER | ButtonField.CONSUME_CLICK);
        btnWizard.setChangeListener(new FieldChangeListener() {
            public void fieldChanged(Field field, int context) {
                openWizard();
            }
        });
        setStatus(btnWizard);
    }

    private void updateUI() {
        userInfoHolder.deleteAll();
        userInfoHolder.add(uInfo.getContent());
    }
    
    private void openWizard() {
        UiApplication.getUiApplication().pushScreen(wizard);
    }
    
    private FieldChangeListener wizardListener = new FieldChangeListener() {
        public void fieldChanged(Field field, int context) {
            if (context == WizardScreen.WIZARD_OK) {
                BBWizardApplication.instance().setUserInfo((UserInfo) uInfo.clone());
                updateUI();
            }
        }
    };
}
