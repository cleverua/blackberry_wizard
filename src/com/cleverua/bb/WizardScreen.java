package com.cleverua.bb;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class WizardScreen extends MainScreen {
    public static final int WIZARD_OK     = 10;
    public static final int WIZARD_CANCEL = 11;
    
    private static final String CANCEL_LABEL = "Cancel";
    private static final String OK_LABEL     = "Save";
    private static final String NEXT_LABEL   = ">>";
    private static final String BACK_LABEL   = "<<";

    private PageIterator iterator;
    
    private ButtonField btnCancel;
    private ButtonField btnOk;
    private ButtonField btnNext;
    private ButtonField btnBack;
    private HorizontalFieldManager buttonsHolder;
    
    public WizardScreen(String title, IPage[] pages) {
        super();
        setTitle(title);
        this.iterator = new PageIterator(pages);

        btnCancel = new ButtonField(CANCEL_LABEL, FIELD_HCENTER | ButtonField.CONSUME_CLICK);
        btnCancel.setChangeListener(cancelListener);
        
        btnOk = new ButtonField(OK_LABEL, FIELD_HCENTER | ButtonField.CONSUME_CLICK);
        btnOk.setChangeListener(okListener);
        
        btnNext = new ButtonField(NEXT_LABEL, FIELD_HCENTER | ButtonField.CONSUME_CLICK);
        btnNext.setChangeListener(nextListener);
        
        btnBack = new ButtonField(BACK_LABEL, FIELD_HCENTER | ButtonField.CONSUME_CLICK);
        btnBack.setChangeListener(backListener);
        
        buttonsHolder = new HorizontalFieldManager(FIELD_HCENTER);
        setStatus(buttonsHolder);
    }
    
    protected void onUiEngineAttached(boolean attached) {
        super.onUiEngineAttached(attached);
        if (attached) {
            showPage(iterator.getFirst());
        }
    }
    
    protected boolean onSavePrompt() {
        return true;
    }
    
    public boolean onMenu(int instance) {
        if (instance == Menu.INSTANCE_CONTEXT) {
            return true;
        }
        return super.onMenu(instance);
    }
    
    private void showPage(IPage page) {
        deleteAll();
        buttonsHolder.deleteAll();
        
        add(page.getContent());
        buttonsHolder.add(btnCancel);
        
        if (!iterator.isFirst()) {
            buttonsHolder.add(btnBack);
        }
        if (iterator.hasNext()) {
            buttonsHolder.add(btnNext);
        } else {
            buttonsHolder.add(btnOk);
        }
    }
    
    private FieldChangeListener backListener = new FieldChangeListener() {
        public void fieldChanged(Field field, int context) {
            showPage(iterator.getPrevious());
        }
    };
    
    private FieldChangeListener nextListener = new FieldChangeListener() {
        public void fieldChanged(Field field, int context) {
            IPage page = iterator.getCurrent();
            if (page.isValid()) {
                page.onPageValid();
                showPage(iterator.getNext());
            } else {
                page.onPageInvalid();
            }
        }
    };
    
    private FieldChangeListener okListener = new FieldChangeListener() {
        public void fieldChanged(Field field, int context) {
            IPage page = iterator.getCurrent(); 
            if (page.isValid()) {
                page.onPageValid();
                close();
                fieldChangeNotify(WIZARD_OK);
            } else {
                page.onPageInvalid();
            }
        }
    };
    
    private FieldChangeListener cancelListener = new FieldChangeListener() {
        public void fieldChanged(Field field, int context) {
            close();
            fieldChangeNotify(WIZARD_CANCEL);
        }
    };
}
