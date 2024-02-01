package com.example.jpa.controller;

import com.example.jpa.entity.Shift;
import com.example.jpa.entity.ShiftType;
import com.example.jpa.entity.ShiftUser;
import com.example.jpa.entity.User;
import com.example.jpa.service.ShiftService;
import com.example.jpa.service.ShiftTypeService;
import com.example.jpa.service.ShiftUserService;
import com.example.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class AllController {

    @Autowired
    private UserService userService;
    @Autowired
    private ShiftService shiftService;
    @Autowired
    private ShiftTypeService shiftTypeService;
    @Autowired
    private ShiftUserService shiftUserService;

    @PostMapping("/shift")
    public Shift addShift(@RequestBody Shift shift){
        log.info("object of type shift addedd");
        return shiftService.saveShift(shift);
    }

    @GetMapping("/shift/top/user")
    public ResponseEntity<List<Shift>> findTop3Shifts() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 1, 25);

        List<Shift> top3Shifts = shiftService.findTop3Shifts(startDate, endDate);

        return ResponseEntity.ok(top3Shifts);
    }

    @PostMapping("/shifttype")
    public ShiftType addShiftType(@RequestBody ShiftType shiftType){
        log.info("object of type shiftype added");
        return shiftTypeService.saveShiftType(shiftType);
    }

    @PostMapping("/shiftuser")
    public ShiftUser createShiftUser(@RequestBody ShiftUser shiftUser){
        log.info("addedd shift user");
        return shiftUserService.saveShiftUser(shiftUser);
    }

    @DeleteMapping("/delete/shiftuser/{id}")
    public ResponseEntity<String> deleteShiftUser(@PathVariable UUID id){
        try {
            shiftUserService.deleteShiftUser(id);
            return ResponseEntity.ok("shift user deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/postUser")
    public User createUser(@RequestBody User user) {
        log.info("user added");
        return userService.saveUser(user);
    }
    @GetMapping("/getalluser")
    public Page<User> findAllUsers(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "50") int size) {
        page = Math.max(page, 0);
        size = Math.min(Math.max(size, 1), 50);

        Pageable pageable = PageRequest.of(page, size);
        return userService.findAll(pageable);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUsername(@PathVariable UUID userId, @RequestBody String userName) {
        try {
            log.info("user updated successfully");
            userService.updateUserName(userName, userId);
            return ResponseEntity.ok("Username updated successfully for user with ID " + userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
