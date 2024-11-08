package com.una.springbootmall.dao;

import com.una.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
    // 根據productId查詢商品的數據
}
