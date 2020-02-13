package dao;

import conexao.JDBCConnection;
import domain.Pais;
import domain.Viajante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViajanteDAO implements DAO<Viajante> {
    Connection conexao = null;
    PreparedStatement statement = null;
    @Override
    public void salvar(Viajante domain) {
        try {

            conexao= JDBCConnection.getConnection();
            String sql = "insert into pais (nome_viajante,documento_viajante,data_nascimento) values (?,?,?)";
            statement = conexao.prepareStatement(sql);
            statement.setString(1,domain.getNomeViajante());
            statement.setString(2,domain.getDocumento_viajante());
            statement.setString(3,domain.getDataNascimento());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }
    }

    @Override
    public void update(Viajante domain) {
        try {

            conexao=JDBCConnection.getConnection();
            String sql = "update viajante set nome_viajante=?,documento_viajante=?,data_nascimento=? where id_pais =?";
            statement = conexao.prepareStatement(sql);
            statement.setString(1,domain.getNomeViajante());
            statement.setString(2,domain.getDocumento_viajante());
            statement.setString(3,domain.getDataNascimento());
            statement.setInt(4,domain.getIdViajante());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }

    }

    @Override
    public void deletar(Viajante domain) {
        try {
            conexao = JDBCConnection.getConnection();
            String sql="delete from viajante  where id_viajante=?";
            statement=conexao.prepareStatement(sql);
            statement.setInt(1,domain.getIdViajante());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }

    }

    @Override
    public List<Viajante> listartodos() {
        List<Viajante> lista = new ArrayList<>();

        try {
            conexao=JDBCConnection.getConnection();
            String sql = "select * from viajantes";
            statement =conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
               Viajante viajante = new Viajante();
                viajante.setIdViajante(resultSet.getInt("id_viajante"));
                viajante.setNomeViajante(resultSet.getString("nome_viajante"));
                viajante.setDocumento_viajante(resultSet.getString("documento_viajante"));
                viajante.setDataNascimento(resultSet.getString("data_nascimento"));
                lista.add(viajante);
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
