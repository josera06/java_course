package gob.isem.eic.cei.dao;

import gob.isem.eic.cei.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long>{
    
}
