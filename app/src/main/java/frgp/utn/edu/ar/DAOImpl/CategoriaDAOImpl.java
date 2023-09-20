package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.util.Log;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.DAO.CategoriaDAO;
import frgp.utn.edu.ar.entidades.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {
    private DataMainActivity dataAccess;
    public List<Categoria> listarCategorias(Context context, Spinner spin){

        dataAccess = new DataMainActivity(spin, context);
        dataAccess.execute();

        return null;
    }
}
