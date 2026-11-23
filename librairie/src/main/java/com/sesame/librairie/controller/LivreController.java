package com.sesame.librairie.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import com.sesame.librairie.model.Livre;
import com.sesame.librairie.service.LivreService;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Livres", description = "Gestion des livres de la librairie")
@RestController
@RequestMapping("/api/livres")
public class LivreController {
    private final LivreService livreService;

    // Injection par constructeur : Spring fournit le service
    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }
    @GetMapping
    public List<Livre> lister(
            @RequestParam(name = "auteur", required = false) String auteur) {
        return livreService.lister(auteur);
    }
    @GetMapping("/nombre")
    public int compter() {
        return livreService.compter();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livre> trouver(@PathVariable("id") Long id) {
        return livreService.trouver(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Créer un livre")
    @PostMapping
    public ResponseEntity<Livre> creer(@Valid @RequestBody Livre livre) {
        Livre cree = livreService.enregistrer(livre);
        URI adresse = URI.create("/api/livres/" + cree.getId());
        return ResponseEntity.created(adresse).body(cree);
    }

    @Operation(summary = "Modifier un livre")
    @PutMapping("/{id}")
    public ResponseEntity<Livre> modifier(@PathVariable Long id, @Valid @RequestBody
    Livre livre) {
        return livreService.modifier(id, livre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Supprimer un livre")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (!livreService.supprimer(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
