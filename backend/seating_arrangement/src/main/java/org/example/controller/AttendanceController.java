package org.example.controller;
import org.example.dto.AttendanceRequest;
import org.example.dto.SessionRequest;
import org.example.model.Attendance;
import org.example.model.Session;
import org.example.repository.AttendanceRepository;
import org.example.repository.SessionRepository;
import org.example.util.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Autowired
    private SessionRepository sessionRepo;

    @PostMapping("/generate-session")
    public String generateSession(@RequestBody SessionRequest request) {
        String sessionId = UUID.randomUUID().toString();
        sessionRepo.save(new Session(sessionId, request.getClassName()));

        try {
            String filePath = "qrcodes/" + sessionId + ".png";
            QRCodeGenerator.generateQRCodeImage(sessionId, 300, 300, filePath);
        } catch (Exception e) {
            return "Session created, but QR generation failed: " + e.getMessage();
        }

        return sessionId;
    }


    // Student marks attendance
    @PostMapping("/mark-attendance")
    public String markAttendance(@RequestBody AttendanceRequest request) {
        Session session = sessionRepo.findBySessionId(request.getSessionId());

        if (session == null) {
            return "Invalid session ID";
        }

        Attendance attendance = new Attendance(
                request.getEnrollmentNumber(),
                request.getGmail(),
                request.getSessionId(),
                session.getClassName()
        );

        attendanceRepo.save(attendance);
        return "Attendance marked for class: " + session.getClassName();
    }
}
