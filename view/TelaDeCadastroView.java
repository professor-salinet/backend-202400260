package view;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeCadastroView extends JFrame
{
    public static JLabel lblImagem;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;

    public static JButton btnCadastrar;

    public static JLabel lblNotificacoes;

    public TelaDeCadastroView()
    {
        super("Tela de Cadastro");
        // setLayout(new GridLayout(4,2,5,5));
        setLayout(InterfaceController.gbLayout);

        lblImagem = new JLabel(InterfaceController.imgPadrao);
        adicionarComponente(lblImagem, 0, 0, 3, 3);

        lblNome = new JLabel("Nome:");
        adicionarComponente(lblNome, 3, 0, 1, 1);

        txtNome = new JTextField(10);
        adicionarComponente(lblNome, 3, 1, 1, 1);

        lblEmail = new JLabel("Email:");
        adicionarComponente(lblEmail, 4, 0, 1, 1);

        txtEmail = new JTextField(10);
        adicionarComponente(txtEmail, 4, 1, 1, 1);

        lblSenha = new JLabel("Senha:");
        adicionarComponente(lblSenha, 5, 0, 1, 1);

        txtSenha = new JPasswordField(10);
        adicionarComponente(txtSenha, 5, 1, 1, 1);

        btnCadastrar = new JButton("Cadastrar");
        adicionarComponente(btnCadastrar, 6, 0, 2, 1);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        adicionarComponente(lblNotificacoes, 7, 0, 2, 1);

        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente."));
                        txtNome.requestFocus();
                        return;
                    }

                    if (txtEmail.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um Email e tente novamente."));
                        txtEmail.requestFocus();
                        return;
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha para o cadastro. Por favor, digite uma Senha e tente novamente."));
                        txtSenha.requestFocus();
                        return;
                    }

                    lblNotificacoes.setText(TelaDeCadastroController.cadastrarController(txtNome.getText(), txtEmail.getText(), String.valueOf(txtSenha.getPassword())));
                    // Aqui deverá ser chamado o método da controller de cadastro
                }
            }
        );

        setSize(250, 250);
        setVisible(true);
    }

    public static void adicionarComponente(Component component, int row, int column, int width, int height) {
        InterfaceController.addComponent(appTelaDeCadastroView, component, row, column, width, height);
    }

    private String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static TelaDeCadastroView appTelaDeCadastroView;
    public static void main(String[] args) {
        appTelaDeCadastroView = new TelaDeCadastroView();
        appTelaDeCadastroView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
