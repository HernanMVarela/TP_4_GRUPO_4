package frgp.utn.edu.ar.DAO;

import android.content.Context;
import android.widget.GridView;

import java.util.List;

import frgp.utn.edu.ar.DAOImpl.DMAListarProductos;
import frgp.utn.edu.ar.entidades.Producto;

public interface ProductoDAO {
    void agregarProducto(Producto nuevo, Context context);
    void listarProductos(Context context, GridView gv, DMAListarProductos.OnItemClickListener listener);
}
