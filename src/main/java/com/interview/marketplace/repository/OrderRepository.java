package com.interview.marketplace.repository;

import com.interview.marketplace.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Viral Shingala
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByBuyerId(int buyerId);

    List<Order> findAllBySellerId(int sellerId);
}
