package frgp.utn.edu.ar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.controller.R;
import frgp.utn.edu.ar.entidades.Categoria;

public class CategoriaAdapter extends ArrayAdapter<Categoria> {
    public CategoriaAdapter(Context context, List<Categoria> categorias) {
        super(context, R.layout.spinner_dropdown_item_categoria, categorias);
        setDropDownViewResource(R.layout.spinner_dropdown_item_categoria);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Categoria categoria = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_dropdown_item_categoria, parent,false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        assert categoria != null;
        textView.setText(categoria.getDescripcion());

        return convertView;
    }
}
