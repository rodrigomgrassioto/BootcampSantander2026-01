public class PetMachine {
    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;

    private Pet pet = null;

    public void takeAShower(){
        if (this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho.");
            return;
        }
        if (this.water < 10){
            System.out.println("Abastecer maquina com água");
            return;
        }
        if (this.shampoo < 2){
            System.out.println("Abastecer maquina com shampoo");
            return;
        }
        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.printf("O pet %s foi limpo.\n", pet.getName());
    }

    public void addWater(){
        if (this.water == 30){
            System.out.println("Capacidade máxima de água já atingida.");
            return;
        }

        int espacoDisponivel = 30 - this.water;
        // Retorna o menor valor 2 ou espaço disponível.
        int quantidadeAdicionada = Math.min(2, espacoDisponivel);

        this.water += quantidadeAdicionada;
        System.out.printf("Adicionado %d litros de água. Total: %d/30L%n", quantidadeAdicionada, this.water);
    }

    public void addShampoo(){
        if (this.shampoo == 10){
            System.out.println("Capacidade máxima de shampoo já atingida.");
            return;
        }
        int espacoDisponivel = 10 - this.shampoo;
        int quantidadeAdicionada = Math.min(2, espacoDisponivel);

        this.shampoo += quantidadeAdicionada;
        System.out.printf("Adicionado %d litros de shampoo. Total: %d/10L%n", quantidadeAdicionada, this.shampoo);
    }

    public int getShampoo() {
        return shampoo;
    }

    public int getWater() {
        return water;
    }

    public boolean hasPet(){
        System.out.printf("PET É: \n%s\n", this.pet);
        return this.pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("Não é possível utilizar a máquina suja.");
            return;
        }
        if (hasPet()){
            System.out.printf("O pet %s já está na máquina. Não é possível adicionar outro\n", this.pet.getName());
            return;
        }
        this.pet = pet;
        System.out.printf("Pet %s foi colocado na máquina.\n", this.pet.getName());
    }

    public void removePet(){
        if (this.pet == null) {
            System.out.println("Máquina vazia. Sem pet para remover");
            return;
        }
        this.clean = this.pet.isClean();
        System.out.printf("O pet %s retirado da máquina.\n", pet.getName());
        this.pet = null;
    }

    public void washMachine(){
        if (this.water < 3){
            System.out.println("Abastecer maquina com água");
            return;
        }
        if (this.shampoo < 1){
            System.out.println("Abastecer maquina com shampoo");
            return;
        }
        this.water -= 3;
        this.shampoo -= 1;
        this.clean = true;
        System.out.println("Máquina limpa com sucesso.");

    }
}
