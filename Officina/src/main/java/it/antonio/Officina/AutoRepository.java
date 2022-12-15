package it.antonio.Officina;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AutoRepository extends JpaRepository<Auto, Long>{

	List<Auto> findByTarga(String ricerca);

	List<Auto> findByMarca(String ricerca);

	List<Auto> findByModello(String ricerca);


}
