/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolas.hostal.persistencia;

import com.nicolas.hostal.modelo.ItemProducto;
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
public class ItemProductoJpaController implements Serializable {

    public ItemProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemProducto itemProducto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itemProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemProducto itemProducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itemProducto = em.merge(itemProducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = itemProducto.getId();
                if (findItemProducto(id) == null) {
                    throw new NonexistentEntityException("The itemProducto with id " + id + " no longer exists.");
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
            ItemProducto itemProducto;
            try {
                itemProducto = em.getReference(ItemProducto.class, id);
                itemProducto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemProducto with id " + id + " no longer exists.", enfe);
            }
            em.remove(itemProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemProducto> findItemProductoEntities() {
        return findItemProductoEntities(true, -1, -1);
    }

    public List<ItemProducto> findItemProductoEntities(int maxResults, int firstResult) {
        return findItemProductoEntities(false, maxResults, firstResult);
    }

    private List<ItemProducto> findItemProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemProducto.class));
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

    public ItemProducto findItemProducto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemProducto> rt = cq.from(ItemProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
