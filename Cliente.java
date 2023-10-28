import org.opencv.core.Core;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame {
	private JPanel contentPane;
	private JTextField txtScreen;

	private Camera camera;

	public boolean ari_log = true;



	/**
	 * Create the frame.
	 */
	public Cliente() {

		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		txtScreen = new JTextField();
		txtScreen.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScreen.setFont(new Font("Arial", Font.BOLD, 18));
		txtScreen.setBounds(10, 11, 212, 42);
		contentPane.add(txtScreen);
		txtScreen.setColumns(10);


		/**
		 * Creat the buttons
		 */

		JButton btnClean = new JButton("C");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(""); // Borra el contenido de la pantalla
			}
		});
		btnClean.setForeground(new Color(255, 0, 0));
		btnClean.setFont(new Font("Arial", Font.BOLD, 17));
		btnClean.setBounds(173, 64, 55, 42);
		contentPane.add(btnClean);

		JButton btnCamera = new JButton("P");
		btnCamera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			if (camera == null){
				camera = new Camera();
				new Thread(new Runnable() {
					@Override
					public void run() {
						camera.camera_start();
					}
				}).start();
			}

			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						String text = camera.getText();
						if (text != null) {
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									txtScreen.setText(text);
								}
							});
							break;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				}
			}).start();

			}
		});
		btnCamera.setForeground(new Color(255, 0, 0));
		btnCamera.setFont(new Font("Arial", Font.BOLD, 17));
		btnCamera.setBounds(120, 64, 45, 42);
		contentPane.add(btnCamera);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "3");
			}
		});
		btn3.setFont(new Font("Arial", Font.BOLD, 18));
		btn3.setBounds(120, 117, 45, 36);
		contentPane.add(btn3);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "2");
			}
		});
		btn2.setFont(new Font("Arial", Font.BOLD, 18));
		btn2.setBounds(65, 117, 45, 36);
		contentPane.add(btn2);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "1");
			}
		});
		btn1.setFont(new Font("Arial", Font.BOLD, 18));
		btn1.setBounds(10, 117, 45, 36);
		contentPane.add(btn1);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "6");
			}
		});
		btn6.setFont(new Font("Arial", Font.BOLD, 18));
		btn6.setBounds(120, 164, 45, 36);
		contentPane.add(btn6);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "5");
			}
		});
		btn5.setFont(new Font("Arial", Font.BOLD, 18));
		btn5.setBounds(65, 164, 45, 36);
		contentPane.add(btn5);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "4");
			}
		});
		btn4.setFont(new Font("Arial", Font.BOLD, 18));
		btn4.setBounds(10, 164, 45, 36);
		contentPane.add(btn4);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "9");
			}
		});
		btn9.setFont(new Font("Arial", Font.BOLD, 18));
		btn9.setBounds(120, 211, 45, 36);
		contentPane.add(btn9);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "8");
			}
		});
		btn8.setFont(new Font("Arial", Font.BOLD, 18));
		btn8.setBounds(65, 211, 45, 36);
		contentPane.add(btn8);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "7");
			}
		});
		btn7.setFont(new Font("Arial", Font.BOLD, 18));
		btn7.setBounds(10, 211, 45, 36);
		contentPane.add(btn7);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "0");
			}
		});
		btn0.setFont(new Font("Arial", Font.BOLD, 18));
		btn0.setBounds(63, 258, 45, 36);
		contentPane.add(btn0);

		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + ".");
			}
		});
		btnDot.setForeground(new Color(255, 0, 0));
		btnDot.setFont(new Font("Arial", Font.BOLD, 23));
		btnDot.setBounds(8, 258, 45, 36);
		contentPane.add(btnDot);



		JButton btnSum = new JButton("+");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "+");
			}
		});
		btnSum.setForeground(Color.RED);
		btnSum.setFont(new Font("Arial", Font.BOLD, 18));
		btnSum.setBounds(173, 117, 45, 36);
		contentPane.add(btnSum);

		JButton btnSubs = new JButton("-");
		btnSubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "-");
			}
		});
		btnSubs.setForeground(Color.RED);
		btnSubs.setFont(new Font("Arial", Font.BOLD, 18));
		btnSubs.setBounds(175, 164, 45, 36);
		contentPane.add(btnSubs);

		JButton btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "*");
			}
		});
		btnMulti.setForeground(Color.RED);
		btnMulti.setFont(new Font("Arial", Font.BOLD, 18));
		btnMulti.setBounds(173, 211, 45, 36);
		contentPane.add(btnMulti);

		JButton btnDivi = new JButton("/");
		btnDivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "/");
			}
		});
		btnDivi.setForeground(Color.RED);
		btnDivi.setFont(new Font("Arial", Font.BOLD, 18));
		btnDivi.setBounds(173, 258, 45, 36);
		contentPane.add(btnDivi);

		JButton btnPorcentage = new JButton("%");
		btnPorcentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "%");
			}
		});
		btnPorcentage.setForeground(Color.RED);
		btnPorcentage.setFont(new Font("Arial", Font.BOLD, 18));
		btnPorcentage.setBounds(175, 305, 53, 36);
		contentPane.add(btnPorcentage);

		JButton btnLeftP = new JButton("(");
		btnLeftP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "(");
			}
		});
		btnLeftP.setForeground(Color.RED);
		btnLeftP.setFont(new Font("Arial", Font.BOLD, 18));
		btnLeftP.setBounds(8, 305, 45, 36);
		contentPane.add(btnLeftP);

		JButton btnRightP = new JButton(")");
		btnRightP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + ")");
			}
		});
		btnRightP.setForeground(Color.RED);
		btnRightP.setFont(new Font("Arial", Font.BOLD, 18));
		btnRightP.setBounds(63, 305, 45, 36);
		contentPane.add(btnRightP);


		JButton btnXOR = new JButton("^");
		btnXOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "^");
			}
		});
		btnXOR.setForeground(Color.BLUE);
		btnXOR.setFont(new Font("Arial", Font.BOLD, 18));
		btnXOR.setBounds(175, 350, 45, 36);
		contentPane.add(btnXOR);
		btnXOR.setVisible(false);

		JButton btnAnd = new JButton("&");
		btnAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "&");
			}
		});
		btnAnd.setForeground(Color.BLUE);
		btnAnd.setFont(new Font("Arial", Font.BOLD, 18));
		btnAnd.setBounds(8, 350, 47, 36);
		contentPane.add(btnAnd);
		btnAnd.setVisible(false);

		JButton btnOr = new JButton("|");
		btnOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "|");
			}
		});
		btnOr.setForeground(Color.BLUE);
		btnOr.setFont(new Font("Arial", Font.BOLD, 18));
		btnOr.setBounds(63, 350, 45, 36);
		contentPane.add(btnOr);
		btnOr.setVisible(false);

		JButton btnNot = new JButton("~");
		btnNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "~");
			}
		});
		btnNot.setForeground(Color.BLUE);
		btnNot.setFont(new Font("Arial", Font.BOLD, 18));
		btnNot.setBounds(120, 350, 45, 36);
		contentPane.add(btnNot);
		btnNot.setVisible(false);

		JButton btnV = new JButton("V");
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "V");
			}
		});
		btnV.setFont(new Font("Arial", Font.BOLD, 18));
		btnV.setBounds(10, 64, 47, 36);
		contentPane.add(btnV);
		btnV.setVisible(false);

		JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScreen.setText(txtScreen.getText() + "F");
			}
		});
		btnF.setFont(new Font("Arial", Font.BOLD, 18));
		btnF.setBounds(63, 64, 45, 36);
		contentPane.add(btnF);
		btnF.setVisible(false);

		JButton btnAL = new JButton("AL");
		btnAL.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ari_log = !ari_log;
				txtScreen.setText("");

				if (ari_log == false){
					btnXOR.setVisible(true);
					btnAnd.setVisible(true);
					btnOr.setVisible(true);
					btnNot.setVisible(true);
					btnV.setVisible(true);
					btnF.setVisible(true);

					btn1.setVisible(false);
					btn2.setVisible(false);
					btn3.setVisible(false);
					btn4.setVisible(false);
					btn5.setVisible(false);
					btn6.setVisible(false);
					btn7.setVisible(false);
					btn8.setVisible(false);
					btn9.setVisible(false);
					btn0.setVisible(false);
					btnDot.setVisible(false);

					btnSum.setVisible(false);
					btnSubs.setVisible(false);
					btnDivi.setVisible(false);
					btnMulti.setVisible(false);
					btnPorcentage.setVisible(false);

				} else{
					btnXOR.setVisible(false);
					btnAnd.setVisible(false);
					btnOr.setVisible(false);
					btnNot.setVisible(false);
					btnV.setVisible(false);
					btnF.setVisible(false);

					btn1.setVisible(true);
					btn2.setVisible(true);
					btn3.setVisible(true);
					btn4.setVisible(true);
					btn5.setVisible(true);
					btn6.setVisible(true);
					btn7.setVisible(true);
					btn8.setVisible(true);
					btn9.setVisible(true);
					btn0.setVisible(true);
					btnDot.setVisible(true);

					btnSum.setVisible(true);
					btnSubs.setVisible(true);
					btnDivi.setVisible(true);
					btnMulti.setVisible(true);
					btnPorcentage.setVisible(true);

				}

			}
		});
		btnAL.setForeground(Color.RED);
		btnAL.setFont(new Font("Arial", Font.BOLD, 18));
		btnAL.setBounds(120, 305, 45, 36);
		contentPane.add(btnAL);

		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				send_data(txtScreen.getText());

			}
		});
		btnIgual.setForeground(Color.RED);
		btnIgual.setFont(new Font("Arial", Font.BOLD, 18));
		btnIgual.setBounds(120, 258, 45, 36);
		contentPane.add(btnIgual);
	}

	private void send_data(String data){
		try{

			Socket socket = new Socket("127.0.0.1", 34723);

			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			pw.println(ari_log + ":" + data);

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String last_result = br.readLine();
			txtScreen.setText(last_result);

			pw.close();
			os.close();
			socket.close();

		} catch (IOException e){
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}