package fr.univsavoie.voyages;

import javax.persistence.Id;


public class VoyageList {

	@Id private long id;
	private String name;
	private int[] idVoyages;
	
	public VoyageList() {
		
	}
	
	public VoyageList(String name, int[] idVoyages) {
		this.name = name;
		this.setIdVoyages(idVoyages);
	}

	public int[] getIdVoyages() {
		return idVoyages;
	}

	public void setIdVoyages(int[] idVoyages) {
		this.idVoyages = idVoyages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
