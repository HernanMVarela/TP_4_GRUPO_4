package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.DAO.CategoriaDAO;
import frgp.utn.edu.ar.entidades.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {
    private DataMainActivity dataAccess;
    public List<Categoria> listarCategorias(Context context){
        List<Categoria> listado = new ArrayList<Categoria>();

        dataAccess = new DataMainActivity(listado, context);
        dataAccess.execute();

        return null;
    }
}
