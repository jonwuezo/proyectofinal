package com.proyectofinal.controller;

import com.proyectofinal.service.ReporteService;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @GetMapping("/principal")
    public String principal(Model model) {
        Calendar fecha = Calendar.getInstance();
        String fechaIni = "" + (fecha.get(Calendar.YEAR) - 1) + "-0101";

        String strMes = (fecha.get(Calendar.MONTH) < 10 ? "0" : "")
                + fecha.get(Calendar.MONTH);
        String strDia = (fecha.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "")
                + fecha.get(Calendar.DAY_OF_MONTH);
        String fechaFin = "" + fecha.get(Calendar.YEAR) + "-" + strMes + "-" + strDia;

        model.addAttribute("fechaInicio", fechaIni);
        model.addAttribute("fechaFin", fechaFin);
        return "/reporte/principal";
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Resource> reporteClientes(@RequestParam String tipo)
            throws IOException {
        var reporte = "usuarios";
        return reporteService.generaReporte(reporte, null, tipo);
    }

    @GetMapping("/ventas")
    public ResponseEntity<Resource> reporteVentas(@RequestParam String tipo)
            throws IOException {
        var reporte = "ventas";
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/cobrar")
    public ResponseEntity<Resource> reporteCuentasCobrar(@RequestParam String tipo)
            throws IOException {
        var reporte = "cobrar";
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/pagar")
    public ResponseEntity<Resource> reporteCuentasPagar(@RequestParam String tipo)
            throws IOException {
        var reporte = "pagar";
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/cuentas")
    public ResponseEntity<Resource> reporteCuentaClientes(@RequestParam String tipo)
            throws IOException {
        var reporte = "cuentas";
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/retencion")
    public ResponseEntity<Resource> reporteRetencionClientes(@RequestParam String tipo)
            throws IOException {
        var reporte = "retencion";
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/compras")
    public ResponseEntity<Resource> reporteCompras(@RequestParam String tipo)
            throws IOException {
        var reporte = "compras";
        return reporteService.generaReporte(reporte, null, tipo);
    }

    @GetMapping("/ventasTotales")
    public ResponseEntity<Resource> reporteVentasTotales(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte = "ventasTotales";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
    
    @GetMapping("/reportesComerciales")
    public ResponseEntity<Resource> reporteComercial(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte = "reportesComerciales";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
    
    @GetMapping("/Rventas")
    public ResponseEntity<Resource> reporteVentas(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte = "ventas";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
    
    @GetMapping("/proveedores")
    public ResponseEntity<Resource> reporteProveedores(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte = "proveedores";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
    
    @GetMapping("/utilidadClientes")
    public ResponseEntity<Resource> reporteUtilidadClientes(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte = "utilidadClientes";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }
    
    @GetMapping("/utilidad")
    public ResponseEntity<Resource> reporteUtilidad(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);
        var reporte = "utilidad";
        return reporteService.generaReporte(reporte, parametros, tipo);
    }

}
