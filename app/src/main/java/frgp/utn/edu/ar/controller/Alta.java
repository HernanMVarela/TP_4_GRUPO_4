package frgp.utn.edu.ar.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import frgp.utn.edu.ar.Negocio.CategoriaNegocio;
import frgp.utn.edu.ar.Negocio.ProductoNegocio;
import frgp.utn.edu.ar.NegocioImpl.CategoriaNegocioImpl;
import frgp.utn.edu.ar.NegocioImpl.ProductoNegocioImpl;
import frgp.utn.edu.ar.entidades.Categoria;
import frgp.utn.edu.ar.entidades.Producto;

public class Alta extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Alta producto";
    private static final String ARG_PARAM2 = "Completar datos";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnAgregar;
    private Spinner spinCategorias;
    private EditText id, nombre, stock;

    public Alta() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Alta newInstance(String param1, String param2) {
        Alta fragment = new Alta();
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
        // Inflate the layout for this fragment
        CategoriaNegocio CatNeg = new CategoriaNegocioImpl();
        View view = inflater.inflate(R.layout.fragment_alta, container, false);
        spinCategorias = view.findViewById(R.id.spinerCategorias);
        id = view.findViewById(R.id.editTextID);
        nombre = view.findViewById(R.id.editTextNombre);
        stock = view.findViewById(R.id.editTextStock);
        btnAgregar = view.findViewById(R.id.bAgregar);
        btnAgregar.setOnClickListener(this);
        CatNeg.listarCategorias(view.getContext(), spinCategorias);
        return view;
    }

    @Override
    public void onClick(View view) {
        Producto nuevo = new Producto();

        nuevo.setId(Integer.parseInt(id.getText().toString()));
        nuevo.setNombre(nombre.getText().toString());
        nuevo.setStock(Integer.parseInt(stock.getText().toString()));
        nuevo.setCategoria(new Categoria(spinCategorias.getSelectedItemPosition()+1,spinCategorias.getSelectedItem().toString()));
        ProductoNegocio ProdNeg = new ProductoNegocioImpl();
        ProdNeg.agregarProducto(nuevo, this.getContext());

    }
}