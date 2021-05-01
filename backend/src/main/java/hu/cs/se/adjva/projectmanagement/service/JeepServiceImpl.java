package hu.cs.se.adjva.projectmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.se.adjva.projectmanagement.model.Jeep;
import hu.cs.se.adjva.projectmanagement.repository.JeepRepository;

/**
 * JeepServiceImpl
 */
@Service
public class JeepServiceImpl implements JeepService {
    
    @Autowired
    private JeepRepository jeepRepository;
    @Override
    public Jeep addJeeps(Jeep jeep) {

        return jeepRepository.save(jeep);
    }
    @Override
    public List<Jeep> getAllJeeps() {
        return jeepRepository.findAll();
    }
    @Override
    public Jeep getJeepById(Integer id) {

        return jeepRepository.getOne(id);
    }

    @Override
    public void deleteJeepById(Integer id) {
        jeepRepository.deleteById(id);
    }

}