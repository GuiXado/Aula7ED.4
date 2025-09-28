/**
 * insereDocumento(Fila f, String documento): void, o documento no formato
ID_PC;Nome_Arquivo (Já validado antes do envio) deverá enfileirar os documentos
enviados


- imprime(Fila f):void, que desenfilera um documento da fila, por vez, exibe no console
[#PC: ID_PC – Arquivo: Nome_Arquivo]. Cada impressão dura de 1 a 2 segundos usar
Math.random() ou a classe Random e um Thread.sleep*(tempo) para simular o tempo
de impressão. Exibir uma exceção caso não haja documento na fila de impressão.
 */

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
