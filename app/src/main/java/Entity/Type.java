package Entity;

import java.util.List;

public class Type {
    private String id;
    private String nomType;
    private String description;
    private List<String> evenements;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getNomtype(){
        return nomType;
    }
    public void setNomType(String nomType){
        this.nomType = nomType;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
