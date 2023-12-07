package com.nicolas.hostal.vista.usuarios;

import com.nicolas.hostal.modelo.Rol;
import com.nicolas.hostal.modelo.Usuario;
import com.nicolas.hostal.servicios.RolServicio;
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
    private final RolServicio roles;
    private final UsuarioServicio usuarios;

    // Lista
    private List<Rol> lista;

    public RolesAsignadosListModel() {
        this.roles = new RolServicio();
        this.usuarios = new UsuarioServicio();
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
