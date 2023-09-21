package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.widget.Spinner;

import java.util.List;

import frgp.utn.edu.ar.DAO.CategoriaDAO;
import frgp.utn.edu.ar.entidades.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {
    private DMASpinnerCategoria dataAccess;
    public List<Categoria> listarCategorias(Context context, Spinner spin){

        dataAccess = new DMASpinnerCategoria(spin, context);
        dataAccess.execute();

        return null;
    }
}
