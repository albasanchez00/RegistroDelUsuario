package com.ceatformacion.registrodelusuario.controller;

import com.ceatformacion.registrodelusuario.modell.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
public class ControllerUser {
    @GetMapping("/registro") // → url con la que accederás a ver el formulario.
    public String altaUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaRegistro = LocalDate.now();
        model.addAttribute("fechaRegistro", fechaRegistro.format(formatter));
        return "formulario"; //Envía al formulario
    }

    //Agregabamos una coleccion para ir guardando los usuarios dados de alta.
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario, Model model){
        usuario.setFechaRegistro(String.valueOf(LocalDate.now()));
        listaUsuarios.add(usuario);
        System.out.println(usuario);
        return "crud";
    }


}
