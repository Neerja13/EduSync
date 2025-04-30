package org.example.repository;

import org.example.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClassRoom,String> {

}
