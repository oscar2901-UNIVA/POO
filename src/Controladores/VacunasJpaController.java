/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Vacunas;
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
public class VacunasJpaController implements Serializable {

    public VacunasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public VacunasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("covid19PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vacunas vacunas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vacunas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vacunas vacunas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vacunas = em.merge(vacunas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vacunas.getId();
                if (findVacunas(id) == null) {
                    throw new NonexistentEntityException("The vacunas with id " + id + " no longer exists.");
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
            Vacunas vacunas;
            try {
                vacunas = em.getReference(Vacunas.class, id);
                vacunas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vacunas with id " + id + " no longer exists.", enfe);
            }
            em.remove(vacunas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vacunas> findVacunasEntities() {
        return findVacunasEntities(true, -1, -1);
    }

    public List<Vacunas> findVacunasEntities(int maxResults, int firstResult) {
        return findVacunasEntities(false, maxResults, firstResult);
    }

    private List<Vacunas> findVacunasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vacunas.class));
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

    public Vacunas findVacunas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vacunas.class, id);
        } finally {
            em.close();
        }
    }

    public int getVacunasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vacunas> rt = cq.from(Vacunas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
