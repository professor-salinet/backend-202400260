package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenuView extends JFrame {
    public JMenu cadastroMenu;

    public JMenuItem novoItem;
    public JMenuItem pesquisarItem;
    public JMenuItem atualizarItem;
    public JMenuItem removerItem;

    public JMenuBar barraDeMenu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenuView() {
        super("Tela de Menu");

        barraDeMenu = new JMenuBar();

        cadastroMenu = new JMenu("Cadastro");

        novoItem = new JMenuItem("Novo");
        pesquisarItem = new JMenuItem("Pesquisar");
        atualizarItem = new JMenuItem("Atualizar");
        removerItem = new JMenuItem("Remover");

        lblTelaDeMenu = new JLabel("Tela de Menu", SwingConstants.CENTER);

        cadastroMenu.add(novoItem);
        cadastroMenu.add(pesquisarItem);
        cadastroMenu.add(atualizarItem);
        cadastroMenu.add(removerItem);

        cadastroMenu.setMnemonic('C');
        novoItem.setMnemonic('N');
        pesquisarItem.setMnemonic('P');
        atualizarItem.setMnemonic('A');
        removerItem.setMnemonic('R');

        barraDeMenu.add(cadastroMenu);

        setJMenuBar(barraDeMenu);

        add(lblTelaDeMenu, BorderLayout.CENTER);

        novoItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeCadastroView();
                }
            }
        );

        pesquisarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDePesquisaView();
                }
            }
        );

        atualizarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeAtualizacaoView();
                }
            }
        );

        removerItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeMenuController.abrirTelaDeRemoverView();
                }
            }
        );

        setSize(500,500);
        setVisible(true);
    }

    public static TelaDeMenuView appTelaDeMenuView;
    public static void main(String[] args) {
        appTelaDeMenuView = new TelaDeMenuView();
        appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
