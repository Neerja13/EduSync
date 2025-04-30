package org.example.service;

import org.example.model.ClassRoom;
import org.example.repository.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepo classRoomRepo;

    public void saveClassRoom(ClassRoom classRoom) {
        String seatRow = classRoom.getSeatRow();
        if (seatRow == null || seatRow.isEmpty()) {
            throw new IllegalArgumentException("seatRow cannot be null or empty");
        }

        int singleCapacity = 0;
        for (char ch : seatRow.toCharArray()) {
            singleCapacity += ch - '0';  // Add the capacity based on the seatRow input
        }

        classRoom.setSingleCapacity(singleCapacity);
        classRoom.setDoubleCapacity(2 * singleCapacity);
        classRoomRepo.save(classRoom);
    }

    public ClassRoom useClassRoom(String classNo){
        System.out.println("Searching for ClassRoom with classNo: " + classNo);
        return classRoomRepo.findById(classNo).orElse(null);
    }

    public Boolean alreadyExist(String classNo){
        return classRoomRepo.findById(classNo).isPresent();
    }
}
