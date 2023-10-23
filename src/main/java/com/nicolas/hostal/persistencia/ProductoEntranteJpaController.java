/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolas.hostal.persistencia;

import com.nicolas.hostal.modelo.ProductoEntrante;
import com.nicolas.hostal.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author NICOLAS
 */
public class ProductoEntranteJpaController implements Serializable {

    public ProductoEntranteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductoEntrante productoEntrante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoEntrante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductoEntrante productoEntrante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoEntrante = em.merge(productoEntrante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = productoEntrante.getId();
                if (findProductoEntrante(id) == null) {
                    throw new NonexistentEntityException("The productoEntrante with id " + id + " no longer exists.");
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
            ProductoEntrante productoEntrante;
            try {
                productoEntrante = em.getReference(ProductoEntrante.class, id);
                productoEntrante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoEntrante with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoEntrante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductoEntrante> findProductoEntranteEntities() {
        return findProductoEntranteEntities(true, -1, -1);
    }

    public List<ProductoEntrante> findProductoEntranteEntities(int maxResults, int firstResult) {
        return findProductoEntranteEntities(false, maxResults, firstResult);
    }

    private List<ProductoEntrante> findProductoEntranteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductoEntrante.class));
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

    public ProductoEntrante findProductoEntrante(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoEntrante.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoEntranteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductoEntrante> rt = cq.from(ProductoEntrante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
