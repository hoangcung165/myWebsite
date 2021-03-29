package com.myWebsite.service;

import com.myWebsite.constant.SystemConstant;
import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Image;
import com.myWebsite.random.RandomString;
import com.myWebsite.reposity.ImageRepository;
import com.myWebsite.service.Interface.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository repository;

    @Autowired
    ServletContext servletContext;
    @Override
    public Image uploadImage(CommonsMultipartFile file) {
        try{
            String path= SystemConstant.url_store;
            String filename=file.getOriginalFilename();
            String randomEx=generateNewFileName();
            File fileEx=new File(path+randomEx+filename);
            while (fileEx.exists()){
                randomEx=generateNewFileName();
                fileEx=new File(path+randomEx+filename);
            }
            copyToTarget(file,randomEx+filename);
            FileOutputStream fileOutputStream=new FileOutputStream(fileEx);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            byte barr[]= file.getBytes();
            bufferedOutputStream.write(barr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            Image image=new Image();
            image.setUrl(randomEx+filename);

            repository.save(image);
            return image;
        }catch (Exception e){
            return null;}

    }

    @Override
    public Image findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void uploadForApartment(CommonsMultipartFile file, Apartment apartment) {
        Image image=uploadImage(file);
        image.setApartment_img(apartment);
        repository.save(image);
    }

    private String generateNewFileName(){
        RandomString randomString=new RandomString();
        String random=randomString.getAlphaNumericString(10);
        return random;
    }

    private void copyToTarget(CommonsMultipartFile file,String name){

        String path=servletContext.getRealPath("template/static/uploadfile/");

        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(
                    new File(path+name)));
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
