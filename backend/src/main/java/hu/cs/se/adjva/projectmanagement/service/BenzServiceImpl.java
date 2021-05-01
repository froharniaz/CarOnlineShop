package hu.cs.se.adjva.projectmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.se.adjva.projectmanagement.model.benz;
import hu.cs.se.adjva.projectmanagement.repository.benzRepository;


@Service
public class BenzServiceImpl implements BenzService {
    @Autowired
    private benzRepository benzRepository;

    @Override
    public benz AddBenz(benz Benz) {

        return benzRepository.save(Benz);
    }

    @Override
    public List<benz> getAllBenzs() {
        
        return benzRepository.findAll();
    }

    @Override
    public benz getBenzById(Integer id) {
      
        return benzRepository.getOne(id);
    }

    @Override
    public void deleteBenzById(Integer id) {
        benzRepository.deleteById(id);

    }
    
}
