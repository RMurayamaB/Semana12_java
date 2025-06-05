// exercício 1
class Funcionario {
    String nome;
    double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }
}
class Gerente extends Funcionario {
    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 1.20;
    }
}
class Estagiario extends Funcionario {
    public Estagiario(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 1.05;
    }
}

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("João", 2000);
        Gerente g = new Gerente("Maria", 5000);
        Estagiario e = new Estagiario("Carlos", 1500);

        System.out.println(f.nome + " - Salário: R$ " + f.calcularSalario());
        System.out.println(g.nome + " - Salário: R$ " + g.calcularSalario());
        System.out.println(e.nome + " - Salário: R$ " + e.calcularSalario());
    }
}

//Exercício 2

class Veiculo {
    String marca, modelo;
    int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirDados() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }
}


class Carro extends Veiculo {
    int quantidadePortas;

    public Carro(String marca, String modelo, int ano, int quantidadePortas) {
        super(marca, modelo, ano);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Portas: " + quantidadePortas);
    }
}
class Moto extends Veiculo {
    int cilindradas;

    public Moto(String marca, String modelo, int ano, int cilindradas) {
        super(marca, modelo, ano);
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Cilindradas: " + cilindradas);
    }
}

public class TesteVeiculo {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 4);
        Moto moto = new Moto("Honda", "CB 500", 2021, 500);

        System.out.println("=== Carro ===");
        carro.exibirDados();

        System.out.println("\n=== Moto ===");
        moto.exibirDados();
    }
}

//exercício 3

class Animal {
    String nome;
    int idade;

    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("Som genérico de animal");
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Latindo...");
    }
}

class Gato extends Animal {
    public Gato(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom() {
        System.out.println("Miando...");
    }
}

public class TesteAnimal {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro("Rex", 3);
        Gato cat = new Gato("Mimi", 2);

        System.out.println("Nome: " + dog.nome + " - Idade: " + dog.idade);
        dog.emitirSom();

        System.out.println("Nome: " + cat.nome + " - Idade: " + cat.idade);
        cat.emitirSom();
    }
}
