
package hu.cs.se.adjva.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cs.se.adjva.projectmanagement.model.benz;
import hu.cs.se.adjva.projectmanagement.service.BenzService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class benzController {
    @Autowired
    private BenzService benzService;
    // Get All Benzs
    @GetMapping("/benz/allBenz")
    public ResponseEntity<List<benz>> getBenz(){
        
        List<benz> Benzs = benzService.getAllBenzs();
        return new ResponseEntity<>(Benzs,HttpStatus.OK);
    }
    //--------------------------------------------------------------------
    // add Benz
    @PostMapping("/benz/AddBenz")
    public ResponseEntity<benz> AddBenz(@RequestBody benz Benz){

    benz savedBenz = benzService.AddBenz(Benz);
        return new ResponseEntity<>(savedBenz,HttpStatus.CREATED);
}
//----------------------------------------------------------
    //get a Benz With id
    @GetMapping("/benz/{id}")
    public ResponseEntity<benz> getBenz(@PathVariable("id") Integer id){
      benz Benz =  benzService.getBenzById(id);
      return new ResponseEntity<>(Benz,HttpStatus.OK);

}
// updateing a benz
    @PutMapping("/benz/update")
    public ResponseEntity<benz> updateBenz(@RequestBody benz Benz){

        benz savedBenz = benzService.AddBenz(Benz);
            return new ResponseEntity<>(savedBenz,HttpStatus.OK);
    }

// Delete a Benz
    @DeleteMapping("/benz/{id}/delete")
    public ResponseEntity<String> deleteBenz(@PathVariable("id") Integer id){
        benzService.deleteBenzById(id);
        return new ResponseEntity<>("Benz " +id + "deleted",HttpStatus.OK); 

    }
} 