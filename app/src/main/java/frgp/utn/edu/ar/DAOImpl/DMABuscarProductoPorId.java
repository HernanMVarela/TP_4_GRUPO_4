package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import frgp.utn.edu.ar.entidades.Producto;

public class DMABuscarProductoPorId extends AsyncTask<String, Void, Producto> {


    private Context context;
    private int id;

    public DMABuscarProductoPorId(int id, Context ct)
    {
        this.id = id;
        context = ct;
    }

    @Override
    protected Producto doInBackground(String... strings) {
        Producto producto = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            PreparedStatement st = con.prepareStatement("SELECT * FROM articulo WHERE id = ?");
            st.setInt(1, id);
            java.sql.ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                producto = new Producto();
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setCategoria(new DMABuscarCategoria(context, resultSet.getInt("idCategoria")).doInBackground(String.valueOf(resultSet.getInt("idCategoria"))));

            }

            st.close();
            con.close();
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }
        return producto;
    }
}
