package com.example.volunteer.repository;

import com.example.volunteer.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    List<Volunteer> findByAvailabilityTrue();
}
