package com.example.inventory;



import com.example.inventory.errors.InvalidCreatingException;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {
    private @Id @GeneratedValue Long id;
    private      @Column(unique = true) @GeneratedValue (strategy = GenerationType.AUTO)
    int inventoryCode;
    private @Column(unique = true) String name;
    private int amount;

    public Item() {}

    Item(String name, int amount, int inventoryCode) throws InvalidCreatingException {
        if (amount < 0) {
            throw new InvalidCreatingException(name, amount);
        }
        this.name = name;
        this.amount = amount;
        this.inventoryCode = inventoryCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return this.id.equals(item.id) && this.inventoryCode == (item.inventoryCode) && this.name.equals(item.name) && this.amount == item.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.inventoryCode, this.name, this.amount);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", inventoryCode=" + inventoryCode +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
