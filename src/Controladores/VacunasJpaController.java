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
import Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import Entidades.Farmacia;
import Entidades.Hospital;
import Entidades.Vacunas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        if (vacunas.getPacienteList() == null) {
            vacunas.setPacienteList(new ArrayList<Paciente>());
        }
        if (vacunas.getFarmaciaList() == null) {
            vacunas.setFarmaciaList(new ArrayList<Farmacia>());
        }
        if (vacunas.getHospitalList() == null) {
            vacunas.setHospitalList(new ArrayList<Hospital>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Paciente> attachedPacienteList = new ArrayList<Paciente>();
            for (Paciente pacienteListPacienteToAttach : vacunas.getPacienteList()) {
                pacienteListPacienteToAttach = em.getReference(pacienteListPacienteToAttach.getClass(), pacienteListPacienteToAttach.getId());
                attachedPacienteList.add(pacienteListPacienteToAttach);
            }
            vacunas.setPacienteList(attachedPacienteList);
            List<Farmacia> attachedFarmaciaList = new ArrayList<Farmacia>();
            for (Farmacia farmaciaListFarmaciaToAttach : vacunas.getFarmaciaList()) {
                farmaciaListFarmaciaToAttach = em.getReference(farmaciaListFarmaciaToAttach.getClass(), farmaciaListFarmaciaToAttach.getId());
                attachedFarmaciaList.add(farmaciaListFarmaciaToAttach);
            }
            vacunas.setFarmaciaList(attachedFarmaciaList);
            List<Hospital> attachedHospitalList = new ArrayList<Hospital>();
            for (Hospital hospitalListHospitalToAttach : vacunas.getHospitalList()) {
                hospitalListHospitalToAttach = em.getReference(hospitalListHospitalToAttach.getClass(), hospitalListHospitalToAttach.getId());
                attachedHospitalList.add(hospitalListHospitalToAttach);
            }
            vacunas.setHospitalList(attachedHospitalList);
            em.persist(vacunas);
            for (Paciente pacienteListPaciente : vacunas.getPacienteList()) {
                Vacunas oldIdVacunaPacienteOfPacienteListPaciente = pacienteListPaciente.getIdVacunaPaciente();
                pacienteListPaciente.setIdVacunaPaciente(vacunas);
                pacienteListPaciente = em.merge(pacienteListPaciente);
                if (oldIdVacunaPacienteOfPacienteListPaciente != null) {
                    oldIdVacunaPacienteOfPacienteListPaciente.getPacienteList().remove(pacienteListPaciente);
                    oldIdVacunaPacienteOfPacienteListPaciente = em.merge(oldIdVacunaPacienteOfPacienteListPaciente);
                }
            }
            for (Farmacia farmaciaListFarmacia : vacunas.getFarmaciaList()) {
                Vacunas oldIdVacunaFarmaciaOfFarmaciaListFarmacia = farmaciaListFarmacia.getIdVacunaFarmacia();
                farmaciaListFarmacia.setIdVacunaFarmacia(vacunas);
                farmaciaListFarmacia = em.merge(farmaciaListFarmacia);
                if (oldIdVacunaFarmaciaOfFarmaciaListFarmacia != null) {
                    oldIdVacunaFarmaciaOfFarmaciaListFarmacia.getFarmaciaList().remove(farmaciaListFarmacia);
                    oldIdVacunaFarmaciaOfFarmaciaListFarmacia = em.merge(oldIdVacunaFarmaciaOfFarmaciaListFarmacia);
                }
            }
            for (Hospital hospitalListHospital : vacunas.getHospitalList()) {
                Vacunas oldIdVacunaHospitalesOfHospitalListHospital = hospitalListHospital.getIdVacunaHospitales();
                hospitalListHospital.setIdVacunaHospitales(vacunas);
                hospitalListHospital = em.merge(hospitalListHospital);
                if (oldIdVacunaHospitalesOfHospitalListHospital != null) {
                    oldIdVacunaHospitalesOfHospitalListHospital.getHospitalList().remove(hospitalListHospital);
                    oldIdVacunaHospitalesOfHospitalListHospital = em.merge(oldIdVacunaHospitalesOfHospitalListHospital);
                }
            }
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
            Vacunas persistentVacunas = em.find(Vacunas.class, vacunas.getId());
            List<Paciente> pacienteListOld = persistentVacunas.getPacienteList();
            List<Paciente> pacienteListNew = vacunas.getPacienteList();
            List<Farmacia> farmaciaListOld = persistentVacunas.getFarmaciaList();
            List<Farmacia> farmaciaListNew = vacunas.getFarmaciaList();
            List<Hospital> hospitalListOld = persistentVacunas.getHospitalList();
            List<Hospital> hospitalListNew = vacunas.getHospitalList();
            List<Paciente> attachedPacienteListNew = new ArrayList<Paciente>();
            for (Paciente pacienteListNewPacienteToAttach : pacienteListNew) {
                pacienteListNewPacienteToAttach = em.getReference(pacienteListNewPacienteToAttach.getClass(), pacienteListNewPacienteToAttach.getId());
                attachedPacienteListNew.add(pacienteListNewPacienteToAttach);
            }
            pacienteListNew = attachedPacienteListNew;
            vacunas.setPacienteList(pacienteListNew);
            List<Farmacia> attachedFarmaciaListNew = new ArrayList<Farmacia>();
            for (Farmacia farmaciaListNewFarmaciaToAttach : farmaciaListNew) {
                farmaciaListNewFarmaciaToAttach = em.getReference(farmaciaListNewFarmaciaToAttach.getClass(), farmaciaListNewFarmaciaToAttach.getId());
                attachedFarmaciaListNew.add(farmaciaListNewFarmaciaToAttach);
            }
            farmaciaListNew = attachedFarmaciaListNew;
            vacunas.setFarmaciaList(farmaciaListNew);
            List<Hospital> attachedHospitalListNew = new ArrayList<Hospital>();
            for (Hospital hospitalListNewHospitalToAttach : hospitalListNew) {
                hospitalListNewHospitalToAttach = em.getReference(hospitalListNewHospitalToAttach.getClass(), hospitalListNewHospitalToAttach.getId());
                attachedHospitalListNew.add(hospitalListNewHospitalToAttach);
            }
            hospitalListNew = attachedHospitalListNew;
            vacunas.setHospitalList(hospitalListNew);
            vacunas = em.merge(vacunas);
            for (Paciente pacienteListOldPaciente : pacienteListOld) {
                if (!pacienteListNew.contains(pacienteListOldPaciente)) {
                    pacienteListOldPaciente.setIdVacunaPaciente(null);
                    pacienteListOldPaciente = em.merge(pacienteListOldPaciente);
                }
            }
            for (Paciente pacienteListNewPaciente : pacienteListNew) {
                if (!pacienteListOld.contains(pacienteListNewPaciente)) {
                    Vacunas oldIdVacunaPacienteOfPacienteListNewPaciente = pacienteListNewPaciente.getIdVacunaPaciente();
                    pacienteListNewPaciente.setIdVacunaPaciente(vacunas);
                    pacienteListNewPaciente = em.merge(pacienteListNewPaciente);
                    if (oldIdVacunaPacienteOfPacienteListNewPaciente != null && !oldIdVacunaPacienteOfPacienteListNewPaciente.equals(vacunas)) {
                        oldIdVacunaPacienteOfPacienteListNewPaciente.getPacienteList().remove(pacienteListNewPaciente);
                        oldIdVacunaPacienteOfPacienteListNewPaciente = em.merge(oldIdVacunaPacienteOfPacienteListNewPaciente);
                    }
                }
            }
            for (Farmacia farmaciaListOldFarmacia : farmaciaListOld) {
                if (!farmaciaListNew.contains(farmaciaListOldFarmacia)) {
                    farmaciaListOldFarmacia.setIdVacunaFarmacia(null);
                    farmaciaListOldFarmacia = em.merge(farmaciaListOldFarmacia);
                }
            }
            for (Farmacia farmaciaListNewFarmacia : farmaciaListNew) {
                if (!farmaciaListOld.contains(farmaciaListNewFarmacia)) {
                    Vacunas oldIdVacunaFarmaciaOfFarmaciaListNewFarmacia = farmaciaListNewFarmacia.getIdVacunaFarmacia();
                    farmaciaListNewFarmacia.setIdVacunaFarmacia(vacunas);
                    farmaciaListNewFarmacia = em.merge(farmaciaListNewFarmacia);
                    if (oldIdVacunaFarmaciaOfFarmaciaListNewFarmacia != null && !oldIdVacunaFarmaciaOfFarmaciaListNewFarmacia.equals(vacunas)) {
                        oldIdVacunaFarmaciaOfFarmaciaListNewFarmacia.getFarmaciaList().remove(farmaciaListNewFarmacia);
                        oldIdVacunaFarmaciaOfFarmaciaListNewFarmacia = em.merge(oldIdVacunaFarmaciaOfFarmaciaListNewFarmacia);
                    }
                }
            }
            for (Hospital hospitalListOldHospital : hospitalListOld) {
                if (!hospitalListNew.contains(hospitalListOldHospital)) {
                    hospitalListOldHospital.setIdVacunaHospitales(null);
                    hospitalListOldHospital = em.merge(hospitalListOldHospital);
                }
            }
            for (Hospital hospitalListNewHospital : hospitalListNew) {
                if (!hospitalListOld.contains(hospitalListNewHospital)) {
                    Vacunas oldIdVacunaHospitalesOfHospitalListNewHospital = hospitalListNewHospital.getIdVacunaHospitales();
                    hospitalListNewHospital.setIdVacunaHospitales(vacunas);
                    hospitalListNewHospital = em.merge(hospitalListNewHospital);
                    if (oldIdVacunaHospitalesOfHospitalListNewHospital != null && !oldIdVacunaHospitalesOfHospitalListNewHospital.equals(vacunas)) {
                        oldIdVacunaHospitalesOfHospitalListNewHospital.getHospitalList().remove(hospitalListNewHospital);
                        oldIdVacunaHospitalesOfHospitalListNewHospital = em.merge(oldIdVacunaHospitalesOfHospitalListNewHospital);
                    }
                }
            }
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
            List<Paciente> pacienteList = vacunas.getPacienteList();
            for (Paciente pacienteListPaciente : pacienteList) {
                pacienteListPaciente.setIdVacunaPaciente(null);
                pacienteListPaciente = em.merge(pacienteListPaciente);
            }
            List<Farmacia> farmaciaList = vacunas.getFarmaciaList();
            for (Farmacia farmaciaListFarmacia : farmaciaList) {
                farmaciaListFarmacia.setIdVacunaFarmacia(null);
                farmaciaListFarmacia = em.merge(farmaciaListFarmacia);
            }
            List<Hospital> hospitalList = vacunas.getHospitalList();
            for (Hospital hospitalListHospital : hospitalList) {
                hospitalListHospital.setIdVacunaHospitales(null);
                hospitalListHospital = em.merge(hospitalListHospital);
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
