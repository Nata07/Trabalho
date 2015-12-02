package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto implements PossuiNome {

	private IntegerProperty item;
	private StringProperty dadosProduto;
	private DoubleProperty valorUnd;
	private IntegerProperty quantidade;
	private DoubleProperty total;

	
	public Produto(String dadosProduto, Double valorUnd, Integer quantidade, Double total){
		this.dadosProduto = new SimpleStringProperty(dadosProduto);
		this.valorUnd = new SimpleDoubleProperty(valorUnd);
		this.quantidade = new SimpleIntegerProperty(quantidade);
		this.total= new SimpleDoubleProperty(total);
		
	}
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getItem() {
		return item.get();
	}
	
	 public IntegerProperty itemPropety() {
	       return item;
	 }
	 
	public void setItem(IntegerProperty item) {
		this.item = item;
	}
	// get settes nome
	public String getDadosProduto() {
		return dadosProduto.get();
	}
	public void setDadosProduto(StringProperty dadosProduto) {
		this.dadosProduto = dadosProduto;
	}
	 public StringProperty dadosProduto() {
	        return dadosProduto;
	 }
	 // get setters cpf 
	 public Double getValorUnd() {
			return valorUnd.get();
	}
	 public void setValorUnd(DoubleProperty valorund) {
		this.valorUnd = valorund;
	}
	 public DoubleProperty valorPropety() {
	       return valorUnd;
	 }
	 // get setters rg
	 public Integer getQuantidade() {
		return quantidade.get();
	}
	public void setQuantidade(IntegerProperty quantidade) {
		this.quantidade = quantidade;
	}
	public IntegerProperty quantidade() {
		 return quantidade;
	}
	//get setters endereco
	public Double getTotal() {
		return total.get();
	}
	public void setTotal(DoubleProperty total) {
		this.total = total;
	}
	 public DoubleProperty total() {
	    return total;
	 }
		
	}
