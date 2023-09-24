package frgp.utn.edu.ar.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import frgp.utn.edu.ar.entidades.Producto;

public class ProductoAdapter extends BaseAdapter {
    private List<Producto> elementos;
    private Context context;

    public ProductoAdapter(Context context, List<Producto> elementos) {
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        if(elementos != null) {
            return elementos.size();
        }else {
            return 0;
        }
    }

    @Override
    public Producto getItem(int position) {
        if(elementos!=null) {
            return elementos.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = convertView;
        if (convertView == null){
            view = inflater.inflate(R.layout.grid_layout,null);
        }

        TextView gvtxID = (TextView) view.findViewById(R.id.gvtxbID);
        TextView gvtxTitulo = (TextView) view.findViewById(R.id.gvtxbTitulo);

        gvtxID.setText("ID: " + getItem(position).getId());
        gvtxTitulo.setText(getItem(position).getNombre());

        return view;
    }
}
