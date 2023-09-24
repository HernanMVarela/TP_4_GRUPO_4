package frgp.utn.edu.ar.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import frgp.utn.edu.ar.Negocio.CategoriaNegocio;
import frgp.utn.edu.ar.Negocio.ProductoNegocio;
import frgp.utn.edu.ar.NegocioImpl.CategoriaNegocioImpl;
import frgp.utn.edu.ar.NegocioImpl.ProductoNegocioImpl;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Modificar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Modificar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText etID, etNombre, etStock;
    private Spinner spinCategorias;

    private Button btnModificar;
    public Modificar() {
        // Required empty public constructor
    }

    public static Modificar newInstance(String param1, String param2) {
        Modificar fragment = new Modificar();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modificar, container, false);
        CategoriaNegocio CatNeg = new CategoriaNegocioImpl();
        etID = view.findViewById(R.id.editTextIDM);
        etNombre = view.findViewById(R.id.editTextNombre);
        etStock = view.findViewById(R.id.editTextStock);
        spinCategorias = view.findViewById(R.id.spinerCategorias);
        btnModificar = view.findViewById(R.id.btnModificar);
        //btnModificar.setOnClickListener(this);
        CatNeg.listarCategorias(view.getContext(), spinCategorias);
        return view;
    }

    public void buscarPorId(View view){
        if(etID.getText().toString().isEmpty()){
            Toast.makeText(this.getContext(), "Ingrese un ID", Toast.LENGTH_LONG).show();
        }
        else{
            ProductoNegocioImpl ProdNeg = new ProductoNegocioImpl();
            ProdNeg.buscarProductoPorId(this.getContext(), Integer.parseInt(etID.getText().toString()), etNombre, etStock, spinCategorias);
        }
    }

}