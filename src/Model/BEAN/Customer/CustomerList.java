package Model.BEAN.Customer;

import javax.swing.*;

public class CustomerList {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;

    public CustomerList(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
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
}
