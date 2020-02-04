package dao;

import conexao.JDBCConnection;
import domain.Modalidade;
import domain.TipoPasseio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoPasseioDAO implements DAO<TipoPasseio> {
    Connection conexao = null;
    PreparedStatement statement = null;

    @Override
    public void salvar(TipoPasseio domain) {
        try {
            conexao = JDBCConnection.getConnection();
            String sql = "INSERT INTO tipo_passeio(nome_passeio,descricao_passeio) VALUES (?,?);";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, domain.getNomePasseio());
            statement.setString(2, domain.getDescricaoPasseio());

            statement.execute();

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void update(TipoPasseio domain) {
        try {

            conexao = JDBCConnection.getConnection();
            String sql = "UPDATE tipo_passeio SET nome_passeio=? , descricacao_passeio=? WHERE id_tipo_passeio =?;";
            // String sql = "INSERT INTO modalidade(nome) VALUES ('"+modalidade.getNome_modalidade()+"');";
            statement = conexao.prepareStatement(sql);
            statement.setString(1, domain.getNomePasseio());
            statement.setString(2, domain.getDescricaoPasseio());
            statement.setInt(3, domain.getIdTipoPasseio());
            statement.execute();

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            close();
        }


    }

    @Override
    public void deletar(TipoPasseio domain) {


        try {

            conexao = JDBCConnection.getConnection();
            String sql = "delete from tipo_passeio where id_tipo_passeio=?";
            // String sql = "INSERT INTO modalidade(nome) VALUES ('"+modalidade.getNome_modalidade()+"');";
            statement = conexao.prepareStatement(sql);
            statement.setInt(1, domain.getIdTipoPasseio());
            statement.executeQuery();

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            close();
        }


    }

    @Override
    public List<TipoPasseio> listartodos() {
        List<TipoPasseio> lista = new ArrayList<>();

        try {
            conexao = JDBCConnection.getConnection();
            String sql = "select * from tipo_passeio";
            statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TipoPasseio tipoPasseio = new TipoPasseio();
                tipoPasseio.setIdTipoPasseio(resultSet.getInt("id_tipo_passeio"));
                tipoPasseio.setNomePasseio(resultSet.getString("nome_passeio"));
                tipoPasseio.setDescricaoPasseio(resultSet.getString("descricao_passeio"));
                lista.add(tipoPasseio);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {
            close();
        }


        return lista;
    }

    private void close() {
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
