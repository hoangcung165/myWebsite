package com.myWebsite.service;

import com.myWebsite.entity.Image;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ImageService {
    Image uploadImage(CommonsMultipartFile file);
    Image findById(Long id);
}
