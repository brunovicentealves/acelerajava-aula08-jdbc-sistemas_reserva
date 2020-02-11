package dao;

import conexao.JDBCConnection;
import domain.Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements DAO<Estado> {
    private Connection conexao =null;
    private PreparedStatement statement = null;

    @Override
    public void salvar(Estado domain) {

        try {
            conexao = JDBCConnection.getConnection();
            String sql = "insert into estado (nome_estado) values(?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1,domain.getNomeEstado());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }

    }

    @Override
    public void update(Estado domain) {
       try {
           conexao=JDBCConnection.getConnection();
           String sql = "update estado set nome=? where id_estado=?";
           statement= conexao.prepareStatement(sql);
           statement.setString(1,domain.getNomeEstado());
           statement.setInt(2,domain.getIdEstado());
           statement.execute();

       }catch (SQLException ex){
           ex.printStackTrace();
       }finally {
           close();
       }

    }

    @Override
    public void deletar(Estado domain) {
        try {

            conexao = JDBCConnection.getConnection();
            String sql = "delete from estado where id_estado=?";
            statement=conexao.prepareStatement(sql);
            statement.setInt(1,domain.getIdEstado());
            statement.execute();

        }catch (SQLException ex){

            ex.printStackTrace();
        }finally {
            close();
        }
    }

    @Override
    public List<Estado> listartodos() {

         List<Estado> lista = new ArrayList<>();
         try {
             conexao = JDBCConnection.getConnection();
             String sql = "select @ from estado";
             statement = conexao.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()){
                 Estado estado = new Estado();
                 estado.setIdEstado(resultSet.getInt("id_estado"));
                 estado.setNomeEstado(resultSet.getString("nome_estado"));
                 lista.add(estado);
             }

         } catch (SQLException ex){
             ex.printStackTrace();
         }finally {
             close();
         }
        return lista;
    }

    @Override
    public void close() {
        try {
            if(conexao !=null){
                conexao.close();
            }

            if (statement != null){
                statement.close();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
