package com.ohgiraffers.section08.namedquery;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "menu_section08")
@Table(name = "tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
// @NamedQuery 정적쿼리를 정의하는 사용되는 어노테이션
// JPQL을 미리 엔티티 클래스에 정의를 해둠으로써 재사용성을 높일 수 있다.
@NamedQueries({
        @NamedQuery(
                name = "section08.namedquery.Menu.findAll", // 쿼리 이름
                query= """
                select m from menu_section08 m
                """ // 쿼리 정의
        ),
        // findByMenuName -> 메뉴이름으로 메뉴 찾아오는 JPQL
        // 메뉴 이름을 파라미터로받고, 일치하는 메뉴객체를 반환하는 JPQL
        @NamedQuery(name = "section08.namedquery.Menu.findByMenuName",
                query = """
                        select m from menu_section08 m where menuName = :menuName
                        """

        ),
        // 메뉴이름에 "밥"이 들어간 메뉴를 전부 전부 조회하는 JPQL
        @NamedQuery(name = "section08.namedquery.Menu.findByMenuNameLike",
                query = """
                        select m from menu_section08 m where m.menuName like concat('%', :menuName, '%')
                        """

        )
})
public class Menu {

    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

   @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;
}
