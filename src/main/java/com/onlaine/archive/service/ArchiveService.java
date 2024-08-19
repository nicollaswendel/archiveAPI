package com.onlaine.archive.service;

import com.onlaine.archive.domain.Archive;
import com.onlaine.archive.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchiveService {

    @Autowired
    private ArchiveRepository archiveRepository;

    public List<Archive> listAll(){
        return (List<Archive>) archiveRepository.findAll(); // Cast, pois o findAll retorna "iterable", mas o método espera uma "list".
    }

    public Archive save(Archive archive){
        return archiveRepository.save(archive);
    }

    public Optional<Archive> getById(int id) {
        return archiveRepository.findById(id);
    }

    public Optional<Archive> getByName(String name) {
        return archiveRepository.findByName(name);
    }

    public void delete(int id) {
        archiveRepository.deleteById(id);
    }
}
