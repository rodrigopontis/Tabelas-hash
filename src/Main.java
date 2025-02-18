import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> disciplinas = new ArrayList<String>();
        disciplinas.add("ed2");
        disciplinas.add("es");

        Aluno<String> Malti = new Aluno(1234, "Malty", disciplinas);
        Aluno<String> Malty = new Aluno(123, "Malti", disciplinas);
        Aluno<String> Rod = new Aluno(4, "Rod", disciplinas);
        Aluno<String> canetazul = new Aluno(8, "canetazul", disciplinas);
        Aluno<String> felipe = new Aluno(48, "felipe", disciplinas);
        Aluno<String> teste = new Aluno(44, "alfred", disciplinas);
        Aluno<String> mcfly = new Aluno(80, "mcfly", disciplinas);
        Aluno<String> ximenes = new Aluno(3, "ximenes", disciplinas);
        Aluno<String> ximenes2 = new Aluno(9, "ximene2s", disciplinas);


        //Aluno<String> qualquer = criaAluno();

        //System.out.println("Nome do Aluno: " + qualquer.getNome()+ "\n" + "Nome da Matricula: " + qualquer.getMatricula() +"\n" + "Nome da(s) Diciplina(s): "+ qualquer.getCadeiras());

        Hash tabelaHash = new Hash(6);

        System.out.println("Insersao Linear:\n");
        tabelaHash.InserirValorLinear(Malti);
        tabelaHash.InserirValorLinear(mcfly);
        tabelaHash.InserirValorLinear(Rod);
        tabelaHash.InserirValorLinear(canetazul);
        tabelaHash.InserirValorLinear(Malty);
        tabelaHash.InserirValorLinear(felipe);
        tabelaHash.InserirValorLinear(teste);
        tabelaHash.InserirArvoreAVL(teste.getMatricula(),teste);

        tabelaHash.InserirArvoreRB(ximenes.getMatricula(),ximenes);



        //tabelaHash.InserirValorLinear(qualquer);
        System.out.println(tabelaHash);
        System.out.println();
        System.out.println(tabelaHash.BuscarLinear(48));
        System.out.println(tabelaHash.BuscaArvoreAVL(teste.getMatricula()));
        System.out.println(tabelaHash.BuscaArvoreRB(ximenes.getMatricula()));


    }
    private static Aluno< String> criaAluno() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do Aluno:");
        String nome = scan.next();

        System.out.println("Digite a matrícula do Aluno:");
        Integer matricula = scan.nextInt();

        System.out.println("Inserir cadeiras do Aluno: ");
        System.out.println("Digite o numero de cadeiras: ");

        int num_cadeiras = scan.nextInt();

        ArrayList<String> cadeiras = new ArrayList<String>();


        System.out.println("Digite as diciplinas: ");


        for (int i = 0; i < num_cadeiras; i++) {

            String nome_cadeiras = scan.next();

            cadeiras.add(nome_cadeiras);
        }

        Aluno<String> novoAluno = new Aluno(matricula, nome, cadeiras);

        return novoAluno;
    }
}



