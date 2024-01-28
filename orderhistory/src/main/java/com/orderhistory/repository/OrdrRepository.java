package com.orderhistory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderhistory.entity.OrderEntity;

@Repository
public interface OrdrRepository extends JpaRepository<OrderEntity, Long>
{

}
