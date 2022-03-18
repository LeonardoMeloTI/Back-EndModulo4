package models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Destino {
	private Integer idDestino;
	private String nomeDestino;
	private String localPartida;
	private Integer horasDeViagem;
	private Date dataViagem;
	private Double preco;
	
	
	public Integer getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public String getLocalPartida() {
		return localPartida;
	}
	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}
	public Integer getHorasDeViagem() {
		return horasDeViagem;
	}
	public void setHorasDeViagem(Integer horasDeViagem) {
		this.horasDeViagem = horasDeViagem;
	}
	public Date getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		
		int dia, mes, ano;
		Scanner sc = new Scanner(System.in);
		System.out.println("Fale qual dia do mês embarcara? ");
		dia = sc.nextInt();
		System.out.println("Fale o mês que ocorrerá a viagem? (1 a 12) ");
		mes = sc.nextInt();
		mes-=1;
		System.out.println("Fale o ano da viagem? ");
		ano = sc.nextInt();
		
		
		
		Calendar dataCalendario = new GregorianCalendar(ano, mes, dia);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		String dataText = sdf.format(dataCalendario.getTime());
		try {
			dataViagem = sdf.parse(dataText);
			this.dataViagem = dataViagem;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
