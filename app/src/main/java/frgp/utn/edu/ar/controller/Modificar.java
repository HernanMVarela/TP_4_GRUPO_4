package frgp.utn.edu.ar.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import frgp.utn.edu.ar.Negocio.CategoriaNegocio;
import frgp.utn.edu.ar.Negocio.ProductoNegocio;
import frgp.utn.edu.ar.NegocioImpl.CategoriaNegocioImpl;
import frgp.utn.edu.ar.NegocioImpl.ProductoNegocioImpl;
import frgp.utn.edu.ar.entidades.Categoria;
import frgp.utn.edu.ar.entidades.Producto;

public class Modificar extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText etID, etNombre, etStock;
    private TextView IDSelec;
    private Spinner spinCategorias;
    private Button btnBuscar, btnModificar;
    private Producto producto = null;
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
        CategoriaNegocio CatNeg = new CategoriaNegocioImpl();
        View view = inflater.inflate(R.layout.fragment_modificar, container, false);
        etID = view.findViewById(R.id.editTextIDM);
        etNombre = view.findViewById(R.id.editTextNombre);
        etStock = view.findViewById(R.id.editTextStock);
        IDSelec = view.findViewById(R.id.IDBuscado);
        spinCategorias = view.findViewById(R.id.spinerCategorias);
        btnBuscar = view.findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(this);
        btnModificar = view.findViewById(R.id.btnModificar);
        btnModificar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                if (checkFormValid(view)) {
                    ProductoNegocioImpl ProdNeg = new ProductoNegocioImpl();
                    Producto modificado = new Producto();
                    modificado.setId(Integer.parseInt(IDSelec.getText().toString()));
                    modificado.setNombre(etNombre.getText().toString());
                    modificado.setStock(Integer.parseInt(etStock.getText().toString()));
                    modificado.setCategoria(new Categoria(spinCategorias.getSelectedItemPosition()+1,spinCategorias.getSelectedItem().toString()));
                    ProdNeg.modificarProducto(modificado,view.getContext());
                    etID.setText("");
                    IDSelec.setText("____");
                    etNombre.setText("");
                    etStock.setText("");
                    spinCategorias.setSelection(0);
                    producto = null;
                }
            }});
        CatNeg.listarCategorias(view.getContext(), spinCategorias);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(etID.getText().toString().isEmpty()){
            Toast.makeText(this.getContext(), "Ingrese un ID", Toast.LENGTH_LONG).show();
        }
        else{
            ProductoNegocioImpl ProdNeg = new ProductoNegocioImpl();
            producto =  ProdNeg.buscarProductoPorId(this.getContext(), Integer.parseInt(etID.getText().toString()));
            if(producto == null){
                Toast.makeText(this.getContext(), "No se encontro el producto", Toast.LENGTH_LONG).show();
            }
            else{
                IDSelec.setText(String.valueOf(producto.getId()));
                etNombre.setText(producto.getNombre());
                etStock.setText(String.valueOf(producto.getStock()));
                spinCategorias.setSelection(producto.getCategoria().getId()-1);
            }
        }
    }

    private boolean checkFormValid(View view) {
        if (IDSelec.getText().toString().isEmpty() || etNombre.getText().toString().isEmpty() || etStock.getText().toString().isEmpty()) {
            Toast.makeText(view.getContext(), "Complete todos los campos", Toast.LENGTH_LONG).show();
            return false;
        }

        if (Integer.parseInt(etStock.getText().toString()) < 0) {
            Toast.makeText(view.getContext(), "El stock no puede ser negativo", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!etNombre.getText().toString().matches("[a-zA-Z ]+")) {
            Toast.makeText(view.getContext(), "El nombre solo puede contener letras", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!producto.getNombre().equals(etNombre.getText().toString())) {
            ProductoNegocioImpl ProdNeg = new ProductoNegocioImpl();
            if (ProdNeg.buscarProductoPorNombre(etNombre.getText().toString(), view.getContext()) != null) {
                Toast.makeText(view.getContext(), "Ya existe un producto con ese nombre", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }
}