package com.example.inventory;
import javax.persistence.*;
import javax.persistence.Lob;
@Entity
public class Image {
    @Id
    @GeneratedValue
    Integer id;
    @Lob
    String data;
    @Column(unique=true)
    Integer itemId;

    String type;
    public Image() {}


    public Image( String type, String data, Integer itemId) {
        this.id = id;
        this.data = data;
        this.itemId = itemId;
        this.type  = type;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData( String data ) {
        this.data = data;
    }


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getType() {
        return type;
    }

}
