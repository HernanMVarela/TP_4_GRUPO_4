package frgp.utn.edu.ar.DAOImpl;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DMABuscarProductoPorId extends AsyncTask<String, Void, Boolean> {


    private Context context;
    private int id;

    public DMABuscarProductoPorId(int id, Context ct)
    {
        this.id = id;
        context = ct;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        String response = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            PreparedStatement st = con.prepareStatement("SELECT * FROM articulo WHERE id = ?");
            st.setInt(1, id);
            java.sql.ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                Log.d("Info: ", "PRODUCTO ENCONTRADO");
                st.close();
                con.close();
                return true;
            } else {
                Log.d("Info: ", "PRODUCTO NO ENCONTRADO");
                st.close();
                con.close();
                return false;
            }
        } catch (Exception e) {
            response = e.toString();
            Log.d("Error: ", response);
        }
        return false;
    }

}
