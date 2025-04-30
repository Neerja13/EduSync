package org.example.controller;

import org.example.model.ClassRoom;
import org.example.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seating_arrangement/class_room")
@CrossOrigin(origins = "http://localhost:5173")
public class ClassRoomController {

    @Autowired
    public ClassRoomService classRoomService;

    @PostMapping("/create/class_room")
    public ResponseEntity<?> createClassRoom(@RequestBody ClassRoom classRoom) {
        // Log the received classRoom object
        System.out.println("Received classRoom: " + classRoom);

        if (classRoom == null) {
            return new ResponseEntity<>("Request body is empty or malformed", HttpStatus.BAD_REQUEST);
        }

        if (classRoom.getSeatRow() == null || classRoom.getSeatRow().isEmpty()) {
            return new ResponseEntity<>("seatRow cannot be null or empty", HttpStatus.BAD_REQUEST);
        }

        Boolean alreadyExist = classRoomService.alreadyExist(classRoom.getClassNo());
        if (alreadyExist) {
            return new ResponseEntity<>("ClassRoom already exists", HttpStatus.BAD_REQUEST);
        }

        classRoomService.saveClassRoom(classRoom);
        return new ResponseEntity<>("ClassRoom Saved", HttpStatus.CREATED);
    }

    @GetMapping("/get/class_room/{classNo}")
    public ResponseEntity<?> getClassRoom(@PathVariable String classNo) {
        // Fetch the classroom details using the provided classNo
        ClassRoom classRoom = classRoomService.useClassRoom(classNo);

        if (classRoom == null) {
            return new ResponseEntity<>("ClassRoom with classNo " + classNo + " not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(classRoom, HttpStatus.OK);
    }


}
