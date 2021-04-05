package com.pawelwlazlo.dentalclinic.controller;

import com.pawelwlazlo.dentalclinic.model.Room;
import com.pawelwlazlo.dentalclinic.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {


    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRoom(){
        List<Room> roomList = roomService.findAllRoom();


        return new ResponseEntity<>(roomList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id) {
        Room room = roomService.findRoomById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {

        Room newRoom = roomService.updateRoom(room);

        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        Room updateRoom = roomService.updateRoom(room);
        return new ResponseEntity<>(updateRoom, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoomById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
