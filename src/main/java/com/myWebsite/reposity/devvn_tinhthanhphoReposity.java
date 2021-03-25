package com.myWebsite.reposity;

import com.myWebsite.entity.devvn_tinhthanhpho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface devvn_tinhthanhphoReposity extends JpaRepository<devvn_tinhthanhpho,String> {
    devvn_tinhthanhpho findByMatp(String mtp);

}
