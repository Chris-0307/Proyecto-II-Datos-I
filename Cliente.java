import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame {
    private JPanel contentPane;
	private JTextField txtPantalla;
    private StringBuilder operacionActual = new StringBuilder(); // Almacena la operación actual

	
	// VARIABLES
	double numero1;

	String operacion;
	
	public static void main(String[] args) {
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
		
		
		
		txtPantalla = new JTextField();
		txtPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPantalla.setFont(new Font("Arial", Font.BOLD, 18));
		txtPantalla.setBounds(10, 11, 212, 42);
		contentPane.add(txtPantalla);
		txtPantalla.setColumns(10);
		txtPantalla.setText(operacionActual.toString());

		
        /**
         * Creat the buttons
         */
		
		JButton btnLimpiar = new JButton("C");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(""); // Borra el contenido de la pantalla
			}
		});
		btnLimpiar.setForeground(new Color(255, 0, 0));
		btnLimpiar.setFont(new Font("Arial", Font.BOLD, 17));
		btnLimpiar.setBounds(173, 64, 55, 42);
		contentPane.add(btnLimpiar);

        JButton btnCamera = new JButton("P");
        btnCamera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        // Codigo para la camara
	        }
		});
        btnCamera.setForeground(new Color(255, 0, 0));
		btnCamera.setFont(new Font("Arial", Font.BOLD, 17));
		btnCamera.setBounds(120, 64, 45, 42);
		contentPane.add(btnCamera);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "3");
    		}
		});
		btn3.setFont(new Font("Arial", Font.BOLD, 18));
		btn3.setBounds(120, 117, 45, 36);
		contentPane.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "2");
    		}
		});
		btn2.setFont(new Font("Arial", Font.BOLD, 18));
		btn2.setBounds(65, 117, 45, 36);
		contentPane.add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "1");
    		}
		});
		btn1.setFont(new Font("Arial", Font.BOLD, 18));
		btn1.setBounds(10, 117, 45, 36);
		contentPane.add(btn1);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "6");
    		}
		});
		btn6.setFont(new Font("Arial", Font.BOLD, 18));
		btn6.setBounds(120, 164, 45, 36);
		contentPane.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "5");
    		}
		});
		btn5.setFont(new Font("Arial", Font.BOLD, 18));
		btn5.setBounds(65, 164, 45, 36);
		contentPane.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "4");
    		}
		});
		btn4.setFont(new Font("Arial", Font.BOLD, 18));
		btn4.setBounds(10, 164, 45, 36);
		contentPane.add(btn4);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "9");
    		}
		});
		btn9.setFont(new Font("Arial", Font.BOLD, 18));
		btn9.setBounds(120, 211, 45, 36);
		contentPane.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "8");
    		}
		});
		btn8.setFont(new Font("Arial", Font.BOLD, 18));
		btn8.setBounds(65, 211, 45, 36);
		contentPane.add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "7");
    		}
		});
		btn7.setFont(new Font("Arial", Font.BOLD, 18));
		btn7.setBounds(10, 211, 45, 36);
		contentPane.add(btn7);
		
		JButton btnCero = new JButton("0");
		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "0");
    		}
		});
		btnCero.setFont(new Font("Arial", Font.BOLD, 18));
		btnCero.setBounds(63, 258, 45, 36);
		contentPane.add(btnCero);
		
		JButton btnPunto = new JButton(".");
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + ".");
			}
		});
		btnPunto.setForeground(new Color(255, 0, 0));
		btnPunto.setFont(new Font("Arial", Font.BOLD, 23));
		btnPunto.setBounds(8, 258, 45, 36);
		contentPane.add(btnPunto);
		
		
		
		JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "+");
			}
		});
		btnSuma.setForeground(Color.RED);
		btnSuma.setFont(new Font("Arial", Font.BOLD, 18));
		btnSuma.setBounds(173, 117, 45, 36);
		contentPane.add(btnSuma);
		
		JButton btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "-");
			}
		});
		btnResta.setForeground(Color.RED);
		btnResta.setFont(new Font("Arial", Font.BOLD, 18));
		btnResta.setBounds(175, 164, 45, 36);
		contentPane.add(btnResta);
		
		JButton btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "*");
			}
		});
		btnMulti.setForeground(Color.RED);
		btnMulti.setFont(new Font("Arial", Font.BOLD, 18));
		btnMulti.setBounds(173, 211, 45, 36);
		contentPane.add(btnMulti);
		
		JButton btnDivi = new JButton("/");
		btnDivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "/");
			}
		});
		btnDivi.setForeground(Color.RED);
		btnDivi.setFont(new Font("Arial", Font.BOLD, 18));
		btnDivi.setBounds(173, 258, 45, 36);
		contentPane.add(btnDivi);

        JButton btnPorcentaje = new JButton("%");
		btnPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "%");
			}
		});
		btnPorcentaje.setForeground(Color.RED);
		btnPorcentaje.setFont(new Font("Arial", Font.BOLD, 18));
		btnPorcentaje.setBounds(175, 305, 53, 36);
		contentPane.add(btnPorcentaje);

		JButton btnParentesisIzquierdo = new JButton("(");
		btnParentesisIzquierdo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "(");
			}
		});
        btnParentesisIzquierdo.setForeground(Color.RED);
        btnParentesisIzquierdo.setFont(new Font("Arial", Font.BOLD, 18));
        btnParentesisIzquierdo.setBounds(8, 305, 45, 36);
        contentPane.add(btnParentesisIzquierdo);

        JButton btnParentesisDerecho = new JButton(")");
		btnParentesisDerecho.addActionListener(new ActionListener() {
   			public void actionPerformed(ActionEvent e) {
       			txtPantalla.setText(txtPantalla.getText() + ")");
    		}
		});
        btnParentesisDerecho.setForeground(Color.RED);
        btnParentesisDerecho.setFont(new Font("Arial", Font.BOLD, 18));
        btnParentesisDerecho.setBounds(63, 305, 45, 36);
        contentPane.add(btnParentesisDerecho);

        JButton btnExponencial = new JButton("^");
        btnExponencial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				txtPantalla.setText("");
            }
        });
        btnExponencial.setForeground(Color.RED);
        btnExponencial.setFont(new Font("Arial", Font.BOLD, 18));
        btnExponencial.setBounds(120, 305, 45, 36);
        contentPane.add(btnExponencial);


        JButton btnXOR = new JButton("^");
        btnXOR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "^");
            }
        });
        btnXOR.setForeground(Color.BLUE);
        btnXOR.setFont(new Font("Arial", Font.BOLD, 18));
        btnXOR.setBounds(175, 350, 45, 36);
        contentPane.add(btnXOR);

        JButton btnAnd = new JButton("&");
        btnAnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtPantalla.setText(txtPantalla.getText() + "&");
            }
        });
        btnAnd.setForeground(Color.BLUE);
        btnAnd.setFont(new Font("Arial", Font.BOLD, 18));
        btnAnd.setBounds(8, 350, 47, 36);
        contentPane.add(btnAnd);

        JButton btnOr = new JButton("|");
        btnOr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtPantalla.setText(txtPantalla.getText() + "|");
            }
        });
        btnOr.setForeground(Color.BLUE);
        btnOr.setFont(new Font("Arial", Font.BOLD, 18));
        btnOr.setBounds(63, 350, 45, 36);
        contentPane.add(btnOr);

        JButton btnNot = new JButton("~");
        btnNot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtPantalla.setText(txtPantalla.getText() + "~");
            }
        });
        btnNot.setForeground(Color.BLUE);
        btnNot.setFont(new Font("Arial", Font.BOLD, 18));
        btnNot.setBounds(120, 350, 45, 36);
        contentPane.add(btnNot);


        JButton btnVerdadero = new JButton("V");
        btnVerdadero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	txtPantalla.setText(txtPantalla.getText() + "V");
            }
        });
        btnVerdadero.setFont(new Font("Arial", Font.BOLD, 18));
        btnVerdadero.setBounds(10, 64, 47, 36);
        contentPane.add(btnVerdadero);

        JButton btnFalso = new JButton("F");
        btnFalso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				txtPantalla.setText(txtPantalla.getText() + "F");
			}
		});
        btnFalso.setFont(new Font("Arial", Font.BOLD, 18));
        btnFalso.setBounds(63, 64, 45, 36);
        contentPane.add(btnFalso);



		JButton btnIgual = new JButton("=");
        btnIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
				/**
				 * Crea una instancia de Bet y pasa la expresión
				 */

                Bet bet = new Bet(txtPantalla.getText());

				/**
				 * Muestra el resultado en la pantalla
				 */
                txtPantalla.setText(String.valueOf(bet.evaluate_exp()));

            }
        });
        btnIgual.setForeground(Color.RED);
        btnIgual.setFont(new Font("Arial", Font.BOLD, 18));
        btnIgual.setBounds(120, 258, 45, 36);
        contentPane.add(btnIgual);
    }
}