package mx.edu.itsuruapan.admnistracionderedes;

public class ListElementListar {
    public String idL;
    public String name;
    public String description;
    public String cuantity;

    public ListElementListar(String idL, String name, String description, String cuantity) {
        this.idL = idL;
        this.name = name;
        this.description = description;
        this.cuantity = cuantity;
    }

    public String getId() {
        return idL;
    }

    public void setId(String id) {
        this.idL = idL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuantity() {
        return cuantity;
    }

    public void setCuantity(String cuantity) {
        this.cuantity = cuantity;
    }

}
