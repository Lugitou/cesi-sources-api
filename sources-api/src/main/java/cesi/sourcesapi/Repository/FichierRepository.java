package cesi.sourcesapi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cesi.sourcesapi.Model.Fichier;

public interface FichierRepository extends JpaRepository<Fichier, Integer>{

	List<Fichier> findByNom(String nom);
	
}