public class UsinaRenovavel extends Usina {
    private FonteEnergia fonteEnergia;

    public UsinaRenovavel(String nome, double producaoMWh, double custoMWh, FonteEnergia fonteEnergia) {
        super(nome, producaoMWh, custoMWh);
        this.fonteEnergia = fonteEnergia;
    }

    @Override
    public double calculaPrecoMWh() {
        double preco = 0;
        if (fonteEnergia == FonteEnergia.EOLICA) {
            preco = getCustoMWh() + (getCustoMWh() * 0.15);
        } else if (fonteEnergia == FonteEnergia.HIDRICA) {
            preco = getCustoMWh() + (getCustoMWh() * 0.5);
        } else {
            preco = getCustoMWh() + (getCustoMWh() * 0.25);
        }
        return preco;
    }

    @Override
    public String geraResumo() { //implementar - CSV
        return null;
    }

    public FonteEnergia getFonteEnergia() {
        return fonteEnergia;
    }
}
