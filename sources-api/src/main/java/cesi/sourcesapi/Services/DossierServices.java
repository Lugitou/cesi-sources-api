package cesi.sourcesapi.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cesi.sourcesapi.Model.Dossier;
import cesi.sourcesapi.Model.Utilisateur;
import cesi.sourcesapi.Repository.DossierRepository;
import cesi.sourcesapi.Repository.UtilisateurRepository;

@Service
public class DossierServices {

	@Autowired
	private DossierRepository dossierRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public Set<Dossier> getDossiers(int idUtilisateur, int idDossierParent) {
		Utilisateur user = utilisateurRepository.findById(idUtilisateur);
		Dossier parent = dossierRepository.findByIdAndUtilisateur(idDossierParent, user);
		return parent.getDossiersEnfant();
	}
	
	public boolean createDossier(int idUtilisateur, int idDossierParent, String name, int statut) {
		Utilisateur user = utilisateurRepository.findById(idUtilisateur);
		Dossier parent = dossierRepository.findByIdAndUtilisateur(idDossierParent, user);
		
		try {
			// TODO : Gestion des statuts
			Dossier dossier = new Dossier(name, String.valueOf(statut), user);
			parent.addDossierEnfant(dossier);
			dossierRepository.save(dossier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
