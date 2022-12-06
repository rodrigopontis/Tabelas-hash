public class ArvoreRB<Tipo> {
    private NoRB<Tipo> raiz;
    public NoRB<Tipo> getRaiz(){
        return this.raiz;
    }

    // ---------------------------------# ##INSERCAO## #-------------------------------------------
    //inserir no x como em uma arvore binaria normal
    //pinte o nó de vermelho
    //Restaure as propriedades rubro negra
    //usando rotacao e recoloracao

    // 3 casos Quando x e o pai dele são VERMELHOS
    //o pai de x não pode ser raiz pois é vermelho
    // Casos simetricos 2 e 3
    // Caso 1: x tem um tio y vermelho ----------> trocar cor do pai, tio, avo
    // Caso 2: x tem o tio y preto e x é filho direito
    // Caso 3: x tem o tio y preto e x é o filho esquerdo
    // Outros casos sao os espelhamentos dos outros casos

    public void inserir2(int chave, Tipo k) {
        NoRB novoNo = new NoRB(chave, k);
        inserirRB(this.raiz, novoNo);
    }

    private void inserirRB(NoRB aComparar, NoRB aInserir) {
        //Se o no for null inserir Novo nó raiz SENAO
        if (aComparar == null) {
            this.raiz = aInserir;
            verificarBalanceamentoRB(aInserir);

        } else {

            //Se a chave a ser inserida for menor que a ja existente, avançar p/ esquerda
            if (aInserir.getChave() < aComparar.getChave()) {

                if (aComparar.getEsquerda() == null) {  //se nao exitir no a esquerda
                    aComparar.setEsquerda(aInserir); //No filho a esquerd do comparado settado para "No aInserido"
                    aInserir.setPai(aComparar); // settar o no comparado como  pai do "No aInserido"
                    //verificarBalanceamentoRB(); //fazer balanceamento de cores
                } else { //se não for nullo realizar denovo o procedimento anterior
                    inserirRB(aComparar.getEsquerda(), aInserir);
                }

            }else if (aInserir.getChave() > aComparar.getChave()) { //se a chave inserida for maior que a ja existente avançar para direita

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    //verificarBalanceamentoRB();
                } else { //se não for nullo realizar denovo o procedimento anterior
                    inserirRB(aComparar.getDireita(), aInserir);
                }
            }else{
            //nao faz nada pois o no faz existe
                }
            }
        }

    //---------------------------------# ##BALANCEAMENTO## #----------------------------------

    private void verificarBalanceamentoRB(NoRB noAtual){
        NoRB tio;
        //se o no for raiz entao: cor = preto
        if(noAtual.getEsquerda()==null && noAtual.getDireita()==null && noAtual.getPai() == null ){

            noAtual.setCor(Cor.black);
        }else{ // se a raiz for dferente de null
               // verificar se ele esta a direita ou a esquerda do pai dele

            while(noAtual.getPai().getCor() == Cor.red){ //cor do pai do noAtual = vermelho
            //2 situacoes
                //quando o pai de x é filho esquerdo do avo de x
                if(noAtual.getPai() == noAtual.getPai().getPai().getEsquerda()){
                    tio = noAtual.getPai().getPai().getDireita(); //tio do noAtual é filho direito

                    //aqui sera aplicado o CASO 1, CASO 2, CASO 3

                    if(tio.getCor()==Cor.red){                                  //CASO1
                        //trocar cor do pai, tio e avo
                        noAtual.getPai().setCor(Cor.black);
                        tio.setCor(Cor.black);
                        noAtual.getPai().getPai().setCor(Cor.red);
                    } else {

                        if(noAtual == noAtual.getPai().getDireita()){           //CASO 2
                            //noAtual = noAtual.getPai(); // verificar isso aq
                            rotacaoEsquerdaRB(noAtual);
                        }
                        noAtual.getPai().setCor(Cor.black);                      //CASO 3
                        noAtual.getPai().getPai().setCor(Cor.red);
                        rotacaoDireitaRB(noAtual.getPai().getPai()); //rotacao no avo
                    }
                //Espelhando todos os casos
                }else{ //senao: o pai do noAtual é filho esquerdo do Avo do atual

                    tio =  noAtual.getPai().getPai().getEsquerda();
                    if(tio.getCor()==Cor.red) {                                  //CASO1
                        //trocar cor do pai, tio e avo
                        noAtual.getPai().setCor(Cor.black);
                        tio.setCor(Cor.black);
                        noAtual.getPai().getPai().setCor(Cor.red);
                    }else {
                        if(noAtual == noAtual.getPai().getDireita()){
                            rotacaoDireitaRB(noAtual);
                        }
                        noAtual.getPai().setCor(Cor.black);                      //CASO 3
                        noAtual.getPai().getPai().setCor(Cor.red);
                        rotacaoEsquerdaRB(noAtual.getPai().getPai()); //rotacao no avo

                    }

                }
            }
            //settar cor da raiz pra preto
            this.raiz.setCor(Cor.black);
        }
    }

    //------------------------------------# ##BUSCA## #-----------------------------------
    public Tipo BuscaRB( int codigo, NoRB<Tipo> comparar ){
        if ( codigo == comparar.getChave() ){
            return comparar.getElemento();
        }
        else if(codigo < comparar.getChave() ){
            BuscaRB(codigo, comparar.getEsquerda());
        }
        else if (codigo > comparar.getChave() ){
            BuscaRB(codigo, comparar.getDireita());
        }
        return null;
    }

    //------------------------------------# ##ROTACOES## #-----------------------------------
        private NoRB rotacaoEsquerdaRB (NoRB inicial){

            NoRB direita = inicial.getDireita();  //No direita =  filho direito do inicial

            inicial.setPai(inicial.getPai());//O filho do inicial a direita -> Recebe o pai do inicial como seu pai

            inicial.setDireita(direita.getEsquerda()); //Inicial direita recebe no filho

            if (inicial.getDireita() != null) {
                inicial.getDireita();
            }
            direita.setEsquerda(inicial);
            inicial.setPai(direita);

            //Se exitir um pai do rotacionado
            if (direita.getPai() != null) {
                //Se a sub-arvore rotacionada estiver a Direita entao
                if (direita.getPai().getDireita() == inicial) {
                    direita.getPai().setDireita(direita);
                    //Se o sub arvore rotacionada estiver a Esquerda
                } else if (direita.getPai().getEsquerda() == inicial) {
                    //vai pegar o pai No que foi rotacionado e agora é o pai
                    //e colocar/settar ele na esquerda
                    direita.getPai().setEsquerda(direita);
                }
            }

            //setBalanceamento(inicial);
            //setBalanceamento(direita);

            return direita; // Retonar o No resultante rotacionado
            // apos rotacionar o no inicial para esquerda
        }

        private NoRB rotacaoDireitaRB (NoRB inicial){

            NoRB esquerda = inicial.getEsquerda();
            esquerda.setPai(inicial.getPai());

            inicial.setEsquerda(esquerda.getDireita());

            if (inicial.getEsquerda() != null) {
                inicial.getEsquerda().setPai(inicial);
            }

            esquerda.setDireita(inicial);
            inicial.setPai(esquerda);

            if (esquerda.getPai() != null) {

                if (esquerda.getPai().getDireita() == inicial) {
                    esquerda.getPai().setDireita(esquerda);

                } else if (esquerda.getPai().getEsquerda() == inicial) {
                    esquerda.getPai().setEsquerda(esquerda);
                }
            }
            //setBalanceamento(inicial);
            //setBalanceamento(esquerda);

            return esquerda;
        }
        private NoRB duplaRotacaoEsquerdaDireita (NoRB inicial){
            inicial.setEsquerda(rotacaoEsquerdaRB(inicial.getEsquerda()));
            return rotacaoDireitaRB(inicial);
        }
        private NoRB duplaRotacaoDireitaEsquerda (NoRB inicial){
            inicial.setDireita(rotacaoDireitaRB(inicial.getDireita()));
            return rotacaoEsquerdaRB(inicial);
        }
}
