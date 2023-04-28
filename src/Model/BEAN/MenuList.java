package Model.BEAN;

import javax.swing.*;

public class MenuList {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;

    public MenuList() {}
    public MenuList(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public MenuList getInstance(){
        return new MenuList();
    }

    public String getKind() {
        return kind;
    }
    public JPanel getJpn() {
        return jpn;
    }
    public JLabel getJlb() {
        return jlb;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
}