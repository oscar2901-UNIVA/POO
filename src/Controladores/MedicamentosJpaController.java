/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Medicamentos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author oscar
 */
public class MedicamentosJpaController implements Serializable {

    public MedicamentosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public MedicamentosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("covid19PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medicamentos medicamentos) {
        if (medicamentos.getPacienteList() == null) {
            medicamentos.setPacienteList(new ArrayList<Paciente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Paciente> attachedPacienteList = new ArrayList<Paciente>();
            for (Paciente pacienteListPacienteToAttach : medicamentos.getPacienteList()) {
                pacienteListPacienteToAttach = em.getReference(pacienteListPacienteToAttach.getClass(), pacienteListPacienteToAttach.getId());
                attachedPacienteList.add(pacienteListPacienteToAttach);
            }
            medicamentos.setPacienteList(attachedPacienteList);
            em.persist(medicamentos);
            for (Paciente pacienteListPaciente : medicamentos.getPacienteList()) {
                Medicamentos oldIdMedicamentoOfPacienteListPaciente = pacienteListPaciente.getIdMedicamento();
                pacienteListPaciente.setIdMedicamento(medicamentos);
                pacienteListPaciente = em.merge(pacienteListPaciente);
                if (oldIdMedicamentoOfPacienteListPaciente != null) {
                    oldIdMedicamentoOfPacienteListPaciente.getPacienteList().remove(pacienteListPaciente);
                    oldIdMedicamentoOfPacienteListPaciente = em.merge(oldIdMedicamentoOfPacienteListPaciente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medicamentos medicamentos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medicamentos persistentMedicamentos = em.find(Medicamentos.class, medicamentos.getId());
            List<Paciente> pacienteListOld = persistentMedicamentos.getPacienteList();
            List<Paciente> pacienteListNew = medicamentos.getPacienteList();
            List<Paciente> attachedPacienteListNew = new ArrayList<Paciente>();
            for (Paciente pacienteListNewPacienteToAttach : pacienteListNew) {
                pacienteListNewPacienteToAttach = em.getReference(pacienteListNewPacienteToAttach.getClass(), pacienteListNewPacienteToAttach.getId());
                attachedPacienteListNew.add(pacienteListNewPacienteToAttach);
            }
            pacienteListNew = attachedPacienteListNew;
            medicamentos.setPacienteList(pacienteListNew);
            medicamentos = em.merge(medicamentos);
            for (Paciente pacienteListOldPaciente : pacienteListOld) {
                if (!pacienteListNew.contains(pacienteListOldPaciente)) {
                    pacienteListOldPaciente.setIdMedicamento(null);
                    pacienteListOldPaciente = em.merge(pacienteListOldPaciente);
                }
            }
            for (Paciente pacienteListNewPaciente : pacienteListNew) {
                if (!pacienteListOld.contains(pacienteListNewPaciente)) {
                    Medicamentos oldIdMedicamentoOfPacienteListNewPaciente = pacienteListNewPaciente.getIdMedicamento();
                    pacienteListNewPaciente.setIdMedicamento(medicamentos);
                    pacienteListNewPaciente = em.merge(pacienteListNewPaciente);
                    if (oldIdMedicamentoOfPacienteListNewPaciente != null && !oldIdMedicamentoOfPacienteListNewPaciente.equals(medicamentos)) {
                        oldIdMedicamentoOfPacienteListNewPaciente.getPacienteList().remove(pacienteListNewPaciente);
                        oldIdMedicamentoOfPacienteListNewPaciente = em.merge(oldIdMedicamentoOfPacienteListNewPaciente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medicamentos.getId();
                if (findMedicamentos(id) == null) {
                    throw new NonexistentEntityException("The medicamentos with id " + id + " no longer exists.");
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
            Medicamentos medicamentos;
            try {
                medicamentos = em.getReference(Medicamentos.class, id);
                medicamentos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medicamentos with id " + id + " no longer exists.", enfe);
            }
            List<Paciente> pacienteList = medicamentos.getPacienteList();
            for (Paciente pacienteListPaciente : pacienteList) {
                pacienteListPaciente.setIdMedicamento(null);
                pacienteListPaciente = em.merge(pacienteListPaciente);
            }
            em.remove(medicamentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medicamentos> findMedicamentosEntities() {
        return findMedicamentosEntities(true, -1, -1);
    }

    public List<Medicamentos> findMedicamentosEntities(int maxResults, int firstResult) {
        return findMedicamentosEntities(false, maxResults, firstResult);
    }

    private List<Medicamentos> findMedicamentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medicamentos.class));
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

    public Medicamentos findMedicamentos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medicamentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicamentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medicamentos> rt = cq.from(Medicamentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
