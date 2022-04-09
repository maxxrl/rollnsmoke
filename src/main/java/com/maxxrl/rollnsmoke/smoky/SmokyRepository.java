package com.maxxrl.rollnsmoke.smoky;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmokyRepository extends JpaRepository<Smoky, Long> {
    @Query("SELECT smoky FROM Smoky smoky WHERE smoky.name = :name")
    Optional<Smoky> findSmokyByName(@Param("name") final String name);
}
