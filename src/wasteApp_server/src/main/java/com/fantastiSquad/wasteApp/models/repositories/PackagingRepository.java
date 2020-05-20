package com.fantastiSquad.wasteApp.models.repositories;

import com.fantastiSquad.wasteApp.models.entities.Packaging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackagingRepository extends JpaRepository<Packaging, Long> {

}
