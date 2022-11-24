import java.lang.reflect.Array;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class Hash<Tipo> {

    // Funcao Hash Linear
    //      h(x) = x % m
    // Quando colidir
    //      h'(x) = ( h(x) + j ) % m  ---> para j = 1
    int operador; // chave/valor
    Tipo[] vetor;
    Lista<Tipo>[] lista; //lista do tipo Tipo
    ArvoreAVL<Tipo> arvoreAVL;

    //Criar Tabela atraves de um construtor de classe
    Hash(int operador){
        this.operador = operador;
        vetor = (Tipo[]) new Object[operador];
                            //Objeto generaliza o Tipo[] para o Tipo que quisermos passar
        lista = new Lista[operador];
        for (int i = 0; i < operador; i++) lista[i] = new Lista<Tipo>();
    }

    Hash(Tipo valor){
        if(vetor!=null){

        }else {
            System.out.println("Vetor não existe");
            this.operador = 37;
            vetor = (Tipo[]) new Object[this.operador];

            InserirValorLinear(Tipo valor);
        }
    }

    void InserirValorLinear(Tipo valor) {
        int chave = aluno.getMatricula() % this.operador;

        //converter aluno para Tipo;
        if (vetor[chave] != null) {
            int i = chave + 1;

            while (i < vetor.length) {
                if (vetor[i] == null) {
                    vetor[i] = (Tipo) aluno;
                    return;
                } else {
                    i++;
                }
            }

            InserirValorListaEncadeada(Tipo valor);
        }else{
            vetor[chave] = (Tipo) aluno;
        }
    }

    
    //Poderia ser um tipo Aluno em vez de "Tipo", mas nós estamos fazendo no vetor um Aluno como tipo "Tipo"
    Tipo BuscarLinear(int codigo){
        Tipo perdido;
        
        if(vetor[codigo % this.operador] != null){
            perdido = vetor[codigo % this.operador]
        }else{
            // Buscando na lista encadeada
            perdido = buscaNaListaEncadeada(valor);
        }

        return perdido;
    }

    void print(){
        System.out.println(this.vetor);
    }

    public String toString() {
        String out = "";
        for(int i = 0; i < operador; i++) {
            out += "" + i + ": ";
            out += lista[i % operador] + "\n";
        }
        return out;
    }

    void InserirValorListaEncadeada(Aluno aluno) {
        int chave = aluno.getMatricula() % this.operador;
        lista[chave].inserir((Tipo)aluno);
    }

    void InserirValorArvoreAVL(Tipo valor){
        arvoreAVL = new ArvoreAVL();

        arvoreAVL.inserir()
    }

}
