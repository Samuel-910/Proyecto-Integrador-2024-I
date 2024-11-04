package com.example.mspracticante.controller;

import com.example.mspracticante.entity.PersoConvo;
import com.example.mspracticante.entity.Practicante;
import com.example.mspracticante.repository.PracticanteRepository;
import com.example.mspracticante.service.PersoConvoService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/persoconvo")
public class PersoConvoController {


    @Autowired
    private PersoConvoService persoConvoService;

    @Autowired
    private PracticanteRepository practicanteRepository;

    private static final String UPLOAD_DIR = "uploads/";

    // Listar todos los registros
    @GetMapping
    public ResponseEntity<List<PersoConvo>> listar() {
        List<PersoConvo> persoConvos = persoConvoService.listar();
        return ResponseEntity.ok(persoConvos);
    }

    // Buscar un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<PersoConvo> buscarPorId(@PathVariable Integer id) {
        try {
            PersoConvo persoConvo = persoConvoService.buscarPorId(id);
            return ResponseEntity.ok(persoConvo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPersoConvo(@RequestParam("documento") MultipartFile documento,
                                               @RequestParam("descripcion") String descripcion,
                                               @RequestParam("practicanteId") Integer practicanteId) {
        try {
            // Crear la carpeta de subida si no existe
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Guardar el archivo en el sistema de archivos
            String fileName = documento.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(documento.getInputStream(), filePath);

            // Crear el objeto PersoConvo y guardar la información en la base de datos
            PersoConvo persoConvo = new PersoConvo();
            persoConvo.setDocumento(fileName); // Guardar solo el nombre del archivo
            persoConvo.setDescripcion(descripcion);
            persoConvo.setEstado("En proceso"); // Estado predeterminado

            Practicante practicante = practicanteRepository.findById(practicanteId)
                    .orElseThrow(() -> new RuntimeException("Practicante no encontrado"));
            persoConvo.setPracticante(practicante);

            persoConvoService.guardar(persoConvo);

            return ResponseEntity.ok("Convocatoria guardada exitosamente.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la convocatoria.");
        }
    }

    // Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<PersoConvo> actualizar(@PathVariable Integer id, @RequestBody PersoConvo persoConvo) {
        try {
            persoConvo.setId(id);
            PersoConvo persoConvoActualizado = persoConvoService.actualizar(persoConvo);
            return ResponseEntity.ok(persoConvoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un registro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            persoConvoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> descargarArchivo(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Path copyLocation = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok("Archivo subido exitosamente: " + file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("No se pudo subir el archivo: " + e.getMessage());
        }
    }
}
