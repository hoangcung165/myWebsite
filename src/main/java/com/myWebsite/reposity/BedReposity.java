package com.myWebsite.reposity;

import com.myWebsite.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedReposity extends JpaRepository<Bed,Long> {

}
