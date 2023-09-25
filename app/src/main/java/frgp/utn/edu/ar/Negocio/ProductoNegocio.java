package frgp.utn.edu.ar.Negocio;

import android.content.Context;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import frgp.utn.edu.ar.DAOImpl.DMAListarProductos;
import frgp.utn.edu.ar.entidades.Producto;

public interface ProductoNegocio {
    void agregarProducto(Producto nuevo, Context context);
    void listarProductos(Context context, GridView gv, DMAListarProductos.OnItemClickListener listener);
    void buscarProductoPorId(Context context, int parseInt, EditText etNombre, EditText etStock, Spinner spinCategorias);
    void modificarProducto(Producto modificado, Context context);
    boolean existeProductoPorId(int parseInt, Context context);
}
