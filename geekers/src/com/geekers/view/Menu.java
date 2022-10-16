package com.geekers.view;

public class Menu {

    public void menuPrincipal(){

        System.out.println("+---------------------------------+\n" +
                           "|             Geeker              |\n" +
                           "+---------------------------------+\n" +
                           "|          [1] Login              |\n" +
                           "|          [2] Cadastrar          |\n" +
                           "|          [0] Sair               |\n" +
                           "+---------------------------------+\n");
    }

    public void menuUsuarioLogado(){
        System.out.println
                       ("+---------------------------------+\n" +
                        "|             Geeker              |\n" +
                        "+---------------------------------+\n" +
                        "|         [1] Dar Match           |\n" +
                        "|         [2] Matchs              |\n" +
                        "|         [3] Editar Perfil       |\n" +
                        "|         [0] Deslogar            |\n" +
                        "+---------------------------------+\n");
    }

    public void menuMatchs(){
        System.out.println
                       ("+---------------------------------+\n" +
                        "|             Matchs              |\n" +
                        "+---------------------------------+\n" +
                        "|     [1] Listar Matchs           |\n" +
                        "|     [2] Comentar Match          |\n" +
                        "|     [2] Editar Match            |\n" +
                        "|     [3] Excluir Match           |\n" +
                        "|     [0] Voltar menu principal   |\n" +
                        "+---------------------------------+\n");
    }

    public void menuEditarPerfil(){
        System.out.println(
                        "+---------------------------------+\n" +
                        "|          Editar Perfil          |\n" +
                        "+---------------------------------+\n" +
                        "|     [1] Ver dados perfil        |\n" +
                        "|     [2] Editar dados perfil     |\n" +
                        "|     [3] Ver desafio             |\n" +
                        "|     [4] Editar Desafio          |\n" +
                        "|     [5] Ver Hobbies             |\n" +
                        "|     [6] Editar Hobbies          |\n" +
                        "|     [0] Voltar menu principal   |\n" +
                        "+---------------------------------+\n");
    }



}
