package com.example.ProjetS2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjetS2.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public  Role  findByRoleName(String code);
}
