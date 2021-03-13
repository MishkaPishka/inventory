package com.example.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Service;

public interface ImageRepository extends JpaRepository<Image, Integer> , QueryByExampleExecutor<Image> {

    @Query("SELECT u FROM Image u WHERE  u.itemId = :id")
    Image getImageByItemID( int id );

}
