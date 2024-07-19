package com.ohgiraffers.springdatajpa.menu.model.repository;

import com.ohgiraffers.springdatajpa.menu.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // jpql 작성 시에는 vaule만 작성해도 되지만 native Query 작성시에는
    // 반드시 nativeQuery = ture 속성을 지정해줘야한다.

    // JPQL 사용
    @Query(value = "select c from Category c order by c.categoryCode")
    List<Category> findAllCategoryByJPQL();

    // Native Query 사용
    @Query(value = "select * from tbl_category order by category_code",
            nativeQuery = true)
    List<Category> findAllCategoryByNativeQuery();

}
