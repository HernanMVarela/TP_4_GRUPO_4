package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.adapters.CategoriaAdapter;
import frgp.utn.edu.ar.entidades.Categoria;

public class DMASpinnerCategoria extends AsyncTask<String, Void, String> {

    private Context context;
    private Spinner spinCate;
    private static String result2;
    private static List<Categoria> listaCategoria;

    //Constructor
    public DMASpinnerCategoria(Spinner spin, Context ct)
    {
        spinCate = spin;
        context = ct;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categoria");
            result2 = " ";
            listaCategoria = new ArrayList<Categoria>();
            while(rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescripcion(rs.getString("descripcion"));

                listaCategoria.add(categoria);
            }
            response = "Conexion exitosa";
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "Conexion no exitosa";
        }
        return response;

    }
    @Override
    protected void onPostExecute(String response) {
        CategoriaAdapter adapter = new CategoriaAdapter(context, listaCategoria);
        spinCate.setAdapter(adapter);
    }
}
