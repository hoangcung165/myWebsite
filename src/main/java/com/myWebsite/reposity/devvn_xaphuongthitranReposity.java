package com.myWebsite.reposity;

import com.myWebsite.entity.devvn_xaphuongthitran;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface devvn_xaphuongthitranReposity extends CrudRepository<devvn_xaphuongthitran,String> {
    List<devvn_xaphuongthitran> findAllByMaqh(String mqh);
    devvn_xaphuongthitran findByXaid(String xaid);
}
