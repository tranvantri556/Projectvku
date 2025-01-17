package Final_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class AccountManagerGUI extends JFrame{
	private AccountManager accountManager = new AccountManager();
	private JTextField jt_taikhoan, jt_money;
	private JPasswordField jp_matkhau;
	private JTable table;
	public AccountManagerGUI() {
		super("Quản lý tài khoản ngân hàng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(750, 450);
		setLocationRelativeTo(null);
		Font font = new Font("Times New Roman", Font.PLAIN, 15);
		
		JPanel jp_west = new JPanel(null);
//		jp_west.setBorder(BorderFactory.createTitledBorder("Trang chủ"));
		setLayout(null);
		jp_west.setBounds(0, 0, 160, 450);
		jp_west.setBackground(Color.LIGHT_GRAY);
		
		JButton jb_home = new JButton("Thông tin tài khoản");
		jb_home.setFont(font);
		jb_home.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(AccountManagerGUI.class.getResource("home.png"))));
		jb_home.setBounds(10, 20, 130, 30);
        JButton jb_transaction = new JButton("Giao dịch");
        jb_transaction.setFont(font);
        jb_transaction.setBounds(10, 70, 130, 30);
        JButton jb_sodu = new JButton("Thông báo");
        jb_sodu.setFont(font);
        jb_sodu.setBounds(10, 120, 130, 30);
        JButton jb_maqr = new JButton("Mã QR");
        jb_maqr.setFont(font);
        jb_maqr.setBounds(10, 170, 130, 30);
        
        jp_west.add(jb_home);
        jp_west.add(jb_transaction);
        jp_west.add(jb_sodu);
//        jp_west.add(jb_maqr);
        
        add(jp_west);
        
		JPanel jp_east = new JPanel(null);
		jp_east.setBounds(560, 0, 200, 450);
		jp_east.setBackground(Color.LIGHT_GRAY);
		
//		JLabel jl_id= new JLabel("ID");
//		jl_id.setBounds(10, 10, 60, 25);
//		jl_id.setFont(font);
//		jt_id = new JTextField();
//		jt_id.setBounds(80, 10, 120, 25);
//		jt_id.setFont(font);
		
		JLabel jl_taikhoan = new JLabel("Tài khoản");
		jl_taikhoan.setBounds(10, 50, 60, 25);
		jl_taikhoan.setFont(font);
		jt_taikhoan = new JTextField();
		jt_taikhoan.setBounds(80, 50, 120, 25);
		jt_taikhoan.setFont(font);
		
		JLabel jl_matkhau = new JLabel("Mật khẩu");
		jl_matkhau.setBounds(10, 90, 60, 25);
		jl_matkhau.setFont(font);
		jp_matkhau = new JPasswordField();
		jp_matkhau.setBounds(80, 90, 120, 25);
		jp_matkhau.setFont(font);
		
		JLabel jl_money = new JLabel("Số tiền");
		jl_money.setBounds(10, 130, 60, 25);
		jl_money.setFont(font);
		jt_money = new JTextField();
		jt_money.setBounds(80, 130, 120, 25);
		jt_money.setFont(font);
		
		JButton jb_add = new JButton("Thêm");
		jb_add.setBounds(30, 220, 120, 30);
		jb_add.setFont(font);
		JButton jb_delete = new JButton("Xóa");
		jb_delete.setBounds(30, 270, 120, 30);
		jb_delete.setFont(font);
		JButton jb_update = new JButton("Cập nhật");
		jb_update.setBounds(30, 320, 120, 30);
		jb_update.setFont(font);
		
//		jp_east.add(jl_id);
//		jp_east.add(jt_id);
		jp_east.add(jl_taikhoan);
		jp_east.add(jt_taikhoan);
		jp_east.add(jl_matkhau);
		jp_east.add(jp_matkhau);
		jp_east.add(jl_money);
		jp_east.add(jt_money);
		jp_east.add(jb_add);
        jp_east.add(jb_delete);
		jp_east.add(jb_update);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[] {
				"Tài khoản",
				"Mật khẩu",
				"Số tiền"}, 0));
		table.setFont(font);
		JScrollPane js_table = new JScrollPane(table);
		js_table.setBounds(160, 0, 400, 450);
		
		add(jp_east);
		add(js_table);
		
		table.getSelectionModel().addListSelectionListener(e ->{
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {
//					jt_id.setText(table.getValueAt(row, 0).toString());
					jt_taikhoan.setText(table.getValueAt(row, 1).toString());
					jp_matkhau.setText("******");
					jt_money.setText(table.getValueAt(row, 3).toString());
				}
			}
		});
		
		jb_home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(jp_west);
				jp_west.setBounds(0, 0, 160, 450);
				JScrollPane js_table = new JScrollPane(table);
				js_table.setBounds(160, 0, 400, 450);
				add(jp_east);
				jb_maqr.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(AccountManagerGUI.class.getResource(""))));
				jp_west.add(jb_maqr);
				revalidate();
				repaint();
			}
		});

        jb_maqr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel jp_qr = new JPanel(null);
				ImageIcon qrIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(AccountManagerGUI.class.getResource("ma_qr.png")));
				JLabel jl_qr = new JLabel(qrIcon);
				jl_qr.setBounds(0, 0, 640, 450);
				jp_qr.add(jl_qr);
				jp_qr.setBounds(160, 0, 640, 450);
				add(jp_qr);
				revalidate();
				repaint();
			}
		});
        
        jb_add.addActionListener(e -> themAccount());
//		jb_delete.addActionListener(e -> deleteAccount());
        jb_update.addActionListener(e -> updateAccount());
		setVisible(true);
	}
	
	public void themAccount() {
		try {
//			String id = jt_id.getText();
			String Account = jt_taikhoan.getText();
			String password = new String(jp_matkhau.getPassword());
			String money = jt_money.getText();
			if (Account.isEmpty() || password.isEmpty() || money.isEmpty()) {
				JOptionPane.showMessageDialog(AccountManagerGUI.this, "Please, Enter full information!");
				return;
			}
			long numberAccount = Long.parseLong(Account);
			double moneyAccount = Double.parseDouble(money);
			Account ac = new Account(numberAccount, password, moneyAccount);
			accountManager.addAccount(ac);
			capNhatBang();
//			jt_id.setText("");
			jt_taikhoan.setText("");
			jp_matkhau.setText("");
			jt_money.setText("");
			JOptionPane.showMessageDialog(this, "Account added successfully!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số!");
		}
	}
	
//	public void deleteAccount() {
//        long numberAccount = JOptionPane.showInputDialog("Nhập ID tài khoản cần xóa:");
//        if (numberAccount != 0) {
//            accountManager.deleteAccount(numberAccount);
//            capNhatBang();
//        } else {
//            JOptionPane.showMessageDialog(this, "ID không hợp lệ.");
//        }
//    }
	
	public void updateAccount() {
		try {
//			String id = jt_id.getText();
			String account = jt_taikhoan.getText();
			String pass = new String(jp_matkhau.getPassword());
			String money = jt_money.getText();
			if (account.isEmpty() || pass.isEmpty() || money.isEmpty()) {
				JOptionPane.showMessageDialog(AccountManagerGUI.this, "Please, Enter full information!");
				return;
			}
			long numberAccount = Long.parseLong(account);
			double moneyAccount = Double.parseDouble(money);
			for(Account ac : accountManager.getAccountList()) {
//	            if (ac.getId().equals(id)) {
	                ac.setNumberAccount(numberAccount);
	                ac.setPassword(pass);
	                ac.setMoney(moneyAccount);
	                break;
//	            }
			}
			capNhatBang();
//			jt_id.setText("");
			jt_taikhoan.setText("");
			jp_matkhau.setText("");
			jt_money.setText("");
			JOptionPane.showMessageDialog(this, "Account updated successfully!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error in input format.");
		}
	}
	
	public void capNhatBang() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		for(Account ac : accountManager.getAccountList()) {
			model.addRow(new Object[] {ac.getNumberAccount(),"******", ac.getMoney()});
		}
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			AccountManagerGUI am = new AccountManagerGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
