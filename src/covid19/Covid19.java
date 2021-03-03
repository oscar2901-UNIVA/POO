/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

import Controladores.VacunasJpaController;
import Entidades.Vacunas;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author oscar
 */
public class Covid19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        VacunasJpaController vac = new VacunasJpaController();
        List<Vacunas> lista = vac.findVacunasEntities();
        System.out.println(lista.get(0).getNombreDeVacuna());
        
        
        
        
        
        
    }
    
}
