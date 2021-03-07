package com.example.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ItemRepository extends JpaRepository<Item, Long>, QueryByExampleExecutor<Item> {
    @Query("SELECT u FROM Item u WHERE  u.name = :name")
    Item getItemByName( String name );

    @Query("SELECT u FROM Item u WHERE  u.inventoryCode = :inventoryCode")
    Item getItemByInventoryCode( int inventoryCode );
}
