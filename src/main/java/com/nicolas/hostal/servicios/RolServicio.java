package com.nicolas.hostal.servicios;

import com.nicolas.hostal.dao.DAOManager;
import com.nicolas.hostal.dao.RolDAO;
import com.nicolas.hostal.modelo.Rol;
import java.util.List;

public class RolServicio {
    RolDAO roles;
    
    public RolServicio(DAOManager manager){
        this.roles = manager.getRolDAO();
    }
    
    // CRUD
    
    public void crearRol(Rol r){
        roles.insertar(r);
    }
    
    public void modificarRol(Rol r){
        roles.modificar(r);
    }
    
    public void eliminarRol(Rol r){
        roles.eliminar(r);
    }
    
    public List<Rol> obtenerTodosRoles(){
        return roles.obtenerTodos();
    } 
    
    public Rol obtenerRol(int id){
        return roles.obtener(id);
    }
}
