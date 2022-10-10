public class UsinaNaoRenovavel extends Usina {
    private Combustivel combustivel;

    public UsinaNaoRenovavel(String nome, double producaoMWh, double custoMWh, Combustivel combustivel) {
        super(nome, producaoMWh, custoMWh);
        this.combustivel = combustivel;
    }

    @Override
    public double calculaPrecoMWh() {
        double preco = 0;
        if(combustivel==Combustivel.CARVAO) {
            preco = getCustoMWh() + (getCustoMWh() * 0.2);
        } else if(combustivel==Combustivel.NUCLEAR) {
            preco = getCustoMWh() + (getCustoMWh() * 0.1);
        }
        else {
            preco = getCustoMWh() + (getCustoMWh() * 0.3);
        }
        return preco;
    }

    @Override
    public String geraResumo() { //implementar
        return null;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }
}
