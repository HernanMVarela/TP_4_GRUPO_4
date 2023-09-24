package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

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
    public void buscarProductoPorId(Context context, int parseInt, EditText etNombre, EditText etStock, Spinner spinCategorias) {
        DMABuscarProducto DMABP = new DMABuscarProducto(parseInt, etNombre, etStock, spinCategorias, context);
        DMABP.execute();
    }
    @Override
    public void modificarProducto(Producto modificado, Context context){
        DMAUpdateProducto DMAUP = new DMAUpdateProducto(modificado,context);
        DMAUP.execute();
    }
}
