package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.TypeDTO;

@Repository
public interface TypeRepo extends JpaRepository<TypeDTO, Long> {

	TypeDTO findTitleByTypeName(String typeName);
}