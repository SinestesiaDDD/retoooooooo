package Retos.Retos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioComputer {
    
    @Autowired
    private InterfaceComputer crud;

    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();
    }

    public Optional<Computer> getBike(int id){
        return crud.findById(id);
    }

    public Computer save(Computer computer){
        return crud.save(computer);
    }
    public void delete(Computer computer){
        crud.delete(computer);
    }

    Optional<Computer> getComputer(int computerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
