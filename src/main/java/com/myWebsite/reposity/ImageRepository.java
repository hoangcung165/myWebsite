package com.myWebsite.reposity;

import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image> findImagesByApartmentImg_Id(Long id);

}
