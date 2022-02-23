package com.interview.marketplace.repository;

import com.interview.marketplace.entity.Bid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Viral Shingala
 */
public interface BidRepository extends CrudRepository<Bid, Long> {

    @Query(value = "select max(o.pricePerUnit) from Bid o where o.itemId = :itemId")
    Integer getCurrentBidPrice(@Param("itemId") int itemId);

    List<Bid> findAllByUserId(int userId);

//    @Query(value = "select * from Bid where item_id = :itemId and price_per_unit >= :pricePerUnit and quantity <= :quantity order by date_created asc limit 1", nativeQuery = true)
    @Query(value = "select * from Bid where item_id = :itemId and price_per_unit >= :pricePerUnit and quantity <= :quantity order by price_per_unit desc limit 1", nativeQuery = true)
    Bid findFirstMatchingBid(@Param("itemId") int itemId, @Param("pricePerUnit") int pricePerUnit, @Param("quantity") int quantity);
}
