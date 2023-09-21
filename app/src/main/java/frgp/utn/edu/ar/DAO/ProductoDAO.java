package frgp.utn.edu.ar.DAO;

import android.content.Context;

import java.util.List;

import frgp.utn.edu.ar.entidades.Producto;

public interface ProductoDAO {
    boolean agregarProducto(Producto nuevo, Context context);
}
