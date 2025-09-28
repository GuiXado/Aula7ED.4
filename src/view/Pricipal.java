/**
 * Deve ter também uma classe Principal no package view com operações usando JOp�onPane que permita
ao usuário inserir e validar os documentos de entrada e iniciar um procedimento de impressão. A aplicação
deve rodar até uma opção de saída ser selecionada pelo usuário
 */

package view;

import br.gui.filagenerica.*;
import javax.swing.JOptionPane;
import controller.ImpressoraController;

public class Pricipal {

	public static void main(String[] args) {
		ImpressoraController ic = new ImpressoraController();
		Fila<String> f = new Fila<>();
		
		String menu = "1 - Inserir Documento\n"
				+ "2 - Imprimir Documento\n"
				+ "0 - sair";
		
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
				case 1:
					String d = JOptionPane.showInputDialog("Digite: ID_PC;Nome_Arquivo");
					if (d != null && d.contains(";")) {
						 String[] partes = d.split(";");
	                        if (partes.length == 2) {
	                        	ic.insereDocumento(f, d);
	                        	JOptionPane.showMessageDialog(null, "Documento inserido!");
	                        	
	                        } else {
	                        	JOptionPane.showMessageDialog(null, "Formato inválido! Use: ID_PC;Nome_Arquivo");
	                        }
					}
					break;
				case 2:
					ic.imprime(f);
					break;
				case 0:
					
					break;
				default:
					JOptionPane.showMessageDialog(null, "Entrada inválida");
			}
		}while (opc != 0);
		
	}

}
