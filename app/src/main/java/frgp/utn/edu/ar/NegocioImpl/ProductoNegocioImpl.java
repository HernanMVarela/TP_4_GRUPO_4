package frgp.utn.edu.ar.NegocioImpl;

import android.content.Context;
import android.widget.GridView;

import frgp.utn.edu.ar.DAO.ProductoDAO;
import frgp.utn.edu.ar.DAOImpl.DMAListarProductos;
import frgp.utn.edu.ar.DAOImpl.ProductoDAOImpl;
import frgp.utn.edu.ar.Negocio.ProductoNegocio;
import frgp.utn.edu.ar.entidades.Producto;

public class ProductoNegocioImpl implements ProductoNegocio {
    ProductoDAO ProDAO = new ProductoDAOImpl();
    @Override
    public void agregarProducto(Producto nuevo, Context context) {
        ProDAO.agregarProducto(nuevo, context);
    }
    public void listarProductos(Context context, GridView gv, DMAListarProductos.OnItemClickListener listener){
        ProDAO.listarProductos(context,gv, listener);
    }
}
