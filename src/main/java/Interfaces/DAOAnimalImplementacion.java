
package Interfaces;

import Animales.Animal;
import Refugio.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DAOAnimalImplementacion implements DAOAnimal{

    Main main = new Main();
    
    public DAOAnimalImplementacion() {
    }
    
    @Override
    public void registrar(Animal animal) {
       
        try {
            Connection conectar = main.establecerConexion();
            
              PreparedStatement insertar = conectar.prepareStatement("INSERT INTO refugio(nombre, Tipo_de_animal, Fecha_de_nacimiento, Adoptado) VALUES(?, ?, ?, ?)");
          
            
            insertar.setString(1, animal.getNombre());
            
            insertar.setString(2, animal.getTipoAnimal());
            
            insertar.setDate(3, animal.getFechaDeNacimiento());
            
             insertar.setBoolean(4, animal.getAdopcion());

            insertar.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
}

    @Override
    public void modificar(Animal animal) {

        try {
            Connection conectar = main.establecerConexion();
            
            PreparedStatement modificar = conectar.prepareStatement("UPDATE refugio set nombre = ? where id = ?");
            
            modificar.setString(1, animal.getNombre());
            modificar.setInt(2, animal.getId());
            
            modificar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
               
}

   @Override
public void eliminar(Animal animal) {
    try {
        Connection conectar = main.establecerConexion();
        
        // Antes de eliminar, obtener los datos del animal
        PreparedStatement obtenerDatos = conectar.prepareStatement("SELECT * FROM refugio WHERE id = ?");
        obtenerDatos.setInt(1, animal.getId());
        ResultSet resultado = obtenerDatos.executeQuery();
        
        // Verificar si hay resultados y mostrar los datos
        if (resultado.next()) {
            
             String adopt = "No";
                if (resultado.getBoolean("adoptado")) {
                     adopt = "si";
                }
            
            String mensaje = "ID: " + resultado.getInt("id") + "\n" +
                             "Nombre: " + resultado.getString("nombre") + "\n" +
                             "Tipo de Animal: " + resultado.getString("tipo_de_animal") + "\n" +
                             "Fecha de Nacimiento: " + resultado.getDate("fecha_de_nacimiento") + "\n" +
                             "Adoptado: " + adopt;
            
            int confirmacion = JOptionPane.showConfirmDialog(null, mensaje, "¿Eliminar registro?", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Si el usuario confirma, proceder con la eliminación
                PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM refugio WHERE id = ?");
                eliminar.setInt(1, animal.getId());
                eliminar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
            } else {
                // Si el usuario no confirma, puedes realizar alguna acción adicional o simplemente no hacer nada
            }
        }
        
        // Cerrar recursos
        resultado.close();
        obtenerDatos.close();
        conectar.close();
    } catch (Exception e) {
        System.out.println("Error al eliminar el registro: " + e.getMessage());
    }
}

    @Override
    public void buscar(Animal animal) {
    try (Connection conectar = main.establecerConexion()) {
        PreparedStatement buscar = conectar.prepareStatement("select * from refugio where id = ?");
        buscar.setInt(1, animal.getId());

        try (ResultSet consulta = buscar.executeQuery()) {
           
            if (consulta.next()) {
                String adopt = "No";
                if (consulta.getBoolean("adoptado")) {
                     adopt = "si";
                }
                // Si el animal se encontró, mostramos los datos
                String mensaje = "ID: " + consulta.getInt("id") + "\n" +
                                 "Nombre: " + consulta.getString("nombre") + "\n" +
                                 "Tipo de Animal: " +  consulta.getString("tipo_de_animal") + "\n" +
                                 "Fecha de Nacimiento: " + consulta.getDate("fecha_de_nacimiento") + "\n" +
                                 "Adoptado: " + adopt;

                JOptionPane.showMessageDialog(null, mensaje, "Registro encontrado con éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un animal con el ID proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
     public Animal getAnimalById(int id) {
        Animal animal = null;

        try {
            Connection conectar = main.establecerConexion();
            PreparedStatement obtener = conectar.prepareStatement("SELECT * FROM refugio WHERE id = ?");
            obtener.setInt(1, id);

            ResultSet resultado = obtener.executeQuery();

            if (resultado.next()) {
                // Supongo que tu constructor de Animal toma los parámetros necesarios.
                animal = new Animal(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("tipo_de_animal"),
                        resultado.getDate("fecha_de_nacimiento"),
                          resultado.getBoolean("adoptado")     
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el Animal por ID: " + e.getMessage());
        }

        return animal;
    }

}


    
  
    
  
    
    
    
    