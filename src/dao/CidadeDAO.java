package dao;

import conexao.JDBCConnection;
import domain.Cidade;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO implements DAO<Cidade> {
    private Connection conexao = null;
   private  PreparedStatement statement = null;

    @Override
    public void salvar(Cidade domain) {
       try {
           conexao= JDBCConnection.getConnection();
           String sql = "insert into cidade (nome_cidade) value (?)";
           statement = conexao.prepareStatement(sql);
           statement.execute();

       }catch (SQLException ex){
           ex.printStackTrace();
       }finally {
           close();
       }
    }

    @Override
    public void update(Cidade domain) {
        try {
            conexao = JDBCConnection.getConnection();
            String sql = "update cidade set nome_cidade=? where id_cidade=?";
            statement=conexao.prepareStatement(sql);
            statement.setString(1,domain.getNomeCidade());
            statement.setInt(2,domain.getIdCidade());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }

    }

    @Override
    public void deletar(Cidade domain) {
        try {
            conexao = JDBCConnection.getConnection();
            String sql = "delete from cidade where id_cidade =?";
            statement=conexao.prepareStatement(sql);
            statement.setInt(1,domain.getIdCidade());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }

    }

    @Override
    public List<Cidade> listartodos() {
        List<Cidade> lista = new ArrayList<>();

        try {
            conexao = JDBCConnection.getConnection();
            String sql = "select * from cidade";
            statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Cidade cidade = new Cidade();
                cidade.setIdCidade(resultSet.getInt("id_cidade"));
                cidade.setNomeCidade(resultSet.getString("nome_cidade"));
                lista.add(cidade);
            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }

        return lista;
    }

    @Override
    public void close() {
        try {
            if (conexao !=null){
                conexao.close();
            }

            if(statement != null){
                statement.close();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
