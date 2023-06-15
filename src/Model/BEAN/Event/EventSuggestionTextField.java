package Model.BEAN.Event;

import javax.swing.*;
import javax.swing.plaf.metal.MetalTextFieldUI;

public class EventSuggestionTextField extends JTextField {

    private TextFieldSusggestUI textUI;
    public EventSuggestionTextField() {
        textUI = new TextFieldSusggestUI(this);
        setUI(textUI);
    }

    public void addItemSuggestion(String text) {
        textUI.getItems().add(text);
    }

    public void removeItemSuggestion(String text) {
        textUI.getItems().remove(text);
    }

    public void clearItemSuggestion() {
        textUI.getItems().clear();
    }
}
