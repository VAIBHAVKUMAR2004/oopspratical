package com.example.volunteer.service;

import com.example.volunteer.entity.Volunteer;
import com.example.volunteer.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    private final VolunteerRepository repository;

    public VolunteerService(VolunteerRepository repository) {
        this.repository = repository;
    }

    public List<Volunteer> getAllVolunteers() {
        return repository.findAll();
    }

    public Volunteer getVolunteerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Volunteer> getAvailableVolunteers() {
        return repository.findByAvailabilityTrue();
    }

    public Volunteer saveVolunteer(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    public Volunteer updateVolunteer(Long id, Volunteer updatedVolunteer) {
        return repository.findById(id).map(v -> {
            v.setName(updatedVolunteer.getName());
            v.setEmail(updatedVolunteer.getEmail());
            v.setAvailability(updatedVolunteer.isAvailability());
            return repository.save(v);
        }).orElse(null);
    }

    public void deleteVolunteer(Long id) {
        repository.deleteById(id);
    }
}
