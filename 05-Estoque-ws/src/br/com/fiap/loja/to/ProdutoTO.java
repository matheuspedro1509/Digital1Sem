package  br.com.fiap.loja.to;

public class ProdutoTO {
		
		 
	private int codigo;
	
	private String descricao;
	
	private double precoUnitario;
		 
    private int qtEstoque;
    
	public ProdutoTO() {
		super();
	}
	public ProdutoTO(int codigo, String descricao, double precoUnitario, int qtEstoque) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.qtEstoque = qtEstoque;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getQtEstque() {
		return qtEstoque;
	}
	public void setQtEstque(int qtEstque) {
		this.qtEstoque = qtEstque;
	}
	 
	
		
}
