package com.ohgiraffers.section03.projection;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "category_section03")
@Table(name = "tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

}
