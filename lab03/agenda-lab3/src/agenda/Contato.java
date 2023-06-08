package agenda;

/**
 * Classe que encapsula o conceito de contato de uma agenda.
 * Contato tem nome, sobrenome, telefone e pode ser favoritado.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favoritado;
    
    /**
     * Cria um contato.
     */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public boolean getFavoritado() {
    	return favoritado;
    }
    
    public void setFavorito(boolean favoritado) {
    	this.favoritado = favoritado;
    }
    
    
    /**
     * Compara os nomes e sobrenomes de 2 contatos.
     * 
     * @param nome Nome do contato que deseja-se cadastrar
     * @param sobrenome Sobrenome do contato que deseja-se cadastrar
     * @return Retorna true ou false
     */
    public boolean equals(String nome, String sobrenome) {
    	if (getNome() != null && getSobrenome() != null) {
    		return getNome().toLowerCase().equalsIgnoreCase(nome) && 
    				getSobrenome().toLowerCase().equalsIgnoreCase(sobrenome);
    	}
    	
    	return false;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), nome, sobrenome);
    }

    /**
     * Faz a representação da entidade contato. A representação segue o estilo "[nome] [sobrenome] [telefone]"
     * ou "❤️ [nome] [sobrenome] [telefone]" caso o contato esteja entre os favoritos.
     * 
     * @return
     */
    public String toString() {
    	if (sobrenome == null || sobrenome.isBlank()) {
    		if (favoritado) {
        		return "❤️ " + nome + "\n" + telefone;
        	}
            return nome + "\n" + telefone;
    	}
    	
    	if (favoritado) {
    		return "❤️ " + nome + " " + sobrenome + "\n" +
            		telefone;
    	}
    	
        return nome + " " + sobrenome + "\n" +
        		telefone;
    }
}