/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cmd;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author dell
 */
public class CMD {
    private File mifile=new File("CMD");
    
    void cd(String nombre) {
        for(File file: mifile.listFiles()){
            if(mifile.isDirectory()){
                mifile=new File(nombre);
                System.out.println(mifile.getAbsolutePath());
                break;
            }
        }
    }
    
    void mkdirs(String nombre){
        File mifile=new File(getMifileActual(),nombre);
        mifile.mkdirs();
        System.out.println(mifile.getAbsolutePath());
    }
    
    boolean crearFile(String nombre)throws IOException {
        File mifile=new File(getMifileActual(),nombre);

        return mifile.createNewFile();
    }
    
    void Rm() {
        getMifileActual().delete();
    }
    
    void puntosSuspensivos(){
         cd( mifile.getAbsoluteFile().getParentFile().getName());
    }
    
    void Dir() {
        if(mifile.isDirectory()) {
            System.out.println("Folder: "+mifile.getName());

            for(File child:mifile.listFiles()){
              System.out.println("\t"+child.getName());                
            }
        } else {
            System.out.println("Acción no permitida");
        }
    }
    
     void  Date() {
        LocalDate fecha = LocalDate.now();
        System.out.println(fecha);
    }
    
     void Time(){
        LocalTime hora = LocalTime.now();
        System.out.println(hora);
    }
    
    void Escribir(String mensaje) {
        if (mifile.isFile()){
           try {
            FileWriter writer = new FileWriter(mifile);
            writer.write(mensaje);
            writer.flush();
            System.out.println("Se ha escrito en el archivo.");
            } catch (IOException e) {
                System.out.println("Error, no se ha podido completar la acción.");
            } 
        }
    }
    
    void Leer() {
        if (mifile.isFile()){
           try {
                FileReader leer = new FileReader(mifile);
                int caracter;

                while((caracter=leer.read())!=-1){
                    System.out.print((char) caracter);
                }
                leer.close();
            
            } catch (IOException e) {
                System.out.println("Error, no se ha podido completar la acción.");
            } 
        }
    }

    public File getMifileActual() {
        return mifile;
 }
}
