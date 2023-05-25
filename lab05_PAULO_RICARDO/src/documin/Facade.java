package documin;

public class Facade {
	private DocumentoController documentoController;
	
	public Facade() {
		this.documentoController = new DocumentoController();
	}
	
	public boolean criarDocumento(String tituloDoc) {
		return this.documentoController.criaDocumento(tituloDoc);
	}
	
	public boolean criarDocumento(String tituloDoc, int tamanhoMaximo) {
		return this.documentoController.criaDocumento(tituloDoc, tamanhoMaximo);
	}
	
	public void removerDocumento(String tituloDoc) {
		this.documentoController.removerDocumento(tituloDoc);
	}
	
	public int contarElementos(String tituloDoc) {
		this.documentoController.contarElementos(tituloDoc);
	}
	
	public String[] exibirDocumento(String tituloDoc) {
		this.documentoController.exibirDocumento(tituloDoc);
	}
	
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {}
	
	public int criarVisaoCompleta(String tituloDoc)
	public int criarVisaoResumida(String tituloDoc)
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade)
	public int criarVisaoTitulo(String tituloDoc)
	public String[] exibirVisao(int visaoId)

}
