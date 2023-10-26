package com.nicolas.hostal.vista.usuarios;

import com.nicolas.hostal.modelo.Rol;
import com.nicolas.hostal.modelo.Usuario;
import com.nicolas.hostal.servicios.RolServicio;
import com.nicolas.hostal.servicios.ServManager;
import com.nicolas.hostal.servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class RolesAsignadosListModel extends DefaultListModel<Rol> {

    // Modelo
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Servicios
    private RolServicio roles;
    private UsuarioServicio usuarios;

    // Lista
    private List<Rol> lista;

    public RolesAsignadosListModel(ServManager manager) {
        if (manager != null) {
            this.roles = manager.getRolServicio();
            this.usuarios = manager.getUsuarioServicio();
        }
        this.lista = new ArrayList<>();
    }

    public void update() {
        removeAllElements();

        if (usuario != null) {
            lista = usuarios.obtenerRoles(usuario);
            addAll(lista);
        }
    }

}
