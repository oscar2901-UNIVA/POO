/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Hospital;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Vacunas;
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
public class HospitalJpaController implements Serializable {

    public HospitalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public HospitalJpaController() {
        this.emf = Persistence.createEntityManagerFactory("covid19PU");
    }
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Hospital hospital) {
        if (hospital.getPacienteList() == null) {
            hospital.setPacienteList(new ArrayList<Paciente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vacunas idVacunaHospitales = hospital.getIdVacunaHospitales();
            if (idVacunaHospitales != null) {
                idVacunaHospitales = em.getReference(idVacunaHospitales.getClass(), idVacunaHospitales.getId());
                hospital.setIdVacunaHospitales(idVacunaHospitales);
            }
            List<Paciente> attachedPacienteList = new ArrayList<Paciente>();
            for (Paciente pacienteListPacienteToAttach : hospital.getPacienteList()) {
                pacienteListPacienteToAttach = em.getReference(pacienteListPacienteToAttach.getClass(), pacienteListPacienteToAttach.getId());
                attachedPacienteList.add(pacienteListPacienteToAttach);
            }
            hospital.setPacienteList(attachedPacienteList);
            em.persist(hospital);
            if (idVacunaHospitales != null) {
                idVacunaHospitales.getHospitalList().add(hospital);
                idVacunaHospitales = em.merge(idVacunaHospitales);
            }
            for (Paciente pacienteListPaciente : hospital.getPacienteList()) {
                Hospital oldIdHospitalesOfPacienteListPaciente = pacienteListPaciente.getIdHospitales();
                pacienteListPaciente.setIdHospitales(hospital);
                pacienteListPaciente = em.merge(pacienteListPaciente);
                if (oldIdHospitalesOfPacienteListPaciente != null) {
                    oldIdHospitalesOfPacienteListPaciente.getPacienteList().remove(pacienteListPaciente);
                    oldIdHospitalesOfPacienteListPaciente = em.merge(oldIdHospitalesOfPacienteListPaciente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Hospital hospital) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hospital persistentHospital = em.find(Hospital.class, hospital.getId());
            Vacunas idVacunaHospitalesOld = persistentHospital.getIdVacunaHospitales();
            Vacunas idVacunaHospitalesNew = hospital.getIdVacunaHospitales();
            List<Paciente> pacienteListOld = persistentHospital.getPacienteList();
            List<Paciente> pacienteListNew = hospital.getPacienteList();
            if (idVacunaHospitalesNew != null) {
                idVacunaHospitalesNew = em.getReference(idVacunaHospitalesNew.getClass(), idVacunaHospitalesNew.getId());
                hospital.setIdVacunaHospitales(idVacunaHospitalesNew);
            }
            List<Paciente> attachedPacienteListNew = new ArrayList<Paciente>();
            for (Paciente pacienteListNewPacienteToAttach : pacienteListNew) {
                pacienteListNewPacienteToAttach = em.getReference(pacienteListNewPacienteToAttach.getClass(), pacienteListNewPacienteToAttach.getId());
                attachedPacienteListNew.add(pacienteListNewPacienteToAttach);
            }
            pacienteListNew = attachedPacienteListNew;
            hospital.setPacienteList(pacienteListNew);
            hospital = em.merge(hospital);
            if (idVacunaHospitalesOld != null && !idVacunaHospitalesOld.equals(idVacunaHospitalesNew)) {
                idVacunaHospitalesOld.getHospitalList().remove(hospital);
                idVacunaHospitalesOld = em.merge(idVacunaHospitalesOld);
            }
            if (idVacunaHospitalesNew != null && !idVacunaHospitalesNew.equals(idVacunaHospitalesOld)) {
                idVacunaHospitalesNew.getHospitalList().add(hospital);
                idVacunaHospitalesNew = em.merge(idVacunaHospitalesNew);
            }
            for (Paciente pacienteListOldPaciente : pacienteListOld) {
                if (!pacienteListNew.contains(pacienteListOldPaciente)) {
                    pacienteListOldPaciente.setIdHospitales(null);
                    pacienteListOldPaciente = em.merge(pacienteListOldPaciente);
                }
            }
            for (Paciente pacienteListNewPaciente : pacienteListNew) {
                if (!pacienteListOld.contains(pacienteListNewPaciente)) {
                    Hospital oldIdHospitalesOfPacienteListNewPaciente = pacienteListNewPaciente.getIdHospitales();
                    pacienteListNewPaciente.setIdHospitales(hospital);
                    pacienteListNewPaciente = em.merge(pacienteListNewPaciente);
                    if (oldIdHospitalesOfPacienteListNewPaciente != null && !oldIdHospitalesOfPacienteListNewPaciente.equals(hospital)) {
                        oldIdHospitalesOfPacienteListNewPaciente.getPacienteList().remove(pacienteListNewPaciente);
                        oldIdHospitalesOfPacienteListNewPaciente = em.merge(oldIdHospitalesOfPacienteListNewPaciente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = hospital.getId();
                if (findHospital(id) == null) {
                    throw new NonexistentEntityException("The hospital with id " + id + " no longer exists.");
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
            Hospital hospital;
            try {
                hospital = em.getReference(Hospital.class, id);
                hospital.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hospital with id " + id + " no longer exists.", enfe);
            }
            Vacunas idVacunaHospitales = hospital.getIdVacunaHospitales();
            if (idVacunaHospitales != null) {
                idVacunaHospitales.getHospitalList().remove(hospital);
                idVacunaHospitales = em.merge(idVacunaHospitales);
            }
            List<Paciente> pacienteList = hospital.getPacienteList();
            for (Paciente pacienteListPaciente : pacienteList) {
                pacienteListPaciente.setIdHospitales(null);
                pacienteListPaciente = em.merge(pacienteListPaciente);
            }
            em.remove(hospital);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hospital> findHospitalEntities() {
        return findHospitalEntities(true, -1, -1);
    }

    public List<Hospital> findHospitalEntities(int maxResults, int firstResult) {
        return findHospitalEntities(false, maxResults, firstResult);
    }

    private List<Hospital> findHospitalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hospital.class));
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

    public Hospital findHospital(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hospital.class, id);
        } finally {
            em.close();
        }
    }

    public int getHospitalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hospital> rt = cq.from(Hospital.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
