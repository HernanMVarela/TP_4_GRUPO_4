package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.util.Log;

import frgp.utn.edu.ar.DAO.ProductoDAO;
import frgp.utn.edu.ar.entidades.Producto;

public class ProductoDAOImpl implements ProductoDAO {
    DMANuevoProducto DMANP;
    @Override
    public boolean agregarProducto(Producto nuevo, Context context) {
        DMANP = new DMANuevoProducto(nuevo, context);
        DMANP.execute();
        if(nuevo!=null){
            Log.i("Prod",nuevo.toString());
            return true;
        }else{
            return false;
        }
    }
}
