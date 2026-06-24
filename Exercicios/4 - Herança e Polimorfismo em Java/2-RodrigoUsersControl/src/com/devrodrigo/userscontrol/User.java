package com.devrodrigo.userscontrol;

public abstract class User {
    //Nome, Email, Senha e um atributo que informa se ele é administrador
    private String name;
    private String email;
    private String password;
    private boolean isAdmin = false;

    public User(String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;

        // modo resumido
        this(name, email, password, false);
    }

    // sobrecarga para quando quiser definir o isAdmin
//    public User(String name, String email, String password, boolean isAdmin) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.isAdmin = isAdmin;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void
}
