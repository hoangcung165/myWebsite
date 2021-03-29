package com.myWebsite.reposity;

import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentReposity extends JpaRepository<Apartment,Long> {
    List<Apartment> findAllByOwner(Manager manager);
}
