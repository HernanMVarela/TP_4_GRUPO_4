package frgp.utn.edu.ar.Negocio;

import android.content.Context;

import frgp.utn.edu.ar.entidades.Producto;

public interface ProductoNegocio {
    boolean agregarProducto(Producto nuevo, Context context);
}
