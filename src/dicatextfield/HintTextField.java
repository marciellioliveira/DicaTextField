package dicatextfield;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Marcielli
 */
public class HintTextField extends JTextField implements FocusListener{

    private final String hint;
    private boolean showingHint;
    
    public HintTextField(final String hint)
    {
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        
        super.addFocusListener(this);
    }
        
    @Override
    public void focusGained(FocusEvent e) {
        
        if(this.getText().isEmpty()) {
            super.setText("");         
            super.setForeground(Color.BLACK);
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        
        if(this.getText().isEmpty()) {
            super.setText(hint);
            super.setForeground(Color.LIGHT_GRAY);
            showingHint = true;
        }        
    }
    
    @Override
    public String getText() {
        
        return showingHint ? "": super.getText();
    }    
}
