package gui.notepad;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class SimpleNotepad extends JFrame implements ActionListener {
	
	JMenuItem itemNew, itemOpen,itemSave, itemExit,itemFont1,
	itemFont2,itemFont3,item10, item15, item20,itemFontRed,itemFontBlue,itemFontBlack;
	JTextArea area= new JTextArea();
	JButton btnNew, btnOpen,btnSave;
	
	public SimpleNotepad() {
		super("Simple Notepad");
		makeMenu();
		makeToolbar();
		add(area);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,200,800,800);
		setVisible(true);
	}
	
	public void makeToolbar() {
		JToolBar toolBar = new JToolBar();
		btnNew = new JButton(new ImageIcon("images/������.png"));
		btnOpen = new JButton(new ImageIcon("images/����.png"));
		btnSave = new JButton(new ImageIcon("images/����.png"));
		btnNew.addActionListener(btnL);
		btnOpen.addActionListener(btnL);
		btnSave.addActionListener(btnL);
		toolBar.add(btnNew);
		toolBar.add(btnOpen);
		toolBar.add(btnSave);
		add(toolBar,"North");
		
	}
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object eBtn = e.getSource();
			if(eBtn == btnNew) {
				area.setText("");
			}else if(eBtn == btnOpen) {
				readFile();
			}else if(eBtn == btnSave) {
				writeFile();
			}
			
		}
	};
	
	public void makeMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuFormat = new JMenu("Format");
		//FOramt�� �����޴�
		JMenu menuFont = new JMenu("Font");
		JMenu menuFontColor = new JMenu("FontColor");
		JMenu menuFontSize = new JMenu("FontSize");
		//JMenuItem: �����޴� �Ǵ� �����޴��� Ŭ������ �� ������ �� �ִ� �׸�
		itemNew = new JMenuItem("New");
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		itemExit = new JMenuItem("Exit");
		itemFont1 = new JMenuItem("�ü�ü");
		itemFont2 = new JMenuItem("�������");
		itemFont3 = new JMenuItem("HY����M");
		item10= new JMenuItem("10px");
		item15 = new JMenuItem("15px");
		item20 = new JMenuItem("20px");
		itemFontRed = new JMenuItem("Red");
		itemFontBlue = new JMenuItem("Blue");
		itemFontBlack = new JMenuItem("Black");
		
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		itemFont1.addActionListener(this);
		itemFont2.addActionListener(this);
		itemFont3.addActionListener(this);
		item10.addActionListener(this);
		item15.addActionListener(this);
		item20.addActionListener(this);
		itemFontRed.addActionListener(this);
		itemFontBlue.addActionListener(this);
		itemFontBlack.addActionListener(this);
		//File�����޴��� �޴��׸���� �߰�
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemExit);
		//Format �����޴��� �޴����� �޴��߰�
		menuFormat.add(menuFont);
		menuFormat.add(menuFontSize);
		menuFormat.add(menuFontColor);
		//�����޴��� �޴��׸��߰�
		menuFont.add(itemFont1);
		menuFont.add(itemFont2);
		menuFont.add(itemFont3);
		menuFontSize.add(item10);
		menuFontSize.add(item15);
		menuFontSize.add(item20);
		menuFontColor.add(itemFontRed);
		menuFontColor.add(itemFontBlue);
		menuFontColor.add(itemFontBlack);
		//�޴��ٿ� File���� �޴� �߰�
		menuBar.add(menuFile);
		menuBar.add(menuFormat);
		//�����ӿ��޴��� ����
		setJMenuBar(menuBar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JMenuItem eItem = (JMenuItem)e.getSource();
		if(eItem == itemNew) {
			area.setText("");
		}else if(eItem== itemOpen) {
			readFile();
		}else if(eItem==itemSave) {
			writeFile();
		}else if(eItem==itemExit) {
			System.exit(0);
		}else if(eItem==itemFont1) {
			area.setFont(new Font("�ü�ü",Font.PLAIN,area.getFont().getSize()));
		}else if(eItem==itemFont2) {
			area.setFont(new Font("���� ���",Font.PLAIN,area.getFont().getSize()));
		}else if(eItem==itemFont3) {
			area.setFont(new Font("HY����M",Font.PLAIN,area.getFont().getSize()));
		}else if(eItem==item10) {
			area.setFont(new Font(area.getFont().getFamily(),Font.PLAIN,10));
		}else if(eItem==item15) {
			area.setFont(new Font(area.getFont().getFamily(),Font.PLAIN,15));
		}else if(eItem==item20) {
			area.setFont(new Font(area.getFont().getFamily(),Font.PLAIN,20));
		}else if(eItem==itemFontRed) {
			area.setForeground(Color.RED);
		}else if(eItem==itemFontBlue) {
			area.setForeground(Color.BLUE);
		}else if(eItem==itemFontBlack) {
			area.setForeground(Color.BLACK);
		}
		
	}
	public void readFile() {
		area.setText("");
		FileDialog fileDlg = null;
		fileDlg = new FileDialog(this,"File Open",FileDialog.LOAD);
		fileDlg.setVisible(true);
		System.out.println(fileDlg.getDirectory());
		System.out.println(fileDlg.getFile());
		FileReader fReader = null;
		BufferedReader bufReader = null;
		try {
			fReader = new FileReader(new File(fileDlg.getDirectory()+"/"+fileDlg.getFile()));
			bufReader= new BufferedReader(fReader);
			String line= "";
			while((line=bufReader.readLine())!=null) {
				area.append(line+"\n");
			}
			bufReader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile() {
		FileDialog fileDlg = null;
		fileDlg= new FileDialog(this,"File Save",FileDialog.SAVE);
		fileDlg.setVisible(true);
		System.out.println(fileDlg.getDirectory());
		System.out.println(fileDlg.getFile());
		FileWriter fWriter = null;
		BufferedWriter bufWriter = null;
		try {
			fWriter = new FileWriter(new File(fileDlg.getDirectory()+"/"+fileDlg.getFile()));
			bufWriter= new BufferedWriter(fWriter);
			bufWriter.write(area.getText());
			bufWriter.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[]args) {
		new SimpleNotepad();
	}
}
