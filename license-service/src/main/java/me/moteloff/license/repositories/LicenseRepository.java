package me.moteloff.license.repositories;

import me.moteloff.license.modules.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
    Optional<License> findLicensesByIdAndOrganizationId(Long licenseId, Long organizationId);

    License deleteLicenseByIdAndOrganizationId (Long licenseId, Long organizationId);
}
