import java.sql.*;
import java.util.*;
import javax.swing.*;

public class NavegadorDeRegistro extends TelaDeRemover {
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
            if (cbxId != null) {
                if (cbxId.getItemCount() > 0) {
                    cbxId.removeAllItems();
                    DefaultComboBoxModel<String> newMod = new DefaultComboBoxModel<String>(ids);
                    cbxId.setModel(newMod);
                    // cbxId = new JComboBox<String>(ids);
                }
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void removerId() {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlRemoverId = "delete from `db_senac`.`tbl_senac` where `id` = " + cbxId.getSelectedItem().toString() + ";";
            // System.out.println(strSqlRemoverId);
            Statement stmSqlRemoverId = conexao.createStatement();
            stmSqlRemoverId.addBatch(strSqlRemoverId);
            stmSqlRemoverId.executeBatch();
            stmSqlRemoverId.close();
            lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi removido com sucesso!");
            limparCampos();
            popularIds();
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível remover o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        cbxId.setSelectedIndex(0);
    }

    public static void atualizarCampos(boolean notificar) {
        try {
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + cbxId.getSelectedItem().toString() + ";";
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    if (notificar == true) {
                        lblNotificacoes.setText("Campos atualizados com sucesso!");
                    }
                } else {
                    if (notificar == true) {
                        lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
                    }
                }
                stmSqlAtualizarCampos.close();
            } else {
                if (notificar == true) {
                    lblNotificacoes.setText("Selecione um id para continuar.");
                    limparCampos();
                }
            }
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }
}
