package beans;

import java.io.Serializable;

public class Scale implements Serializable {

    private int id;

    public Scale(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }