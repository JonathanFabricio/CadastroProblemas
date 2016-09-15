/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProblemasControle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Jonathan Fabricio
 */
public class ProblemasVisao {
    public static void exibirCadastroProblemas(){
        Scanner entrada = new Scanner(System.in);
        String descricao, codigo, situacao="Aberto";
        Date dataProblema;
        
        System.out.println("\n\n==== REPORTE DE NOVO PROBLEMAS ====");
        System.out.println("Digite a descrição do problema:");
        System.out.print(">> ");
        descricao = entrada.nextLine();
        
        System.out.println("Digite a data que o problema foi reportado (dd.MM.aaaa):");
        System.out.print(">> ");        
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd.MM.yyyy");
        formatadorData.setLenient(false);
        do{
            try{
                dataProblema = formatadorData.parse(entrada.nextLine());
                break;
            }catch(Exception  e){
                System.out.print("Data inválida, digite novamente: ");
            }
        }while(true);
        
        ProblemasControle.receberDadosCadastroProblemas(descricao, dataProblema, situacao);
    }
}
