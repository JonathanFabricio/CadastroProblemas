/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.Scanner;

/**
 *
 * @author Jonathan Fabricio
 */
public class Menu {
    public static void exibirMenu(){
        do{
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("Digite V para visualizar os problemas reportados.");
            System.out.println("Digite R para reportar um novo problema.");
            System.out.println("\nOpção:");
            System.out.print(">> ");

            Scanner entrada = new Scanner(System.in);
            String opcao = entrada.nextLine();
            switch(opcao){
                case "V":
                    ListagemProblemasVisao.exibirListagemProblemas();
                    break;
                case "R":
                    ProblemasVisao.exibirCadastroProblemas();
                    break;
                case "v":
                    ListagemProblemasVisao.exibirListagemProblemas();
                    break;
                case "r":
                    ProblemasVisao.exibirCadastroProblemas();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }while(true);
    }
}