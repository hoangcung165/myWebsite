package com.myWebsite.reposity;

import com.myWebsite.entity.RoomName;
import com.myWebsite.entity.TypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomNameReposity extends JpaRepository<RoomName,Long> {
    List<RoomName> findAllByTypeRoom(TypeRoom typeRoom);
}
