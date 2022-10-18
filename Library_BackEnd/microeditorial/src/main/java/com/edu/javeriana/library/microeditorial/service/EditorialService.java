package com.edu.javeriana.library.microeditorial.service;

import com.edu.javeriana.library.microeditorial.domain.Editorial;
import com.edu.javeriana.library.microeditorial.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {

    @Autowired
    EditorialRepository editorialRepository;

    public List<Editorial> findAllEditorials() {
        return editorialRepository.findAll();
    }

    public void saveEditorial(Editorial editorial) {
        editorialRepository.save(editorial);
    }

    public void deleteEditorial(int id) {
        editorialRepository.deleteById(id);
    }

    public void updateEditorial(Editorial editorial) {
        editorialRepository.save(editorial);
    }
}
