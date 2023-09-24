package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.util.Log;
import android.widget.GridView;

import frgp.utn.edu.ar.DAO.ProductoDAO;
import frgp.utn.edu.ar.entidades.Producto;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void agregarProducto(Producto nuevo, Context context) {
        DMANuevoProducto DMANP = new DMANuevoProducto(nuevo, context);
        DMANP.execute();
    }
    @Override
    public void listarProductos(Context context, GridView gv, DMAListarProductos.OnItemClickListener listener) {
        DMAListarProductos DMALP = new DMAListarProductos(gv,context, listener);
        DMALP.execute();
    }
}
