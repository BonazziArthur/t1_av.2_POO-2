import java.util.ArrayList;
import java.util.Objects;

public class Conglomerado { //METODO CSV
    private ArrayList<Usina> listaDeUsinas = new ArrayList<>();

    public boolean cadastraUsina(Usina usinaRecebida) { //OK
        for (Usina usinaCadastrada : listaDeUsinas) {
            if (usinaRecebida.getNome().equals(usinaCadastrada.getNome())) {
                return false;
            }
        }
        listaDeUsinas.add(usinaRecebida);
        return true;

    }

    public Usina pesquisaUsina(String nome) { //ok
        for (Usina usinaCadastrada : listaDeUsinas) {
            if (usinaCadastrada.getNome().equals(nome)) {
                return usinaCadastrada;
            }
        }
        return null;
    }

    public ArrayList<Usina> listaTodasUsinas() { //OK
        if (listaDeUsinas.isEmpty()) {
            return null;
        }
        return listaDeUsinas;
    }

    public double consultaPreco(String nome) { //ok
        for (Usina usinaCadastrada : listaDeUsinas) {
            if (usinaCadastrada.getNome().equals(nome)) {
                return usinaCadastrada.calculaPrecoMWh();
            }
        }
        return -1.0;
    }

    public boolean salvaDadosArquivo(String nomeArquivo) {  //IMPLEMENTAR
        return true;
    }


    public ArrayList<Usina> getListaDeUsinas() {
        return listaDeUsinas;
    }

    public void setListaDeUsinas(ArrayList<Usina> listaDeUsinas) {
        this.listaDeUsinas = listaDeUsinas;
    }
}
