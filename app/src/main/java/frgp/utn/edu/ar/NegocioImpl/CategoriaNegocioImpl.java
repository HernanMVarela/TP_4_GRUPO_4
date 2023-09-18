package frgp.utn.edu.ar.NegocioImpl;

import android.content.Context;

import frgp.utn.edu.ar.DAO.CategoriaDAO;
import frgp.utn.edu.ar.DAOImpl.CategoriaDAOImpl;
import frgp.utn.edu.ar.Negocio.CategoriaNegocio;

public class CategoriaNegocioImpl implements CategoriaNegocio {
    private CategoriaDAO CatDAO = new CategoriaDAOImpl();
    @Override
    public void listarCategorias(Context context) {
        CatDAO.listarCategorias(context);
    }
}
