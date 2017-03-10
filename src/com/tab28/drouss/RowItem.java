package com.tab28.drouss;
public class RowItem {
    private int imageId;
    private String nom;
    private String auteur;
    private String langue;
 
    public RowItem(int imageId, String nom, String auteur, String langue) {
		this.imageId = imageId;
		this.nom = nom;
		this.auteur = auteur;
		this.langue = langue;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	@Override
    public String toString() {
        return nom + "\n" + auteur;
    }
}