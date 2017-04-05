package org.rbc.document.repository;

import org.rbc.document.model.Configuration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lena on 2017-04-04.
 */
public interface ConfigurationRepository extends JpaRepository<Configuration,Long> {

    @Cacheable
    Configuration findByAppCodeAndVersion(String appCode, String version);

    @Cacheable
    @Query("select c.version from Configuration c where c.appCode = :appCode order by c.updatedDate desc")
    List<String> findAvailableVersions(@Param("appCode") String appCode);
}
