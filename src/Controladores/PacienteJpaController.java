/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Vacunas;
import Entidades.Medicamentos;
import Entidades.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author oscar
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PacienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("covid19PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vacunas idVacunaPaciente = paciente.getIdVacunaPaciente();
            if (idVacunaPaciente != null) {
                idVacunaPaciente = em.getReference(idVacunaPaciente.getClass(), idVacunaPaciente.getId());
                paciente.setIdVacunaPaciente(idVacunaPaciente);
            }
            Medicamentos idMedicamento = paciente.getIdMedicamento();
            if (idMedicamento != null) {
                idMedicamento = em.getReference(idMedicamento.getClass(), idMedicamento.getId());
                paciente.setIdMedicamento(idMedicamento);
            }
            em.persist(paciente);
            if (idVacunaPaciente != null) {
                idVacunaPaciente.getPacienteList().add(paciente);
                idVacunaPaciente = em.merge(idVacunaPaciente);
            }
            if (idMedicamento != null) {
                idMedicamento.getPacienteList().add(paciente);
                idMedicamento = em.merge(idMedicamento);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getId());
            Vacunas idVacunaPacienteOld = persistentPaciente.getIdVacunaPaciente();
            Vacunas idVacunaPacienteNew = paciente.getIdVacunaPaciente();
            Medicamentos idMedicamentoOld = persistentPaciente.getIdMedicamento();
            Medicamentos idMedicamentoNew = paciente.getIdMedicamento();
            if (idVacunaPacienteNew != null) {
                idVacunaPacienteNew = em.getReference(idVacunaPacienteNew.getClass(), idVacunaPacienteNew.getId());
                paciente.setIdVacunaPaciente(idVacunaPacienteNew);
            }
            if (idMedicamentoNew != null) {
                idMedicamentoNew = em.getReference(idMedicamentoNew.getClass(), idMedicamentoNew.getId());
                paciente.setIdMedicamento(idMedicamentoNew);
            }
            paciente = em.merge(paciente);
            if (idVacunaPacienteOld != null && !idVacunaPacienteOld.equals(idVacunaPacienteNew)) {
                idVacunaPacienteOld.getPacienteList().remove(paciente);
                idVacunaPacienteOld = em.merge(idVacunaPacienteOld);
            }
            if (idVacunaPacienteNew != null && !idVacunaPacienteNew.equals(idVacunaPacienteOld)) {
                idVacunaPacienteNew.getPacienteList().add(paciente);
                idVacunaPacienteNew = em.merge(idVacunaPacienteNew);
            }
            if (idMedicamentoOld != null && !idMedicamentoOld.equals(idMedicamentoNew)) {
                idMedicamentoOld.getPacienteList().remove(paciente);
                idMedicamentoOld = em.merge(idMedicamentoOld);
            }
            if (idMedicamentoNew != null && !idMedicamentoNew.equals(idMedicamentoOld)) {
                idMedicamentoNew.getPacienteList().add(paciente);
                idMedicamentoNew = em.merge(idMedicamentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getId();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
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
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            Vacunas idVacunaPaciente = paciente.getIdVacunaPaciente();
            if (idVacunaPaciente != null) {
                idVacunaPaciente.getPacienteList().remove(paciente);
                idVacunaPaciente = em.merge(idVacunaPaciente);
            }
            Medicamentos idMedicamento = paciente.getIdMedicamento();
            if (idMedicamento != null) {
                idMedicamento.getPacienteList().remove(paciente);
                idMedicamento = em.merge(idMedicamento);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
