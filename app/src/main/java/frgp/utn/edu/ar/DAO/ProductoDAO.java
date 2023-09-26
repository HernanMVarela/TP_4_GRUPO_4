package frgp.utn.edu.ar.DAO;

import android.content.Context;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import frgp.utn.edu.ar.DAOImpl.DMAListarProductos;
import frgp.utn.edu.ar.entidades.Producto;

public interface ProductoDAO {
    void agregarProducto(Producto nuevo, Context context);
    void listarProductos(Context context, GridView gv, DMAListarProductos.OnItemClickListener listener);
    Producto buscarProductoPorId(Context context, int parseInt);
    void modificarProducto(Producto modificado, Context context);
    Producto buscarProductoPorNombre(Context context, String toString);
}
