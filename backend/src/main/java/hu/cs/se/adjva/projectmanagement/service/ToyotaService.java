

package hu.cs.se.adjva.projectmanagement.service;
import java.util.List;

import hu.cs.se.adjva.projectmanagement.model.Toyota;

public interface ToyotaService  {
    Toyota addToyota(Toyota toyota);
     List<Toyota> getAllToyotas();
     Toyota getToyotaById(Integer id);
     void deleteToyotaById(Integer id);
}

