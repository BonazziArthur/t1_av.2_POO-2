import java.util.ArrayList;
import java.util.Scanner;

public class ACMEEnergy {
    private Conglomerado conglomerado;
    private Scanner in;

    public ACMEEnergy() {
        conglomerado = new Conglomerado();
        in = new Scanner(System.in);
    }

    public void executa() {
        int escolha;
        do {
            menu();
            escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 0:
                    break;
                case 1:
                    cadastrarNovaUsina(); //MAIS COMPLICADO
                    break;
                case 2:
                    pesquisarUsina(); //ok
                    break;
                case 3:
                    listarTodasUsinas(); //ok
                    break;
                case 4:
                    consultarPrecoMwh(); //conferir renck
                    break;
                case 5:
                    salvarUsinasArquivo(); //pesquisar como fazer
                    break;
            }
        } while (escolha != 0);
    }

    private void menu() {
        System.out.println("=============================");
        System.out.println("Opcoes:");
        System.out.println("[0] Sair");
        System.out.println("[1] Cadastrar nova usina");
        System.out.println("[2] Pesquisar uma usina");
        System.out.println("[3] Listas todas as usinas");
        System.out.println("[4] Consulta o preço do MWh:");
        System.out.println("[5] Salvar usinas em arquivo");
        System.out.println("Opcao desejada: ");
    }

    public void inicializa() {
        UsinaRenovavel usinaRenovavel1, usinaRenovavel2;
        UsinaNaoRenovavel usinaNaoRenovavel1, usinaNaoRenovavel2;

        usinaRenovavel1 = new UsinaRenovavel("Lapa", 158.7, 2, FonteEnergia.SOLAR);
        conglomerado.cadastraUsina(usinaRenovavel1);
        usinaNaoRenovavel1 = new UsinaNaoRenovavel("Springfield", 120.0, 3, Combustivel.PETROLEO);
        conglomerado.cadastraUsina(usinaNaoRenovavel1);
        usinaRenovavel2 = new UsinaRenovavel("Vale", 120.0, 3, FonteEnergia.EOLICA);
        conglomerado.cadastraUsina(usinaRenovavel2);
    }

    public void cadastrarNovaUsina() { //FOCAR
        System.out.println("Insira os dados de uma nova usina para cadastrá-la");

        System.out.println("Nome: ");
        String nome = in.nextLine();
        System.out.println("Producao MWh: ");
        double producaoMWh = in.nextDouble();
        System.out.println("Custo Mwh: ");
        double custoMWh = in.nextDouble();

    }

    public void pesquisarUsina() { //ok
        System.out.println("Insira o nome de uma usina para pesquisá-la: ");
        String nome = in.nextLine();
        Usina usinaCadastrada = conglomerado.pesquisaUsina(nome);
        if (usinaCadastrada == (null)) {
            System.out.println("Nenhuma usina localizada com este nome.");
            return;
        }
        System.out.println("Nome: " + usinaCadastrada.getNome());
        System.out.println("Producao de MWh: " + usinaCadastrada.getProducaoMWh());
        System.out.println("Custo por MWh: " + usinaCadastrada.getCustoMWh());
        //fonte de energia ou combustivel?

    }

    private void listarTodasUsinas() { //ok
        ArrayList<Usina> usinasCadastradas = conglomerado.listaTodasUsinas();
        if (usinasCadastradas == null) {
            System.out.println("Nenhuma usina cadastrada.");
        } else {
            for (Usina usina : usinasCadastradas) {
                System.out.println("Nome: " + usina.getNome());
                System.out.println("Producao de MWh: " + usina.getProducaoMWh());
                System.out.println("Custo de MWh: " + usina.getCustoMWh());

                if (usina instanceof UsinaNaoRenovavel) {
                    UsinaNaoRenovavel usinaNaoRenovavel = (UsinaNaoRenovavel) usina;
                    System.out.println("Combustivel: " + usinaNaoRenovavel.getCombustivel());
                } else {
                    UsinaRenovavel usinaRenovavel = (UsinaRenovavel) usina;
                    System.out.println("Fonte de Energia: " + usinaRenovavel.getFonteEnergia());
                }
            }
        }
    }

    public void consultarPrecoMwh() { //CONFERIR com o renck
        System.out.println("Insira o nome de uma usina para consultar seu preco por MWh: ");
        String nome = in.nextLine();
        double usinaCadastrada = conglomerado.consultaPreco(nome);
        if (usinaCadastrada == -1.0) {
            System.out.println("Nenhuma usina foi localizada com este nome.");
            return;
        }
        System.out.println(usinaCadastrada);

    }

    public void salvarUsinasArquivo() {

    }
}
