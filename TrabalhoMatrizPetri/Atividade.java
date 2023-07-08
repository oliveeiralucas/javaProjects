import java.util.Scanner;

// 
// Decompiled by Procyon v0.5.36
// 

public class Atividade
{
    public static boolean validarIdade(final String input) {
        try {
            final int numero = Integer.parseInt(input);
            return numero >= 0;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void inserirAluno(final String[][] matriz, final int linhas, final int colunas) {
        System.out.println("Inserir Aluno");
        final Scanner scanner = new Scanner(System.in);
        matriz[linhas][0] = String.valueOf(linhas + 1);
        System.out.print("Nome: ");
        matriz[linhas][1] = scanner.next();
        boolean idadeValida = false;
        do {
            System.out.print("Idade: ");
            final String input = scanner.next();
            idadeValida = validarIdade(input);
            if (!idadeValida) {
                System.out.println("Idade inv\u00e1lida! Insira um n\u00famero positivo.");
            }
            else {
                final int idade = Integer.parseInt(input);
                matriz[linhas][2] = String.valueOf(idade);
            }
        } while (!idadeValida);
        System.out.print("Turma: ");
        matriz[linhas][3] = scanner.next();
        System.out.println("Aluno adicionado.");
    }
    
    public static void mostrarAlunos(final String[][] matriz, final int linhas, final int colunas) {
        System.out.println("ID | Nome | Idade | Turma");
        for (int i = 0; i < linhas; ++i) {
            for (int j = 0; j < colunas; ++j) {
                System.out.print(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, matriz[i][j]));
            }
            System.out.println();
            System.out.println("M\u00e9todo finalizado, prossiga com outra op\u00e7\u00e3o");
            System.out.println("-----------------------");
        }
    }
    
    public static void removerAluno(final String[][] matriz, final int linhas, final String nomeAluno) {
        boolean encontrado = false;
        for (int i = 0; i < linhas; ++i) {
            if (matriz[i][0] != null && matriz[i][1].equalsIgnoreCase(nomeAluno)) {
                encontrado = true;
                matriz[i][1] = null;
                matriz[i][2] = null;
                matriz[i][3] = null;
            }
        }
        if (encontrado) {
            System.out.println("Aluno removido.");
        }
        else {
            System.out.println("Aluno n\u00e3o encontrado.");
        }
    }
    
    public static void mensagem(final String texto) {
        System.out.println("=====================");
        System.out.println("| ERRO: Nenhum aluno cadastrado.");
        System.out.println("| Por favor, adicione um aluno para acessar essa op\u00e7\u00e3o.");
        System.out.println("| Acesse a op\u00e7\u00e3o 2 no menu para prosseguir.");
        System.out.println("=====================");
    }
    
    public static void mensagemDespedida(final String texto) {
        System.out.println("Esperamos ter voc\u00ea de volta em breve");
        System.out.print("Finalizando");
        try {
            for (int i = 0; i < 10; ++i) {
                System.out.print(".");
                Thread.sleep(200L);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void mensagemCadastro() {
        System.out.println("Seja bem-vindo ao portal de cadastramento de alunos");
    }
    
    public static void editarAluno(final String[][] matriz, final int linhas) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do aluno a ser editado: ");
        System.out.println("Caso n\u00e3o saiba o ID do aluno");
        System.out.println("Digite 'sair'");
        System.out.println("E acesse a op\u00e7\u00e3o 1 no menu");
        final String entrada = scanner.next();
        if (entrada.equals("sair") || entrada.equals("Sair")) {
            return;
        }
        while (!scanner.hasNextInt()) {
            System.out.println("N\u00famero de aluno inv\u00e1lido. Digite um n\u00famero inteiro: ");
            scanner.next();
        }
        final int numeroAluno = scanner.nextInt();
        if (numeroAluno >= 1 && numeroAluno <= linhas) {
            final int indiceAluno = numeroAluno - 1;
            System.out.println("Dados atuais do aluno:");
            System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, matriz[indiceAluno][0]));
            System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, matriz[indiceAluno][1]));
            System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, matriz[indiceAluno][2]));
            System.out.println(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, matriz[indiceAluno][3]));
            System.out.println("Digite os novos dados do aluno:");
            System.out.print("Nome: ");
            matriz[indiceAluno][1] = scanner.next();
            System.out.print("Idade: ");
            matriz[indiceAluno][2] = scanner.next();
            System.out.print("Turma: ");
            matriz[indiceAluno][3] = scanner.next();
            System.out.println("Dados do aluno atualizados.");
        }
        else {
            System.out.println("N\u00famero de aluno inv\u00e1lido.");
        }
    }
    
    public static void main(final String[] args) {
        int alunos = 0;
        final int colunas = 4;
        final Scanner scanner = new Scanner(System.in);
        final int MAX_ALUNOS = 100;
        final String[][] lista = new String[MAX_ALUNOS][colunas];
        System.out.println("Bem-vindo ao Portal do Aluno High-Tech");
        System.out.println("Selecione uma op\u00e7\u00e3o abaixo:");
        int opcao;
        do {
            System.out.println("Escolha uma op\u00e7\u00e3o:\n1 - Mostrar lista de alunos\n2 - Inserir aluno\n3 - Remover aluno \n4 - Editar aluno\n0 - Sair");
            while (!scanner.hasNextInt()) {
                System.out.println("Op\u00e7\u00e3o inv\u00e1lida! Insira um n\u00famero inteiro.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            if (opcao == 0) {
                mensagemDespedida("");
            }
            switch (opcao) {
                case 0: {
                    continue;
                }
                case 1: {
                    if (alunos == 0) {
                        mensagem("");
                        continue;
                    }
                    mostrarAlunos(lista, alunos, colunas);
                    continue;
                }
                case 2: {
                    inserirAluno(lista, alunos, colunas);
                    ++alunos;
                    continue;
                }
                case 3: {
                    if (alunos == 0) {
                        mensagem("");
                        continue;
                    }
                    System.out.println("Insira o nome do aluno a ser removido:");
                    final String nomeAluno = scanner.next();
                    removerAluno(lista, alunos, nomeAluno);
                    continue;
                }
                case 4: {
                    if (alunos == 0) {
                        mensagem("Nenhum aluno registrado.");
                        continue;
                    }
                    editarAluno(lista, alunos);
                    continue;
                }
                default: {
                    System.out.println("Op\u00e7\u00e3o inv\u00e1lida!");
                    continue;
                }
            }
        } while (opcao != 0);
    }
}
