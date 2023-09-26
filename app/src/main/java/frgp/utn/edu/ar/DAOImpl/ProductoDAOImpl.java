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

    @Override
    public Producto buscarProductoPorId(Context context, int parseInt) {
        DMABuscarProductoPorId DMABP = new DMABuscarProductoPorId(parseInt, context);
        DMABP.execute();
        try {
            return DMABP.get();
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            return null;
        }
    }

    @Override
    public void modificarProducto(Producto modificado, Context context){
        DMAUpdateProducto DMAUP = new DMAUpdateProducto(modificado,context);
        DMAUP.execute();
    }

    @Override
    public Producto buscarProductoPorNombre(Context context, String toString) {
        DMABuscarProductoPorNombre DMABPN = new DMABuscarProductoPorNombre(toString, context);
        DMABPN.execute();
        try {
            return DMABPN.get();
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            return null;
        }
    }
}
