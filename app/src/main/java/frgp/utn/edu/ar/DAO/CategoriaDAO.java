package frgp.utn.edu.ar.DAO;

import android.content.Context;
import android.widget.Spinner;

import java.util.List;

import frgp.utn.edu.ar.entidades.Categoria;

public interface CategoriaDAO {
    List<Categoria> listarCategorias(Context context, Spinner spin);
}
