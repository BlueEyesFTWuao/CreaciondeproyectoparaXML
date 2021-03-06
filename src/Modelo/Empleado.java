/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author dacastro
 */
public class Empleado extends Persona {

    private String codigoEmpleado;
    private String departamento;

    public Empleado() {
    }

    public Empleado(String codigoEmpleado, String departamento, String nombre, String direccion, int edad) {
        super(nombre, direccion, edad);
        this.codigoEmpleado = codigoEmpleado;
        this.departamento = departamento;
    }

    public Empleado(String codigo, String nombre, String Edad, String direccion, String departamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the value of departamento
     *
     * @return the value of departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Set the value of departamento
     *
     * @param departamento new value of departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Get the value of codigoEmpleado
     *
     * @return the value of codigoEmpleado
     */
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     * Set the value of codigoEmpleado
     *
     * @param codigoEmpleado new value of codigoEmpleado
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return  super.toString() + "," + codigoEmpleado + "," + departamento ;
    }

    public boolean guardarEmpleados(LinkedList<Empleado> listaEmpleados) {
        boolean g = false;
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("estudiantes.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (int i = 0; i < listaEmpleados.size(); i++) {
                //escribe los datos en el archivo
                bfwriter.write(listaEmpleados.get(i) + "\n");
            }
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");
            g = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return g;

    }

    public boolean crearFileXML(LinkedList<Empleado> listaEmpleados) {
      try {
          Element company = new Element("company");
          Document doc=new Document(company);
          
          for (int i = 0; i < listaEmpleados.size(); i++) {
              
               Element staff = new Element("empleado");
          
          staff.addContent(new Element("Nombre").setText(listaEmpleados.get(i).getNombre()));
          staff.addContent(new Element("Direccion").setText(listaEmpleados.get(i).getDireccion()));
          staff.addContent(new Element("Codigo").setText(listaEmpleados.get(i).getCodigoEmpleado()));
          staff.addContent(new Element("Departamento").setText(listaEmpleados.get(i).getDepartamento()));
          staff.addContent(new Element("Edad").setText(listaEmpleados.get(i).getEdad()));
              
          }
         
      }
    }

}
