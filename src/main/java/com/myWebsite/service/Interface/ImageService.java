package com.myWebsite.service.Interface;

import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Image;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ImageService {
    Image uploadImage(CommonsMultipartFile file);
    Image findById(Long id);
    void uploadForApartment(CommonsMultipartFile file, Apartment apartment);
}
