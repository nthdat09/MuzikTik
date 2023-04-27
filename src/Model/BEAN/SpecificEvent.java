package Model.BEAN;

import javax.swing.*;

public class SpecificEvent {
    private String specific;
    private JPanel jpn;
    private JLabel jlb;

    public SpecificEvent(){}
    public SpecificEvent(String specific, JPanel jpn, JLabel jlb){
        this.specific = specific;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getSpecific() {
        return specific;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
}
