package Model.BEAN;

import javax.swing.*;

public class Menu {
    private String kind;
    private JButton jbt;
    public Menu(){}
    public Menu(String kind, JButton jbt){
        this.kind = kind;
        this.jbt = jbt;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setJbt(JButton jbt){
        this.jbt = jbt;
    }

    public String getKind() {
        return kind;
    }

    public JButton getJbt() {
        return jbt;
    }
}
