package hu.cs.se.adjva.projectmanagement.service;

import java.util.List;

import hu.cs.se.adjva.projectmanagement.model.Jeep;

/**
 * JeepService
 */
public interface JeepService {

    Jeep addJeeps(Jeep jeep);

	List<Jeep> getAllJeeps();

	Jeep getJeepById(Integer id);

	void deleteJeepById(Integer id);

	
}