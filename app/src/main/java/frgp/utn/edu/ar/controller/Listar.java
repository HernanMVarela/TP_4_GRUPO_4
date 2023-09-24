package frgp.utn.edu.ar.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;
import android.widget.Toast;

import frgp.utn.edu.ar.DAOImpl.DMAListarProductos;
import frgp.utn.edu.ar.Negocio.ProductoNegocio;
import frgp.utn.edu.ar.NegocioImpl.ProductoNegocioImpl;
import frgp.utn.edu.ar.entidades.Producto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Listar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Listar extends Fragment implements DMAListarProductos.OnItemClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private GridView gvProductos;

    public Listar() {
        // Required empty public constructor
    }

    public static Listar newInstance(String param1, String param2) {
        Listar fragment = new Listar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProductoNegocio ProdNeg = new ProductoNegocioImpl();
        View view = inflater.inflate(R.layout.fragment_listar, container, false);
        gvProductos = view.findViewById(R.id.gvProductos);
        ProdNeg.listarProductos(this.getContext(),gvProductos, this);
        return view;
    }

    @Override
    public void onItemClick(Producto producto) {
        ProductoDetalleDialogFragment dialogFragment = new ProductoDetalleDialogFragment(producto);
        dialogFragment.show(getFragmentManager(), "producto_detalle");
    }
}