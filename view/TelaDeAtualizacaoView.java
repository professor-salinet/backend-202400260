package view;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeAtualizacaoView extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblImagem;
    public static JButton btnCarregarImagem;
    public static JButton btnRemoverImagem;
    public static final JTextField txtImagem = new JTextField();

    public static JLabel lblNome;
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail;
    public static JTextField txtEmail;
    public static String emailAtual;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeAtualizacaoView()
    {
        super("Tela de Atualização");
        InterfaceController.gbLayout = new GridBagLayout();
        setLayout(InterfaceController.gbLayout);
        InterfaceController.gbConstraints = new GridBagConstraints();
        //   setLayout(new GridLayout(7,1,5,5));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(lblId,0,1,1,1);

        TelaDeAtualizacaoController.popularIds();
        cbxId = new JComboBox<String>(ids);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(cbxId,0,2,1,1);

        // add(linha_id);

        lblImagem = new JLabel(InterfaceController.imgPadrao);
        // gbConstraints.fill = GridBagConstraints.BOTH;
        adicionarComponente(lblImagem, 0, 0, 1, 7);

        btnCarregarImagem = new JButton("Carregar Imagem");
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(btnCarregarImagem, 1, 1, 1, 1);

        btnRemoverImagem = new JButton("Remover Imagem");
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(btnRemoverImagem, 1, 2, 1, 1);

        // add(linha_imagem);

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(lblNome, 2, 1, 1, 1);

        txtNome = new JTextField(tamanhoInputs);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(txtNome, 2, 2, 1, 1);

        // add(linha_nome);

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(lblEmail, 3, 1, 1, 1);

        txtEmail = new JTextField(tamanhoInputs);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(txtEmail, 3, 2, 1, 1);

        // add(linha_email);

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(lblSenha, 4, 1, 1, 1);

        txtSenha = new JPasswordField(tamanhoInputs);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(txtSenha, 4, 2, 1, 1);

        // add(linha_senha);

        btnAtualizar = new JButton("Atualizar");
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(btnAtualizar, 5, 1, 1, 1);

        btnCancelar = new JButton("Cancelar");
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(btnCancelar, 5, 2, 1, 1);

        // add(linha_botoes);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        // gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        adicionarComponente(lblNotificacoes, 6, 1, 2, 1);

        // add(linha_notificacoes);

        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.atualizarId();
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.limparCampos();
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        TelaDeAtualizacaoController.atualizarCampos(String.valueOf(cbxId.getSelectedItem()));
                    }
                } 
            }
        );

        btnCarregarImagem.addActionListener(
            new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.carregarImagem();
                } 
            }
        );

        btnRemoverImagem.addActionListener(
            new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.removerImagem();
                } 
            }
        );

        setSize(450, 200);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    public static void adicionarComponente(Component component, int row, int column, int width, int height) {
        InterfaceController.addComponent(appTelaDeAtualizacaoView, component, row, column, width, height);
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static TelaDeAtualizacaoView appTelaDeAtualizacaoView;
    public static void main(String[] args) {
        appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();
        appTelaDeAtualizacaoView.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // appTelaDeAtualizacaoView.getRootPane().addComponentListener(
        //     new ComponentAdapter() {
        //         public void componentResized(ComponentEvent e) {
        //             int larguraTela = appTelaDeAtualizacaoView.getWidth();
        //             int alturaTela = appTelaDeAtualizacaoView.getHeight();
        //             // This is only called when the user releases the mouse button.
        //             TelaDeAtualizacaoController.notificarUsuario(String.format("Largura: %s, Altura: %s", larguraTela, alturaTela));
        //         }
        //     }
        // );
    }
}
