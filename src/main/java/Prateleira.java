import java.util.ArrayList;
import java.util.List;

public class Prateleira {

    private final static double pesoMax = 100;
    private final static double volumeMax = 100;
    private static double controlaPeso = 0;
    private static double controlaVolume = 0;
    private List<Item> listaItems;
    private int id;

    // Construção da prateleira
    public Prateleira(int id) {
        this.id = id;
        this.listaItems = new ArrayList<>();
    }

    // Método que retorna o peso máximo de cada prateleira
    public double getPesoMax() {
        return pesoMax;
    }

    // Método que retorna o volume máximo de cada prateleira
    public double getVolumeMax() {
        return volumeMax;
    }

    // Retorna o id da prateleira
    public int getId(){
        return this.id;
    }

    // Método que retorna um determinado item na prateleira
    public Item getItemNaPrateleira(String nome, String tipo){
        for(Item item : listaItems){
            if(item.getNome().equals(nome) && item.getTipo().equals(tipo)){
                return item;
            }
        }
        return null;
    }

    // Método que retorna true se um determinado item está contido na prateleira
    // e false caso o contrário
    public boolean contemItem(String nome, String tipo, String nomeSetor, int idPrateleira){
        for(Item i : listaItems){
            if(i.getNome().equals(nome) &&
                i.getTipo().equals(tipo) &&
                i.getNomeSetor().equals(nomeSetor) &&
                i.getIdPrateleira() == idPrateleira){
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
    // Esse método também contra o peso máximo e volume máximo da prateleira, impedindo a adição
    // do item caso os limites seja ultrapassados
    public void addItem(Item item){
        if(controlaPeso+item.getPeso() <= this.getPesoMax() && controlaVolume+item.getVolume() <= this.getVolumeMax()){
            for(Item i : listaItems) {
                if (this.contemItem(item.getNome(), item.getTipo(), item.getNomeSetor(), item.getIdPrateleira())) {
                    Item posItem = listaItems.get(this.procurarIndexDoItem(i));
                    posItem.setQuantidade(posItem.getQuantidade() + item.getQuantidade());
                    posItem.setPeso(posItem.getPeso() + item.getPeso());
                    posItem.setVolume(posItem.getVolume() + item.getVolume());
                    controlaPeso = (controlaPeso + item.getPeso());
                    controlaVolume = (controlaVolume + item.getVolume());
                    return;
                }
            }
            listaItems.add(item);
            controlaPeso = (controlaPeso + item.getPeso());
            controlaVolume = (controlaVolume + item.getVolume());
        }
    }

    // Método que permite a aleteração de um determinado item na prateleira
    public void alteraItemPrateleira(Item item, String nome, String tipo, double peso, double volume, int quantidade, String nomeSetor, int idPrateleira){
        for(Item i : listaItems){
            if(i.equals(item) && listaItems.contains(item)){
                i.alteraItem(nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira);
                return;
            }
        }
    }

    // Método usado para remove "x" unidades determinado item na prateleira, cuidando para ver
    // se esse mesmo item já está contido nela, se sim, a quantidade, peso e volume são decrementados
    // de acordo com as especificações do item a ser removido, se não, o item é removido por completo
    // Faz também o controle do peso e volume máximo da prateleira
    public void retiraUnidades(int quantidade, Item item){
        for (Item i : listaItems) {
            if (i.equals(item) && this.contemItem(i.getNome(), i.getTipo(), i.getNomeSetor(), i.getIdPrateleira()) && i.getQuantidade() > 1) {
                item.setPeso(i.getPeso() - (item.getPesoUni() * quantidade));
                item.setVolume(i.getVolume() - (item.getVolUni() * quantidade));
                item.setQuantidade(i.getQuantidade() - quantidade);
                controlaPeso = (controlaPeso - (item.getPesoUni()*quantidade));
                controlaVolume = (controlaVolume - (item.getVolUni()*quantidade));
                return;
            } else if (i.equals(item) && this.contemItem(i.getNome(), i.getTipo(), i.getNomeSetor(), i.getIdPrateleira()) && i.getQuantidade() == 1) {
                this.removeItemDaPrateleira(item);
                return;
            }
        }

    }

    // Método usado para fazer a remoção por completo de um determinado item na prateleira
    // controlando peso e volume máximo
    public void removeItemDaPrateleira(Item item){
        if(listaItems.contains(item) && item.getQuantidade() > 0){
            controlaPeso = (controlaPeso - item.getPeso());
            controlaVolume = (controlaVolume - item.getVolume());
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