package com.example.demo.dao;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommodityDAO extends JpaRepository<Commodity,Integer> {
    List<Commodity> findAllByCategory(Category category);
    List<Commodity> findAllByNameLikeOrSellerLike(String keyword1, String keyword2);
}
