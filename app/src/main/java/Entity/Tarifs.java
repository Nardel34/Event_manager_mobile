package Entity;

public class Tarifs {

    private String id;
    private String TrancheAge;
    private String Prix;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getTrancheAge(){
        return TrancheAge;
    }
    public void setTrancheAge(String trancheAge){
        this.TrancheAge = trancheAge;
    }

    public String getPrix(){
        return Prix;
    }
    public void setPrix(String prix){
        this.Prix = prix;
    }
}
