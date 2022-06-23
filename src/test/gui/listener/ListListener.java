package test.gui.listener;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * @author Marko Joksimovic
 * @version 1.0
 * @date
 */
public class ListListener implements ListDataListener {

    private DefaultListModel model;

    public ListListener(DefaultListModel model){
        this.model = model;
    }
    @Override
    public void intervalAdded(ListDataEvent e) {
        System.out.println("Test");
    }
    @Override
    public void intervalRemoved(ListDataEvent e) {

    }
    @Override
    public void contentsChanged(ListDataEvent e) {

    }
}
