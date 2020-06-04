package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.Packaging;

import java.util.List;
import java.util.Optional;

public interface PackagingService {

    Optional<List<Packaging>> getAllPackagings();

    Optional<Packaging> getPackagingById(Long id);

    Optional<Packaging> saveOrUpdatePackaging(Packaging packaging);

    Optional<Packaging> updatePackagingById(Long id);

    void deletePackaging(Long id);
}
