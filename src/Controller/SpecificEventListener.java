package Controller;

import Model.BEAN.SpecificEvent;

import javax.swing.*;
import java.util.List;
public class SpecificEventListener {
    private JPanel root;
    private String kindSelected = "";
    private List<SpecificEvent> listItem = null;

    public SpecificEventListener(JPanel jpnRoot) {
        this.root = jpnRoot;
    }


}
