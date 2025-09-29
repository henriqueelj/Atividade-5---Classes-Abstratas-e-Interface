package AtividadePOO;

    public class Produto{
        private String nome;
        private double preco;
        private int estoque;

        public Produto(String nome, double preco){
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome(){
            return nome;
        }
        public double getPreco(){
            return preco;
        }
        public int getEstoque(){
            return estoque;
        }
        public void setNome(String nome){
            this.nome = nome;
        }
        public void setPreco(double preco){
            this.preco = preco;
        }
        public void setEstoque(int estoque){
            this.estoque = estoque;
        }

        public void adicionarEstoque(int quantidade){
            if(quantidade > 0) {
                this.estoque += quantidade;
            };
        }

    }
