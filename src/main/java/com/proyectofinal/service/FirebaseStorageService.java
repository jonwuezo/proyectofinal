package com.proyectofinal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService{
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    final String BucketName = "Pizzeria-556cf.appspot.com";
    
    final String rutaSuperiorStorage = "pizzeria";
    
    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "pizzeria-556cf-firebase-adminsdk-vggoi-4147330d3d.jason";
    
}
