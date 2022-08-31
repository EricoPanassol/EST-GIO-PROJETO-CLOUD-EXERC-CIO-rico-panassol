import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        String nome, tipo;
        String nomeSetor = "";
        String itemParaAlterarNome, itemParaAlterarTipo;
        double itemParaAlterarPeso, itemParaAlterarVolume;
        int itemParaAlterarQuantiadade;
        String itemParaAlterarSetor = "";
        int itemParaAlterarIdPrateleria;
        double peso, volume;
        int quantidade, idPrateleira;

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

        int op = 0;
        while(op != -1){
            System.out.println("\n" +
                    "[1] - Imprimir estoque \n" +
                    "[2] - Adicionar itens \n" +
                    "[3] - Alterar item \n" +
                    "[4] -  \n" +
                    "[5] -  \n" +
                    "[6] -  \n" +
                    "[7] -  \n" +
                    "[-1] - Sair");
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
                    while(op != -1){
                        System.out.println("Adicionando o item " + countItem + "\nVoltar [S/N]");
                        String exit = sc.nextLine().toUpperCase();
                        if(exit.equals("S")){
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
                        System.out.println("Quantiadde: ");
                        quantidade = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                        switch(sc.nextInt()){
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
                        while(idPrateleira > 6){
                            System.out.println("Prateleira incorreta! \nTente novamente");
                            System.out.println("Id prateleira (1 - 5): ");
                            idPrateleira = sc.nextInt();
                        }
                        countItem++;
                        Item novo = new Item(nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira);
                        if(novo.getPeso() >= estoque.getSetor(nomeSetor).getPrateleira(idPrateleira).getPesoMax()){
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
                    System.out.println("Escolha o item que precisa ser alterado informando suas especificações: ");
                    System.out.println(estoque.toString());
                    System.out.println("Nome: ");
                    itemParaAlterarNome = sc.nextLine();
                    System.out.println("Tipo: ");
                    itemParaAlterarTipo = sc.nextLine();
                    System.out.println("Peso Total: ");
                    itemParaAlterarPeso = sc.nextDouble();
                    System.out.println("Volume Total: ");
                    itemParaAlterarVolume = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Quantiadde: ");
                    itemParaAlterarQuantiadade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                    switch(sc.nextInt()){
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
                    while(itemParaAlterarIdPrateleria > 6){
                        System.out.println("Prateleira incorreta! \nTente novamente");
                        System.out.println("Id prateleira (1 - 5): ");
                        itemParaAlterarIdPrateleria = sc.nextInt();
                    }
                    Item aux = new Item(itemParaAlterarNome, itemParaAlterarTipo, itemParaAlterarPeso, itemParaAlterarVolume,
                            itemParaAlterarQuantiadade, itemParaAlterarSetor, itemParaAlterarIdPrateleria);
                    if(estoque.getSetor(itemParaAlterarSetor).getPrateleira(itemParaAlterarIdPrateleria).contemItem(aux)){
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
                        System.out.println("Quantiadde: ");
                        quantidade = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Setores \n[1] - Padaria \n[2] - Açogue  \n[3] - Limpeza \n[4] - Frios");
                        switch(sc.nextInt()){
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
                        while(idPrateleira > 6){
                            System.out.println("Prateleira incorreta! \nTente novamente");
                            System.out.println("Id prateleira (1 - 5): ");
                            idPrateleira = sc.nextInt();
                        }
                        aux.alteraItem(nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira);
                        nao é o aux que tem q ser alterado, mas sim o item origianl
                        break;
                    }
                    System.out.println("Item não encontrado");
                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }
}
