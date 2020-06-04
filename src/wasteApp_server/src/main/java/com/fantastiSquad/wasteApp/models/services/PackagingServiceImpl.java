package com.fantastiSquad.wasteApp.models.services;

import com.fantastiSquad.wasteApp.models.entities.Packaging;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "PackagingServiceImpl")
public class PackagingServiceImpl implements PackagingService {
    @Override
    public Optional<List<Packaging>> getAllPackagings() {
        return Optional.empty();
    }

    @Override
    public Optional<Packaging> getPackagingById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Packaging> saveOrUpdatePackaging(Packaging packaging) {
        return Optional.empty();
    }

    @Override
    public Optional<Packaging> updatePackagingById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deletePackaging(Long id) {

    }
}
