package Entity;


public class Personnes {

    private String id;
    private String email;
    private String roles;
    private String password;
    private String nom;
    private String prenom;
    private String age;
    private String dateEntree;
    private String diplome;
    private String expPro;
    private String tarif;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getRoles(){
        return roles;
    }
    public void setRoles(String roles){
        this.roles = roles;
    }

    public String getPassword(){
        return id;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age = age;
    }

    public String getDateEntree(){
        return dateEntree;
    }
    public void setDateEntree(String dateEntree){
        this.dateEntree = dateEntree;
    }

    public String getDiplome(){
        return diplome;
    }
    public void setDiplome(String diplome){
        this.diplome = diplome;
    }

    public String getExpPro(){
        return expPro;
    }
    public void setExpPro(String expPro){
        this.expPro = expPro;
    }

    public String getTarif(){
        return tarif;
    }
    public void setTarif(String tarif){
        this.tarif = tarif;
    }
}
