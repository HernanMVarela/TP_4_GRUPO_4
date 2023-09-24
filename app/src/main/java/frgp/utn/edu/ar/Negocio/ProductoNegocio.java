package frgp.utn.edu.ar.Negocio;

import android.content.Context;
import android.widget.GridView;

import frgp.utn.edu.ar.DAOImpl.DMAListarProductos;
import frgp.utn.edu.ar.entidades.Producto;

public interface ProductoNegocio {
    void agregarProducto(Producto nuevo, Context context);
    void listarProductos(Context context, GridView gv, DMAListarProductos.OnItemClickListener listener);
}
