package Final_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.*;

import javax.swing.*;

public class RegisterFormUI extends JFrame{
	private JLabel JL_Username, JL_password, JL_ch, JL_register;
	private JTextField JTF_Username;
	private JPasswordField JPF_password;
	static HashMap<String, String> users = new HashMap<>();
	public RegisterFormUI() {
		super("Registration Form");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		setLayout(null);
		Font font = new Font("Times New Roman", Font.PLAIN, 30);
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(font);
		titleLabel.setBounds(110, 0, 100, 40);
		
		Font f = new Font("Times New Roman", Font.BOLD, 15);
		Font f1 = new Font("Times New Roman", Font.PLAIN, 15);
		JL_Username = new JLabel("User name");
		JL_Username.setFont(f);
		JL_Username.setBounds(70, 50, 100, 27);
		JL_password = new JLabel("Password");
		JL_password.setFont(f);
		JL_password.setBounds(70, 100, 100, 27);
		JTF_Username = new JTextField();
		JTF_Username.setFont(f1);
		JTF_Username.setBounds(70, 75, 150, 27);
		JPF_password = new JPasswordField();
		JPF_password.setFont(f1);
		JPF_password.setBounds(70, 125, 150, 27);
		
		JButton jb_login = new JButton("Login");
		jb_login.setFont(f);
		jb_login.setBackground(Color.CYAN);
		jb_login.setBounds(70, 170, 150, 27);
		jb_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = JTF_Username.getText();
				String pass = new String(JPF_password.getPassword());
				if (username.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterFormUI.this, "Vui lòng điền thông tin còn trống.");
                    return;
                }
				if(users.containsKey(username) && users.get(username).equals(pass)){
					JOptionPane.showMessageDialog(RegisterFormUI.this, "Đăng nhập thành công!");
					AccountManagerGUI amg = new AccountManagerGUI();
					amg.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(RegisterFormUI.this, "Tên đăng nhập hoặc mật khẩu không đúng! Vui lòng nhập lại");
				}
			}
		});
		
		JL_ch = new JLabel("You haven't account?");
		JL_ch.setFont(f1);
		JL_ch.setBounds(38, 200, 300, 27);
		JL_register = new JLabel("Register now");
		JL_register.setFont(f);
		JL_register.setForeground(Color.RED);
		JL_register.setBounds(170, 200, 300, 27);
		JL_register.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				RegisterForm registerForm = new RegisterForm();
				registerForm.setVisible(true);
				dispose();
			}
		});
		
		add(titleLabel);
		add(JL_Username);
		add(JTF_Username);
		add(JL_password);
		add(JPF_password);
		add(jb_login);
		add(JL_ch);
		add(JL_register);
		setVisible(true);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			RegisterFormUI rgf = new RegisterFormUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class RegisterForm extends JFrame {
    private JLabel JL_Username1, JL_password1, JL_password2;
    private JTextField JTF_Username1;
    private JPasswordField JPF_password1, JPF_password2;
    public RegisterForm() {
        super("Register Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        Font font = new Font("Times New Roman", Font.PLAIN, 30);
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(font);
        titleLabel.setBounds(95, 0, 300, 40);

        Font f = new Font("Times New Roman", Font.BOLD, 15);
        Font f1 = new Font("Times New Roman", Font.PLAIN, 15);
        JL_Username1 = new JLabel("Register name");
        JL_Username1.setFont(f);
        JL_Username1.setBounds(70, 40, 100, 27);
        JTF_Username1 = new JTextField();
        JTF_Username1.setFont(f1);
        JTF_Username1.setBounds(70, 65, 150, 27);
        JL_password1 = new JLabel("Password");
        JL_password1.setFont(f);
        JL_password1.setBounds(70, 90, 100, 27);
        JPF_password1 = new JPasswordField();
        JPF_password1.setFont(f1);
        JPF_password1.setBounds(70, 115, 150, 27);
        JL_password2 = new JLabel("Again password");
        JL_password2.setFont(f);
        JL_password2.setBounds(70, 140, 300, 27);
        JPF_password2 = new JPasswordField();
        JPF_password2.setFont(f1);
        JPF_password2.setBounds(70, 165, 150, 27);

        JButton jb_register = new JButton("Register");
        jb_register.setFont(f);
        jb_register.setBackground(Color.CYAN);
        jb_register.setBounds(70, 200, 150, 27);
        jb_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = JTF_Username1.getText();
				String pass1 = new String(JPF_password1.getPassword());
				String pass2 = new String(JPF_password2.getPassword());
				if (username.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Vui lòng điền thông tin còn trống.");
                    return;
                }
				if (pass1.equals(pass2)) {
					RegisterFormUI.users.put(username, pass1);
					JOptionPane.showMessageDialog(RegisterForm.this, "Đăng ký thành công! Vui lòng đăng nhập.");
                    RegisterFormUI login = new RegisterFormUI();
                    login.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Mật khẩu xác nhận không khớp!");
                }
			}
		});
        
        JLabel JL_Login = new JLabel("Login");
        JL_Login.setFont(f);
        JL_Login.setForeground(Color.RED);
        JL_Login.setBounds(125, 230, 300, 27);
        JL_Login.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		RegisterFormUI login = new RegisterFormUI();
        		login.setVisible(true);
        		dispose();
        	}
		});

        add(titleLabel);
        add(JL_Username1);
        add(JTF_Username1);
        add(JL_password1);
        add(JPF_password1);
        add(JL_password2);
        add(JPF_password2);
        add(jb_register);
        add(JL_Login);
        setVisible(true);
    }

    public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			RegisterForm rgf = new RegisterForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

