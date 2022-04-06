package Entity;

public class Evenement {

    private String id;
    private String dateEvent;
    private String type;
    private String lieu;
    private String personnes;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getDateEvent(){
        return dateEvent;
    }
    public void setDateEvent(String dateEvent){
        this.dateEvent = dateEvent;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getLieu(){
        return lieu;
    }
    public void setLieu(String lieu){
        this.lieu = lieu;
    }

    public String getPersonnes(){
        return personnes;
    }
    public void setPersonnes(String personnes){
        this.personnes = personnes;
    }
}
