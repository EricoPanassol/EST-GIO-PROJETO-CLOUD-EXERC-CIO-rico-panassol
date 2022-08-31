import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void criaItem(){
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

        System.out.println(estoque.toString());
    }

    @Test
    public void deveSomarPesoVolumeEQuantidadeNumItemJaContido(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 2, "Padaria", 1);


        Item i4 = new Item("Pão", "Comestível", 7, 5, 5, "Padaria", 1);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);
        itemList.add(i4);

        estoque.addNoEstoque(itemList);

        System.out.println(estoque.toString());
    }

    @Test
    public void deveRemoverItemDoEstoque(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 5, "Padaria", 1);
        Item i1 = new Item("Detergente", "Limpeza", 10, 10, 2, "Limpeza", 2);
        Item i2 = new Item("Queijo", "Laticínio", 10, 10, 2, "Frios", 3);
        Item i3 = new Item("Carne", "Comestível", 10, 10, 2, "Açogue", 4);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);
        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);

        estoque.addNoEstoque(itemList);

        //System.out.println(estoque.toString());

        estoque.removeItemDoEstoque(i0);

        System.out.println(estoque.toString());
    }

    @Test
    public void deveSerPossivelRemoverXUnidadesDeUmItemDoEstoqueSeEsseItemTiverQuantidadeMaiorQueUm(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 5, "Padaria", 1);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);

        estoque.addNoEstoque(itemList);

        System.out.println(estoque.toString());

        estoque.retiraUnidadesDoEstoque(1, i0);

        System.out.println(estoque.toString());
    }

    @Test
    public void seAQuantidadeForIgualAUmOItemEhRemovido(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 1, "Padaria", 1);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);

        estoque.addNoEstoque(itemList);

        System.out.println(estoque.toString());

        estoque.retiraUnidadesDoEstoque(5, i0);

        System.out.println(estoque.toString());
    }

    @Test
    public void deveSerPossivelConsultarUmItem(){
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

        System.out.println(estoque.toString());

        System.out.println("-----------------------------------------\n");

        System.out.println(estoque.verItemNoEstoque(i0));
    }

    @Test
    public void deveSerPossivelAlterarUmItem(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 5, "Padaria", 1);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);

        estoque.addNoEstoque(itemList);

        System.out.println(estoque.toString());

        estoque.alteraItemEstoque(i0, "Queijo", "Laticínio", 10, 10, 2, "Frios", 3);

        System.out.println(estoque.toString());
    }

    @Test
    public void consultaDeItensPorSetor(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 2, "Padaria", 1);
        Item i1 = new Item("Detergente", "Limpeza", 10, 10, 2, "Limpeza", 2);
        Item i2 = new Item("Queijo", "Laticínio", 10, 10, 2, "Frios", 1);
        Item i3 = new Item("Carne", "Comestível", 10, 10, 2, "Açogue", 4);
        Item i4 = new Item("Sonho", "Comestível", 10, 10, 2, "Padaria", 5);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);
        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);
        itemList.add(i4);

        estoque.addNoEstoque(itemList);

        System.out.println(estoque.consultaItensPorSetorEstoque("Padaria"));
    }

    @Test
    public void consultaItensPorPrateleira(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 2, "Padaria", 1);
        Item i1 = new Item("Detergente", "Limpeza", 10, 10, 2, "Limpeza", 2);
        Item i2 = new Item("Queijo", "Laticínio", 10, 10, 2, "Frios", 1);
        Item i3 = new Item("Carne", "Comestível", 10, 10, 2, "Açogue", 4);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);
        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);

        estoque.addNoEstoque(itemList);


        System.out.println(estoque.procuraItemsNaPrateleiraNoSetorNoEstoque(1));
    }

    @Test
    public void consultaPrateleirasPorSetor(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 2, "Padaria", 1);
        Item i1 = new Item("Detergente", "Limpeza", 10, 10, 2, "Limpeza", 2);
        Item i2 = new Item("Queijo", "Laticínio", 10, 10, 2, "Frios", 1);
        Item i3 = new Item("Carne", "Comestível", 10, 10, 2, "Açogue", 4);
        Item i4 = new Item("Sonho", "Comestível", 10, 10, 2, "Padaria", 5);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);
        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);
        itemList.add(i4);

        estoque.addNoEstoque(itemList);

        System.out.println(estoque.consultaPrateleirasPorSetor("Limpeza"));
    }

    @Test
    public void testaPesoEVolumeMax(){
        Estoque estoque = new Estoque();

//        Item i0 = new Item("Pão", "Comestível", 40, 10, 3, "Padaria", 1);
//        Item i1 = new Item("Detergente", "Limpeza", 40, 10, 3, "Limpeza", 2);
//        Item i2 = new Item("Queijo", "Laticínio", 5, 10, 3, "Frios", 3);
        Item i3 = new Item("Pão", "Comestível", 10, 10, 5, "Padaria", 1);
        //Item i4 = new Item("Carne", "Comestível",10, 10, 1, "Açogue", 4);

        List<Item> itemList = new ArrayList<>();

//        itemList.add(i0);
//        itemList.add(i1);
//        itemList.add(i2);
        itemList.add(i3);
        //itemList.add(i4);

        estoque.addNoEstoque(itemList);

        System.out.println(estoque.toString());

        //estoque.retiraUnidadesDoEstoque(1, i3);
        estoque.removeItemDoEstoque(i3);

        System.out.println(estoque.toString());

    }

    @Test
    public void deveAddNaMesmaPrateleiraItensDoMesmoTipo(){
        Estoque estoque = new Estoque();

        Item i0 = new Item("Pão", "Comestível", 10, 10, 2, "Padaria", 1);
        Item i1 = new Item("Detergente", "Limpeza", 10, 10, 2, "Limpeza", 2);
        Item i2 = new Item("Queijo", "Laticínio", 10, 10, 2, "Frios", 3);
        Item i3 = new Item("Carne", "Comestível", 10, 10, 5, "Açogue", 4);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i0);
        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);

        estoque.addNoEstoque(itemList);


        //System.out.println(estoque.toString());
        //System.out.println("ID PRAT CARNE: " + i3.getIdPrateleira());
        //System.out.println(i3.toString());

        //System.out.println(estoque.procuraItemsNaPrateleiraNoSetorNoEstoque(1));
    }


}
