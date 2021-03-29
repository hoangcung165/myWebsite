package com.myWebsite.service.Interface;

import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Manager;

import java.util.List;

public interface ApartmentService {
    List<Apartment> findAllByOwner(Manager manager);
    boolean save(Apartment apartment);
}
