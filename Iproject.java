import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class Iproject {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iproject window = new Iproject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Iproject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		
		JButton btnCargarArchivo = new JButton("Cargar Archivo");
		btnCargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Colocar ruta de acceso para cargar el archivo
		            Scanner input = new Scanner(new File("Descargas"));
		            while (input.hasNextLine()) {
		                String line = input.nextLine();
		                textArea.append(line + "\n");
		            }
		            JOptionPane.showMessageDialog(null, "El archivo se ha cargado exitosamente:)");
		            //System.out.println(textArea.getText());
		            //("\n")
		            input.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnCargarArchivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCargarArchivo.setBounds(12, 5, 161, 25);
		frame.getContentPane().add(btnCargarArchivo);
		
		JButton btnCor = new JButton("Correr");
		btnCor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textoTotal = textArea.getText();				
				String progra = textoTotal.replaceAll("\n"," ").replaceAll("\r"," ").replaceAll("\t", " ").replace("(", "( ").replace(")", " )").replaceAll("  ", " ").replaceAll("   ", " ");
				Decode decode = new Decode(progra);
				decode.interpret();
			}
		});
		btnCor.setBounds(526, 386, 97, 25);
		frame.getContentPane().add(btnCor);
		
		JButton btnGuardarArchivo = new JButton("Guardar Archivo");
		btnGuardarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texto = textArea.getText();				
					String[] Code = texto.split("\n");
					String contenido = "";
					//Colocar ruta de acceso para guardar el archivo
		            String ruta = "Descargas";
		            for(int i=0; i<Code.length;i++) {
		            contenido = contenido + Code[i] + "\n" ;
		            }
		            File file = new File(ruta);
		            
		            // Si el archivo no existe es creado
		            if (!file.exists()) {
		                file.createNewFile();
		            }
		            FileWriter fw = new FileWriter(file);
		            BufferedWriter bw = new BufferedWriter(fw);
		            bw.write(contenido);
		            bw.close();
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
				System.out.println("Archivo guardado exitosamente :)");
			}
		});
		btnGuardarArchivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardarArchivo.setBounds(185, 6, 161, 25);
		frame.getContentPane().add(btnGuardarArchivo);
		
		
		textArea.setBounds(12, 49, 613, 331);
		frame.getContentPane().add(textArea);
	}
}
