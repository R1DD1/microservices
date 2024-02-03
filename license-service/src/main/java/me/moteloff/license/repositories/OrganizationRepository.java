package me.moteloff.license.repositories;

import me.moteloff.license.modules.License;
import me.moteloff.license.modules.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
