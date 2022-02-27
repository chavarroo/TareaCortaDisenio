/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import java.util.ArrayList;
import java.util.List;
import model.Formulario;
import model.TEstado;

/**
 *
 * @author Jhonny Picado Vega
 */
public class DAOFormulariosImpl implements DAOTrasaccional{
    
    // instancia autorreferenciada para el uso de Singleton
    private static DAOFormulariosImpl accesoFormularios;

    // atributo de acceso controlado:
    private List<Formulario> tablaFormularios = new ArrayList<Formulario>();

    
    private DAOFormulariosImpl() {
    }        

    
    public static DAOFormulariosImpl getInstance(){
        if (accesoFormularios == null)
            accesoFormularios = new DAOFormulariosImpl();
        return accesoFormularios;
    }
    
    @Override
    public boolean create(Object obj) {
        
        
        Formulario unFormulario = (Formulario)obj;
        
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formActual = tablaFormularios.get(i);
            if (formActual.equals(unFormulario))
                return false;   // no se pueden recebir dos solicitudes iguales
        }
        return tablaFormularios.add(unFormulario);
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Object key) {
        int num = (int) key;
        
        for (int i = 0; i < tablaFormularios.size(); i++){
            
            if (tablaFormularios.get(i).getNum() == num){
                return tablaFormularios.get(i);
            }
        }
        return null;
    }

    @Override
    public List getAll() {
        return tablaFormularios;
    }
    
    public int newID(){
        if (tablaFormularios.isEmpty()){
            return 0;
        } else{
            return tablaFormularios.get(tablaFormularios.size()-1).getNum() + 1;
        }
    }
    
    
    //Punto 10, devuelve la lista de forms filtrada por estado y carrera
    public List getAll(String tEstado, String codCarrera){
        
        List formularios = new ArrayList<Formulario>();
        TEstado estado = TEstado.valueOf(tEstado);
        
        
        for (int i=0; i<tablaFormularios.size(); i++){
            
            if (tablaFormularios.get(i).getEstado() == estado && tablaFormularios.get(i).getCarrera().getCodigo().equals(codCarrera)){
                formularios.add(tablaFormularios.get(i));
            }
            
        }
        return formularios;
    }
}
