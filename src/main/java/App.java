import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String nome, tipo;
        String nomeSetor = "";
        String itemParaAlterarNome, itemParaAlterarTipo;
        double itemParaAlterarPeso, itemParaAlterarVolume;
        int itemParaAlterarQuantiadade;
        String itemParaAlterarSetor = "";
        int itemParaAlterarIdPrateleria;
        double peso, volume;
        int quantidade, idPrateleira;
        Item novo;

        Scanner sc = new Scanner(System.in);

        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 2, "Padaria", 1);
        Item i1 = new Item("Detergente", "Limpeza", 10, 10, 2, "Limpeza", 2);
        Item i2 = new Item("Queijo", "Laticínio", 10, 10, 2, "Frios", 3);
        Item i3 = new Item("Carne", "Comestível", 10, 10, 2, "Açogue", 4);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);
        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);

        estoque.addNoEstoque(itemList);

        System.out.println("Bem Vindo ao Sistema de Gerência de Estoque de Mercado");
        int op = -1;
        while (op != 0) {
            System.out.println("\n" +
                    "[1] - Consultar estoque \n" +
                    "[2] - Adicionar itens \n" +
                    "[3] - Alterar item \n" +
                    "[4] - Remover item \n" +
                    "[5] - Consultar item \n" +
                    "[6] - Consultar itens por setor \n" +
                    "[7] - Consultar itens por prateleira \n" +
                    "[8] - Consultar prateleiras por setor \n" +
                    "[0] - Sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println(estoque.toString());
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Adicione uma lista de itens de acordo com os setores (" +
                            "Padaria - Açogue - Limpeza - Frios)");
                    int countItem = 1;
                    while (op != -1) {
                        System.out.println("Adicionando o item " + countItem + "\nCancelar - [S/N]");
                        String exit = sc.nextLine().toUpperCase();
                        if (exit.equals("S")) {
                            break;
                        }
                        System.out.println("Nome: ");
                        nome = sc.nextLine();
                        System.out.println("Tipo: ");
                        tipo = sc.nextLine();
                        System.out.println("Peso: ");
                        peso = sc.nextDouble();
                        System.out.println("Volume: ");
                        volume = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Quantidade: ");
                        quantidade = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                        switch (sc.nextInt()) {
                            case 1:
                                nomeSetor = "Padaria";
                                break;
                            case 2:
                                nomeSetor = "Açogue";
                                break;
                            case 3:
                                nomeSetor = "Limpeza";
                                break;
                            case 4:
                                nomeSetor = "Frios";
                                break;
                        }
                        System.out.println("Id prateleira (1 - 5): ");
                        idPrateleira = sc.nextInt();
                        while (idPrateleira > 6) {
                            System.out.println("Prateleira incorreta! \nTente novamente");
                            System.out.println("Id prateleira (1 - 5): ");
                            idPrateleira = sc.nextInt();
                        }
                        countItem++;
                        novo = new Item(nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira);
                        if (novo.getPeso() >= estoque.getSetor(nomeSetor).getPrateleira(idPrateleira).getPesoMax()) {
                            System.out.println("Esse item é muito pesado, não é possíve adicionná-lo!");
                            break;
                        }
                        itemList.add(novo);
                        estoque.addNoEstoque(itemList);
                        sc.nextLine();
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println(estoque.toString());
                    System.out.println("Escolha o item que precisa ser alterado informando suas especificações: ");
                    System.out.println("Nome: ");
                    itemParaAlterarNome = sc.nextLine();
                    System.out.println("Tipo: ");
                    itemParaAlterarTipo = sc.nextLine();
                    System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                    switch (sc.nextInt()) {
                        case 1:
                            itemParaAlterarSetor = "Padaria";
                            break;
                        case 2:
                            itemParaAlterarSetor = "Açogue";
                            break;
                        case 3:
                            itemParaAlterarSetor = "Limpeza";
                            break;
                        case 4:
                            itemParaAlterarSetor = "Frios";
                            break;
                    }
                    System.out.println("Id prateleira: ");
                    itemParaAlterarIdPrateleria = sc.nextInt();
                    while (itemParaAlterarIdPrateleria > 6) {
                        System.out.println("Prateleira incorreta! \nTente novamente");
                        System.out.println("Id prateleira (1 - 5): ");
                        itemParaAlterarIdPrateleria = sc.nextInt();
                    }

                    sc.nextLine();
                    System.out.println("Insira as novas informações: ");
                    System.out.println("Nome: ");
                    nome = sc.nextLine();
                    System.out.println("Tipo: ");
                    tipo = sc.nextLine();
                    System.out.println("Peso: ");
                    peso = sc.nextDouble();
                    System.out.println("Volume: ");
                    volume = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Quantidade: ");
                    quantidade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                    switch (sc.nextInt()) {
                        case 1:
                            nomeSetor = "Padaria";
                            break;
                        case 2:
                            nomeSetor = "Açogue";
                            break;
                        case 3:
                            nomeSetor = "Limpeza";
                            break;
                        case 4:
                            nomeSetor = "Frios";
                            break;
                    }
                    System.out.println("Id prateleira (1 - 5): ");
                    idPrateleira = sc.nextInt();
                    while (idPrateleira > 6) {
                        System.out.println("Prateleira incorreta! \nTente novamente");
                        System.out.println("Id prateleira (1 - 5): ");
                        idPrateleira = sc.nextInt();
                    }
                    estoque.alteraItemEstoque(estoque.getItem(itemParaAlterarNome, itemParaAlterarTipo, itemParaAlterarSetor, itemParaAlterarIdPrateleria),
                            nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira
                            );
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println(estoque.toString());
                    System.out.println("Escolha o item que precisa ser removido informando suas especificações: ");
                    System.out.println("Nome: ");
                    itemParaAlterarNome = sc.nextLine();
                    System.out.println("Tipo: ");
                    itemParaAlterarTipo = sc.nextLine();
                    System.out.println("Peso Total: ");
                    itemParaAlterarPeso = sc.nextDouble();
                    System.out.println("Volume Total: ");
                    itemParaAlterarVolume = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Quantidade: ");
                    itemParaAlterarQuantiadade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                    switch (sc.nextInt()) {
                        case 1:
                            itemParaAlterarSetor = "Padaria";
                            break;
                        case 2:
                            itemParaAlterarSetor = "Açogue";
                            break;
                        case 3:
                            itemParaAlterarSetor = "Limpeza";
                            break;
                        case 4:
                            itemParaAlterarSetor = "Frios";
                            break;
                    }
                    System.out.println("Id prateleira: ");
                    itemParaAlterarIdPrateleria = sc.nextInt();
                    while (itemParaAlterarIdPrateleria > 6) {
                        System.out.println("Prateleira incorreta! \nTente novamente");
                        System.out.println("Id prateleira (1 - 5): ");
                        itemParaAlterarIdPrateleria = sc.nextInt();
                    }
                    novo = estoque.getSetor(itemParaAlterarSetor).getPrateleira(itemParaAlterarIdPrateleria).getItemNaPrateleira(itemParaAlterarNome, itemParaAlterarTipo);
                    estoque.removeItemDoEstoque(novo);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println(estoque.toString());
                    System.out.println("Escolha o item que precisa ser removido informando suas especificações: ");
                    System.out.println("Nome: ");
                    nome = sc.nextLine();
                    System.out.println("Tipo: ");
                    tipo = sc.nextLine();
                    //sc.nextLine();
                    System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                    switch (sc.nextInt()) {
                        case 1:
                            nomeSetor = "Padaria";
                            break;
                        case 2:
                            nomeSetor = "Açogue";
                            break;
                        case 3:
                            nomeSetor = "Limpeza";
                            break;
                        case 4:
                            nomeSetor = "Frios";
                            break;
                    }
                    System.out.println("Id prateleira: ");
                    idPrateleira = sc.nextInt();
                    while (idPrateleira > 6) {
                        System.out.println("Prateleira incorreta! \nTente novamente");
                        System.out.println("Id prateleira (1 - 5): ");
                        idPrateleira = sc.nextInt();
                    }
                    System.out.println(estoque.getSetor(nomeSetor).getPrateleira(idPrateleira).getItemNaPrateleira(nome, tipo).toString());
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Escolha o setor que deseja ver os itens: ");
                    System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                    switch (sc.nextInt()) {
                        case 1:
                            nomeSetor = "Padaria";
                            break;
                        case 2:
                            nomeSetor = "Açogue";
                            break;
                        case 3:
                            nomeSetor = "Limpeza";
                            break;
                        case 4:
                            nomeSetor = "Frios";
                            break;
                    }
                    System.out.println(estoque.getSetor(nomeSetor).toString());
                    break;
                case 7:
                    sc.nextLine();
                    System.out.println("Escolha o id da prateleira que deseja ver os itens: ");
                    idPrateleira = sc.nextInt();
                    while (idPrateleira > 6) {
                        System.out.println("Prateleira incorreta! \nTente novamente");
                        System.out.println("Id prateleira (1 - 5): ");
                        idPrateleira = sc.nextInt();
                    }
                    System.out.println(estoque.procuraItemsNaPrateleiraNoSetorNoEstoque(idPrateleira));
                    break;
                case 8:
                    sc.nextLine();
                    System.out.println("Escolha o setor que deseja ver as prateleiras: ");
                    System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                    switch (sc.nextInt()) {
                        case 1:
                            nomeSetor = "Padaria";
                            break;
                        case 2:
                            nomeSetor = "Açogue";
                            break;
                        case 3:
                            nomeSetor = "Limpeza";
                            break;
                        case 4:
                            nomeSetor = "Frios";
                            break;
                    }
                    System.out.println(estoque.consultaPrateleirasPorSetor(nomeSetor));
                    break;
                case 0:
                    System.out.println("[*] - Saindo do programa...");
                    System.exit(1);
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }
}

