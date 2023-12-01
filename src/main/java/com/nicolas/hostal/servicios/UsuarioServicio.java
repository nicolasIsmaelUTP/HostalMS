package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.RolDAO;
import com.nicolas.hostal.dao.UsuarioDAO;
import com.nicolas.hostal.modelo.Rol;
import com.nicolas.hostal.modelo.Usuario;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioServicio {

    UsuarioDAO usuarios;
    RolDAO roles;

    public UsuarioServicio(DAOManager manager) {
        this.usuarios = manager.getUsuarioDAO();
        this.roles = manager.getRolDAO();
    }

    // CRUD
    public void crearUsuario(Usuario u) {
        usuarios.insertar(u);
    }

    public void modificarUsuario(Usuario u) {
        usuarios.modificar(u);
    }

    public void eliminarUsuario(Usuario u) {
        usuarios.eliminar(u);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarios.obtenerTodos();
    }

    public Usuario obtenerUsuario(String u) {
        return usuarios.obtener(u);
    }

    // Roles
    public void agregarRol(Usuario u, Rol r) {
        u.getRoles().add(r);
        usuarios.modificar(u);
    }

    public void quitarRol(Usuario u, Rol r) {
        u.getRoles().remove(r);
        usuarios.modificar(u);
    }

    public List<Rol> obtenerRoles(Usuario u) {
        return u.getRoles();
    }

    public List<Rol> obtenerRolesSinAsignar(Usuario u) {
        return roles.obtenerTodos().stream()
            .filter(r -> !u.getRoles().contains(r))
            .collect(Collectors.toList());
    }

    // 
    public boolean existeUsuario(String un) {
        return (usuarios.obtener(un) != null);
    }
}
