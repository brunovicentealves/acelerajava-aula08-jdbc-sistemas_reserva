import conexao.JDBCConnection;
import dao.ModalidadeDAO;
import dao.TipoPasseioDAO;
import domain.TipoPasseio;

public class App {

    public static void main(String[] args) {

//        System.out.println(JDBCConnection.getConnection());
//
//
//        Modalidade modalidade = new Modalidade();
//
//        modalidade.setNome_modalidade("caminhada tirando fotos");
//
//        new ModalidadeDAO().salvar(modalidade);
//
//        for (Modalidade modalidade1: new ModalidadeDAO().listartodos()) {
//
//            System.out.println(modalidade1.getId_modalidade()+"/"+modalidade1.getNome_modalidade());
//        }

        TipoPasseio tipoPasseio = new TipoPasseio();
        tipoPasseio.setNomePasseio("grupo seleto");
        tipoPasseio.setDescricaoPasseio("até 10 pessoas");

        new TipoPasseioDAO().salvar(tipoPasseio);


        for (TipoPasseio tipoPasseio1: new TipoPasseioDAO().listartodos()) {
            System.out.println(tipoPasseio1.getIdTipoPasseio()+"/"+tipoPasseio1.getNomePasseio()+"/"+tipoPasseio1.getDescricaoPasseio());

        }


    }
}
