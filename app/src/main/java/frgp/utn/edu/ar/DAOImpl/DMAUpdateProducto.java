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

public class DMAUpdateProducto extends AsyncTask<String, Void, String> {

    private Context context;
    private Producto modificado;
    private static String result2;
    //Constructor
    public DMAUpdateProducto(Producto modificado, Context ct)
    {
        this.modificado = modificado;
        context = ct;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE articulo SET nombre = ?, stock = ?, idCategoria = ? WHERE id = ?");
            preparedStatement.setString(1, modificado.getNombre());
            preparedStatement.setInt(2, modificado.getStock());
            preparedStatement.setInt(3, modificado.getCategoria().getId());
            preparedStatement.setInt(4, modificado.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                response = "Modificado exitosamente";
                Log.i("Estado","Modificado");
            } else {
                response = "No se pudo modificar";
                Log.e("Estado","No Modificado");
            }
            result2 = "Modificado";
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "No Modificado";
        }
        return response;
    }
    @Override
    protected void onPostExecute(String response) {
        if(result2.equals("Modificado")){
            Toast.makeText(context, "Articulo Modificado", Toast.LENGTH_SHORT).show();
        }
        if(result2.equals("No Modificado")){
            Toast.makeText(context, "Articulo No Modificado", Toast.LENGTH_SHORT).show();
        }
    }
}
