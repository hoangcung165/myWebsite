package com.myWebsite.reposity;

import com.myWebsite.entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomReposity extends CrudRepository<Room,Long> {

}
