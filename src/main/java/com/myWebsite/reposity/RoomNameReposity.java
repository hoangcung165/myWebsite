package com.myWebsite.reposity;

import com.myWebsite.entity.RoomName;
import org.springframework.data.repository.CrudRepository;

public interface RoomNameReposity extends CrudRepository<RoomName,Long> {
}
