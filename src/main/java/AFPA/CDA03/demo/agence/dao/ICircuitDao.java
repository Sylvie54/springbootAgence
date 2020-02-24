/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.agence.dao;

import java.util.List;
import AFPA.CDA03.demo.agence.models.Circuit;

/**
 *
 * @author Acer
 */
public interface ICircuitDao {
    List<Circuit> findAll();
    Circuit findById(int id);
    Circuit save(Circuit c);
    boolean deleteById (int id);
}
