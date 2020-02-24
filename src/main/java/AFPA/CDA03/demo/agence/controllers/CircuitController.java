/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.agence.controllers;

import AFPA.CDA03.demo.agence.dao.CircuitDao;
import java.net.URI;
import java.util.List;
import AFPA.CDA03.demo.agence.models.Circuit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Acer
 */
/*
L’annotation @RestController marque la classe en tant que contrôleur
où chaque méthode renvoie un objet de type JSON, en lieu et place d'une vue.
Cette annotation est à utiliser lorsque l’on développe des services REST.
Si l’on veut afficher des templates (vues html), il faut utiliser l’annotation @Controller.
*/
@RestController
public class CircuitController {
/*    
L’annotation @Autowired injecte la dépendance de l’objet implicitement.
Dans notre cas, Spring va créer une instance de l’objet CircuitDao
et l’injecter dans la variable mesCircuits.    
*/
//appel du Dao
    @Autowired
    CircuitDao mesCircuits;
/*
@GetMapping("/route")  permet de définir la route en méthode GET.
Cette annotation est équivalente à
@RequestMapping(value="/route", method=RequestMethod.GET)
*/
@GetMapping("/circuits")
    //liste des produits
    public List<Circuit> listeCircuits() {
        return mesCircuits.findAll();
    } 
    
/*
    @PathVariable sert à récupérer dans une variable le paramètre passé au niveau de la route
*/    
@GetMapping("/circuits/{id}")
    //détail d'un produit
    public Circuit listeCircuits(@PathVariable int id) {
        return mesCircuits.findById(id); 
    }
    //ajout d’un produit
    @PostMapping("/circuits")
    /*
    @RequestBody sert à récupérer l’objet passé dans le corps de la requête
    (ici, le circuit que l’on veut créer ou modifier).
    */
    public ResponseEntity<Void> ajouterCircuit(@RequestBody Circuit c) {
        Circuit newCircuit = mesCircuits.save(c);
        //renvoie un status à 204 (nocontent)
        if (newCircuit == null)
            return ResponseEntity.noContent().build();
        //ce qui suit sert à renvoyer un status à 201 (et non pas 200)
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() .path("/{id}")
                .buildAndExpand(newCircuit.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }    
    //suppression d’un circuit
    @DeleteMapping("/circuits/{id}")
    public void deleteCircuits(@PathVariable int id) {
        mesCircuits.deleteById(id); }
    //modification d’un circuit
    @PutMapping("/circuits") 
    public void modifierCircuit(@RequestBody Circuit c) { 
        mesCircuits.save(c);
    }    
} 


