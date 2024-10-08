package model;
import java.sql.*;

import controller.*;

public class TelaDePesquisaModel {
    public static void pesquisarModel(String textoPesquisa) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                rstSqlPesquisa.last();
                int rowNumbers = rstSqlPesquisa.getRow();
                rstSqlPesquisa.first();

                stmSqlPesquisa.close();
                TelaDePesquisaController.notificarUsuario("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s).");
                // lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));

                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"), rstSqlPesquisa.getString("nome"), rstSqlPesquisa.getString("email"));
                // txtId.setText(rstSqlPesquisa.getString("id"));
                // txtNome.setText(rstSqlPesquisa.getString("nome"));
                // txtEmail.setText(rstSqlPesquisa.getString("email"));

                // criar métodos: habilitarVoltar habilitarTodos habilitarAvancar
                // txtUsuario = textoPesquisa;
                // btnPesquisar.setEnabled(false);
                // if (rowNumbers > 1) {
                //     btnProximo.setEnabled(true);
                //     btnUltimo.setEnabled(true);
                // }
            } else {
                // txtUsuario = textoPesquisa;
                // btnPesquisar.setEnabled(false);
                // lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\"."));
                stmSqlPesquisa.close();
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
                // return 2;
            }
        } catch (Exception e) {
            // lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
            // return 0;
        }
    }
}
