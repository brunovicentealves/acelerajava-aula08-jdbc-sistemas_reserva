package dao;

import conexao.JDBCConnection;
import domain.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDao implements DAO<Pais> {
    Connection conexao = null;
    PreparedStatement statement =null;
    @Override
    public void salvar(Pais domain) {

        try {

            conexao= JDBCConnection.getConnection();
            String sql = "insert into pais (nome_pais) values (?)";
            statement = conexao.prepareStatement(sql);

            statement.setString(1,domain.getNomePais());

            statement.execute();

        }catch (SQLException ex){

            ex.printStackTrace();
        }finally {
            close();
        }
    }

    @Override
    public void update(Pais domain) {

        try {
            conexao=JDBCConnection.getConnection();
            String sql = "update pais set nome_pais=? where id_pais =?";
            statement = conexao.prepareStatement(sql);
            statement.setString(1,domain.getNomePais());
            statement.setInt(2,domain.getIdPais());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }
    }

    @Override
    public void deletar(Pais domain) {

        try {
            conexao = JDBCConnection.getConnection();
            String sql="delete from pais  where id_pais=?";
            statement=conexao.prepareStatement(sql);
            statement.setInt(1,domain.getIdPais());
            statement.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List<Pais> listartodos() {

        List<Pais> lista = new ArrayList<>();

        try {
            conexao=JDBCConnection.getConnection();
            String sql = "select * from pais";
            statement =conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Pais pais = new Pais();
                pais.setIdPais(resultSet.getInt("id_pais"));
                pais.setNomePais(resultSet.getString("nome_pais"));
                lista.add(pais);


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
