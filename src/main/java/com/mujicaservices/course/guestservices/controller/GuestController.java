package com.mujicaservices.course.guestservices.controller;

import com.mujicaservices.course.guestservices.domain.Guest;
import com.mujicaservices.course.guestservices.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/guests")
public class GuestController {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<Guest> getAllGuests(){
        return guestRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{guestId}", produces = "application/json")
    public Guest getById(@PathVariable(name = "guestId") long guestId){
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new NoSuchElementException("Guest is not present!"));
    }
}
