package dao;

import conexao.JDBCConnection;
import domain.Modalidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModalidadeDAO implements DAO<Modalidade>{
    Connection conexao = null;
    PreparedStatement statement = null;
    @Override
    public void salvar(Modalidade domain) {
       try {

           conexao = JDBCConnection.getConnection();
           String sql = "INSERT INTO modalidade(nome) VALUES (?);";
           // String sql = "INSERT INTO modalidade(nome) VALUES ('"+modalidade.getNome_modalidade()+"');";
            statement = conexao.prepareStatement(sql);
           statement.setString(1,domain.getNome_modalidade());

           statement.execute();

       }catch (SQLException ex){

           ex.printStackTrace();
       }finally {
           close();
       }

    }

    @Override
    public void update(Modalidade domain) {
        try {

             conexao = JDBCConnection.getConnection();
            String sql = "UPDATE modalidade SET nome_modalidade=? WHERE id_modalidade =?;";
            // String sql = "INSERT INTO modalidade(nome) VALUES ('"+modalidade.getNome_modalidade()+"');";
             statement = conexao.prepareStatement(sql);
            statement.setString(1,domain.getNome_modalidade());
            statement.setInt(2,domain.getId_modalidade());
            statement.execute();

        }catch (SQLException ex){

            ex.printStackTrace();
        }
    }

    @Override
    public void deletar(Modalidade domain) {
        try {

            conexao = JDBCConnection.getConnection();
            String sql = "delete from modalidade where id_modalidade=?";
            // String sql = "INSERT INTO modalidade(nome) VALUES ('"+modalidade.getNome_modalidade()+"');";
            statement = conexao.prepareStatement(sql);
            statement.setInt(1,domain.getId_modalidade());
            statement.executeQuery();

        }catch (SQLException ex){

            ex.printStackTrace();
        }
    }

    @Override
    public List<Modalidade> listartodos() {
        List<Modalidade> lista = new ArrayList<>();
       try {

           conexao = JDBCConnection.getConnection();
           String sql = "select * from modalidade";
            statement = conexao.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();

           while (resultSet.next()){
               Modalidade modalidade = new Modalidade();
               modalidade.setId_modalidade(resultSet.getInt("id_modalidade"));
               modalidade.setNome_modalidade(resultSet.getString("nome"));
               lista.add(modalidade);
           }

       }catch (SQLException ex){

           ex.printStackTrace();
       }


        return lista;
    }

    @Override
    public void close() {
        try {
            if (conexao != null) {
                conexao.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
