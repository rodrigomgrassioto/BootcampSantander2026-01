package com.devrodrigo.userscontrol;

public abstract class User {
    //Nome, Email, Senha e um atributo que informa se ele é administrador
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean logged;

    public User(String name, String email, String password, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setLogged(boolean status){
        logged = status;
    }

    public void login (String email, String password){
        if (this.email.equals(email) && this.password.equals(password)) {
            setLogged(true);
            System.out.println("✅ Bem vindo!");
            return;
        }
        setLogged(false);
        System.out.println("❌ Não encontrado combinação para usuário e senha informado");
    }

    public void logoff(){
        setLogged(false);
        System.out.println("❗ Até logo!");
    }

    // trocar apenas nome e email
    public void changePersonalData(String name, String email, String password) {
        if (this.password.equals(password)){
            setName(name);
            setEmail(email);
            System.out.println("✅ Dados Alterados!");
            return;
        }
        System.out.println("❌ Senha não confere!");
    }

    // trocar senha
    public void changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)){
            setPassword(newPassword);
            System.out.println("✅ Senha Alterada!");
            return;
        }
        System.out.println("❌ Senha não confere!");
    }

}
