package com.example.mscoordinador.controller;

import com.example.mscoordinador.entity.Convocatoria;
import com.example.mscoordinador.service.ConvocatoriaService;
import com.example.mscoordinador.util.PdfUtils;
import com.example.mscoordinador.util.UserExcelExporter;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/convocatoria")
public class ConvocatoriaController {
    @Autowired
    private ConvocatoriaService convocatoriaService;

    @GetMapping
    public ResponseEntity<List<Convocatoria>> listar() {
        return ResponseEntity.ok(convocatoriaService.listar());
    }

    @PostMapping
    public ResponseEntity<Convocatoria> guardar(@RequestBody Convocatoria convocatoria) {
        return ResponseEntity.ok(convocatoriaService.guardar(convocatoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convocatoria> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(convocatoriaService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Convocatoria> actualizar(@RequestBody Convocatoria convocatoria) {
        return ResponseEntity.ok(convocatoriaService.actualizar(convocatoria));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Convocatoria>> eliminar(@PathVariable(required = true) Integer id) {
        convocatoriaService.eliminar(id);
        return ResponseEntity.ok(convocatoriaService.listar());
    }
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() throws IOException, DocumentException {
        // List<Map<String, Object>> queryResults = myService.executeQuery(request);
        ByteArrayOutputStream pdfStream = PdfUtils.generatePdfStream(convocatoriaService.listar()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=query_results.pdf");
        headers.setContentLength(pdfStream.size());
        return new ResponseEntity<>(pdfStream.toByteArray(), headers, HttpStatus.OK);
    }
    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

            List<Convocatoria> convocatorias = convocatoriaService.listar();

        UserExcelExporter excelExporter = new UserExcelExporter(convocatorias);

        excelExporter.export(response);
    }
}
