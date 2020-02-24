/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.agence.dao;

import java.util.ArrayList;
import java.util.List;
import AFPA.CDA03.demo.agence.models.Circuit;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
 
//L’annotation @Repository permet d’indiquer les classes remplissant le rôle de dépôt
//ou d’accès aux données. Elle permet notamment à Spring de gérer automatiquement les exceptions.

@Repository
public class CircuitDao implements ICircuitDao {
    public static List<Circuit> circuits = new ArrayList<>();
    static {
        circuits.add(new Circuit(1, "Tour des villes impériales", "Maroc"));
        circuits.add(new Circuit(2, "Le delta du Mekong", "Vietnam"));
        circuits.add(new Circuit(3, "Treck de l\'Inca", "Pérou")); }
    @Override
    public List<Circuit> findAll() {
        return circuits; } 
    
    @Override
    public Circuit findById(int id) {
        Circuit cherche = null;	
		for (Circuit c : circuits)
		{
			if (c.getId() == id)
			{
				cherche = c;
				break;
			}
		}
		return  cherche;
    }
    // dans cette maquette, la méthode save sert à la fois à la création et à la modification d'un circuit
    // si le circuit n'existe pas, il est crée, sinon il est modifié (nom ou pays)
    @Override
    public Circuit save(Circuit c) {
     if ( (c != null) && (c.getId() > 0 ) && (! c.getNom().isEmpty()))
		{
			Circuit existant = findById(c.getId());
			if (existant != null)
			{
				existant.setNom( c.getNom());
				existant.setPays(c.getPays());
			}
			else
			{		   
				circuits.add( c);
			}
		}
		else 
		{
			c = null;
		}
		return c;   
    }
    
    @Override
    public boolean deleteById(int id) {
        boolean ok = false;
		
		Circuit asupprimer = findById(id);
		if (asupprimer != null)
		{
	    	circuits.remove(asupprimer);
	    	ok = true;
		}
		return ok;
    }
    
}
