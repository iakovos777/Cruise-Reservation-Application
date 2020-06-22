package cast.cruise.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DefaultJFrame extends JFrame implements View {


    private static final long serialVersionUID = -1026655302725303603L;


    public void open() {
        setVisible(true);
        
    }


    public void close() {
       dispose();
    }


    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Cruise", JOptionPane.ERROR_MESSAGE);
    }


    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this,message,"Cruise", JOptionPane.INFORMATION_MESSAGE);
    }

}
