package musicmachine;

import jaco.mp3.player.MP3Player;
import jaco.mp3.player.c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MusicMachine extends JFrame {

	/*
	 * Defined global variables
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	private JLabel label;

	String showChooserPath;

	static AudioFilter audioFilter = new AudioFilter();
	FileFilter fileFilter = new FileFilter();
	File fFile;

	MP3Player player = new MP3Player();

	boolean shuffle;
	boolean repeat;

	private BufferedReader br;

	/*
	 * Create frame
	 */
	public MusicMachine() {
		setTitle("Music Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 511);

		/*
		 * Menu bar
		 */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		/*
		 * File menu
		 */
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Exit();
			}
		});

		/*
		 * New playlist menu item
		 */
		JMenuItem mntmNewPlaylist = new JMenuItem("New Playlist");
		mntmNewPlaylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewPlaylist();
			}
		});
		mnFile.add(mntmNewPlaylist);

		/*
		 * Open playlist menu item
		 */
		JMenuItem mntmOpenPlaylist = new JMenuItem("Open Playlist");
		mntmOpenPlaylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OpenPlaylist();
			}
		});
		mnFile.add(mntmOpenPlaylist);

		/*
		 * Save playlist menu item
		 */
		JMenuItem mntmSavePlaylist = new JMenuItem("Save Playlist");
		mntmSavePlaylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SavePlaylist();
			}
		});
		mnFile.add(mntmSavePlaylist);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mnFile.add(mntmExit);

		/*
		 * Preferences menu
		 */
		JMenu mnPreferences = new JMenu("Preferences");
		menuBar.add(mnPreferences);

		JMenuItem mntmDefaultMusicDirectory = new JMenuItem(
				"Default Music Directory");
		mntmDefaultMusicDirectory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetMusicDir();
			}
		});
		mnPreferences.add(mntmDefaultMusicDirectory);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		/*
		 * Playlist label
		 */
		JLabel lblPlaylistName = new JLabel("Playlist:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPlaylistName, 0,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPlaylistName, 15,
				SpringLayout.WEST, contentPane);
		contentPane.add(lblPlaylistName);

		/*
		 * jTable and jPanel
		 */

		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 6,
				SpringLayout.SOUTH, lblPlaylistName);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 0,
				SpringLayout.WEST, lblPlaylistName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -148,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Song" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		/*
		 * Add button
		 */
		JButton btnAdd = new JButton("Add Song");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAdd, 6,
				SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAdd, 0,
				SpringLayout.WEST, lblPlaylistName);
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Add();
			}
		});
		contentPane.add(btnAdd);

		/*
		 * Play button
		 */
		JButton btnPlay = new JButton("Play");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPlay, 0,
				SpringLayout.WEST, lblPlaylistName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPlay, -10,
				SpringLayout.SOUTH, contentPane);
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play();
			}
		});
		contentPane.add(btnPlay);

		/*
		 * Stop button
		 */
		JButton btnStop = new JButton("Stop");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnStop, 0,
				SpringLayout.NORTH, btnPlay);
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Stop();
			}
		});
		contentPane.add(btnStop);

		/*
		 * Exit button
		 */
		JButton btnExit = new JButton("Exit");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnExit, 0,
				SpringLayout.NORTH, btnPlay);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnExit, 0,
				SpringLayout.EAST, scrollPane);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		contentPane.add(btnExit);

		/*
		 * Pause button
		 */
		JButton btnPause = new JButton("Pause");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPause, 0,
				SpringLayout.NORTH, btnPlay);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPause, 6,
				SpringLayout.EAST, btnPlay);
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pause();
			}
		});
		contentPane.add(btnPause);

		/*
		 * Next button
		 */
		JButton btnNext = new JButton("Next");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNext, 0,
				SpringLayout.NORTH, btnPlay);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNext, 6,
				SpringLayout.EAST, btnPause);
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Next();
			}
		});
		contentPane.add(btnNext);

		/*
		 * Previous button
		 */
		JButton btnPrevious = new JButton("Previous");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnStop, 6,
				SpringLayout.EAST, btnPrevious);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPrevious, 0,
				SpringLayout.NORTH, btnPlay);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPrevious, 6,
				SpringLayout.EAST, btnNext);
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Previous();
			}
		});
		contentPane.add(btnPrevious);

		/*
		 * Shuffles playlist
		 */
		final JToggleButton tglbtnShuffle = new JToggleButton("Shuffle");
		sl_contentPane.putConstraint(SpringLayout.NORTH, tglbtnShuffle, 0,
				SpringLayout.NORTH, btnPlay);
		sl_contentPane.putConstraint(SpringLayout.WEST, tglbtnShuffle, 6,
				SpringLayout.EAST, btnStop);
		tglbtnShuffle.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent evt) {
				if (tglbtnShuffle.isSelected()) {
					player.setShuffle(true);
				} else {
					player.setShuffle(false);
				}
			}
		});
		contentPane.add(tglbtnShuffle);

		/*
		 * Repeats playlist
		 */
		final JToggleButton tglbtnRepeat = new JToggleButton("Repeat");
		sl_contentPane.putConstraint(SpringLayout.NORTH, tglbtnRepeat, 0,
				SpringLayout.NORTH, btnPlay);
		sl_contentPane.putConstraint(SpringLayout.WEST, tglbtnRepeat, 6,
				SpringLayout.EAST, tglbtnShuffle);
		tglbtnRepeat.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent evt) {
				if (tglbtnRepeat.isSelected()) {
					player.setRepeat(true);
				} else {
					player.setRepeat(false);
				}
			}
		});
		contentPane.add(tglbtnRepeat);

		/*
		 * Remove song from playlist
		 */
		JButton btnRemoveSong = new JButton("Remove Song");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRemoveSong, 6,
				SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRemoveSong, 6,
				SpringLayout.EAST, btnAdd);
		btnRemoveSong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Remove();
			}
		});
		contentPane.add(btnRemoveSong);

		/*
		 * Label for playlist name
		 */
		label = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 0,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 14,
				SpringLayout.EAST, lblPlaylistName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, 0,
				SpringLayout.SOUTH, lblPlaylistName);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -548,
				SpringLayout.EAST, contentPane);
		contentPane.add(label);

		this.setLocationRelativeTo(null);
	}

	/*
	 * Add files to table
	 */
	public void Add() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		GetPath();
		JFileChooser fc = new JFileChooser(showChooserPath);
		fc.setFileFilter(audioFilter);
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setMultiSelectionEnabled(true);
		fc.showOpenDialog(fc);
		File[] files = fc.getSelectedFiles();

		for (File file : files) {
			model.addRow(new String[] { file.toString() });
		}
	}

	/*
	 * Remove file from table
	 */
	public void Remove() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			model.removeRow(rows[i] - i);
		}
	}

	/*
	 * Exit program
	 */
	public void Exit() {
		System.exit(0);
	}

	/*
	 * Play MP3
	 */
	public void Play() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int i;
		int k = 0;

		for (i = 0; i < table.getRowCount(); i++) {
			model.getColumnName(k);
			String song = model.getValueAt(i, k).toString();

			player.addToPlayList(new File(song));
			player.play();
		}
	}

	/*
	 * Pause player
	 */
	public void Pause() {
		player.pause();
	}

	/*
	 * Stops player
	 */
	public void Stop() {
		player.stop();
	}

	/*
	 * Plays next MP3
	 */
	public void Next() {
		player.skipForward();
	}

	/*
	 * Plays previous MP3
	 */
	public void Previous() {
		player.skipBackward();
	}

	/*
	 * Action for new playlist
	 */
	public void NewPlaylist() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		label.setText("");
	}

	/*
	 * Action to open playlist
	 */
	public void OpenPlaylist() {
		JFileChooser fc = new JFileChooser();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		fc.setDialogTitle("Open Playlist");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setCurrentDirectory(new File("."));
		fc.setFileFilter(fileFilter);

		int result = fc.showOpenDialog(this);

		if (result == JFileChooser.CANCEL_OPTION) {
		} else if (result == JFileChooser.APPROVE_OPTION) {
			fFile = fc.getSelectedFile();
		}
		String choosefile = fc.getSelectedFile().toString();

		try {
			String file = choosefile;
			br = new BufferedReader(new FileReader(file));
			ArrayList<String> songList = new ArrayList<String>();
			String line = br.readLine();

			while (line != null) {
				songList.add(line);
				String[] rowfields = line.split("\n");
				for (String s : rowfields) {
					model.addRow(new String[] { s.toString().trim() });
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		label.setText(fFile.getName().replaceAll(".txt", ""));
	}

	/*
	 * Action for save playlist
	 */
	public void SavePlaylist() {
		JFileChooser fc = new JFileChooser();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		fc.setDialogTitle("Save Playlist");
		fc.setCurrentDirectory(new File("."));
		fc.setFileFilter(fileFilter);
		fc.setSelectedFile(fFile);

		int result = fc.showSaveDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			fFile = fc.getSelectedFile();
			if (fFile.exists()) {
				int response = JOptionPane.showConfirmDialog(null,
						"Overwrite existing file?", "Confirm Overwrite",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.CANCEL_OPTION)
					;
			}
			String choosefile = fc.getSelectedFile().toString();

			try {
				String file = choosefile;
				FileWriter out = new FileWriter(file + ".txt");

				for (int i = 0; i < model.getRowCount(); i++) {
					for (int j = 0; j < model.getColumnCount(); j++) {
						out.write(model.getValueAt(i, j).toString() + "\t");
					}
					out.write("\n");
				}
				out.close();

			} catch (IOException e) {
				System.out.println(e);
			}
			label.setText(fFile.getName());
		}
	}

	/*
	 * Set default music directory
	 */
	public void SetMusicDir() {
		String choosedir;
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.showSaveDialog(fc);
		choosedir = fc.getSelectedFile().toString();

		try {
			PrintWriter out = new PrintWriter("musicdir.txt");
			out.write(choosedir);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Get music directory path
	 */
	public void GetPath() {
		File showFile = new File("./musicdir.txt");
		if (showFile.exists()) {
			try {
				BufferedReader showPathReader = new BufferedReader(
						new FileReader(showFile));
				showChooserPath = showPathReader.readLine();
				showPathReader.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex);
			}
		}
	}
}