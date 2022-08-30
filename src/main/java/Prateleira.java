import java.util.ArrayList;
import java.util.List;

public class Prateleira {

    private final double pesoMax;
    private final double volumeMax;
    private List<Item> listaItems;
    private int id;

    // Construção da prateleira
    public Prateleira(int id) {
        this.id = id;
        this.pesoMax = 100;
        this.volumeMax = 100;
        this.listaItems = new ArrayList<>();
    }

    // Retorna o id da prateleira
    public int getId(){
        return this.id;
    }

    // Método que retorna true se um determinado item está contido na prateleira
    // e false caso o contrário
    public boolean contemItem(Item item){
        for(Item i : listaItems){
            if(i.getNome().equals(item.getNome())){
                return true;
            }
        }
        return false;
    }

    // Método que procura o index do item a partir do próprio item
    public int procurarIndexDoItem(Item item){
        for (int i = 0; i < listaItems.size(); i++) {
            if(listaItems.get(i).getNome().equals(item.getNome())){
                return i;
            }
        }
        return -1;
    }

    // Método usado para adicionar um determinado item na prateleira, cuidando para ver
    // se esse mesmo item já está contido nela, se sim, a ]quantidade, peso e volume são incrementados
    // de acordo com as especificações do item a ser adicionado, se não, o item é adicionado
    public void addItem(Item item){
        for(Item i : listaItems) {
            if (this.contemItem(i)) {
                Item posItem = listaItems.get(this.procurarIndexDoItem(i));
                posItem.setQuantidade(posItem.getQuantidade() + i.getQuantidade());
                posItem.setPeso(posItem.getPeso() + i.getPeso());
                posItem.setVolume(posItem.getVolume() + i.getVolume());
                return;
            }
        }
        listaItems.add(item);
    }

    // Método que permite a aleteração de um determinado item na prateleira
    public void alteraItemPrateleira(Item item, String nome, String tipo, double peso, double volume, int quantidade, String nomeSetor, int idPrateleira){
        for(Item i : listaItems){
            if(i.equals(item) && this.contemItem(item)){
                i.alteraItem(nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira);
                return;
            }
        }
    }

    // Método usado para remove "x" unidades determinado item na prateleira, cuidando para ver
    // se esse mesmo item já está contido nela, se sim, a quantidade, peso e volume são decrementados
    // de acordo com as especificações do item a ser removido, se não, o item é removido por completo
    public void retiraUnidades(int quantidade, Item item){
        for(Item i : listaItems){
            if(i.equals(item) && this.contemItem(i) && item.getQuantidade() > 1){
                item.setPeso(i.getPeso() - (item.getPesoUni()*quantidade));
                item.setVolume(i.getVolume() - (item.getVolUni()*quantidade));
                item.setQuantidade(i.getQuantidade() - quantidade);
                return;
            }
            else if(i.equals(item) && this.contemItem(i) && i.getQuantidade() == 1){
                this.removeItemDaPrateleira(item);
                return;
            }
        }
    }

    // Método usado para fazer a remoção por completo de um determinado item na prateleira
    public void removeItemDaPrateleira(Item item){
        if(listaItems.contains(item) && item.getQuantidade() > 0){
            listaItems.remove(item);
        }
    }

    // Método usado para a consulta de itens a partir do nome do setor
    public void consultaItensPorSetorPrateleira(String setor){
        String itens = "";
        for(Item i : listaItems){
            if(i.getNomeSetor().equals(setor)){
                itens += i.getIdPrateleira() + "\n";
            }
        }
    }

    // Método que exibe o id da prateleira dos itens
    public String prateleiraToString(){
        String i = "";
        for(Item item : listaItems){
            i += "Prateleira: " + item.getIdPrateleira() + "\n";
        }
        return i;
    }

    // Mostrar todos os itens, chama o toString() de Item
    @Override
    public String toString(){
        String i = "";
        for(Item item : listaItems){
             i += item.toString();
        }
        return i;
    }





}