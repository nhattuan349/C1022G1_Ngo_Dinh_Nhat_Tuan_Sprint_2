package com.example.be.repository;

import com.example.be.dto.IOrderDetailDto;
import com.example.be.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query(value =
            "SELECT p.product_id       as productId, " +
                    "       a.account_id       as accountId, " +
                    "       a.name             as name, " +
                    "       od.order_detail_id as orderDerailId, " +
                    "       od.amount          as amount,  " +
                    "       p.product_image as productImage, " +
                    "       p.product_name  as productName, " +
                    "       p.product_promotional_price as productPromotionalPrice " +
                    "FROM `order_detail` od " +
                    "         JOIN `orders` o on o.order_id = od.order_id " +
                    "         JOIN `account` a on a.account_id = o.account_id " +
                    "         join `product` p on p.product_id = od.product_id " +
                    "WHERE a.account_id = :id " +
                    "AND od.flag_delete = false " +
                    "ORDER BY od.order_detail_id desc",
            countQuery =
                    "SELECT p.product_id       as productId, " +
                            "       a.account_id       as accountId, " +
                            "       a.name             as name, " +
                            "       od.order_detail_id as orderDerailId, " +
                            "       od.amount          as amount,  " +
                            "       p.product_image as productImage, " +
                            "       p.product_name  as productName, " +
                            "       p.product_promotional_price as productPromotionalPrice " +
                            "FROM `order_detail` od " +
                            "         JOIN `orders` o on o.order_id = od.order_id " +
                            "         JOIN `account` a on a.account_id = o.account_id " +
                            "         join `product` p on p.product_id = od.product_id " +
                            "WHERE a.account_id = :id " +
                            "AND od.flag_delete = false " +
                            "ORDER BY od.order_detail_id desc",
            nativeQuery = true
    )
    Page<IOrderDetailDto> findAllDetailDto(@Param("id") Long id, Pageable pageable);



    @Transactional
    @Modifying
    @Query(value =
            "update order_detail\n" +
                    "set order_detail.amount = order_detail.amount + 1 " +
                    "where order_detail.order_detail_id = :id", nativeQuery = true)
    void increaseQuantity(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(value =
            "update order_detail\n" +
                    "set order_detail.amount = order_detail.amount - 1 " +
                    "where order_detail.order_detail_id = :id", nativeQuery = true)
    void decreaseQuantity(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update order_detail set flag_delete=true where order_detail_id = :id",
            countQuery = "update order_detail set flag_delete=true where order_detail_id = :id"
            , nativeQuery = true)
    void removeOrderDetail(@Param("id") Long id);

    @Query(value =
            "SELECT p.product_id       as productId, " +
                    "       a.account_id       as accountId, " +
                    "       a.name             as name, " +
                    "       od.order_detail_id as orderDerailId, " +
                    "       od.amount          as amount,  " +
                    "       p.product_image as productImage, " +
                    "       p.product_name  as productName, " +
                    "       p.product_promotional_price as productPromotionalPrice " +
                    "FROM `order_detail` od " +
                    "         JOIN `orders` o on o.order_id = od.order_id " +
                    "         JOIN `account` a on a.account_id = o.account_id " +
                    "         join `product` p on p.product_id = od.product_id " +
                    "         join order_detail d on o.order_id = d.order_id " +
                    "WHERE a.account_id = :accountId " +
                    "AND od.flag_delete = false ",
            countQuery =
                    "SELECT p.product_id       as productId, " +
                            "       a.account_id       as accountId, " +
                            "       a.name             as name, " +
                            "       od.order_detail_id as orderDerailId, " +
                            "       od.amount          as amount,  " +
                            "       p.product_image as productImage, " +
                            "       p.product_name  as productName, " +
                            "       p.product_promotional_price as productPromotionalPrice " +
                            "FROM `order_detail` od " +
                            "         JOIN `orders` o on o.order_id = od.order_id " +
                            "         JOIN `account` a on a.account_id = o.account_id " +
                            "         join `product` p on p.product_id = od.product_id " +
                            "         join order_detail d on o.order_id = d.order_id " +
                            "WHERE a.account_id = :accountId " +
                            "AND od.flag_delete = false ",
            nativeQuery = true
    )
    List<IOrderDetailDto> findAllListDetailDto(@Param("accountId") Long accountId);

    @Query(value =
            "SELECT " +
                    "       od.order_detail_id as orderDerailId, " +
                    "FROM `order_detail` od " +
                    "WHERE od.order_detail_id =:orderDerailId ",
            nativeQuery = true)
    OrderDetail getOrderDetailFindById(@Param("orderDerailId") Long orderDerailId);

    @Transactional
    @Modifying
    @Query(value =
            "UPDATE product " +
                    "    JOIN order_detail ON product.product_id = order_detail.product_id " +
                    "    JOIN orders o on o.order_id = order_detail.order_id " +
                    "    JOIN account a on a.account_id = o.account_id " +
                    "SET product.product_quantity = product.product_quantity - order_detail.amount, " +
                    "    order_detail.flag_delete = true, " +
                    "    order_detail.flag_buy = true " +
                    "WHERE a.account_id = :accountId " +
                    "AND order_detail.flag_delete = false;",
            countQuery =
                    "UPDATE product " +
                            "    JOIN order_detail ON product.product_id = order_detail.product_id " +
                            "    JOIN orders o on o.order_id = order_detail.order_id " +
                            "    JOIN account a on a.account_id = o.account_id " +
                            "SET product.product_quantity = product.product_quantity - order_detail.amount, " +
                            "    order_detail.flag_delete = true, " +
                            "    order_detail.flag_buy = true " +
                            "WHERE a.account_id = :accountId " +
                            "AND order_detail.flag_delete = false;",
            nativeQuery = true)
    void updateBuySuccess(@Param("accountId") Long accountId);

    @Query(value =
            "SELECT p.product_id       as productId, " +
                    "       a.account_id       as accountId, " +
                    "       a.name             as name, " +
                    "       od.order_detail_id as orderDerailId, " +
                    "       od.order_product_time as orderProductTime, " +
                    "       od.flag_buy as flagBuy, " +
                    "       od.amount          as amount,  " +
                    "       p.product_image as productImage, " +
                    "       p.product_name  as productName, " +
                    "       p.product_promotional_price as productPromotionalPrice " +
                    "FROM `order_detail` od " +
                    "         JOIN `orders` o on o.order_id = od.order_id " +
                    "         JOIN `account` a on a.account_id = o.account_id " +
                    "         join `product` p on p.product_id = od.product_id " +
                    "WHERE a.account_id = :id " +
                    "AND od.flag_buy = true " +
                    "ORDER BY od.order_product_time asc",
            countQuery =
                    "SELECT p.product_id       as productId, " +
                            "       a.account_id       as accountId, " +
                            "       a.name             as name, " +
                            "       od.order_detail_id as orderDerailId, " +
                            "       od.order_product_time as orderProductTime, " +
                            "       od.flag_buy as flagBuy, " +
                            "       od.amount          as amount,  " +
                            "       p.product_image as productImage, " +
                            "       p.product_name  as productName, " +
                            "       p.product_promotional_price as productPromotionalPrice " +
                            "FROM `order_detail` od " +
                            "         JOIN `orders` o on o.order_id = od.order_id " +
                            "         JOIN `account` a on a.account_id = o.account_id " +
                            "         join `product` p on p.product_id = od.product_id " +
                            "WHERE a.account_id = :id " +
                            "AND od.flag_buy = true " +
                            "ORDER BY od.order_product_time asc",
            nativeQuery = true
    )
    Page<IOrderDetailDto> findAllPurchaseHistory(@Param("id") Long id,Pageable pageable);

    @Query(value = "SELECT a.account_id as accountId,\n" +
            "       SUM(od.amount) as totalQuantity \n" +
            "FROM `order_detail` od\n" +
            "         JOIN `orders` o on o.order_id = od.order_id\n" +
            "         JOIN `account` a on a.account_id = o.account_id\n" +
            "         JOIN `product` p on p.product_id = od.product_id\n" +
            "WHERE a.account_id = :id\n" +
            "  AND od.flag_delete = false\n" +
            "GROUP BY a.account_id\n" +
            "ORDER BY totalQuantity DESC", nativeQuery = true)
    IOrderDetailDto getTotal(@Param("id") Long id);

    @Query(value = "select * from order_detail od\n" +
            "                  JOIN `orders` o on o.order_id = od.order_id\n" +
            "                  JOIN `account` a on a.account_id = o.account_id\n" +
            "                  JOIN `product` p on p.product_id = od.product_id\n" +
            "where a.account_id =:id " +
            "AND od.flag_delete = false ",
            countQuery = "select * from order_detail od\n" +
                    "                  JOIN `orders` o on o.order_id = od.order_id\n" +
                    "                  JOIN `account` a on a.account_id = o.account_id\n" +
                    "                  JOIN `product` p on p.product_id = od.product_id\n" +
                    "where a.account_id =:id " +
                    "AND od.flag_delete = false ",
            nativeQuery = true)
    List<IOrderDetailDto> amountShoppingCart(@Param("id") Long id);

}
