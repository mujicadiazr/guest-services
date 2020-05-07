package com.mujicaservices.course.guestservices.repository;

import com.mujicaservices.course.guestservices.domain.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
