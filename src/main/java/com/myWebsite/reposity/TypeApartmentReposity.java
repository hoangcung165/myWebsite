package com.myWebsite.reposity;

import com.myWebsite.entity.TypeApartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeApartmentReposity extends JpaRepository<TypeApartment,Long> {
}
