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

                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"), rstSqlPesquisa.getString("nome"), rstSqlPesquisa.getString("email"));
                TelaDePesquisaController.registrarPesquisa();

                TelaDePesquisaController.desabilitarPesquisar();
                if (rowNumbers > 1) {
                    TelaDePesquisaController.habilitarAvancar();
                }
            } else {
                TelaDePesquisaController.registrarPesquisa();
                TelaDePesquisaController.desabilitarPesquisar();
                stmSqlPesquisa.close();
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e);
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
        }
    }

    public static void primeiroRegistroModel(String textoPesquisa) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"), rstSqlPesquisa.getString("nome"), rstSqlPesquisa.getString("email"));

                TelaDePesquisaController.habilitarAvancar();
            } else {
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
            }
            TelaDePesquisaController.registrarPesquisa();

            TelaDePesquisaController.desabilitarPesquisar();
            stmSqlPesquisa.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }
}
