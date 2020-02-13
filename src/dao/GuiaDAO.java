package dao;

import conexao.JDBCConnection;
import domain.Guia;
import domain.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuiaDAO implements DAO<Guia> {
    Connection conexao = null;
    PreparedStatement statement = null;
    @Override
    public void salvar(Guia domain) {
        try {
            conexao= JDBCConnection.getConnection();
            String sql = "insert into pais (nome_guia,documento_guia,data_nascimento,credenciais,id_modalidade,id_tipo_passeio) " +
                    "values (?,?,?,?,?,?)";
            statement = conexao.prepareStatement(sql);

            statement.setString(1,domain.getNomeGuia());
            statement.setString(2,domain.getDocumentoGuia());
            statement.setString(3,domain.getDataNascimento());
            statement.setString(4,domain.getCredencial());
            statement.setInt(5,domain.getIdModalidade());
            statement.setInt(6,domain.getIdTipoPasseio());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }
    }

    @Override
    public void update(Guia domain) {

        try {
            conexao=JDBCConnection.getConnection();
            String sql = "update guia set nome_guia=?,documento_guia=?,data_nascimento=? where id_guia =?";
            statement = conexao.prepareStatement(sql);
            statement.setString(1,domain.getNomeGuia());
           statement.setString(2,domain.getDocumentoGuia());
           statement.setString(3,domain.getDataNascimento());
           statement.setInt(4,domain.getIdGuia());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }
    }

    @Override
    public void deletar(Guia domain) {
        try {
            conexao = JDBCConnection.getConnection();
            String sql="delete from guia  where id_guia=?";
            statement=conexao.prepareStatement(sql);
            statement.setInt(1,domain.getIdGuia());
            statement.execute();

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            close();
        }
    }

    @Override
    public List<Guia> listartodos() {
        List<Guia> lista = new ArrayList<>();
        try {
            conexao=JDBCConnection.getConnection();
            String sql = "select * from guia";
            statement =conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
               Guia guia = new Guia();
                guia.setIdGuia(resultSet.getInt("id_guia"));
                guia.setNomeGuia(resultSet.getString("nome_guia"));
                guia.setDocumentoGuia(resultSet.getString("documento_guia"));
                guia.setDataNascimento(resultSet.getString("data_nascimento"));
                guia.setCredencial(resultSet.getString("credenciais"));
                guia.setIdModalidade(resultSet.getInt("id_modalidade"));
                guia.setIdTipoPasseio(resultSet.getInt("id_modalidade"));
                lista.add(guia);
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
            if(conexao != null){
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
