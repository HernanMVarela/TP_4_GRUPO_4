package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import frgp.utn.edu.ar.entidades.Categoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DMABuscarCategoria  extends AsyncTask<String, Void, Categoria> {

    private Context context;
    private int id;

    public DMABuscarCategoria(Context context, int id) {
        this.context = context;
        this.id = id;
    }

    @Override
    public Categoria doInBackground(String... strings) {
        Categoria categoria = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            PreparedStatement st = con.prepareStatement("SELECT * FROM categoria WHERE id = ?");
            st.setInt(1, id);
            java.sql.ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                categoria = new Categoria();
                categoria.setId(resultSet.getInt("id"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
            }

            st.close();
            con.close();
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }
        return categoria;
    }


}
