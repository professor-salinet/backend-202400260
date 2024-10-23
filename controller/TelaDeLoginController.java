package controller;
import model.*;
import view.*;

public class TelaDeLoginController extends TelaDeLoginView {
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao));
    }

    public static void logarController(String login, String senha) {
        TelaDeLoginModel.logarModel(login, senha);
    }

    public static void abrirTelaDeMenu() {
        TelaDeMenuView.appTelaDeMenuView = new TelaDeMenuView();
        TelaDeMenuView.appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE);

        appTelaDeLoginView.dispose();
    }
}
