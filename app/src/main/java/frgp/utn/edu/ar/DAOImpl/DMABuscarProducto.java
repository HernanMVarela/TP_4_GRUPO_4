package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import frgp.utn.edu.ar.entidades.Producto;

public class DMABuscarProducto extends AsyncTask<String, Void, String> {


    private Context context;
    private int id;
    private EditText nombre;
    private EditText stock;
    private Spinner idCategoria;

    public DMABuscarProducto(int id, EditText nombre, EditText stock, Spinner idCategoria, Context ct)
    {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.idCategoria = idCategoria;
        context = ct;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            PreparedStatement st = con.prepareStatement("SELECT * FROM articulo WHERE a.id = ?");
            st.setInt(1, id);
            java.sql.ResultSet rs = st.executeQuery();
            while(rs.next()) {
                nombre.setText(rs.getString("nombre"));
                stock.setText(rs.getString("stock"));
                idCategoria.setSelection(rs.getInt("idCategoria"));
            }

            if(!rs.next())
            {
                Toast.makeText(context, "No se encontró el producto", Toast.LENGTH_SHORT).show();
            }

            response = "Conexion exitosa";
            st.close();
            con.close();
        } catch (MySQLIntegrityConstraintViolationException e) {
            response = e.toString();
        } catch (Exception e) {
            response = e.toString();
        }
        return response;
    }
}
