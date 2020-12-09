
package com.guillermo.agenda;

import com.guillermo.agenda.DAO.Conexion_DAO;
import com.guillermo.agenda.DAO.Persona_DAO;
import com.guillermo.agenda.beans.Persona;
import com.guillermo.agenda.util.Herramientas;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Guillermo Suarez
 *
 */
public class APPController {
    public ListView<Persona> lvLista;
    public Label lbNombre;
    public Label Direccion;
    public Label lbTelefono_1;
    public Label getLbTelefono_2;
    public TextArea txNotas;
    public Button btNuevo;
    public Button btEditar;
    public Button btEliminar;
    public Button btBuscar;
    private Herramientas tool;
    private Persona_DAO persona_dao;

    public APPController(){
        Conexion_DAO baseDatos = new Conexion_DAO();
        persona_dao= new Persona_DAO();
        tool = new Herramientas();
            try {
                baseDatos.conectar();
            } catch (ClassNotFoundException e) {
                tool.alertaError("Error critico, programa dañado");
            } catch (SQLException throwables) {
                tool.alertaError("Error al conectar con la base de datos");
            }
    }
    public void cargarDatos() {
        ArrayList<Persona> lista = null;
        try {
            lista = persona_dao.listar();
        } catch (SQLException throwables) {
            tool.alertaError("No se ha podido eliminar el coche");
        }
        lvLista.setItems(FXCollections.observableArrayList(lista));
    }

}
