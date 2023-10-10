/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolas.hostal.persistencia;

import com.nicolas.hostal.modelo.Producto_entrante;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author NICOLAS
 */
public class Producto_entranteJpaController implements Serializable {

    public Producto_entranteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public Producto_entranteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto_entrante producto_entrante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(producto_entrante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto_entrante producto_entrante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            producto_entrante = em.merge(producto_entrante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = producto_entrante.getId();
                if (findProducto_entrante(id) == null) {
                    throw new NonexistentEntityException("The producto_entrante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto_entrante producto_entrante;
            try {
                producto_entrante = em.getReference(Producto_entrante.class, id);
                producto_entrante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto_entrante with id " + id + " no longer exists.", enfe);
            }
            em.remove(producto_entrante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto_entrante> findProducto_entranteEntities() {
        return findProducto_entranteEntities(true, -1, -1);
    }

    public List<Producto_entrante> findProducto_entranteEntities(int maxResults, int firstResult) {
        return findProducto_entranteEntities(false, maxResults, firstResult);
    }

    private List<Producto_entrante> findProducto_entranteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto_entrante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Producto_entrante findProducto_entrante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto_entrante.class, id);
        } finally {
            em.close();
        }
    }

    public int getProducto_entranteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto_entrante> rt = cq.from(Producto_entrante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
