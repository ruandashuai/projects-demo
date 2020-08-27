package com.example.repository;

import com.example.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = "select * from admin", nativeQuery = true)
    Long test(String adminName);
}
