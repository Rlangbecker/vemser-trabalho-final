package com.geekers.service;

import com.geekers.exceptions.BancoDeDadosException;
import com.geekers.model.Hobbies;
import com.geekers.repository.HobbiesRepository;

public class HobbieService {

    private HobbiesRepository hobbiesRepository;

    public HobbieService() {
        hobbiesRepository = new HobbiesRepository();
    }

    public HobbiesRepository getHobbiesRepository() {
        return hobbiesRepository;
    }

    public void setHobbiesRepository(HobbiesRepository hobbiesRepository) {
        this.hobbiesRepository = hobbiesRepository;
    }

    public void adicionarHobbie(Hobbies hobbie) {
        try {
            Hobbies hobbieAdicionado = hobbiesRepository.adicionar(hobbie);
            System.out.println("Hobbie adicionado com sucesso! " + hobbieAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = hobbiesRepository.remover(id);
            System.out.println("Hobbie removido? " + conseguiuRemover + "| com id= " + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editar(Integer id, Hobbies hobbie) {
        try {
            boolean conseguiuEditar = hobbiesRepository.editar(id, hobbie);
            System.out.println("Hobbie editado? " + conseguiuEditar + "| com id= " + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            hobbiesRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


}
