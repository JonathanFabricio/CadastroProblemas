/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jony
 */
public class ProblemaDao {
    
    public static Problema obterPeloCodigo(int codigo){
        for(Problema objDaVez : ProblemaDao.obterLista()){
            if(objDaVez.getCodigo()==codigo)    return objDaVez;
        }
        return null;
    }
    
    public static ArrayList<Problema>  obterLista(){
        ArrayList<Problema> retorno = new ArrayList<>();
        try {
            Path local = Paths.get("armazenamento/problemas.txt");
            for(String linha : Files.readAllLines(local)){
                String dados[] = linha.split(";");
                Problema objProblema = new Problema();
                objProblema.setDescricao(dados[0]);
                objProblema.setCodigo(Integer.valueOf(dados[1]));
                DateFormat formatador = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                objProblema.setDataProblema(formatador.parse(dados[2]));
                objProblema.setSituacao(dados[3]);                
                //http://stackoverflow.com/questions/4713825/how-to-parse-output-of-new-date-tostring                
                retorno.add(objProblema);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProblemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public static void salvar(Problema problema){
        try {
            Path local = Paths.get("armazenamento/equipamentos.txt");
            String separadorLinha = System.getProperty("line.separator");
            String problemaString = problema.getDescricao()+";"+problema.getDataProblema().toString()+";"+problema.getCodigo()+";"+problema.getSituacao()+separadorLinha;
            Files.write(local, problemaString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(ProblemaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
