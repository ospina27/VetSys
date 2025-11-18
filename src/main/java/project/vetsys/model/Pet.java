package project.vetsys.model;

import java.sql.Date;

public class Pet {
    
    private int id_pet;
    private int id_Client;
    private int id_Clinic;
    private Clinic clinic;
    private ClienteModel client;
    private String name_Pet;
    private String species;
    private String bred; ///raza
    private String color;
    private String sex;
    private Date date_of_birth;

    public Pet(int id_pet, ClienteModel client, Clinic clinic, String name_Pet, 
            String species, String bred, String color, String sex, Date date_of_birth) {
        this.id_pet = id_pet;
        this.client = client;
        this.clinic = clinic;
        this.name_Pet = name_Pet;
        this.species = species;
        this.bred = bred;
        this.color = color;
        this.sex = sex;
        this.date_of_birth = date_of_birth;
        
    }
    
    public Pet(){
        
    }

    public ClienteModel getClient() {
        return client;
    }

    public void setClient(ClienteModel client) {
        this.client = client;
    }
    
    

    public int getId_Clinic() {
        return id_Clinic;
    }

    public void setId_Clinic(int id_Clinic) {
        this.id_Clinic = id_Clinic;
    }
   
    public int getId_pet() {
        return id_pet;
    }

    public void setId_pet(int id_pet) {
        this.id_pet = id_pet;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public String getName_Pet() {
        return name_Pet;
    }

    public void setName_Pet(String name_Pet) {
        this.name_Pet = name_Pet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBred() {
        return bred;
    }

    public void setBred(String bred) {
        this.bred = bred;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

         
     @Override
    public String toString() {
        return "Mascota: " + name_Pet;           
    }
}
