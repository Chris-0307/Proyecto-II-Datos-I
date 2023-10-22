import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Grafico.Calculadora;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
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
	double numero2;
	double resultado;
	String operacion;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora2 frame = new Calculadora2();
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
		
		
		JButton btnLimpiar = new JButton("C");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPantalla.setText("");
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
				//NUMERO 3
				String IngreseNumero = txtPantalla.getText() + btn3.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn3.setFont(new Font("Arial", Font.BOLD, 18));
		btn3.setBounds(120, 117, 45, 36);
		contentPane.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 2
				
				String IngreseNumero = txtPantalla.getText() + btn2.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn2.setFont(new Font("Arial", Font.BOLD, 18));
		btn2.setBounds(65, 117, 45, 36);
		contentPane.add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 1
				String IngreseNumero = txtPantalla.getText() + btn1.getText();
				txtPantalla.setText(IngreseNumero);
				
			}
		});
		btn1.setFont(new Font("Arial", Font.BOLD, 18));
		btn1.setBounds(10, 117, 45, 36);
		contentPane.add(btn1);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 6
				String IngreseNumero = txtPantalla.getText() + btn6.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn6.setFont(new Font("Arial", Font.BOLD, 18));
		btn6.setBounds(120, 164, 45, 36);
		contentPane.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 5
				String IngreseNumero = txtPantalla.getText() + btn5.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn5.setFont(new Font("Arial", Font.BOLD, 18));
		btn5.setBounds(65, 164, 45, 36);
		contentPane.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 4
				String IngreseNumero = txtPantalla.getText() + btn4.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn4.setFont(new Font("Arial", Font.BOLD, 18));
		btn4.setBounds(10, 164, 45, 36);
		contentPane.add(btn4);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 9
				String IngreseNumero = txtPantalla.getText() + btn9.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn9.setFont(new Font("Arial", Font.BOLD, 18));
		btn9.setBounds(120, 211, 45, 36);
		contentPane.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 8
				String IngreseNumero = txtPantalla.getText() + btn8.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn8.setFont(new Font("Arial", Font.BOLD, 18));
		btn8.setBounds(65, 211, 45, 36);
		contentPane.add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NUMERO 7
				String IngreseNumero = txtPantalla.getText() + btn7.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btn7.setFont(new Font("Arial", Font.BOLD, 18));
		btn7.setBounds(10, 211, 45, 36);
		contentPane.add(btn7);
		
		JButton btnCero = new JButton("0");
		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CERO
				String IngreseNumero = txtPantalla.getText() + btnCero.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btnCero.setFont(new Font("Arial", Font.BOLD, 18));
		btnCero.setBounds(63, 258, 45, 36);
		contentPane.add(btnCero);
		
		JButton btnPunto = new JButton(".");
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PUNTO
				String IngreseNumero = txtPantalla.getText() + btnPunto.getText();
				txtPantalla.setText(IngreseNumero);
			}
		});
		btnPunto.setForeground(new Color(255, 0, 0));
		btnPunto.setFont(new Font("Arial", Font.BOLD, 23));
		btnPunto.setBounds(8, 258, 45, 36);
		contentPane.add(btnPunto);
		
		
		
		JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SUMA
				numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " + ");
				txtPantalla.setText("");
				operacion = "+";
				
			}
		});
		btnSuma.setForeground(Color.RED);
		btnSuma.setFont(new Font("Arial", Font.BOLD, 18));
		btnSuma.setBounds(173, 117, 45, 36);
		contentPane.add(btnSuma);
		
		JButton btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RESTA
				numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " - ");
				txtPantalla.setText("");
				operacion = "-";
			}
		});
		btnResta.setForeground(Color.RED);
		btnResta.setFont(new Font("Arial", Font.BOLD, 18));
		btnResta.setBounds(175, 164, 45, 36);
		contentPane.add(btnResta);
		
		JButton btnMulti = new JButton("x");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MULTIPLICACION
				numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " * ");
				txtPantalla.setText("");
				operacion = "*";
			}
		});
		btnMulti.setForeground(Color.RED);
		btnMulti.setFont(new Font("Arial", Font.BOLD, 18));
		btnMulti.setBounds(173, 211, 45, 36);
		contentPane.add(btnMulti);
		
		JButton btnDivi = new JButton("/");
		btnDivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DIVICION
				numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " / ");
				txtPantalla.setText("");
				operacion = "/";
			}
		});
		btnDivi.setForeground(Color.RED);
		btnDivi.setFont(new Font("Arial", Font.BOLD, 18));
		btnDivi.setBounds(173, 258, 45, 36);
		contentPane.add(btnDivi);

        JButton btnPorcentaje = new JButton("%");
		btnPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PORCENTAJE
				numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " % ");
				txtPantalla.setText("");
				operacion = "%";
			}
		});
		btnPorcentaje.setForeground(Color.RED);
		btnPorcentaje.setFont(new Font("Arial", Font.BOLD, 18));
		btnPorcentaje.setBounds(175, 305, 53, 36);
		contentPane.add(btnPorcentaje);

        JButton btnParentesisIzquierdo = new JButton("(");
        btnParentesisIzquierdo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // PARENTESIS
                numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " ) ");
				txtPantalla.setText("");
				operacion = ")";
            }
        });
        btnParentesisIzquierdo.setForeground(Color.RED);
        btnParentesisIzquierdo.setFont(new Font("Arial", Font.BOLD, 18));
        btnParentesisIzquierdo.setBounds(8, 305, 45, 36);
        contentPane.add(btnParentesisIzquierdo);

        JButton btnParentesisDerecho = new JButton(")");
        btnParentesisDerecho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // PARENTESIS
                numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " ) ");
				txtPantalla.setText("");
				operacion = ")";
            }
        });
        btnParentesisDerecho.setForeground(Color.RED);
        btnParentesisDerecho.setFont(new Font("Arial", Font.BOLD, 18));
        btnParentesisDerecho.setBounds(63, 305, 45, 36);
        contentPane.add(btnParentesisDerecho);

        JButton btnExponencial = new JButton("^");
        btnExponencial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // EXPONENTE
                numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " ^ ");
				txtPantalla.setText("");
				operacion = "^";
            }
        });
        btnExponencial.setForeground(Color.RED);
        btnExponencial.setFont(new Font("Arial", Font.BOLD, 18));
        btnExponencial.setBounds(120, 305, 45, 36);
        contentPane.add(btnExponencial);


        JButton btnXOR = new JButton("^");
        btnXOR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // XOR
                numero1 = Double.parseDouble(txtPantalla.getText());
				operacionActual.append(txtPantalla.getText() + " ^ ");
				txtPantalla.setText("");
				operacion = "^";
            }
        });
        btnXOR.setForeground(Color.BLUE);
        btnXOR.setFont(new Font("Arial", Font.BOLD, 18));
        btnXOR.setBounds(175, 350, 45, 36);
        contentPane.add(btnXOR);

        JButton btnAnd = new JButton("&");
        btnAnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // AND
                numero1 = Double.parseDouble(txtPantalla.getText());
                operacionActual.append(txtPantalla.getText() + " & ");
                txtPantalla.setText("");
                operacion = "&";
            }
        });
        btnAnd.setForeground(Color.BLUE);
        btnAnd.setFont(new Font("Arial", Font.BOLD, 18));
        btnAnd.setBounds(8, 350, 47, 36);
        contentPane.add(btnAnd);

        JButton btnOr = new JButton("|");
        btnOr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // OR
                numero1 = Double.parseDouble(txtPantalla.getText());
                operacionActual.append(txtPantalla.getText() + " | ");
                txtPantalla.setText("");
                operacion = "|";
            }
        });
        btnOr.setForeground(Color.BLUE);
        btnOr.setFont(new Font("Arial", Font.BOLD, 18));
        btnOr.setBounds(63, 350, 45, 36);
        contentPane.add(btnOr);

        JButton btnNot = new JButton("~");
        btnNot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // NOT
                numero1 = Double.parseDouble(txtPantalla.getText());
                operacionActual.append(txtPantalla.getText() + " ~ ");
                txtPantalla.setText("");
                operacion = "~";
            }
        });
        btnNot.setForeground(Color.BLUE);
        btnNot.setFont(new Font("Arial", Font.BOLD, 18));
        btnNot.setBounds(120, 350, 45, 36);
        contentPane.add(btnNot);


        JButton btnVerdadero = new JButton("V");
        btnVerdadero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String IngreseNumero = txtPantalla.getText() + btnVerdadero.getText();
                txtPantalla.setText(IngreseNumero);
            }
        });
        btnVerdadero.setFont(new Font("Arial", Font.BOLD, 18));
        btnVerdadero.setBounds(10, 64, 47, 36);
        contentPane.add(btnVerdadero);

        // Botón Falso (0)
        JButton btnFalso = new JButton("F");
        btnFalso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String IngreseNumero = txtPantalla.getText() + btnFalso.getText();
                txtPantalla.setText(IngreseNumero);
            }
        });
        btnFalso.setFont(new Font("Arial", Font.BOLD, 18));
        btnFalso.setBounds(63, 64, 45, 36);
        contentPane.add(btnFalso);



		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionar;
				numero2 = Double.parseDouble(txtPantalla.getText());
				
				if(operacion == "+") {
					resultado = numero1+numero2;
					seleccionar = String.format("%.0f",resultado);
					txtPantalla.setText(seleccionar);
				}
				
				else if(operacion == "-") {
					resultado = numero1-numero2;
					seleccionar = String.format("%.0f",resultado);
					txtPantalla.setText(seleccionar);
				}
				
				else if(operacion == "*") {
					resultado = numero1*numero2;
					seleccionar = String.format("%.0f",resultado);
					txtPantalla.setText(seleccionar);
				}
				
				else if(operacion == "/") {
					resultado = numero1/numero2;
					seleccionar = String.format("%.2f",resultado);
					txtPantalla.setText(seleccionar);
				}

                else if(operacion == "%") {
					resultado = numero1%numero2;
					seleccionar = String.format("%.2f",resultado);
					txtPantalla.setText(seleccionar);
				}

                else if(operacion == "^") {
					resultado = Math.pow(numero1, numero2);
					seleccionar = String.format("%.0f",resultado);
					txtPantalla.setText(seleccionar);
				}

                else if (operacion.equals("^")) {
                    resultado = (int) numero1 ^ (int) numero2; // Realizar la operación XOR (como enteros)
                    seleccionar = String.format("%.0f",resultado);
					txtPantalla.setText(seleccionar);
                } 
                
                else if (operacion == "&") {
                    resultado = (int) numero1 & (int) numero2; // Realizar la operación AND (como enteros)
                    seleccionar = String.format("%.0f", resultado);
                    txtPantalla.setText(seleccionar);
                }

                else if (operacion == "|") {
                    resultado = (int) numero1 | (int) numero2; // Realizar la operación OR (como enteros)
                    seleccionar = String.format("%.0f", resultado);
                    txtPantalla.setText(seleccionar);
                }

                else if (operacion == "~") { 
                    resultado = ~((int) numero1); // Realizar la operación NOT (como un número entero)
                    txtPantalla.setText(String.format("%.0f", resultado));
                    operacionActual.append(" = " + txtPantalla.getText());
                }

                else {
                    seleccionar = "Operación no válida";
                    txtPantalla.setText(seleccionar);
                    operacionActual.setLength(0);
                    return;
                }

                
                seleccionar = String.format("%.2f", resultado);
                operacionActual.append(txtPantalla.getText());
                txtPantalla.setText(operacionActual + " = " + seleccionar);
                operacionActual.setLength(0);
			}
		});
		btnIgual.setForeground(Color.RED);
		btnIgual.setFont(new Font("Arial", Font.BOLD, 18));
		btnIgual.setBounds(120, 258, 45, 36);
		contentPane.add(btnIgual);
		
		
	}
}