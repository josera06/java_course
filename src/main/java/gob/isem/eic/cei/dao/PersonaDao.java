package gob.isem.eic.cei.dao;

import gob.isem.eic.cei.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
