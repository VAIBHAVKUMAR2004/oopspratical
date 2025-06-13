package com.example.volunteer.controller;

import com.example.volunteer.entity.Volunteer;
import com.example.volunteer.service.VolunteerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Volunteer> getAllVolunteers() {
        return service.getAllVolunteers();
    }

    @GetMapping("/{id}")
    public Volunteer getVolunteerById(@PathVariable Long id) {
        return service.getVolunteerById(id);
    }

    @GetMapping("/available")
    public List<Volunteer> getAvailableVolunteers() {
        return service.getAvailableVolunteers();
    }

    @PostMapping
    public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {
        return service.saveVolunteer(volunteer);
    }

    @PutMapping("/{id}")
    public Volunteer updateVolunteer(@PathVariable Long id, @RequestBody Volunteer volunteer) {
        return service.updateVolunteer(id, volunteer);
    }

    @DeleteMapping("/{id}")
    public void deleteVolunteer(@PathVariable Long id) {
        service.deleteVolunteer(id);
    }
}
