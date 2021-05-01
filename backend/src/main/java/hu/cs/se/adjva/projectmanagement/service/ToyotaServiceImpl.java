    
package hu.cs.se.adjva.projectmanagement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.se.adjva.projectmanagement.model.Toyota;
import hu.cs.se.adjva.projectmanagement.repository.ToyotaRepository;

/**
 * ToyotaServiceImpl
 */
@Service
public class ToyotaServiceImpl implements ToyotaService{
@Autowired
private ToyotaRepository toyotaRepository;

@Override
public Toyota addToyota(Toyota toyota){

    return toyotaRepository.save(toyota);
}
@Override

public List<Toyota> getAllToyotas(){
    return toyotaRepository.findAll();
}
@Override
public Toyota getToyotaById(Integer id){
    return toyotaRepository.getOne(id);
}
@Override
public void deleteToyotaById(Integer id){
    toyotaRepository.deleteById(id);

}
    

}
