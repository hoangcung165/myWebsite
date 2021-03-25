package com.myWebsite.reposity;

import com.myWebsite.entity.devvn_quanhuyen;
import com.myWebsite.entity.devvn_tinhthanhpho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface devvn_quanhuyenReposity extends JpaRepository<devvn_quanhuyen,String> {
    List<devvn_quanhuyen> findAllByTinhthanhpho(devvn_tinhthanhpho tp);

    List<devvn_quanhuyen> findAllByMatp(String mtp);
    devvn_quanhuyen findByMaqh(String mqh);
}
