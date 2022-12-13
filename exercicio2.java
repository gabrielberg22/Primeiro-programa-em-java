import java.util.Scanner;

public class exercicio2 {
    public static void main(String args[]) {
        Scanner leia = new Scanner (System.in, "CP850");
        String nome = "", nomeVelho = "", NomeNovo = "";
        char opcao = 'S';
        double vDiaria, valorTot = 0; 
        int idade, contMeia = 0, contGratis = 0, maisVelho = 0, maisNovo = 0;

        System.out.println("Informe o valor da diária: ");
        vDiaria = leia.nextDouble();

        while (opcao != 'N' && opcao != 'n') {
            leia.nextLine();
            System.out.println("Informe o nome do hóspede: ");
            nome = leia.nextLine();

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

            if (idade > maisVelho) {
                if (maisVelho == 0) {
                    maisVelho = idade;
                    nomeVelho = nome;
                }
                else{
                    if (maisNovo == 0) {
                        maisNovo = maisVelho;
                        NomeNovo = nomeVelho;
                        maisVelho = idade;
                        nomeVelho = nome;
                    }
                    else  {
                        maisVelho = idade;
                        nomeVelho = nome;
                    }
                }
            }
            else if (idade < maisVelho) {
                if (maisNovo == 0) {
                    maisNovo = idade;
                    NomeNovo = nome;
                }
                else if (idade < maisNovo) {
                    maisNovo = idade;
                    NomeNovo = nome;
                }
            }

            System.out.println("Deseja continuar? (S/N) ");
            opcao = leia.next().charAt(0);
            
        }

        System.out.printf("Total de hospedagens: R$ %.2f; %d gratuidade(s); %d meia(s)" ,valorTot, contGratis, contMeia);

        System.out.println("\n\nO hospede mais velho é " +nomeVelho+ " com " +maisVelho+ " anos. E o mais novo é " +NomeNovo+ " com " +maisNovo+ " ano(s).");
        leia.close();
    }
}
