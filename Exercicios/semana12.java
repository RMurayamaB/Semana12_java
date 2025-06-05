import java.util.Scanner;

interface Pagamento {
    void realizarPagamento(double valor);
}
class CartaoCredito implements Pagamento {
    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado com Cartão de Crédito.");
    }
}
class BoletoBancario implements Pagamento {
    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado com Boleto Bancário.");
    }
}
abstract class FormaGeometrica {
    abstract double calcularArea();
    abstract double calcularPerimetro();
}
class Retangulo extends FormaGeometrica {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
}
class Circulo extends FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}
interface DispositivoEletronico {
    void ligar();
    void desligar();
}
class Smartphone implements DispositivoEletronico {
    @Override
    public void ligar() {
        System.out.println("Smartphone ligado.");
    }

    @Override
    public void desligar() {
        System.out.println("Smartphone desligado.");
    }
}

class Televisao implements DispositivoEletronico {
    @Override
    public void ligar() {
        System.out.println("TV ligada.");
    }

    @Override
    public void desligar() {
        System.out.println("TV desligada.");
    }
}

class DispositivoFactory {
    public static DispositivoEletronico getDispositivo(int tipo) {
        switch (tipo) {
            case 1: return new Smartphone();
            case 2: return new Televisao();
            default: throw new IllegalArgumentException("Dispositivo inválido!");
        }
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Pagamentos ===");
        realizarPagamento();

        System.out.println("=== Formas Geométricas ===");
        calcularFormas(scanner);

        System.out.println("=== Dispositivos Eletrônicos ===");
        controlarDispositivos(scanner);

        scanner.close();
    }

    private static void realizarPagamento() {
        Pagamento cartao = new CartaoCredito();
        Pagamento boleto = new BoletoBancario();
        
        cartao.realizarPagamento(150.00);
        boleto.realizarPagamento(200.00);
        System.out.println();
    }

    private static void calcularFormas(Scanner scanner) {
        System.out.print("Digite a largura do retângulo: ");
        double largura = scanner.nextDouble();
        System.out.print("Digite a altura do retângulo: ");
        double altura = scanner.nextDouble();
        FormaGeometrica retangulo = new Retangulo(largura, altura);
        System.out.println("Área do retângulo: " + retangulo.calcularArea());
        System.out.println("Perímetro do retângulo: " + retangulo.calcularPerimetro());

        System.out.print("Digite o raio do círculo: ");
        double raio = scanner.nextDouble();
        FormaGeometrica circulo = new Circulo(raio);
        System.out.println("Área do círculo: " + circulo.calcularArea());
        System.out.println("Perímetro do círculo: " + circulo.calcularPerimetro());
        System.out.println();
    }

    private static void controlarDispositivos(Scanner scanner) {
        System.out.println("Escolha o dispositivo: 1 - Smartphone, 2 - Televisão");
        int dispositivo = scanner.nextInt();
        System.out.println("Escolha a ação: 1 - Ligar, 2 - Desligar");
        int acao = scanner.nextInt();

        try {
            DispositivoEletronico dispositivoSelecionado = DispositivoFactory.getDispositivo(dispositivo);
            if (acao == 1) dispositivoSelecionado.ligar();
            else if (acao == 2) dispositivoSelecionado.desligar();
            else System.out.println("Ação inválida!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
