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
                        "|     [3] Excluir Match           |\n" +
                        "|     [4] Mostrar Comentarios     |\n" +
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

    public void menuEscolhaHobbies(){
        System.out.println("+---------------------------------+");
        System.out.println("|       QUAL SEU HOBBIE?          |\n" +
                "+---------------------------------+" +
                "\n|          [1] Jogos              |" +
                "\n|          [2] Series             |" +
                "\n|          [3] Livros             |" +
                "\n|          [4] Filmes             |" +
                "\n|          [5] Bebidas            |" +
                "\n|          [6] Outros             |" +
                "\n+---------------------------------+ \n");
    }

    public void menuDescreverHobbie(){
        System.out.println("+------ DESCREVA SEU HOBBIE ------+");
        System.out.println("Informe a descricao: ");
    }

    public void menuCriarDesafio(){
        System.out.println("+---------------------------------+\n"
                +"|            DESAFIO              |\n"
                +"+---------------------------------+\n"
                +"Informe a pergunta : ");
    }

    public void menuRespostaDesafio(){
        System.out.println("Informe sua resposta: \n" +
                "[0] VERDADEIRO\n"+"[1] FALSO");
    }
}
