package model;
import controller.*;
import java.sql.*;
import java.util.*;

public class TelaDeAtualizacaoModel {
    public static void popularIdsModel() {
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
            TelaDeAtualizacaoController.enviarIds(idsTemp.toArray(new String[0]));
            stmSqlPopularIds.close();
        } catch (Exception e) {
            TelaDeAtualizacaoController.notificarUsuario("Não foi possível encontrar os ids! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }
}
