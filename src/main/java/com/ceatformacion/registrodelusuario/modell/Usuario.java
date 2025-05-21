package com.ceatformacion.registrodelusuario.modell;

import java.time.LocalDate;

public class Usuario {
    private String nombreApellido;
    private String email;
    private String userName;
    private String password;
    static int id=1;
    private int idUsario=0;
    private LocalDate fechaRegistro;


    //Método Constructor
    public Usuario(){
        this.idUsario = id++;
    }
    public Usuario(String nombreApellido, String email, String userName, String password, String fechaRegistro) {
        this();
        this.nombreApellido = nombreApellido;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fechaRegistro = LocalDate.parse(fechaRegistro);
    }

    //Métodos Getter y Setter
    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsario() {
        return idUsario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = LocalDate.parse(fechaRegistro);
    }

    //Método toString
    @Override
    public String toString() {
        return "User ID("+idUsario+")" +
                "User name='" + userName + '\'' +
                "Nombre y apellido:'" + nombreApellido + '\'' +
                "Email:" + email + '\'' +
                "Password:" + password + '\'' +
                "Fecha de registro:" + fechaRegistro;
    }
}
