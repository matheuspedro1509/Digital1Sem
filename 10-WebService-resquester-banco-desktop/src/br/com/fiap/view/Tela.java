package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Cadastrar;
import br.com.fiap.bo.TimeBOStub.Time;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Slider;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtTitulo;
	private Text txtTurma;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNomeDoTime = new Label(shell, SWT.NONE);
		lblNomeDoTime.setBounds(10, 10, 120, 15);
		lblNomeDoTime.setText("Nome do time");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(10, 31, 120, 21);
		
		Label lblTitulos = new Label(shell, SWT.NONE);
		lblTitulos.setBounds(10, 58, 55, 15);
		lblTitulos.setText("Titulos");
		
		txtTitulo = new Text(shell, SWT.BORDER);
		txtTitulo.setBounds(10, 83, 120, 21);
		
		txtTurma = new Text(shell, SWT.BORDER);
		txtTurma.setBounds(10, 140, 120, 21);
		
		Label lblTurma = new Label(shell, SWT.NONE);
		lblTurma.setBounds(10, 119, 55, 15);
		lblTurma.setText("Turma");
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//recuperar as informaçoes da tela
				String nome=txtNome.getText();
				String turma=txtTurma.getText();
				int titulo=Integer.parseInt(txtTitulo.getText());
				try {
					TimeBOStub stub = new TimeBOStub();
					
					//instanciar um time
					Time time= new Time();
					time.setTurma(turma);
					time.setNome(nome);
					time.setTitulos(titulo);
					
					//instanciar o "Cadastrar".
					Cadastrar params= new Cadastrar();
				    
					//setar o time no "Cadastrar"
					 params.setTime(time);
				
					//chamar o metodo cadastrar do stub passando o "Cadastrar"
				    stub.cadastrar(params);
				    
				    //Exibir mensagem de sucesso
				    MessageBox dialog= new MessageBox(shell,SWT.OK);
				    dialog.setMessage("Time cadastrado");
				    dialog.open();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnCadastrar.setBounds(10, 187, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(198, 10, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(198, 31, 76, 21);
		
		Button btnExibir = new Button(shell, SWT.NONE);
		btnExibir.setBounds(303, 27, 75, 25);
		btnExibir.setText("Exibir");

	}
}
