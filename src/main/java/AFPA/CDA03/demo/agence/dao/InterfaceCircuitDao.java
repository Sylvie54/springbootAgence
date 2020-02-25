/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.agence.dao;

import java.util.List;
import AFPA.CDA03.demo.agence.models.Circuits;
import org.springframework.data.jpa.repository.JpaRepository;
 

/**
 *
 * @author Acer
 */
public interface InterfaceCircuitDao extends JpaRepository<Circuits, Integer> {
    //List<Circuit> findAll();
    // liste des Circuits dont le pays contient recherche
    List<Circuits> findByPaysLike(String recherche);
    // recherche des Circuits dont le nom de circuit est nom
    List<Circuits> findByNom (String nom);
    
    Circuits findById(int id);
    //Circuit save(Circuits c);
    // boolean deleteById (int id);
}
