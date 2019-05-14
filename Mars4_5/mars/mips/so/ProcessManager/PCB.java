package mars.mips.so.ProcessManager;
import javax.swing.JOptionPane;

import mars.mips.hardware.*;
import mars.util.SystemIO;


public class PCB {
private int [] regValue = new int[35];  //INTEIROS  - REGISTRADORES
private int limInf, limSup; //Endereços limite de memória
private static int seq = 0;
private int pid; //Número do Processo (sequencial)
private char estado; //P - pronto, E - executando ou B - bloqueado
private int PC; //Program Counter (Endereço inicial ou onde o PC trocou de processo)
private  int prioridade;

	
	public PCB() {
		// TODO Auto-generated constructor stub
	
		setPid(seq++); //Incrementa o PID 
		
	
		
	}

	
	//Pega conteúdo dos registradores físicos
	public  void getRegFisicos() { 

			for (int i=0 ; i<32; i++) {
				this.regValue[i] = RegisterFile.getValue(i);
			}
				this.regValue[33]= RegisterFile.getValue(33); //hi
				this.regValue[34]= RegisterFile.getValue(34); //lo
				//O PC é pego em outro local
		}
	
	//Altera o conteúdo dos registradores físicos		
	public void setRegFisicos() {
		for (int i=0 ; i<32; i++) {	
			RegisterFile.updateRegister(i, this.regValue[i]) ; 
		 
		}
			RegisterFile.updateRegister(33, this.regValue[33]);  //hi
			RegisterFile.updateRegister(34, this.regValue[34]);  //lo
			RegisterFile.setProgramCounter(getPC()); //Altera o valor de PC
	}

	public int[] getRegValue() {
		return regValue;
	}



	public void setRegValue(int[] reg) {
		this.regValue = reg;
	}



	public int getLimInf() {
		return limInf;
	}


	public void setLimInf(int limInf) {
		this.limInf = limInf;
	}


	public int getLimSup() {
		return limSup;
	}


	public void setLimSup(int limSup) {
		this.limSup = limSup;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	public int getPC() {
		return PC;
	}


	public void setPC(int pC) {
		PC = pC;
	}


	public int getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	

}
