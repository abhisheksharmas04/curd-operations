package com.example.curd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curd.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}

/*the spring boot generate in memory implmentation classes for our IToruist Interface having tourist entity class based mapping
persistance logic for all methods available on inheriated for JPA Repository.*/

/*The king of in memory classes will be generated in-memory (where application runs nothing but JVM memory of RAM).
In JVM Memory Heap is for objects, Stacks is for methods and local variables, Premgen/metaspace for in-memory code generation.*/