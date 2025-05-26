package com.ceatformacion.registrodelusuario.modell;

import java.time.LocalDate;

public class Usuario {
    private String nombreApellido;
    private String email;
    private String userName;
    private String password;
    static int id=0;
    private int idUsuario =0;
    private LocalDate fechaRegistro;


    //Método Constructor
    public Usuario(){
    }
    public Usuario(int idUsuario, String nombreApellido, String email, String userName, String password, String fechaRegistro) {
        this.idUsuario = idUsuario;
        this.nombreApellido = nombreApellido;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fechaRegistro = LocalDate.parse(fechaRegistro);
    }

    //Métodos Getter y Setter
    //Metodo asignarID temporal porque cuando usemos BBDD este id se autogenera.
    public void asignarIdUsuario() {
        this.idUsuario =++id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = LocalDate.parse(fechaRegistro);
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getFechaRegistro() {
        return String.valueOf(this.fechaRegistro);
    }

    public String getPassword() {
        return password;
    }

    //Método toString
    @Override
    public String toString() {
        return "User ID("+ idUsuario +")" +
                "User name='" + userName + '\'' +
                "Nombre y apellido:'" + nombreApellido + '\'' +
                "Email:" + email + '\'' +
                "Password:" + password + '\'' +
                "Fecha de registro:" + fechaRegistro;
    }
}
