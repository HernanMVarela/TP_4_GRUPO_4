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
            PreparedStatement st = con.prepareStatement("SELECT * FROM articulo WHERE id = ?");
            st.setInt(1, id);
            java.sql.ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                nombre.setText(resultSet.getString("nombre"));
                stock.setText(resultSet.getString("stock"));
                idCategoria.setSelection(resultSet.getInt("idCategoria"));
            } else {
                Log.d("Info: ", "PRODUCTO NO ENCONTRADO");
                nombre.setText("N/A");
                stock.setText("N/A");
            }

            response = "Conexion exitosa";
            st.close();
            con.close();
        } catch (Exception e) {
            response = e.toString();
        }
        return response;
    }
}
