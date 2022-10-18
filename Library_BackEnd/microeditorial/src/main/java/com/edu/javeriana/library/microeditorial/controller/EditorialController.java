package com.edu.javeriana.library.microeditorial.controller;

import com.edu.javeriana.library.microeditorial.domain.Editorial;
import com.edu.javeriana.library.microeditorial.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping("/editoriallist")
    public List<Editorial> findAllEditorials() {
        return editorialService.findAllEditorials();
    }

    @PostMapping("/createeditorial")
    public int createEditorial(@RequestBody Editorial editorial) {
        editorialService.saveEditorial(editorial);
        return editorial.getId();
    }

    @DeleteMapping("/deleteeditorial/{id}")
    public void deleteEditorial(@PathVariable("id") int id) {
        editorialService.deleteEditorial(id);
    }

    @PutMapping("/updateeditorial")
    public Editorial updateEditorial(@RequestBody Editorial editorial) {
        editorialService.updateEditorial(editorial);
        return editorial;
    }
}
