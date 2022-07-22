import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bootcamp bootcamp = new Bootcamp();
        Scanner scanner = new Scanner(System.in);
        Curso[] curso = new Curso[100];
        Mentoria[] mentoria = new Mentoria[100];

        System.out.println("---------------------------------------------------------");
        System.out.println("Bem-Vindo, a Plataforma para o Gerenciamento de Bootcamp ");
        System.out.println("---------------------------------------------------------");
        System.out.println();

        //Cadastrando Bootcamps
        System.out.print("Insira o nome do Bootcamp: ");
        bootcamp.setNome(scanner.nextLine());
        System.out.print("Insira a descrição do Bootcamp "+ bootcamp.getNome() + ": ");
        bootcamp.setDescricao(scanner.nextLine());

        System.out.println("Bootcamp "+ bootcamp.getNome() + " cadastrado com sucesso!");
        System.out.println("Adicionar curso ao Bootcamp " + bootcamp.getNome());
        System.out.println();

        boolean continuar = true;
        int contC = 0;
        int contM = 0;

        //Cadastro de Mentorias e Cursos
        do {
            System.out.print("Qual conteúdo quer cadastrar? Curso ou Mentoria? ");
            String tipoCadastro = scanner.nextLine();

            if (tipoCadastro.equals("Curso")) {
                curso[contC] = new Curso();

                System.out.print("Insira o nome do Curso: ");
                curso[contC].setTitulo(scanner.nextLine());
                System.out.print("Insira a descrição do " + curso[contC].getTitulo() + ": ");
                curso[contC].setDescricao(scanner.nextLine());
                System.out.print("Insira a carga horária " + curso[contC].getTitulo() + ": ");
                curso[contC].setCargaHoraria(scanner.nextInt());
                scanner.nextLine();

                bootcamp.getConteudos().add(curso[contC]);
                contC = contC + 1;
            } else if (tipoCadastro.equals("Mentoria")){
                mentoria[contM] = new Mentoria();

                System.out.print("Insira o nome da Mentoria: ");
                mentoria[contM].setTitulo(scanner.nextLine());
                System.out.print("Insira a descrição da " + mentoria[contM].getTitulo() + ": ");
                mentoria[contM].setDescricao(scanner.nextLine());
                mentoria[contM].setData(LocalDate.now());

                bootcamp.getConteudos().add(mentoria[contM]);
                contM = contM + 1;
            } else{
                System.out.println("Entrada inválida!");
            }

            System.out.println();

            boolean repete = true;
            do {
                System.out.print("Quer continuar [S/N]? ");
                String ler = scanner.nextLine();

                if (ler.equals("N") || (ler.equals("n"))){
                    continuar = false;
                    repete = false;
                } else if (ler.equals("S") || ler.equals("s")){
                    repete = false;
                }
            } while (repete);
        } while (continuar);

        // Cadastro de Devs e inscrição no BootCamp

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        devCamila.progredir();
        devCamila.calcularTotalXP();

        System.out.println("Conteúdos Inscritos: " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos: " +devCamila.getConteudosConcluidos());
        System.out.println(devCamila.calcularTotalXP());

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.calcularTotalXP();
        System.out.println("Conteúdos Inscritos: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos: " +devCamila.getConteudosConcluidos());
        System.out.println(devJoao.calcularTotalXP());
    }
}
