package com.onlaine.archive.repository;

import com.onlaine.archive.domain.Archive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArchiveRepository extends CrudRepository<Archive, Integer> {
    Optional<Archive> findByName(String name);
}
