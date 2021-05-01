package hu.cs.se.adjva.projectmanagement.service;

import java.util.List;

import hu.cs.se.adjva.projectmanagement.model.benz;

/**
 * benzService
 */
public interface BenzService {

    benz AddBenz(benz Benz);

	List<benz> getAllBenzs();

	benz getBenzById(Integer id);

	void deleteBenzById(Integer id);
}