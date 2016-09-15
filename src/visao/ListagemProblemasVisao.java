/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProblemasControle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.Problema;

/**
 *
 * @author Jonathan Fabricio
 */
public class ListagemProblemasVisao {
    public static void exibirListagemProblemas(){
        Scanner entrada = new Scanner(System.in);
        String valorDigitado;
        System.out.println("\n==== LISTAGEM DE PROBLEMAS REPORTADOS ====");
        System.out.println("  CÓDIGO \t\tDESCRICAO \t\t\tDATA \t\t\tSITUAÇÃO ");
        
        // Pucha as informações da lista.
        for(Problema obj : ProblemasControle.obterListaEquipamentos()){
            System.out.println( "  " + obj.getCodigo() + "\t\t      " + obj.getDescricao() + "\t\t\t" + obj.getDataProblema() + "\t\t" + obj.getSituacao() );
        }
         
        System.out.println("\nDigite M pare retornar ao menu.");
        System.out.println("Digite o código do problema para mudar a situação para resolvido.");
            
        System.out.println("Opção: ");
        System.out.print(">> ");
        valorDigitado = entrada.nextLine();
            
        /*if(entrada.equals("M")){
        //não faz nada, ou seja, retorna pro menu
        }else{
            
            Problema encontrado = ProblemasControle.obterProblemaPeloCodigo(Integer.parseInt(valorDigitado));
            if(encontrado == null){
                System.out.println(" - Erro, problema não encontrado\n\n");
                exibirListagemProblemas();
            }else{
                encontrado.setSituacao("Resolvido");
                System.out.println(" *** Alterada situação do problema '" + valorDigitado + "' para resolvido!!!!\n");
            }
        }*/
        
        if(valorDigitado.equals("M")){ //
        //não faz nada, ou seja, retorna pro menu
        }else{
            try{
                Problema encontrado = ProblemasControle.obterProblemaPeloCodigo(Integer.parseInt(valorDigitado));
                if(encontrado == null){
                    encontrado.setSituacao("Resolvido");
                    System.out.println(" *** Alterada situação do problema '" + valorDigitado + "' para resolvido!!!!\n");                    
                }
            }catch(Exception e){
                System.out.println(" - Erro, problema não encontrado\n\n");
            }
        }
    }
}
