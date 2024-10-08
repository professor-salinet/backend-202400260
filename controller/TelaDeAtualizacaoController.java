package controller;
import model.*;
import view.*;
import java.sql.*;
import java.util.*;

public class TelaDeAtualizacaoController extends TelaDeAtualizacaoView {
    public static void popularIds() {
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }
            ids = idsTemp.toArray(new String[0]);
            stmSqlPopularIds.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void atualizarId() {
        try {
            String atualizarNome = "";
            String atualizarEmail = "";
            String atualizarSenha = "";

            if (txtNome.getText().trim().equals(nomeAtual) == false) {
                atualizarNome = "`nome` = '" + txtNome.getText() + "'";
            }

            if (txtEmail.getText().trim().equals(emailAtual) == false) {
                if (atualizarNome.length() > 0) {
                    atualizarEmail = " , ";
                }
                atualizarEmail += "`email` = '" + txtEmail.getText() + "'";
            }

            if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
                if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                    atualizarSenha = " , ";
                }
                atualizarSenha += "`senha` = '" + String.valueOf(txtSenha.getPassword()) + "'";
            }

            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set " + atualizarNome + atualizarEmail + atualizarSenha + " where `id` = " + cbxId.getSelectedItem().toString() + ";";
                // System.out.println(strSqlAtualizarId);
                Statement stmSqlAtualizarId = conexao.createStatement();
                stmSqlAtualizarId.addBatch(strSqlAtualizarId);
                stmSqlAtualizarId.executeBatch();
                nomeAtual = txtNome.getText();
                emailAtual = txtEmail.getText();
                senhaAtual = String.valueOf(txtSenha.getPassword());
                stmSqlAtualizarId.close();
                lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi atualizado com sucesso!");
            } else {
                lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString());
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível atualizar o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        cbxId.setSelectedIndex(0);
    }

    public static void atualizarCampos(String id) {
        try {
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";";
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    nomeAtual = txtNome.getText();
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    emailAtual = txtEmail.getText();
                    txtSenha.setText(rstSqlAtualizarCampos.getString("senha"));
                    senhaAtual = String.valueOf(txtSenha.getPassword());
                    lblNotificacoes.setText("Campos atualizados com sucesso!");
                } else {
                    lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
                }
                stmSqlAtualizarCampos.close();
            } else {
                lblNotificacoes.setText("Selecione um id para continuar.");
                limparCampos();
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

}
