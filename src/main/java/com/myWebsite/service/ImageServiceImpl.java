package com.myWebsite.service;

import com.myWebsite.constant.SystemConstant;
import com.myWebsite.entity.Image;
import com.myWebsite.random.RandomString;
import com.myWebsite.reposity.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
@Transactional
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository repository;


    @Override
    public boolean uploadImage(CommonsMultipartFile file) {
        try{
            String path= SystemConstant.url_store;
            String filename=file.getOriginalFilename();
            String randomEx=generateNewFileName();
            File fileEx=new File(path+randomEx+filename);
            while (fileEx.exists()){
                randomEx=generateNewFileName();
                fileEx=new File(path+randomEx+filename);
            }
            FileOutputStream fileOutputStream=new FileOutputStream(fileEx);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            byte barr[]= file.getBytes();
            bufferedOutputStream.write(barr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            Image image=new Image();
            image.setUrl(randomEx+filename);
            repository.save(image);
            return true;
        }catch (Exception e){
            return false;}

    }

    @Override
    public Image findById(Long id) {
        return repository.findById(id).get();
    }

    private String generateNewFileName(){
        RandomString randomString=new RandomString();
        String random=randomString.getAlphaNumericString(10);
        return random;
    }


}
