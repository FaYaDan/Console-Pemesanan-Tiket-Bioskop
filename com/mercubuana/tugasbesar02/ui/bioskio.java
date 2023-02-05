package com.mercubuana.tugasbesar02.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.mercubuana.tugasbesar02.Film;
import com.mercubuana.tugasbesar02.FilmDAO;
import com.mercubuana.tugasbesar02.TugasBesar02PersistentManager;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;

public class FormBioskopXXX {

	private JFrame frmTiketBioskop;
	private JTextField txtJudulFilm;
	private JTextField txtJumlahKursi;
	private JTextField txtSisaKursi;
	private JPanel panelRincianDataFilm;
	private JButton btnTambahData;
	private JList listDaftarFilm;
	private JComboBox cmbKategoriFilm;
	private Film[] dataFilm = null;
	private JButton btnRekamDataFilm;
	private JScrollPane scrollPane;
	private JButton btnHapus;
	private JButton btnUbahData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBioskopXXX window = new FormBioskopXXX();
					window.frmTiketBioskop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormBioskopXXX() {
		// 1. Inisialiasi dan menampilkan form utama
		initialize();
		/* 2. Membaca data dari database dan menampilkannya 
		 *    pada List daftar kamar
		 */
		bacaDataDariDatabase();
		tampilkanDataFilmPadaList();
		/* 3. Memeriksa jika sudah ada data
		 *    untuk ditampilkan pada list
		 */
		bacaDataDariDatabase();
		if(dataFilm.length>0) {
			tampilkanDataFilmPadaList();
			// 4. Pilih Film teratas pada list
			listDaftarFilm.setSelectedIndex(0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTiketBioskop = new JFrame();
		frmTiketBioskop.setTitle("Tiket Film");
		frmTiketBioskop.setBounds(100, 100, 580, 460);
		frmTiketBioskop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTiketBioskop.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 562, 413);
		frmTiketBioskop.getContentPane().add(tabbedPane);
		
		JPanel panelDataBioskop = new JPanel();
		tabbedPane.addTab("Data Film", null, panelDataBioskop, null);
		panelDataBioskop.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 396, 146);
		panelDataBioskop.add(scrollPane);
		
		listDaftarFilm = new JList();
		scrollPane.setViewportView(listDaftarFilm);
		listDaftarFilm.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahTampilanPadaPanelRincian();
			}
		});
		listDaftarFilm.setFont(new Font("Dialog", Font.BOLD, 14));
		listDaftarFilm.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblDaftarFilm = new JLabel("Daftar Film");
		lblDaftarFilm.setBounds(12, 12, 113, 16);
		panelDataBioskop.add(lblDaftarFilm);
		lblDaftarFilm.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnTambahData = new JButton("Tambah Data");
		btnTambahData.setBounds(420, 40, 123, 26);
		panelDataBioskop.add(btnTambahData);
		btnTambahData.setFont(new Font("Dialog", Font.BOLD, 14));
		
		panelRincianDataFilm = new JPanel();
		panelRincianDataFilm.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Rincian Data Film", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRincianDataFilm.setName("");
		panelRincianDataFilm.setBounds(12, 199, 396, 177);
		panelDataBioskop.add(panelRincianDataFilm);
		panelRincianDataFilm.setLayout(null);
		
		JLabel lblJudulFilm = new JLabel("Judul Film : ");
		lblJudulFilm.setBounds(12, 27, 123, 16);
		panelRincianDataFilm.add(lblJudulFilm);
		lblJudulFilm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJudulFilm.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblKategoriFilm = new JLabel("Kategori Film : ");
		lblKategoriFilm.setBounds(12, 55, 123, 16);
		panelRincianDataFilm.add(lblKategoriFilm);
		lblKategoriFilm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKategoriFilm.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblJumlahKursi = new JLabel("Jumlah Kursi : ");
		lblJumlahKursi.setBounds(12, 83, 123, 16);
		panelRincianDataFilm.add(lblJumlahKursi);
		lblJumlahKursi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumlahKursi.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblSisaKursi = new JLabel("Sisa Kursi : ");
		lblSisaKursi.setBounds(12, 111, 123, 16);
		panelRincianDataFilm.add(lblSisaKursi);
		lblSisaKursi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSisaKursi.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtJudulFilm = new JTextField();
		txtJudulFilm.setBounds(139, 27, 150, 20);
		panelRincianDataFilm.add(txtJudulFilm);
		txtJudulFilm.setColumns(10);
		
		txtJumlahKursi = new JTextField();
		txtJumlahKursi.setBounds(139, 83, 60, 20);
		panelRincianDataFilm.add(txtJumlahKursi);
		txtJumlahKursi.setColumns(10);
		
		txtSisaKursi = new JTextField();
		txtSisaKursi.setBounds(139, 111, 60, 20);
		panelRincianDataFilm.add(txtSisaKursi);
		txtSisaKursi.setColumns(10);
		
		cmbKategoriFilm = new JComboBox();
		cmbKategoriFilm.setBounds(139, 53, 150, 25);
		panelRincianDataFilm.add(cmbKategoriFilm);
		cmbKategoriFilm.setModel(new DefaultComboBoxModel(new String[] {"Komedi", "Action", "Romansa"}));
		
		btnRekamDataFilm = new JButton("Rekam Data Film");
		btnRekamDataFilm.setVisible(false);
		btnRekamDataFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataFilm();
			}
		});
		btnRekamDataFilm.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRekamDataFilm.setBounds(22, 139, 175, 26);
		panelRincianDataFilm.add(btnRekamDataFilm);
		
		btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hapusData();
			}
		});
		btnHapus.setFont(new Font("Dialog", Font.BOLD, 14));
		btnHapus.setBounds(420, 160, 123, 26);
		panelDataBioskop.add(btnHapus);
		
		btnUbahData = new JButton("Ubah Data");
		btnUbahData.setFont(new Font("Dialog", Font.BOLD, 14));
		btnUbahData.setBounds(420, 78, 123, 26);
		panelDataBioskop.add(btnUbahData);
		btnTambahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelRincianDataFilm.setVisible(true);
				btnTambahData.setEnabled(false);
				aktifkanPanel();
			}
		});
	}
	
	void rekamDataFilm() {
		// 1. Membaca input User dari GUI
		String judulFilm = "";
		judulFilm = txtJudulFilm.getText();
		
		char kategoriFilm = 'K';
		if (cmbKategoriFilm.getSelectedIndex()==1) {
			kategoriFilm = 'A';
		}
		else if (cmbKategoriFilm.getSelectedIndex()==2) {
			kategoriFilm = 'R';
		}
		
		int jumlahKursi = 0;
		int sisaKursi = 0;
		try {
			jumlahKursi = Integer.parseInt(txtJumlahKursi.getText());
			txtSisaKursi.setText("" + jumlahKursi);
			sisaKursi = jumlahKursi;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, 
					"Isian Jumlah Tiket harus berupa bilangan bulat");
			return;
		}
		
		// 2. Memulai transaction baru
		PersistentTransaction t = null; 
		try {
			t = TugasBesar02PersistentManager
					.instance().getSession().beginTransaction();
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal memulai transaction\n"
					+ "Pesan Error : " + e.getMessage());
			return;
		}
		
		/* 3. Membungkus semua proses perubahan dalam try-catch agar bisa dibatalkan
		 *    (roll-back) seandainya terjadi error
		 */	
		try {
			// 3a. Membuat objek Film baru (memori + database)
			Film filmBaru = FilmDAO.createFilm();
			// 3b. Mengubah atribut objek Film baru
			filmBaru.setJudulFilm(judulFilm);
			filmBaru.setKategoriFilm(kategoriFilm);
			filmBaru.setJumlahKursi(jumlahKursi);
			filmBaru.setSisaKursi(sisaKursi); 
			// 3c. Rekam perubahan ke dalam database
			FilmDAO.save(filmBaru);
			// 3d. Jika semua perubahan berhasil, maka lakukan commit
			t.commit();
			JOptionPane.showMessageDialog(null, 
					"Data Film baru berhasil ditambahkan");
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal merekam data Film\n"
					+ "Pesan Error : " + e.getMessage());
			try {
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback\n"
						+ "Pesan Error : " + e1.getMessage());
			}
		}
		bacaDataDariDatabase();
		tampilkanDataFilmPadaList();
		nonAktifkanPanel();
	}
	
	void aktifkanPanel() {
		btnRekamDataFilm.setVisible(true);
		txtJudulFilm.setText("");
		cmbKategoriFilm.setSelectedIndex(0);
		txtJumlahKursi.setText("");
		txtSisaKursi.setText("");
	}
	
	void nonAktifkanPanel() {
		btnRekamDataFilm.setVisible(false);
		btnTambahData.setEnabled(true);
	}
	
	void bacaDataDariDatabase() {
		try {
			dataFilm = FilmDAO.listFilmByQuery(null, null);
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal membaca data Film\n"
					+ "Pesan Error : " + e.getMessage());
		}
	}
	
	void tampilkanDataFilmPadaList() {
		listDaftarFilm.setListData(dataFilm);
	}
	
	void ubahTampilanPadaPanelRincian() {
		int index = listDaftarFilm.getSelectedIndex();
		if (index==-1) {
			index = dataFilm.length - 1;
		}
		Film FilmDipilihPadaList = (Film) listDaftarFilm
				.getModel().getElementAt(index);
		txtJudulFilm.setText(FilmDipilihPadaList.getJudulFilm());
		cmbKategoriFilm.setSelectedIndex(0);
		if (FilmDipilihPadaList.getKategoriFilm()=='A') {
			cmbKategoriFilm.setSelectedIndex(1);
		}
		else if (FilmDipilihPadaList.getKategoriFilm()=='R') {
			cmbKategoriFilm.setSelectedIndex(2);
		}
		txtJumlahKursi.setText("" + FilmDipilihPadaList.getJumlahKursi());
		txtSisaKursi.setText("" + FilmDipilihPadaList.getSisaKursi());	
	}
	
	void hapusData() {
		// 1. Menentukan objek Film yang sedang dipilih pada list
		int index = listDaftarFilm.getSelectedIndex();
		Film FilmDipilihPadaList = (Film) listDaftarFilm
				.getModel().getElementAt(index);
		// 2. Hapus data dari database
		PersistentTransaction t = null;
		try {
			t = TugasBesar02PersistentManager
					.instance().getSession().beginTransaction();
			FilmDAO.deleteAndDissociate(FilmDipilihPadaList);
			t.commit();
			bacaDataDariDatabase();
			tampilkanDataFilmPadaList();	
		} catch (PersistentException e) {
			try {
				JOptionPane.showMessageDialog(null, 
						"Gagal hapus data\n"
						+ "Pesan Error : " + e.getMessage());
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback\n"
						+ "Pesan Error : " + e1.getMessage());
			}
		}
	}
	
}