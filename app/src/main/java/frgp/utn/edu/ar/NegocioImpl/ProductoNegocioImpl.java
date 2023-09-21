package frgp.utn.edu.ar.NegocioImpl;

import android.content.Context;

import frgp.utn.edu.ar.DAO.ProductoDAO;
import frgp.utn.edu.ar.DAOImpl.ProductoDAOImpl;
import frgp.utn.edu.ar.Negocio.ProductoNegocio;
import frgp.utn.edu.ar.entidades.Producto;

public class ProductoNegocioImpl implements ProductoNegocio {
    ProductoDAO ProDAO = new ProductoDAOImpl();
    @Override
    public boolean agregarProducto(Producto nuevo, Context context) {
        return ProDAO.agregarProducto(nuevo, context);
    }
}
