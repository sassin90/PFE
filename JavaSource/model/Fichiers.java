package model;

import java.io.Serializable;
import java.nio.file.Path;

public class Fichiers implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 240545116337689611L;
 /*   private String model;
    private int year;
    private String manufacturer;
    private String color;
    private int price;*/
    private int numero;
    private String url;
    private String nom;
    private String date;
    private String folder;
    
    private Path name;
    private Path chemin;

  /*  public Fichiers(String model, int year, String manufacturer, String color) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.color = color;
    }

    public Fichiers(Path url, int year, String manufacturer, String color, int price) {
        this.url = url;
        this.year = year;
        this.manufacturer = manufacturer;
        this.color = color;
        this.price = price;
    }*/

   public Fichiers( String nom, String folder, String date,String url) {
        
        this.nom=nom;
    	this.folder=folder;
    	this.date=date;
    	this.url=url;
    }
    
   /* public Fichiers( Path name, String folder, String date, Path chemin) {
    	
        this.name=name;
    	this.folder=folder;
    	this.date=date;
    	this.chemin=chemin;
		
	}*/
    
   /*public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Fichiers))
            return false;

        Fichiers compare = (Fichiers) obj;

        return compare.model.equals(this.model);
    }

    @Override
    public int hashCode() {
        int hash = 1;

        return hash * 31 + model.hashCode();
    }

    @Override
    public String toString() {
        return "Car{" + "model=" + model + ", year=" + year + ", manufacturer=" + manufacturer + ", color=" + color + ", price=" + price + '}';
    }*/

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public Path getName() {
		return name;
	}

	public void setName(Path name) {
		this.name = name;
	}

	public Path getChemin() {
		return chemin;
	}

	public void setChemin(Path chemin) {
		this.chemin = chemin;
	}
}