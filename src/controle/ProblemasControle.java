/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.Date;
import modelo.Problema;
import modelo.ProblemaDao;

/**
 *
 * @author Jonathan Fabricio
 */
public class ProblemasControle {
    public static void receberDadosCadastroProblemas(String descricao, Date dataProblema, String situacao){
        Problema objetoProblema = new Problema();
        objetoProblema.setSituacao(situacao);
        objetoProblema.setCodigo(obterListaEquipamentos().size());
        objetoProblema.setDescricao(descricao);
        objetoProblema.setDataProblema(dataProblema);
        ProblemaDao.salvar(objetoProblema);
    }
    
    public static ArrayList<Problema> obterListaEquipamentos(){
        return ProblemaDao.obterLista();
    }
    
    public static Problema obterProblemaPeloCodigo(int codigo){
        return ProblemaDao.obterPeloCodigo(codigo);
    }
}
