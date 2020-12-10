package com.guillermo.agenda.DAO;

import com.guillermo.agenda.beans.Persona;
import com.guillermo.agenda.beans.Telefono;
import com.guillermo.agenda.interfaces.interfaz_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Guillermo Suarez
 */
public class Telefono_DAO extends Conexion_DAO implements interfaz_DAO<Telefono> {


    public ArrayList<Telefono> listarTelefonos (Persona p) throws SQLException {
        String sql = "SELECT * FROM telefonos where id_persona = ?";
        ResultSet rs = null;
        ArrayList<Telefono> listaTelefonos = new ArrayList<>();
        PreparedStatement st = conexion.prepareStatement(sql);
        st.setInt(1, p.getId_persona());
        rs = st.executeQuery();

        while (rs.next()) {
            Telefono t = new Telefono();
            t.setId_telefono(rs.getInt("id_telefono"));
            t.setNombre(rs.getString("nombre"));
            t.setNumero(rs.getString("numero"));
            listaTelefonos.add(t);
        }
        return listaTelefonos;

    }

    @Override
    public ArrayList<Telefono> listar() throws SQLException {
        return null;
    }

    @Override
    public void insertar(Telefono object) throws SQLException {

    }

    @Override
    public void modificar(Telefono object, Telefono object2) throws SQLException {

    }

    @Override
    public void eliminar(Telefono object) throws SQLException {

    }
}
