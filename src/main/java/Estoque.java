import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Setor> setores;

    // Ao criar o estoque, os setores também são criados
    public Estoque() {
        Setor padaria = new Setor("Padaria");
        Setor acogue = new Setor("Açogue");
        Setor frios = new Setor("Frios");
        Setor limpeza = new Setor("Limpeza");

        this.setores = new ArrayList<>();
        this.setores.add(padaria);
        this.setores.add(acogue);
        this.setores.add(frios);
        this.setores.add(limpeza);
    }

    // Método usado para adicionar uma lista de itens no estoque
    // organizando por setor e após a adição, a lista de itens
    // é esvaziada
    public void addNoEstoque(List<Item> listItem){
        for(Item item : listItem){
            String nomeSetorItem = item.getNomeSetor();
            switch(nomeSetorItem){
                case "Padaria":
                    setores.get(0).addNoSetor(item);
                    break;
                case "Açogue":
                    setores.get(1).addNoSetor(item);
                    break;
                case "Frios":
                    setores.get(2).addNoSetor(item);
                    break;
                case "Limpeza":
                    setores.get(3).addNoSetor(item);
                    break;
            }
        }
        listItem.clear();
    }

    // Método que permite a visualização de um determinado item no estoque
    public String verItemNoEstoque(Item item){
        for(Setor sAux : setores){
            if(sAux.getNome().equals(item.getNomeSetor())){
                return sAux.toString();
            }
        }
        return  null;
    }

    // Método que permite a alteração de um determinado item no estoque
    public void alteraItemEstoque(Item item, String nome, String tipo, double peso, double volume, int quantidade, String nomeSetor, int idPrateleira){
        for(Setor sAux : setores){
            if(sAux.getNome().equals(item.getNomeSetor())){
                sAux.alteraItemSetor(item, nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira);
                return;
            }
        }
    }

    // Método que permite a remoção de "x" unidades do mesmo item do estoque,
    // cuidando para alterar o valor do volume e peso caso
    // a quantidade desse item seja maior que um, se for igual a um, caso contrário,
    // remove o item
    public void retiraUnidadesDoEstoque(int quantidade, Item item){
        for (Setor sAux : setores) {
            if (sAux.getNome().equals(item.getNomeSetor()) && item.getQuantidade() > 1) {
                sAux.retiraUnidadesDoSetor(quantidade, item);
                return;
            } else {
                this.removeDoItemEstoque(item);
            }
        }
    }

    // Método que permite a remoção de um item por completo e todas suas unidades
    public void removeDoItemEstoque(Item item){
        for (Setor sAux : setores) {
            if (sAux.getNome().equals(item.getNomeSetor())) {
                sAux.removeItemDoSetor(item);
            }
        }
    }

    // Método que permite procurar itens que estão organizados na mesma prateleira,
    // a partir do id dela
    public String procuraItemsNaPrateleiraNoSetorNoEstoque(int id) {
        String itens = "";
        for (Setor sAux : setores) {
            Prateleira p = sAux.getPrateleira(id);
            itens += p.toString();
        }
        return itens;
    }

    // Método usado para retornar um determinado setor
    public Setor getSetor(String setor){
        switch(setor){
            case "Padaria":
                return setores.get(0);
            case "Açogue":
                return setores.get(1);
            case "Frios":
                return setores.get(2);
            case "Limpeza":
                return setores.get(3);
        }
        return null;
    }

    // Método que permita a consulta de itens por setor, especificando o nome dele
    public String consultaItensPorSetorEstoque(String setor){
        String itens = "";
        for(Setor sAux : setores){
            if(sAux.getNome().equals(setor)){
                Setor s = this.getSetor(setor);
                sAux.consultaItensPorSetorSetor(setor);
                itens += s.toString();
            }
        }
        return itens;
    }

    // Método que permite a consulta de todas as prateleiras no mesmo setor,
    // especificando o nome dele
    public String consultaPrateleirasPorSetor(String setor){
        String prat = "";
        for(Setor sAux : setores){
            if(sAux.getNome().equals(setor)){
                prat += sAux.prateleirasPorSetor() + "\n";
            }
        }
        return prat;
    }

    // Mostrar todos os itens que estão que estão nos setores, chama a o toString()
    // dos Setor
    @Override
    public String toString(){
        String output = "";
        for(Setor s : setores){
            output += s.toString();
        }
        return output;
    }


}