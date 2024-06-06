package com.example.sbars.repositores;

import com.example.sbars.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
// quando productrepository estende jparepository voce passa a utilizar todas ferramentas do mesmo
