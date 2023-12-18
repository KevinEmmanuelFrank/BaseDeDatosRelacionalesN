package Interfaces;

import Animales.Animal;

public interface DAOAnimal {

    public void registrar(Animal animal);

    public void modificar(Animal animal);

    public void eliminar(Animal animal);

    public void buscar(Animal animal);

}
