package controller;

import javax.swing.JOptionPane;
import br.gui.filagenerica.*;

public class ImpressoraController {

	public void insereDocumento (Fila<String> f, String documento) {
		f.insert(documento);
	}
	
	public void imprime(Fila<String> f) {
		if (f.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vazia");
		} else {
			while(!f.isEmpty()) {
				try {
					String doc = f.remove(); 
	                String[] partes = doc.split(";");
	                String idPC = partes[0];
	                String nomeArquivo = partes[1];

	                JOptionPane.showMessageDialog(null, "[#PC: " + idPC + " – Arquivo: " + nomeArquivo + "]");
	                if (!f.isEmpty()) {
	                	Thread.sleep((int)((Math.random()* 1001) + 1000));	                	
	                } else {
		                JOptionPane.showMessageDialog(null, "Fim da Lista");
	                }
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}

