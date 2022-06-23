package test.facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class HintTextField extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;

    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;
        setForeground(Color.GRAY);
        setFont(new Font("Arial", Font.ITALIC,14));
        this.showingHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setFont(new Font("Arial", Font.PLAIN, 14));
        setForeground(Color.BLACK);
        if (this.getText().isEmpty()) {
            super.setText("");
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        setForeground(Color.GRAY);
        setFont(new Font("Arial", Font.ITALIC,14));
        if (this.getText().isEmpty()) {
            super.setText(hint);
            showingHint = true;
        }
    }

    public String getText() {
        String msg;
        if (showingHint) {
            msg = "";
        } else {
            msg = super.getText();
        }
        return msg;
    }
}
