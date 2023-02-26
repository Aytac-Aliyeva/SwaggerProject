package com.example.swaggerproject.repository;

import com.example.swaggerproject.entity.IcecreamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcecreamRepository extends JpaRepository <IcecreamEntity, Long> {
}
