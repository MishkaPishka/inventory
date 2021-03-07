package com.example.inventory;



import com.example.inventory.exceptions.InvalidCreatingException;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {
    private @Id @GeneratedValue Long id;
    private      @Column(unique = true) @GeneratedValue (strategy = GenerationType.AUTO)     @Basic(optional = false)
    int inventoryCode;
    private @Column(unique = true)     @Basic(optional = false) String name;
    private int quantity;

    public Item() {}

    Item(String name, int quantity, int inventoryCode) throws InvalidCreatingException {
        if (quantity < 0) {
            throw new InvalidCreatingException(name, quantity);
        }
        this.name = name;
        this.quantity = quantity;
        this.inventoryCode = inventoryCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int amount) {
        this.quantity = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(int inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public JSONObject toJsonObject() {
        JSONObject jo = new JSONObject();
        jo.put("name",this.name);
        jo.put("id", String.valueOf(this.id) );
        jo.put("quantity",String.valueOf(this.quantity));
        jo.put("inventoryCode",String.valueOf(this.inventoryCode));

        return jo;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return this.id.equals(item.id) && this.inventoryCode == (item.inventoryCode) && this.name.equals(item.name) && this.quantity == item.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.inventoryCode, this.name, this.quantity);
    }

//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", inventoryCode=" + inventoryCode +
//                ", name='" + name + '\'' +
//                ", amount='" + amount + '\'' +
//                '}';
//    }


}
