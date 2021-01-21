package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.Produk;

public interface ProdukRepository  extends JpaRepository<Produk, Integer>{

}
