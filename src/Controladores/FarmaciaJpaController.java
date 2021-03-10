/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Farmacia;
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
 * @author oscar
 */
public class FarmaciaJpaController implements Serializable {

    public FarmaciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public FarmaciaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("covid19PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Farmacia farmacia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(farmacia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Farmacia farmacia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            farmacia = em.merge(farmacia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = farmacia.getId();
                if (findFarmacia(id) == null) {
                    throw new NonexistentEntityException("The farmacia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Farmacia farmacia;
            try {
                farmacia = em.getReference(Farmacia.class, id);
                farmacia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The farmacia with id " + id + " no longer exists.", enfe);
            }
            em.remove(farmacia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Farmacia> findFarmaciaEntities() {
        return findFarmaciaEntities(true, -1, -1);
    }

    public List<Farmacia> findFarmaciaEntities(int maxResults, int firstResult) {
        return findFarmaciaEntities(false, maxResults, firstResult);
    }

    private List<Farmacia> findFarmaciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Farmacia.class));
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

    public Farmacia findFarmacia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Farmacia.class, id);
        } finally {
            em.close();
        }
    }

    public int getFarmaciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Farmacia> rt = cq.from(Farmacia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
