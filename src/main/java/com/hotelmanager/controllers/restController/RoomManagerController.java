package com.hotelmanager.controllers.restController;

import com.hotelmanager.models.room.Room;
import com.hotelmanager.services.intface.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomManagerController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> findAllRooms() {
        List<Room> rooms = roomService.findAll();
        if (rooms.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> findRoomById(@PathVariable Long id) {
        Room room = roomService.findOne(id);
        if (room == null) {
            return new ResponseEntity<>(null,
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@RequestBody Room room, UriComponentsBuilder builder) {
        roomService.save(room);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(room.getId()).toUri());
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rooms/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Room> updateRoom(
            @PathVariable("id") Long id,
            @RequestBody Room room) {
        Room currentRoom = roomService.findOne(id);

        if (currentRoom == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentRoom.setNumber(room.getNumber());
        currentRoom.setRoomRank(room.getRoomRank());
        currentRoom.setFoStatus(room.getFoStatus());
        currentRoom.setHkStatus(room.getHkStatus());
        currentRoom.setView(room.getView());
        roomService.save(currentRoom);
        return new ResponseEntity<>(currentRoom, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Room> deleteRoom(
            @PathVariable("id") Long id) {
        Room room = roomService.findOne(id);
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        roomService.delete(room.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
