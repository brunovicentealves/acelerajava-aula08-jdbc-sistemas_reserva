package dao;

import java.util.List;

public interface DAO <T> {

    public  void salvar (T domain);

    public  void update (T domain);

    public  void deletar (T domain);

    public List<T> listartodos();
}
