import java.util.Scanner;


public class exercicio {
    public static void main(String[] args) {
        Scanner leia = new Scanner (System.in, "CP850");
        String nome = "";
        double vDiaria, valorTot = 0; 
        int idade, contMeia = 0, contGratis = 0;

        System.out.println("Digite \"PARE\" se quiser encerrar o programa. ");

        System.out.println("Informe o valor da diária: ");
        vDiaria = leia.nextDouble();

        while (!nome.equalsIgnoreCase("PARE")) {
            leia.nextLine();
            System.out.println("Informe o nome do hóspede: ");
            nome = leia.nextLine().toUpperCase();

            if (!nome.equalsIgnoreCase("PARE")) {
                System.out.println("Digite a idade do hóspede: ");
                idade = leia.nextInt();

                if (idade < 4) {
                    System.out.println(nome+" possui gratuidade");
                    contGratis++;
                }
                else if (idade >= 4 && idade <= 80) {
                    valorTot = vDiaria + valorTot;
                }
                else if (idade > 80) {
                    System.out.println(nome+" paga meia.");
                    contMeia++;
                    valorTot = valorTot + vDiaria / 2;
                }
            }
        }

        System.out.printf("Total de hospedagens: R$ %.2f; %d gratuidade(s); %d meia(s)" ,valorTot, contGratis, contMeia);
        leia.close();
    }
}