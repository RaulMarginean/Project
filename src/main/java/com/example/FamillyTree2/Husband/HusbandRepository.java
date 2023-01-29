package com.example.FamillyTree2.Husband;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HusbandRepository extends JpaRepository<Husband, Long> {}
