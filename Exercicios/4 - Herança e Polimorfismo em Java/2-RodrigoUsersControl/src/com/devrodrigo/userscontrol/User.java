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

        // modo resumido com sobrecarga
//        this(name, email, password, false);
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

    // Abandonado para atender os requisitos técnicos solicitado.
    //Altera apenas Nome e Email
//    public void changePersonalData(String name, String email) {
//        // Chama a função que sobrecarrega esta (a de baixo), passando null na senha
//        changePersonalData(name, email, null);
//    }
//
//    // Altera nome, email e senha se informado.
//    public void changePersonalData(String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//
//        if (password != null && !password.isBlank()) {
//            this.password = password;
//            System.out.println("✅ Senha alterada com sucesso!");
//        }
//        System.out.println("✅ Dados Alterados!");
//    }

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
