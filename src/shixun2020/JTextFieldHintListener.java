package shixun2020;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldHintListener implements FocusListener {
    private String mHintText;
    private JTextField mTextField;

    public JTextFieldHintListener(String hintText, JTextField textField) {
        this.mHintText = hintText;
        this.mTextField = textField;
        textField.setForeground(Color.GRAY);
    }
    @Override
    public void focusGained(FocusEvent e) {
        String temp = mTextField.getText();
        if(temp.equals(mHintText)){

        	if(mTextField instanceof JPasswordField)
				((JPasswordField) mTextField).setEchoChar((char)0);
            mTextField.setText("");
            mTextField.setForeground(Color.BLACK);
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        String temp = mTextField.getText();
        if(temp.length()>0) {
        	if(mTextField instanceof JPasswordField)
    			((JPasswordField) mTextField).setEchoChar('*');
        }
        if(temp.equals("")||temp.equals(mHintText)){
        	if(mTextField instanceof JPasswordField)
				((JPasswordField) mTextField).setEchoChar((char)0);
            mTextField.setForeground(Color.LIGHT_GRAY);
            mTextField.setText(mHintText);
    }
        
//        else {
//        	if(mTextField instanceof JPasswordField)
//				((JPasswordField) mTextField).setEchoChar((char)0);
//        }
        	
}
}