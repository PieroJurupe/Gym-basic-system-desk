package com.jc.gymbasicsystemfront;
import com.jc.gymbasicsystemfront.views.auth.LoginView;
import javax.swing.*;

public class Gymbasicsystemfront {

    public static void main(String[] args) {
        
        setLookAndFeel();
        
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
    
    private static void setLookAndFeel() {
        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
