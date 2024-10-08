package controller;
import model.*;
import view.*;

import java.sql.*;

public class TelaDePesquisaController extends TelaDePesquisaView {
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao));
    }

    public static void preencherCampos(String id, String nome, String email) {
        txtId.setText(id);
        txtNome.setText(nome);
        txtEmail.setText(email);
    }

    public static void pesquisar() {
        if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
            limparCampos("");
        }
    }

    public static void primeiroRegistro() {
        try {
            limparCampos("Você está no primeiro registro.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                txtId.setText(rstSqlPesquisa.getString("id"));
                txtNome.setText(rstSqlPesquisa.getString("nome"));
                txtEmail.setText(rstSqlPesquisa.getString("email"));
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            txtUsuario = txtPesquisa.getText();
            btnPesquisar.setEnabled(false);
            stmSqlPesquisa.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void registroAnterior() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("Registro anterior posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` < " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao primeiro registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }    }

    public static void proximoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("Próximo registro posicionado com sucesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void ultimoRegistro() {
        try {
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos("");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            } else {
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

}
