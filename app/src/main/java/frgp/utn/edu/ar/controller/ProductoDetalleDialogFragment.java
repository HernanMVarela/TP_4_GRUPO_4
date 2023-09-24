package frgp.utn.edu.ar.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import frgp.utn.edu.ar.entidades.Producto;

public class ProductoDetalleDialogFragment extends DialogFragment {

    private Producto producto;

    public ProductoDetalleDialogFragment(Producto producto) {
        this.producto = producto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_producto_detalle, container, false);

        // Configura las vistas con los detalles del producto
        TextView IDTextView = view.findViewById(R.id.idTextView);
        TextView nombreTextView = view.findViewById(R.id.tituloTextView);
        TextView categoriaTextView = view.findViewById(R.id.categoriaTextView);
        TextView stockTextView = view.findViewById(R.id.stockTextView);

        IDTextView.setText("ID: " + producto.getId());
        nombreTextView.setText(producto.getNombre());
        categoriaTextView.setText(producto.getCategoria().getDescripcion());
        stockTextView.setText("Stock: " + producto.getStock());

        return view;
    }
}