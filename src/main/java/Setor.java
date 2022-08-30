import java.util.ArrayList;
import java.util.List;

public class Setor {

    private List<Prateleira> listPrateleira;
    private String nome;

    // Ao criar o setor as pratelerias também são criadas
    public Setor(String nome) {
        this.nome = nome;

        Prateleira p1 = new Prateleira(1);
        Prateleira p2 = new Prateleira(2);
        Prateleira p3 = new Prateleira(3);
        Prateleira p4 = new Prateleira(4);
        Prateleira p5 = new Prateleira(5);

        this.listPrateleira = new ArrayList<>();

        this.listPrateleira.add(p1);
        this.listPrateleira.add(p2);
        this.listPrateleira.add(p3);
        this.listPrateleira.add(p4);
        this.listPrateleira.add(p5);
    }

    // Método que retorna o nome do setor
    public String getNome(){
        return this.nome;
    }

    // Método que permite a adição de um item no setor
    public void addNoSetor(Item item){
        listPrateleira.get(item.getIdPrateleira()-1).addItem(item);
    }

    // Método que permite a alteração de um item no setor
    public void alteraItemSetor(Item item, String nome, String tipo, double peso, double volume, int quantidade, String nomeSetor, int idPrateleira){
        for(Prateleira pAux : listPrateleira){
            if(pAux.contemItem(item)){
                pAux.alteraItemPrateleira(item, nome, tipo, peso, volume, quantidade, nomeSetor, idPrateleira);
                return;
            }
        }
    }

    // Método que permite a remoção de "x" unidades do mesmo item do setor,
    // cuidando para alterar o valor do volume e peso caso
    // a quantidade desse item seja maior que um, se for igual a um, caso contrário,
    // remove o item
    public void retiraUnidadesDoSetor(int quantidade, Item item){
        for (Prateleira pAux : listPrateleira) {
            if (pAux.contemItem(item) && item.getQuantidade() > 1) {
                pAux.retiraUnidades(quantidade, item);
            } else if (pAux.contemItem(item) && item.getQuantidade() == 1) {
                this.removeItemDoSetor(item);
            }
        }
    }

    // Método que permite a remoção de um item por completo e todas suas unidades
    public void removeItemDoSetor(Item item){
        for (Prateleira pAux : listPrateleira) {
            if (pAux.contemItem(item)) {
                pAux.removeItemDaPrateleira(item);
                return;
            }
        }
    }

    // Método que retorna uma prateleira a partir de seu id
    public Prateleira getPrateleira(int id){
        return listPrateleira.get(id-1);
    }

    // Método que consulta itens por setor, passando o nome dele
    public void consultaItensPorSetorSetor(String setor){
        String itens = "";
        for(Prateleira pAux : listPrateleira){
            if(this.getNome().equals(setor)){
                pAux.consultaItensPorSetorPrateleira(setor);
                itens += pAux.toString() + "\n";
            }
        }
    }

    // Método que consulta as prateleiras por setor
    public String prateleirasPorSetor(){
        String output = "";
        for(Prateleira p : listPrateleira){
            output += p.prateleiraToString();
        }
        return output;
    }

    // Mostrar todos os itens que estão que estão nas pratelerias, chama o toString()
    // da Prateleira
    @Override
    public String toString(){
        String output = "";
        for(Prateleira p : listPrateleira){
            output += p.toString();
        }
        return output;
    }
}