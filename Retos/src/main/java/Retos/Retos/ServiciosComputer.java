package Retos.Retos;

import Retos.Retos.Computer;
import Retos.Retos.RepositorioComputer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosComputer {
     @Autowired
    private RepositorioComputer metodosCrud;

    public List<Computer> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Computer> getComputer(int computerId) {
        return metodosCrud.getComputer(computerId);
    }

    public Computer save(Computer computer){
        if(computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<Computer> e=metodosCrud.getComputer(computer.getId());
            if(e.isEmpty()){
                return metodosCrud.save(computer);
            }else{
                return computer;
            }
        }
    }

    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> e=metodosCrud.getBike(computer.getId());
            if(!e.isEmpty()){
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    e.get().setBrand(computer.getBrand());
                }
                if(computer.getYear()!=null){
                    e.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    e.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    e.get().setCategory(computer.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteBike(int bikeId) {
        Boolean aBoolean = getComputer(bikeId).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    boolean deleteComputer(int computerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}