package controller;
import view.*;
import java.awt.event.*;

public class TelaDeMenuController extends TelaDeMenuView {
    public static void abrirTelaDeCadastroView() {
        TelaDeCadastroView.appTelaDeCadastroView = new TelaDeCadastroView();
        TelaDeCadastroView.appTelaDeCadastroView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        appTelaDeMenuView.setVisible(false);

        TelaDeCadastroView.appTelaDeCadastroView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);
                }
            }
        );
    }
}
