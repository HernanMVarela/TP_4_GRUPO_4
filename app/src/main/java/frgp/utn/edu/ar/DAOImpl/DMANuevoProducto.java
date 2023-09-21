package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import frgp.utn.edu.ar.entidades.Producto;

public class DMANuevoProducto extends AsyncTask<String, Void, String> {

    private Context context;
    private Producto nuevo;
    private static String result2;
    //Constructor
    public DMANuevoProducto(Producto nuevo, Context ct)
    {
        this.nuevo = nuevo;
        context = ct;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO articulo (id, nombre, stock, idCategoria) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, nuevo.getId());
            preparedStatement.setString(2, nuevo.getNombre());
            preparedStatement.setInt(3, nuevo.getStock());
            preparedStatement.setInt(4, nuevo.getCategoria().getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                response = "Agregado exitosamente";
                Log.i("Estado","Agregado");
            } else {
                response = "No se pudo agregar";
                Log.e("Estado","NO Agregado");
            }
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "No se pudo agregar";
        }
        return response;
    }
    @Override
    protected void onPostExecute(String response) {

    }
}
