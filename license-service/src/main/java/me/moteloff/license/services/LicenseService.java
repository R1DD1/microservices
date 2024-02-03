package me.moteloff.license.services;

import lombok.RequiredArgsConstructor;
import me.moteloff.license.config.ServiceConfig;
import me.moteloff.license.modules.License;
import me.moteloff.license.repositories.LicenseRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LicenseService {
    private final MessageSource messageSource;
    private final LicenseRepository licenseRepository;
    private final ServiceConfig serviceConfig;

    public License getLicense(Long licenseId, Long organizationId) {
        License license = licenseRepository.findLicensesByIdAndOrganizationId(licenseId, organizationId).orElseThrow(() -> new IllegalArgumentException(
                String.format(messageSource.getMessage(
                                "license.search.error.message", null, null), licenseId, organizationId)
        ));
        return license.withComment(serviceConfig.getProperty());
    }

    public License createLicense(License license) {
        licenseRepository.save(license);
        return license.withComment(serviceConfig.getProperty());
    }

    public License updateLicense(License license) {
        licenseRepository.save(license);
        return license.withComment(serviceConfig.getProperty());
    }

    public String deleteLicense(Long licenseId, Long organizationId) {
        licenseRepository.deleteLicenseByIdAndOrganizationId(licenseId, organizationId);
        return String.format(messageSource.getMessage("license.delete.message", null, null), licenseId);
    }
}
