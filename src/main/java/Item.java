public class Item {

    private String nome;
    private String tipo;
    private double peso;
    private double volume;
    private String nomeSetor;
    private int quantidade;
    private int idPrateleira;

    // Construtor dos itens
    public Item(String nome, String tipo, double peso, double volume, int quantidade, String nomeSetor, int idPrateleira) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.volume = volume;
        this.quantidade = quantidade;
        this.nomeSetor = nomeSetor;
        this.idPrateleira = idPrateleira;
    }

    // Método que permite a alteração de um item
    public void alteraItem(String nome, String tipo, double peso, double volume, int quantidade, String nomeSetor, int idPrateleira){
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.volume = volume;
        this.quantidade = quantidade;
        this.nomeSetor = nomeSetor;
        this.idPrateleira = idPrateleira;
    }

    // Método que retorna o nome do item
    public String getNome() {
        return nome;
    }

    // Método que retorna o peso total de todas as unidades do item
    public double getPeso() {
        return peso;
    }

    // Método que retorna o peso unitário do item
    public double getPesoUni() {
        return peso/getQuantidade();
    }

    // Método que muda o peso de um item
    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Método que retorna o volume total de todas as unidades do item
    public double getVolume() {
        return volume;
    }

    // Método que retorna o volume unitário do item
    public double getVolUni() {
        return volume/getQuantidade();
    }

    // Método que muda o volume de um item
    public void setVolume(double volume) {
        this.volume = volume;
    }

    // Método que retorna a quantidade de itens
    public int getQuantidade() {
        return quantidade;
    }

    // Método que muda a quantidade de itens
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método que retorna o id da prateleira onde está o item
    public int getIdPrateleira(){
        return this.idPrateleira;
    }

    // Método que retorna o nome do estor onde está o item
    public String getNomeSetor(){
        return this.nomeSetor;
    }

    // Método que mostra tdoas as especificações do item
    @Override
    public String toString() {
        return  " Nome              :   " + nome + "\n" +
                " Tipo              :   " + tipo + "\n" +
                " Peso Total        :   " + peso + "\n" +
                " Peso Unitário     :   " + getPesoUni() + "\n" +
                " Volume            :   " + volume + "\n" +
                " Volume Unitário   :   " + getVolUni() + "\n" +
                " Quantidade        :   " + quantidade + "\n" +
                " Setor             :   " + nomeSetor + "\n" +
                " Prateleira        :   " + idPrateleira +
                "\n\n";
    }


}