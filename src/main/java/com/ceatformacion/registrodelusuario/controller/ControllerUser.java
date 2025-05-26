package com.ceatformacion.registrodelusuario.controller;

import com.ceatformacion.registrodelusuario.modell.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

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
        //Asegurarse que la fecha está correctamente configurada
        usuario.setFechaRegistro(String.valueOf(LocalDate.now()));
        usuario.asignarIdUsuario();
        //Agregar el usuario a la lista
        listaUsuarios.add(usuario);

        //Mostrar por consola para depurar
        System.out.println(usuario);

        return "redirect:/crud";
    }

    @GetMapping("/crud")
    public String mostrarUsuarios(Model model){
        //Pasar la lista de usuarios a la vista
        model.addAttribute("usuarios", listaUsuarios);
        return "crud"; //Nombre de la vista para mostrar los usuarios
    }

    @GetMapping("/editar/{idUsuario}")
    public String modificarUsuario(@PathVariable int idUsuario, Model model){
        //Usuario donde almacenará el objeto Usuario encontrado en el Iterator, para pasarlo
        //a la vista -> modificar.html
        Usuario usuarioE = null;
        //Iterator para recorrer el ArrayList y ubicar el ID que se pasa como parámetro
        Iterator<Usuario> itUsuario = listaUsuarios.iterator();
        while (itUsuario.hasNext()){
            Usuario user = itUsuario.next();
            if(idUsuario == user.getIdUsuario()){
                usuarioE = user;
                break;
            }
        }
        if(listaUsuarios!=null){
            model.addAttribute("usuario", usuarioE);
            return "modificar";
        }else {
            //Si la lista no se encuentra o la lista esta vacía.
            return "redirect:/crud";
        }
    }

    @PostMapping("/modificar")
    public String guardarModificacion(Model model, Usuario usuarioActualizado){
        //Recorremos el ArrayList buscando el id del usuario que llega, y después remplazo todos sus datos
        for(int i=0; i<listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getIdUsuario()==usuarioActualizado.getIdUsuario()){

                listaUsuarios.set(i, usuarioActualizado); //Se reemplazan todos sus datos
                break; //nos salimos
            }
        }
        //Redirigimos al Crud
        return "redirect:/crud";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String eliminarUsuario(@PathVariable int idUsuario){
        for(int i=0; i<listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getIdUsuario()==idUsuario){
                listaUsuarios.remove(i);
                break;
            }
        }
        return "redirect:/crud";
    }




}
