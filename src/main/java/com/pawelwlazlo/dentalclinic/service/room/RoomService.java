package com.pawelwlazlo.dentalclinic.service.room;

import com.pawelwlazlo.dentalclinic.exception.room.RoomNotFoundException;
import com.pawelwlazlo.dentalclinic.model.Room;
import com.pawelwlazlo.dentalclinic.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findRoomById(id).orElseThrow(() ->
        new RoomNotFoundException("Room by id " + id + " was not found"));
    }

}
