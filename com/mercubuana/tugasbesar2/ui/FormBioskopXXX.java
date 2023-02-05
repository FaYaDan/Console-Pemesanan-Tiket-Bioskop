package com.mercubuana.tugasbesar2.ui;

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
import com.mercubuana.tugasbesar02.Pemesan;
import com.mercubuana.tugasbesar02.PemesanDAO;
import com.mercubuana.tugasbesar02.TugasBesar02PersistentManager;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.JulianFields;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.transaction.Transaction;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FormBioskopXXX {

	private JFrame frmTiketFilm;
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
	private JButton btnBatal;
	private JButton btnRekamPerubahan;
	private boolean apakahTambahData = true;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Film[] dataFilmSesuai = new Film[0];
	private JRadioButton rdbtnKomedi;
	private JRadioButton rdbtnRomansa;
	private JRadioButton rdbtnAction;
	private JButton btnCariFilm;
	private JLabel lblDaftarFilmSesuai;
	private JList listDaftarFilmSesuai;
	private JLabel lblJudulFilmDipilih;
	private JLabel lblJumlahKursiPanelDua;
	private JLabel lblSisaKursiPanelDua;
	private JTextField txtJudulFilmPanelDua;
	private JTextField txtJumlahKursiPanelDua;
	private JTextField txtSisaKursiPanelDua;
	private JPanel panelRincianDataPemesan;
	private JLabel lblNamaPemesan;
	private JLabel lblTanggalPemesanan;
	private JTextField txtNamaPemesan;
	private JTextField txtTanggalPemesananPanelDua;
	private JButton btnRekamPemesanan;
	private JList listDaftarFilmPanelTiga;
	private JLabel lblDaftarPemesan;
	private JList listDaftarPemesanPanelTiga;
	private JScrollPane scrollPane_2;
	private JPanel panelTiga;
	private JLabel lblKategoriFilmPanelTiga;
	private JLabel lblTanggalPemesananPanelTiga;
	private JTextField txtTanggalPemesananPanelTiga;
	private JComboBox cmbKategoriFilmPanelTiga;
	private JLabel lblDaftarFilmPanelTiga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBioskopXXX window = new FormBioskopXXX();
					window.frmTiketFilm.setVisible(true);
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
		/* 2. Membaca data dari database */
		bacaDataDariDatabase();
		/* 3. Memeriksa jika sudah ada data untuk
		 * 	  ditampilkan pada list
		 */
		if (dataFilm.length>0) {
			tampilkanDataFilmPadaList();
			// 4. Pilih film teratas pada list
			listDaftarFilm.setSelectedIndex(0);
			/* 5. Tampilkan data film pada list yang ada 
			 *    pada panel tiga
			 */
			listDaftarFilmPanelTiga.setListData(dataFilm);
		}
		nonAktifkanPanelRincian();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTiketFilm = new JFrame();
		frmTiketFilm.setTitle("Tiket Film");
		frmTiketFilm.setBounds(100, 100, 650, 545);
		frmTiketFilm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTiketFilm.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 632, 498);
		frmTiketFilm.getContentPane().add(tabbedPane);
		
		JPanel panelSatu = new JPanel();
		tabbedPane.addTab("Data Film", null, panelSatu, null);
		panelSatu.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 396, 146);
		panelSatu.add(scrollPane);
		
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
		panelSatu.add(lblDaftarFilm);
		lblDaftarFilm.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnTambahData = new JButton("Tambah Data");
		btnTambahData.setBounds(420, 40, 123, 26);
		panelSatu.add(btnTambahData);
		btnTambahData.setFont(new Font("Dialog", Font.BOLD, 14));
		
		panelRincianDataFilm = new JPanel();
		panelRincianDataFilm.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Rincian Data Film", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRincianDataFilm.setName("");
		panelRincianDataFilm.setBounds(12, 199, 507, 177);
		panelSatu.add(panelRincianDataFilm);
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
		btnRekamDataFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rekamDataFilm();
			}
		});
		btnRekamDataFilm.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRekamDataFilm.setBounds(12, 139, 175, 26);
		panelRincianDataFilm.add(btnRekamDataFilm);
		
		btnBatal = new JButton("Batal");
		btnBatal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				masukModeBrowsing();
//				batalkanProsesManipulasiData();
			}
		});
		btnBatal.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBatal.setBounds(372, 139, 123, 26);
		panelRincianDataFilm.add(btnBatal);
		
		btnRekamPerubahan = new JButton("Rekam Perubahan");
		btnRekamPerubahan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rekamPerubahan();
//				masukModeEditing();
//				btnRekamPerubahan.setEnabled(true);
			}
		});
		btnRekamPerubahan.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRekamPerubahan.setBounds(199, 139, 161, 26);
		panelRincianDataFilm.add(btnRekamPerubahan);
		
		btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hapusData();
			}
		});
		btnHapus.setFont(new Font("Dialog", Font.BOLD, 14));
		btnHapus.setBounds(420, 160, 123, 26);
		panelSatu.add(btnHapus);
		
		btnUbahData = new JButton("Ubah Data");
		btnUbahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apakahTambahData = false;
				masukModeEditing();
				btnRekamPerubahan.setEnabled(true);
				btnRekamDataFilm.setEnabled(false);
			}
		});
		btnUbahData.setFont(new Font("Dialog", Font.BOLD, 14));
		btnUbahData.setBounds(420, 78, 123, 26);
		panelSatu.add(btnUbahData);
		
		JPanel panelDua = new JPanel();
		tabbedPane.addTab("Pemesanan Film", null, panelDua, null);
		panelDua.setLayout(null);
		
		JLabel lblPilihKategoriFilm = new JLabel("Pilih Kategori Film ");
		lblPilihKategoriFilm.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPilihKategoriFilm.setBounds(12, 12, 131, 19);
		panelDua.add(lblPilihKategoriFilm);
		
		rdbtnKomedi = new JRadioButton("Komedi");
		rdbtnKomedi.setFont(new Font("Dialog", Font.BOLD, 14));
		rdbtnKomedi.setSelected(true);
		buttonGroup.add(rdbtnKomedi);
		rdbtnKomedi.setBounds(148, 9, 89, 24);
		panelDua.add(rdbtnKomedi);
		
		rdbtnRomansa = new JRadioButton("Romansa");
		rdbtnRomansa.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonGroup.add(rdbtnRomansa);
		rdbtnRomansa.setBounds(148, 65, 89, 24);
		panelDua.add(rdbtnRomansa);
		
		rdbtnAction = new JRadioButton("Action");
		rdbtnAction.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonGroup.add(rdbtnAction);
		rdbtnAction.setBounds(148, 36, 89, 24);
		panelDua.add(rdbtnAction);
		
		btnCariFilm = new JButton("Cari Film");
		btnCariFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cariFilm();
			}
		});
		btnCariFilm.setBounds(246, 37, 121, 26);
		panelDua.add(btnCariFilm);
		
		lblDaftarFilmSesuai = new JLabel("Daftar Film Sesuai :");
		lblDaftarFilmSesuai.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDaftarFilmSesuai.setBounds(12, 96, 162, 16);
		panelDua.add(lblDaftarFilmSesuai);
		
		listDaftarFilmSesuai = new JList();
		listDaftarFilmSesuai.setFont(new Font("Dialog", Font.BOLD, 14));
		listDaftarFilmSesuai.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahRincianDataFilmDipilih();
			}
		});
		listDaftarFilmSesuai.setBorder(new LineBorder(new Color(0, 0, 0)));
		listDaftarFilmSesuai.setBounds(12, 120, 430, 112);
		panelDua.add(listDaftarFilmSesuai);
		
		lblJudulFilmDipilih = new JLabel("Judul Film Dipilih");
		lblJudulFilmDipilih.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJudulFilmDipilih.setFont(new Font("Dialog", Font.BOLD, 14));
		lblJudulFilmDipilih.setBounds(22, 244, 152, 16);
		panelDua.add(lblJudulFilmDipilih);
		
		lblJumlahKursiPanelDua = new JLabel("Jumlah Kursi");
		lblJumlahKursiPanelDua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJumlahKursiPanelDua.setFont(new Font("Dialog", Font.BOLD, 14));
		lblJumlahKursiPanelDua.setBounds(22, 272, 152, 16);
		panelDua.add(lblJumlahKursiPanelDua);
		
		lblSisaKursiPanelDua = new JLabel("Sisa Kursi");
		lblSisaKursiPanelDua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSisaKursiPanelDua.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSisaKursiPanelDua.setBounds(22, 299, 152, 16);
		panelDua.add(lblSisaKursiPanelDua);
		
		txtJudulFilmPanelDua = new JTextField();
		txtJudulFilmPanelDua.setBounds(192, 243, 114, 20);
		panelDua.add(txtJudulFilmPanelDua);
		txtJudulFilmPanelDua.setColumns(10);
		
		txtJumlahKursiPanelDua = new JTextField();
		txtJumlahKursiPanelDua.setBounds(192, 271, 57, 20);
		panelDua.add(txtJumlahKursiPanelDua);
		txtJumlahKursiPanelDua.setColumns(10);
		
		txtSisaKursiPanelDua = new JTextField();
		txtSisaKursiPanelDua.setBounds(192, 298, 57, 20);
		panelDua.add(txtSisaKursiPanelDua);
		txtSisaKursiPanelDua.setColumns(10);
		
		panelRincianDataPemesan = new JPanel();
		panelRincianDataPemesan.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		panelRincianDataPemesan.setBorder(new TitledBorder(null, "Rincian Data Pemesan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRincianDataPemesan.setBounds(12, 340, 430, 118);
		panelDua.add(panelRincianDataPemesan);
		panelRincianDataPemesan.setLayout(null);
		
		lblNamaPemesan = new JLabel("Nama Pemesan");
		lblNamaPemesan.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNamaPemesan.setBounds(12, 45, 120, 16);
		panelRincianDataPemesan.add(lblNamaPemesan);
		
		lblTanggalPemesanan = new JLabel("Tanggal Pemesanan");
		lblTanggalPemesanan.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTanggalPemesanan.setBounds(12, 72, 143, 16);
		panelRincianDataPemesan.add(lblTanggalPemesanan);
		
		txtNamaPemesan = new JTextField();
		txtNamaPemesan.setBounds(173, 44, 245, 20);
		panelRincianDataPemesan.add(txtNamaPemesan);
		txtNamaPemesan.setColumns(10);
		
		txtTanggalPemesananPanelDua = new JTextField();
		txtTanggalPemesananPanelDua.setBounds(173, 71, 114, 20);
		panelRincianDataPemesan.add(txtTanggalPemesananPanelDua);
		txtTanggalPemesananPanelDua.setColumns(10);
		
		btnRekamPemesanan = new JButton("Rekam Pemesanan");
		btnRekamPemesanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rekamDataPemesanan();
			}
		});
		btnRekamPemesanan.setBounds(454, 388, 152, 26);
		panelDua.add(btnRekamPemesanan);
		
		panelTiga = new JPanel();
		tabbedPane.addTab("Data Pemesan", null, panelTiga, null);
		panelTiga.setLayout(null);
		
		lblDaftarFilmPanelTiga = new JLabel("Daftar Film");
		lblDaftarFilmPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDaftarFilmPanelTiga.setBounds(12, 12, 97, 19);
		panelTiga.add(lblDaftarFilmPanelTiga);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 38, 418, 140);
		panelTiga.add(scrollPane_1);
		
		listDaftarFilmPanelTiga = new JList();
		listDaftarFilmPanelTiga.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahDaftarPemesanPadaFilmPanelTiga();
			}
		});
		scrollPane_1.setViewportView(listDaftarFilmPanelTiga);
		listDaftarFilmPanelTiga.setBorder(new LineBorder(new Color(0, 0, 0)));
		listDaftarFilmPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		
		lblDaftarPemesan = new JLabel("Daftar Pemesan");
		lblDaftarPemesan.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDaftarPemesan.setBounds(12, 190, 110, 19);
		panelTiga.add(lblDaftarPemesan);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 221, 415, 137);
		panelTiga.add(scrollPane_2);
		
		listDaftarPemesanPanelTiga = new JList();
		listDaftarPemesanPanelTiga.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ubahRincianPemesanPanelTiga();
			}
		});
		scrollPane_2.setViewportView(listDaftarPemesanPanelTiga);
		listDaftarPemesanPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		listDaftarPemesanPanelTiga.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblKategoriFilmPanelTiga = new JLabel("Kategori Film : ");
		lblKategoriFilmPanelTiga.setHorizontalAlignment(SwingConstants.LEFT);
		lblKategoriFilmPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		lblKategoriFilmPanelTiga.setBounds(12, 370, 152, 19);
		panelTiga.add(lblKategoriFilmPanelTiga);
		
		lblTanggalPemesananPanelTiga = new JLabel("Tanggal Pemesanan : ");
		lblTanggalPemesananPanelTiga.setHorizontalAlignment(SwingConstants.LEFT);
		lblTanggalPemesananPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTanggalPemesananPanelTiga.setBounds(12, 400, 152, 19);
		panelTiga.add(lblTanggalPemesananPanelTiga);
		
		cmbKategoriFilmPanelTiga = new JComboBox();
		cmbKategoriFilmPanelTiga.setModel(new DefaultComboBoxModel(new String[] {"Komedi", "Action", "Romansa"}));
		cmbKategoriFilmPanelTiga.setFont(new Font("Dialog", Font.BOLD, 14));
		cmbKategoriFilmPanelTiga.setBounds(170, 370, 114, 25);
		panelTiga.add(cmbKategoriFilmPanelTiga);
		
		txtTanggalPemesananPanelTiga = new JTextField();
		txtTanggalPemesananPanelTiga.setBounds(170, 402, 114, 20);
		panelTiga.add(txtTanggalPemesananPanelTiga);
		txtTanggalPemesananPanelTiga.setColumns(10);
		btnTambahData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apakahTambahData = true;
				masukModeEditing();
				btnRekamDataFilm.setEnabled(true);
				btnRekamPerubahan.setEnabled(false);
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
			// 3a. Membuat objek film baru (memori + database)
			Film filmBaru = FilmDAO.createFilm();
			// 3b. Mengubah atribut objek film baru
			filmBaru.setJudulFilm(judulFilm);
			filmBaru.setKategoriFilm(kategoriFilm);
			filmBaru.setJumlahKursi(jumlahKursi);
			filmBaru.setSisaKursi(sisaKursi); 
			// 3c. Rekam perubahan ke dalam database
			FilmDAO.save(filmBaru);
			// 3d. Jika semua perubahan berhasil, maka lakukan commit
			t.commit();
			JOptionPane.showMessageDialog(null, 
					"Data film baru berhasil ditambahkan");
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal merekam data film\n"
					+ "Pesan Error : " + e.getMessage());
			try {
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback\n"
						+ "Pesan Error : " + e1.getMessage());
			}
			return;
		}
		bacaDataDariDatabase();
		tampilkanDataFilmPadaList();
		int indeksDipilih = dataFilm.length - 1;
		pilihSebuahFilmPadaList(indeksDipilih);
		masukModeBrowsing();
	}
	
	void rekamPerubahan() {
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
					int index = listDaftarFilm.getSelectedIndex();
					Film filmBaru = (Film) listDaftarFilm
								.getModel().getElementAt(index);
					// 3b. Mengubah atribut objek film baru
					filmBaru.setJudulFilm(judulFilm);
					filmBaru.setKategoriFilm(kategoriFilm);
					filmBaru.setJumlahKursi(jumlahKursi);
					filmBaru.setSisaKursi(sisaKursi); 
					// 3c. Rekam perubahan ke dalam database
					FilmDAO.save(filmBaru);
					// 3d. Jika semua perubahan berhasil, maka lakukan commit
					t.commit();
					JOptionPane.showMessageDialog(null, 
							"Data film berhasil diubah");
				} catch (PersistentException e) {
					JOptionPane.showMessageDialog(null, 
							"Gagal merubah data film\n"
							+ "Pesan Error : " + e.getMessage());
					try {
						t.rollback();
					} catch (PersistentException e1) {
						JOptionPane.showMessageDialog(null, 
								"Gagal melakukan rollback\n"
								+ "Pesan Error : " + e1.getMessage());
					}
					return;
				}
				//bacaDataDariDatabase();
				int indeksDipilih = listDaftarFilm
						.getSelectedIndex();
				tampilkanDataFilmPadaList();
				pilihSebuahFilmPadaList(indeksDipilih);
				masukModeBrowsing();
	}
	
	void tambahDataFilm() {
		masukModeEditing();
		btnRekamDataFilm.setText("Rekam Data Film");
		txtJudulFilm.setText("");
		cmbKategoriFilm.setSelectedIndex(0);
		txtJumlahKursi.setText("");
		txtSisaKursi.setText("");
	}
	
	void ubahData() {
		aktifkanPanelRincian();
	}
	
	void masukModeEditing() {
		aktifkanPanelRincian();
		panelRincianDataFilm.setVisible(true);
		listDaftarFilm.setEnabled(false);
		btnTambahData.setEnabled(false);
		btnUbahData.setEnabled(false);
		btnHapus.setEnabled(false);
		btnRekamDataFilm.setEnabled(true);
		btnRekamPerubahan.setVisible(true);
		btnBatal.setEnabled(true);
		if (apakahTambahData==true) {
			txtJudulFilm.setText("");
			cmbKategoriFilm.setSelectedIndex(0);
			txtJumlahKursi.setText("");
			txtSisaKursi.setText("");
		} 
	}
	
	void masukModeBrowsing() {
		nonAktifkanPanelRincian();
		listDaftarFilm.setEnabled(true);
		btnRekamDataFilm.setEnabled(false);
		btnRekamPerubahan.setEnabled(false);
		btnBatal.setEnabled(false);
		btnTambahData.setEnabled(true);
		btnUbahData.setEnabled(true);
		btnHapus.setEnabled(true);
	}
	
	void bacaDataDariDatabase() {
		try {
			dataFilm = FilmDAO.listFilmByQuery(null, null);
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, 
					"Gagal membaca data film\n"
					+ "Pesan Error : " + e.getMessage());
		}
	}
	
	void tampilkanDataFilmPadaList() {
		listDaftarFilm.setListData(dataFilm);
		listDaftarFilmPanelTiga.setListData(dataFilm);
	}
	
	void ubahTampilanPadaPanelRincian() {
		if (listDaftarFilm.getModel().getSize()==0) {
			/* Jika list data film kosong, maka kosongkan
			 * juga panel rincian data film
			 */
			txtJudulFilm.setText("");
			txtJumlahKursi.setText("");
			txtSisaKursi.setText("");
			cmbKategoriFilm.setSelectedIndex(0);
			return;
		}
		int index = listDaftarFilm.getSelectedIndex();
		if (index==-1) {
			return;
		}
		Film filmDipilihPadaList = (Film) listDaftarFilm
				.getModel().getElementAt(index);
		txtJudulFilm.setText(filmDipilihPadaList.getJudulFilm());
		cmbKategoriFilm.setSelectedIndex(0);
		if (filmDipilihPadaList.getKategoriFilm()=='A') {
			cmbKategoriFilm.setSelectedIndex(1);
		}
		else if (filmDipilihPadaList.getKategoriFilm()=='R') {
			cmbKategoriFilm.setSelectedIndex(2);
		}
		txtJumlahKursi.setText("" + filmDipilihPadaList.getJumlahKursi());
		txtSisaKursi.setText("" + filmDipilihPadaList.getSisaKursi());	
	}
	
	void batalkanProsesManipulasiData() {
		/*1. Aktifkan/NonAktifkan Tombol GUI */
		masukModeBrowsing();
		
		/*2. Update Tampilan Isian Data Sesuai Pilihan pada list */
		ubahTampilanPadaPanelRincian();
	}
	
	void hapusData() {
		int pilihanKonfirmasi = JOptionPane.showConfirmDialog(null, 
				"Apakah anda yakin untuk menghapus data film " 
				+ listDaftarFilm.getSelectedValue(),
				"Konfirmasi Hapus Data",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (pilihanKonfirmasi == JOptionPane.OK_OPTION) {
		// 1. Menentukan objek film yang sedang dipilih pada list
		int index = listDaftarFilm.getSelectedIndex();
		Film filmDipilihPadaList = (Film) listDaftarFilm
					.getModel().getElementAt(index);
			// 2. Hapus data dari database
			PersistentTransaction t = null;
			int indeksDataDipilih = listDaftarFilm.getSelectedIndex();
			int jumlahFilm = dataFilm.length;
			if (indeksDataDipilih == jumlahFilm-1 && jumlahFilm >= 2) {
				/* Yang dipilih adalah yang terakhir dan masih
				 * ada sisa film belum dihapus di dalam list
				 */
				indeksDataDipilih -= 1;
			} else if (indeksDataDipilih == 0 && jumlahFilm == 1) {
				// Yang dipilih adalah satu-satunya film dalam list
				indeksDataDipilih = -1;
			} 
			try {
				t = TugasBesar02PersistentManager
						.instance().getSession().beginTransaction();
				FilmDAO.deleteAndDissociate(filmDipilihPadaList);
				t.commit();
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
				return;
			}
			bacaDataDariDatabase();
			tampilkanDataFilmPadaList();	
			pilihSebuahFilmPadaList(indeksDataDipilih);
		}
	}
	
	void pilihSebuahFilmPadaList(int indeksDipilih) {
		if (indeksDipilih==-1) {
			return;
		}
		listDaftarFilm.setSelectedIndex(indeksDipilih);
	}
	
	void aktifkanPanelRincian() {
		for (Component guiObject:panelRincianDataFilm
				.getComponents()) {
			guiObject.setEnabled(true);
		}
	}
	
	void nonAktifkanPanelRincian() {
		for (Component guiObject:panelRincianDataFilm
				.getComponents()) {
			guiObject.setEnabled(false);
		}
	}
	
	void cariFilm() {
		// 1. Membuat string query
		String kondisi = String.format("kategori_film = " + "'%s' and sisa_kursi > 0" , 
				rdbtnKomedi.isSelected() ? "K" : rdbtnAction.isSelected() ? "A" : "R"  );
		//2. Mengeksekusi hasil query dengan kondisi dan
		//Menyimpan hasil query ke dalam array
		dataFilmSesuai = new Film[0];
		try {
			dataFilmSesuai = FilmDAO.listFilmByQuery(kondisi,
					"sisa_kursi DESC");
		} catch (PersistentException e) {
			JOptionPane.showMessageDialog(null, "Gagal"
					+ "membaca data film\n"
					+ "Pesan error:" + e.getMessage());
			
			return;
		}
		
		/* 3. Menampilkan data film yang sesuai
		 * pada list daftar film sesuai, jika ada minimal
		 * 1 film sebagai hasil query
		 */
		
		if(dataFilmSesuai.length>0) {
			listDaftarFilmSesuai.setListData(dataFilmSesuai);
		} else {
			JOptionPane.showMessageDialog(null, 
					"Tidak tersedia film yang masih memiliki"
					+ "kursi kosong");
			return;
		}
	}
	
	void ubahRincianDataFilmDipilih() {
		/* 1. Memeriksa apakah event list selection change dipicu
		 * oleh perubahan pilihan user pada list atau oleh proses
		 * menampilkan data pad list
		 */
		
		int indeksDipilih = listDaftarFilmSesuai.getSelectedIndex();
		if (indeksDipilih == -1) {
			txtJudulFilmPanelDua.setText("");
			txtJumlahKursiPanelDua.setText("");
			txtSisaKursiPanelDua.setText("");
			return;
		}
		
		/* 2. Menentukan objek kamar yang dipilih
		 * user pada list
		 */
		Film filmDipilih = (Film) listDaftarFilmSesuai.getModel()
				.getElementAt(indeksDipilih);
	
	/* 3. Mengisi rincian data film sesuai yang dipilih user
	 * 
	 */
	txtJudulFilmPanelDua.setText(""+filmDipilih.getJudulFilm());
	txtJumlahKursiPanelDua.setText(""+filmDipilih.getJumlahKursi());
	txtSisaKursiPanelDua.setText(""+filmDipilih.getSisaKursi());
	}
	void rekamDataPemesanan() {
		//1. Memeriksa apakah film sudah dipilih
		if (listDaftarFilmSesuai.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(null, 
					"Film untuk pemesan harus dipilih terlebih dahulu. \n"
					+ "Silahkan Perbaiki.");
			return;
		}
		
		/* 2. Menentukan objek kamar yang dipilih
		 * user pada list
		 */
		int indeksDipilih = listDaftarFilmSesuai.getSelectedIndex();
		Film filmDipilih = (Film) listDaftarFilmSesuai.getModel()
				.getElementAt(indeksDipilih);
	
		/*3. Memeriksa apakah nama pemesan sudah diisi 
		 */
		if(txtNamaPemesan.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Nama pemesan harus diisi terlebih dahulu.\n"
				+ "Silahkan Perbaiki");
			return;
		}
		String namaPemesan = txtNamaPemesan.getText();
		
		/* 4. Memeriksa apakah tanggal pemesanan adalah tanggal yang valid
		 */
//		Date tanggalPemesanan = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date tanggalPemesanan = null;
		try {
			tanggalPemesanan = sdf.parse(txtTanggalPemesananPanelDua
					.getText());
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, 
					"Tanggal pemesanan harus ditulis dengan format "
					+ "DD/MM/YYYY.\n"
					+ "Silahkan perbaiki.");
			return;
		}
		
		// 5. Merekam data pendaftaran ke dalam database
		// 5a. Membuat transaction
		PersistentTransaction t = null;
		try {
			t = TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		} catch (PersistentException e1) {
			JOptionPane.showMessageDialog(null, 
					"Gagal membuat transaction.\n"
					+ "Pesan Error : " + e1.getMessage());
		}
		
		try {
			// 5b. Melakukan langkah perubahan data
			// 5b1. Membuat objek pemesan baru
			Pemesan pemesanBaru = PemesanDAO.createPemesan();
			// 5b2. Mengubah berbagai atribut objek pemesan
			pemesanBaru.setNamaPemesan(namaPemesan);
			pemesanBaru.setTanggalPemesanan(tanggalPemesanan);
			// 5b3. Mengubah berbagai atribut objek film
			filmDipilih.pemesan.add(pemesanBaru);
			filmDipilih.setSisaKursi(filmDipilih
					.getSisaKursi() - 1);
			// 5b4. Merekam perubahan ke dalam database
			PemesanDAO.save(pemesanBaru);
			FilmDAO.save(filmDipilih);
			t.commit();
		} catch (PersistentException e) {
			JOptionPane.showConfirmDialog(null, 
					"Gagal merekam data pemesan\n"
					+ "Pesan Error : " + e.getMessage());
			try {
				t.rollback();
			} catch (PersistentException e1) {
				JOptionPane.showMessageDialog(null, 
						"Gagal melakukan rollback.\n"
						+ "Pesan Error : " + e1.getMessage());
			}
			return;
		}
		JOptionPane.showMessageDialog(null, 
				"Data pemesan berhasil ditambahkan");
		txtNamaPemesan.setText("");
		txtJumlahKursiPanelDua.setText("");
		txtSisaKursiPanelDua.setText("");
		listDaftarFilmSesuai.setListData(new Film[0]);
		rdbtnKomedi.setSelected(true);
	}
	
	void ubahDaftarPemesanPadaFilmPanelTiga() {
		/* 1. Memeriksa apakah event selection-change dipicu oleh
		 * berubahnya pilihan user pada list atau dipicu oleh awal 
		 * ditampilkannya daftar film pada list
		 */
		int indeksDipilih = listDaftarFilmPanelTiga.getSelectedIndex();
		if (indeksDipilih==-1) {
			// Dipicu oleh awal ditampilkannya daftar
			return;
		}
		// 2. Mendapatkan objek film yang dipilih pada list
		Film filmDipilih = (Film) listDaftarFilmPanelTiga.getModel()
				.getElementAt(indeksDipilih);
		// 3. Membuat daftar pemesan
		/* 3a. Membuat array objek pemesan dengan jumlah elemen sebanyak 
		 * jumlah objek pemesan dalam koleksi pemesan pada objek film dipilih
		 */
		Pemesan[] dataPemesan = new Pemesan[filmDipilih.pemesan.size()];
		/* 3b. Konversi koleksi pemesan menjadi array */
		dataPemesan = (Pemesan[]) filmDipilih.pemesan.getCollection()
				.toArray(dataPemesan);
		// 4. Menampilkan daftar pemesan pada list
		listDaftarPemesanPanelTiga.setListData(dataPemesan);
	}
	
	void ubahRincianPemesanPanelTiga() {
		/* 1. Memeriksa apakah perubahan pilihan list dipicu oleh 
		 * berubahnya pilihan user atau dipicu oleh baru
		 * ditampilkannya daftar pemesan
		 */
		int indeksDipilih = listDaftarPemesanPanelTiga.getSelectedIndex();
		if (indeksDipilih==-1) {
			// Dipicu oleh baru ditampilkannya daftar
			if (listDaftarPemesanPanelTiga.getModel().getSize()>0) {
				// Jika list tidak kosong, pilih pemesan pada daftar paling atas
				listDaftarPemesanPanelTiga.setSelectedIndex(0);
			}
			return;
		}
		// 2. Ubah rincian
		cmbKategoriFilmPanelTiga.setSelectedIndex(0);
		Pemesan pemesanDipilih = (Pemesan) listDaftarPemesanPanelTiga
				.getModel().getElementAt(indeksDipilih);
		if (pemesanDipilih.getKategoriFilm()=='A') {
			cmbKategoriFilmPanelTiga.setSelectedIndex(1);
		} else if (pemesanDipilih.getKategoriFilm()=='R') {
			cmbKategoriFilmPanelTiga.setSelectedIndex(2);
		}
		String tanggal = "";
		LocalDate tanggalPemesanan = Instant.ofEpochMilli(pemesanDipilih
				.getTanggalPemesanan().getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		tanggal += tanggalPemesanan.getDayOfMonth() + "/";
		tanggal += tanggalPemesanan.getMonthValue() + "/";
		tanggal += tanggalPemesanan.getYear();
		txtTanggalPemesananPanelTiga.setText(tanggal);
	}
}