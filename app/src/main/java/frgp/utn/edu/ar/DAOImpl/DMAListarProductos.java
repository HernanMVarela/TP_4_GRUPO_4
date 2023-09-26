package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.controller.ProductoAdapter;
import frgp.utn.edu.ar.entidades.Categoria;
import frgp.utn.edu.ar.entidades.Producto;

public class DMAListarProductos extends AsyncTask<String, Void, String> {

    private Context context;
    private GridView gv;
    private static String result2;
    private static List<Producto> listaProductos;
    private OnItemClickListener itemClickListener;
    //Constructor
    public DMAListarProductos(GridView gv, Context ct)
    {
        this.gv = gv;
        context = ct;
    }
    public DMAListarProductos(GridView gv, Context ct, OnItemClickListener listener) {
        this.gv = gv;
        context = ct;
        itemClickListener = listener;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo a inner join categoria c on a.idCategoria = c.id");
            result2 = " ";
            listaProductos = new ArrayList<Producto>();
            while(rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(new Categoria(rs.getInt("idCategoria"),rs.getString("descripcion")));

                listaProductos.add(producto);
            }

            response = "Conexion exitosa";
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "Error";
        }
        return response;
    }
    @Override
    protected void onPostExecute(String response) {
        if (listaProductos != null && !listaProductos.isEmpty()) {
            ProductoAdapter adapter = new ProductoAdapter(context, listaProductos);
            gv.setAdapter(adapter);

            // Configura el OnItemClickListener para el GridView
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Obtiene el producto seleccionado
                    Producto productoSeleccionado = listaProductos.get(position);

                    // Llama al método onItemClick de la interfaz para manejar el clic
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(productoSeleccionado);
                    }
                }

            });
        } else {
            Toast.makeText(context, "Sin productos", Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Producto producto);
    }

}
