package hw5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class BookStore extends JFrame{

	private JPanel contentPane;

	private static ArrayList<Book> library = new ArrayList<Book>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	private static Customer customer;
	private static Book book;
	
	private JTextField searchTitle;
	private JTextField searchAuthor;
	private JTextField searchPublisher;
	private JTextField searchCategory;
	private JTextField searchCopies;
	private JTextField searchYear;
	private JTextField searchPageNum;
	private JTextField searchFirstName;
	private JTextField searchLastName;
	private JTextField searchEmail;
	private JTextField searchPhone;
	private JTextField searchAddress;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	 	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStore frame = new BookStore();
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
	public BookStore() {
		
		//Books that are in the bookstore
		Book b1 = new Book("Magical Tree House: Dinosaurs Before Dark", "Mary Pope Osborn", "Random House", "Fantasy",80, 1973, 13);
		Book b2 = new Book("Magical Tree House: The Knight at Dawn", "Mary Pope Osborn", "Random House", "Fantasy",67, 1993, 25);
		Book b3 = new Book("Magical Tree House: Mummies in the Morning", "Mary Pope Osborn", "Random House", "Fantasy",80, 1993, 31);
		Book b4 = new Book("Lord of the Flies", "William Golding", "Fabor and Fabor", "Novel",224, 1954, 25);
	 	Book b5 = new Book("Strange Case of Dr Jekyll and Mr Hyde", "Robert Louis Stevenson", "Simon & Schuster", "Horror Fiction",141, 1886, 19);	
		library.add(b1);
		library.add(b2);
		library.add(b3);
		library.add(b4);
		library.add(b5);
	 	
	 	
	 	//Customers in the bookstore
	 	Customer c1 = new Customer("Rakin", "Bhuyan", "rabhuyan@uab.edu", "17th Street 606 Gold Dorm" , "3158303946" );
	 	Customer c2 = new Customer("Tony", "Bhuyan", "tbhuyan@uab.edu", "129 Avengers Tower", "1580987457");
	 	Customer c3 = new Customer("Tony", "Universe", "tuniverse@uab.edu", "1000 Rainbow Drive", "1234567890");
	 	customers.add(c1);
	 	customers.add(c2);
	 	customers.add(c3);
	 	
	 	//Books customer 2 has
	 	Book b6 = new Book("Percy Jackson & the Olympians: The Lightning Thief", "Rick Riordan", "Disney-Hyperion", "Greek Mythology", 416, 2005, 10);
	 	Book b7 = new Book("Percy Jackson & the Olympians: The Sea of Monsters", "Rick Riordan", "Disney-Hyperion", "Greek Mythology", 320, 2006, 7);
	 	c2.books.add(b6);
	 	c2.books.add(b7);
	 	
	 	//Books customer 3 has
	 	Book b8 = new Book("The Unwanteds", "Lisa McMann", "Simon & Schuster", "Fantasy", 416 ,2011, 12);
	 	Book b9 = new Book("The Unwanteds: Island of Silence", "Lisa McMann", "Simon & Schuster", "Fantasy", 432 ,2012, 18);
	 	Book b10 = new Book("The Unwanteds: Island of Fire", "Lisa McMann", "Simon & Schuster", "Fantasy", 480 ,2013, 6);
	 	c3.books.add(b8);
	 	c3.books.add(b3);
	 	c3.books.add(b10);
	 	
//=========================================================================================================================================================
//=========================================================================================================================================================
	 	
		setResizable(false);
		setTitle("UAB BookStore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66, 164, 2));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 792, 522);
		contentPane.add(tabbedPane);

//=========================================================================================================================================================
//=========================================================================================================================================================
		
		
		JPanel displayBooks = new JPanel();
		displayBooks.setBackground(new Color(112, 196, 57));
		tabbedPane.addTab("Display Books", null, displayBooks, null);
		displayBooks.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 37, 717, 414);
		scrollPane_2.setBorder(BorderFactory.createEmptyBorder());
		displayBooks.add(scrollPane_2);
		
		JTextArea displayOfBooks = new JTextArea();
		scrollPane_2.setViewportView(displayOfBooks);
		displayOfBooks.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		displayOfBooks.setEditable(false);
		displayOfBooks.setBackground(new Color(112, 196, 56));
		for(Book b : library) {
			displayOfBooks.append(b.toString());
		}
		
		//Updates what the JTextArea
		JButton update = new JButton("Update");
		update.setBounds(217, 6, 326, 29);
		displayBooks.add(update);
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayOfBooks.setText("");  //makes the JTextArea nothing
				for(Book b : library) { 	//appends the new information
					displayOfBooks.append(b.toString());
				}
			}
		});
		
//=========================================================================================================================================================
//=========================================================================================================================================================
		
		//Searching for a book
		JPanel SearchBook = new JPanel();
		SearchBook.setBackground(new Color(112, 196, 57));
		tabbedPane.addTab("Search Book", null, SearchBook, null);
		SearchBook.setLayout(null);
		
		searchTitle = new JTextField();
		searchTitle.setBounds(199, 25, 405, 36);
		searchTitle.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		SearchBook.add(searchTitle);
		searchTitle.setColumns(10);
		
		searchAuthor = new JTextField();
		searchAuthor.setBounds(126, 122, 176, 36);
		searchAuthor.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchAuthor.setColumns(10);
		SearchBook.add(searchAuthor);
		
		searchPublisher = new JTextField();
		searchPublisher.setBounds(126, 231, 176, 36);
		searchPublisher.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchPublisher.setColumns(10);
		SearchBook.add(searchPublisher);
		
		searchCategory = new JTextField();
		searchCategory.setBounds(126, 338, 176, 36);
		searchCategory.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchCategory.setColumns(10);
		SearchBook.add(searchCategory);
		
		searchCopies = new JTextField();
		searchCopies.setBounds(534, 338, 176, 36);
		searchCopies.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchCopies.setColumns(10);
		SearchBook.add(searchCopies);
		
		searchYear = new JTextField();
		searchYear.setBounds(534, 231, 176, 36);
		searchYear.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchYear.setColumns(10);
		SearchBook.add(searchYear);
		
		searchPageNum = new JTextField();
		searchPageNum.setBounds(534, 122, 176, 36);
		searchPageNum.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchPageNum.setColumns(10);
		SearchBook.add(searchPageNum);
		
		JLabel lblTitle = new JLabel("Title: ");
		lblTitle.setBounds(144, 33, 83, 21);
		lblTitle.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		SearchBook.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(45, 130, 93, 21);
		lblAuthor.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		SearchBook.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setBounds(17, 239, 121, 21);
		lblPublisher.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		SearchBook.add(lblPublisher);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(17, 323, 121, 28);
		lblCategory.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		SearchBook.add(lblCategory);
		
		JLabel lblNumberOfPages = new JLabel("Number of Pages:");
		lblNumberOfPages.setBounds(337, 125, 207, 31);
		lblNumberOfPages.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		SearchBook.add(lblNumberOfPages);
		
		JLabel lblTyear = new JLabel("Year: ");
		lblTyear.setBounds(472, 239, 83, 21);
		lblTyear.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		SearchBook.add(lblTyear);
		
		JLabel lblCopies = new JLabel("Copies:");
		lblCopies.setBounds(454, 346, 83, 21);
		lblCopies.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		SearchBook.add(lblCopies);
		
		JButton searchByTitle = new JButton("Search");
		searchByTitle.setBounds(320, 62, 161, 29);
		searchByTitle.setBackground(new Color(112, 196, 57));
		SearchBook.add(searchByTitle);
		
		searchByTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchTitle.getText().equals(""))) {			//First checks if the textbox is empty, if not it will proceed
					String titleInput = searchTitle.getText();
					
					JScrollPane foundScroll = new JScrollPane();	//Creates a scrollPane to output results
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchBook.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Book b : library) {
						if(b.getTitle().equals(titleInput)) {	//Will output all of the matches
							found.append(b.toString());		
						}
					}
					
					back.addActionListener(new ActionListener() {		//removes the scrollPane to go back to the search page
						public void actionPerformed(ActionEvent e) {
							SearchBook.remove(foundScroll);
						}
					});
					searchTitle.setText("");
				}
				
			}
		});		
		
		JButton searchByAuthor = new JButton("Search");
		searchByAuthor.setBounds(159, 159, 111, 29);
		searchByAuthor.setBackground(new Color(112, 196, 57));
		SearchBook.add(searchByAuthor);

		searchByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchAuthor.getText().equals(""))) {
					String authorInput = searchAuthor.getText();
					
					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchBook.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Book b : library) {
						if(b.getAuthor().equals(authorInput)) {
							found.append(b.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchBook.remove(foundScroll);
						}
					});
					searchAuthor.setText("");
				}
				
			}
		});
		
		JButton searchByPublisher = new JButton("Search");
		searchByPublisher.setBounds(159, 268, 111, 29);
		searchByPublisher.setBackground(new Color(112, 196, 57));
		SearchBook.add(searchByPublisher);
		
		searchByPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchPublisher.getText().equals(""))) {
					String publisherInput = searchPublisher.getText();

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchBook.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Book b : library) {
						if(b.getPublisher().equals(publisherInput)) {
							found.append(b.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchBook.remove(foundScroll);
						}
					});
					searchPublisher.setText("");
				}
				
			}
		});
		
		JButton searchByCategory = new JButton("Search");
		searchByCategory.setBounds(159, 374, 111, 29);
		searchByCategory.setBackground(new Color(112, 196, 57));
		SearchBook.add(searchByCategory);
		
		searchByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchCategory.getText().equals(""))) {
					String categoryInput = searchCategory.getText();

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchBook.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Book b : library) {
						if(b.getCategory().equals(categoryInput)) {
							found.append(b.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchBook.remove(foundScroll);
						}
					});
					searchCategory.setText("");
				}
				
			}
		});
		
		JButton searchByNumPages = new JButton("Search");
		searchByNumPages.setBounds(566, 159, 111, 29);
		searchByNumPages.setBackground(new Color(112, 196, 57));
		SearchBook.add(searchByNumPages);
		
		searchByNumPages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchPageNum.getText().equals(""))) {
					int numPagesInput = Integer.parseInt(searchPageNum.getText());

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchBook.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Book b : library) {
						if(b.getNumPages() == numPagesInput) {
							found.append(b.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchBook.remove(foundScroll);
						}
					});
					searchPageNum.setText("");
				}
				
			}
		});
		
		JButton searchByYear = new JButton("Search");
		searchByYear.setBounds(566, 268, 111, 29);
		searchByYear.setBackground(new Color(112, 196, 57));
		SearchBook.add(searchByYear);
		
		searchByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchYear.getText().equals(""))) {
					int yearInput = Integer.parseInt(searchYear.getText());

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchBook.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Book b : library) {
						if(b.getYear() == yearInput) {
							found.append(b.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchBook.remove(foundScroll);
						}
					});
					searchYear.setText("");
				}
				
			}
		});
		
		JButton searchByCopies = new JButton("Search");
		searchByCopies.setBounds(566, 374, 111, 29);
		searchByCopies.setBackground(new Color(112, 196, 57));
		SearchBook.add(searchByCopies);
		
		searchByCopies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchCopies.getText().equals(""))) {
					int copiesInput = Integer.parseInt(searchCopies.getText());

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchBook.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Book b : library) {
						if(b.getCopies() == copiesInput) {
							found.append(b.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchBook.remove(foundScroll);
						}
					});
					searchCopies.setText("");
				}
				
			}
		});
		
//=========================================================================================================================================================
//=========================================================================================================================================================
		
		//Renting a book
		JPanel rentBook = new JPanel();
		rentBook.setBackground(new Color(112, 196, 57));
		tabbedPane.addTab("Rent Book", null, rentBook, null);
		rentBook.setLayout(null);
		
		JLabel customerChoice = new JLabel("Choose a Customer:");
		customerChoice.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		customerChoice.setBounds(21, 6, 167, 36);
		rentBook.add(customerChoice);
		
		JLabel bookChoice = new JLabel("Choose a Book:");
		bookChoice.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		bookChoice.setBounds(21, 151, 167, 36);
		rentBook.add(bookChoice);
		
		JRadioButtonMenuItem customerChoice1 = new JRadioButtonMenuItem(c1.getFirstName() + " " + c1.getLastName());
		customerChoice1.setHorizontalAlignment(SwingConstants.CENTER);
		customerChoice1.setBackground(new Color(138, 203, 83));
		customerChoice1.setBounds(31, 54, 153, 75);
		rentBook.add(customerChoice1);
		
		JRadioButtonMenuItem customerChoice2 = new JRadioButtonMenuItem(c2.getFirstName() + " " + c2.getLastName());
		customerChoice2.setHorizontalAlignment(SwingConstants.CENTER);
		customerChoice2.setBackground(new Color(138, 203, 83));
		customerChoice2.setBounds(272, 54, 153, 75);
		rentBook.add(customerChoice2);
		
		JRadioButtonMenuItem customerChoice3 = new JRadioButtonMenuItem(c3.getFirstName() + " " + c3.getLastName());
		customerChoice3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		customerChoice3.setHorizontalAlignment(SwingConstants.CENTER);
		customerChoice3.setBackground(new Color(138, 203, 83));
		customerChoice3.setBounds(511, 54, 153, 75);
		rentBook.add(customerChoice3);
		
		ButtonGroup buttons1 = new ButtonGroup();		//Makes it so that you can't have more than one item selected
		buttons1.add(customerChoice1);
		buttons1.add(customerChoice2);
		buttons1.add(customerChoice3);
		
		JPanel bookPanel = new JPanel();
		bookPanel.setBackground(new Color(109, 191, 53));
		bookPanel.setBounds(6, 187, 759, 251);
		rentBook.add(bookPanel);
		bookPanel.setLayout(new GridLayout(5,0));
		
		customerChoice1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				customer = c1;
			}
		});
		
		customerChoice2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				customer = c2;
			}
		});
		
		customerChoice3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				customer = c3;
			}
		});
		
		JRadioButtonMenuItem book1 = new JRadioButtonMenuItem(b1.getTitle());
		JRadioButtonMenuItem book2 = new JRadioButtonMenuItem(b2.getTitle());
		JRadioButtonMenuItem book3 = new JRadioButtonMenuItem(b3.getTitle());
		JRadioButtonMenuItem book4 = new JRadioButtonMenuItem(b4.getTitle());
		JRadioButtonMenuItem book5 = new JRadioButtonMenuItem(b5.getTitle());
		
		ButtonGroup buttons2 = new ButtonGroup();
		
		for(int i = 0; i < library.size(); i++) {
			if(i == 0) {
				if(library.get(i).getCopies() != 0){
					book1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					book1.setHorizontalAlignment(SwingConstants.CENTER);
					book1.setBackground(new Color(138, 203, 83));
					bookPanel.add(book1);
					buttons2.add(book1);
				}
			}
			if(i == 1) {
				if(library.get(i).getCopies() != 0){
					book2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					book2.setHorizontalAlignment(SwingConstants.CENTER);
					book2.setBackground(new Color(138, 203, 83));
					bookPanel.add(book2);
					buttons2.add(book2);
				}
			}
			if(i == 2) {
				if(library.get(i).getCopies() != 0){
					book3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					book3.setHorizontalAlignment(SwingConstants.CENTER);
					book3.setBackground(new Color(138, 203, 83));
					bookPanel.add(book3);
					buttons2.add(book3);
				}
			}
			if(i == 3) {
				if(library.get(i).getCopies() != 0){
					book4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					book4.setHorizontalAlignment(SwingConstants.CENTER);
					book4.setBackground(new Color(138, 203, 83));
					bookPanel.add(book4);
					buttons2.add(book4);
				}
			}
			if(i == 4) {
				if(library.get(i).getCopies() != 0){
					book5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					book5.setHorizontalAlignment(SwingConstants.CENTER);
					book5.setBackground(new Color(138, 203, 83));
					bookPanel.add(book5);
					buttons2.add(book5);
				}
			}
		}
		
		book1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				book = b1;
			}
		});
		
		book2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				book = b2;
			}
		});
		
		book3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				book = b3;
			}
		});
		
		book4.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				book = b4;
			}
		});
		
		book5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				book = b5;
			}
		});
		
		JButton rentButton = new JButton("Rent");
		rentButton.setBounds(235, 441, 271, 29);
		rentBook.add(rentButton);
		
		rentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(customer != null && book != null) {		//Depending on what the user chose
					customer.books.add(book);				//program will add the decided book to the 
					book.setCopies(book.getCopies()-1);		//decided customer's book list
				}
			}
		});
		
		
//=========================================================================================================================================================		
//=========================================================================================================================================================	
		
		//Displaying customers
		JPanel DisplayCustomers = new JPanel();
		DisplayCustomers.setBackground(new Color(112, 196, 57));
		tabbedPane.addTab("Display Customers", null, DisplayCustomers, null);
		DisplayCustomers.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 20, 717, 425);
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		DisplayCustomers.add(scrollPane_1);
		
		JTextArea displayOfCustomers = new JTextArea();
		scrollPane_1.setViewportView(displayOfCustomers);
		displayOfCustomers.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		displayOfCustomers.setEditable(false);
		displayOfCustomers.setBackground(new Color(112, 196, 56));
		for(Customer c : customers) {
			displayOfCustomers.append(c.toString() + "\n");
		}
			
//=========================================================================================================================================================
//=========================================================================================================================================================
		
		//Searching up a Customer
		JPanel SearchCustomer = new JPanel();
		SearchCustomer.setBackground(new Color(112, 196, 57));
		tabbedPane.addTab("Search Customer", null, SearchCustomer, null);
		SearchCustomer.setLayout(null);
		
		searchFirstName = new JTextField();
		searchFirstName.setBounds(138, 85, 210, 41);
		searchFirstName.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchFirstName.setColumns(10);
		SearchCustomer.add(searchFirstName);
		
		searchLastName = new JTextField();
		searchLastName.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchLastName.setColumns(10);
		searchLastName.setBounds(138, 214, 210, 41);
		SearchCustomer.add(searchLastName);
		
		searchEmail = new JTextField();
		searchEmail.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchEmail.setColumns(10);
		searchEmail.setBounds(500, 85, 210, 41);
		SearchCustomer.add(searchEmail);
		
		searchPhone = new JTextField();
		searchPhone.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchPhone.setColumns(10);
		searchPhone.setBounds(500, 214, 210, 41);
		SearchCustomer.add(searchPhone);
		
		searchAddress = new JTextField();
		searchAddress.setFont(new Font("Lantinghei TC", Font.PLAIN, 22));
		searchAddress.setColumns(10);
		searchAddress.setBounds(334, 325, 176, 36);
		SearchCustomer.add(searchAddress);
		
		JLabel lblFirstname = new JLabel("First Name:");
		lblFirstname.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		lblFirstname.setBounds(18, 95, 135, 21);
		SearchCustomer.add(lblFirstname);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		lblLastName.setBounds(18, 224, 135, 21);
		SearchCustomer.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		lblEmail.setBounds(433, 95, 74, 21);
		SearchCustomer.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone #:");
		lblPhone.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		lblPhone.setBounds(403, 224, 135, 21);
		SearchCustomer.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Lantinghei TC", Font.BOLD, 22));
		lblAddress.setBounds(234, 333, 135, 21);
		SearchCustomer.add(lblAddress);
		
		JButton searchByFirstName = new JButton("Search");
		searchByFirstName.setBackground(new Color(112, 196, 57));
		searchByFirstName.setBounds(183, 123, 111, 21);
		SearchCustomer.add(searchByFirstName);
		
		searchByFirstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchFirstName.getText().equals(""))) {				//First Checks if the text box is empty or not
					String firstNameInput = searchFirstName.getText();

					JScrollPane foundScroll = new JScrollPane();		   	//Creates a ScrollPane to output the results
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchCustomer.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Customer c : customers) {
						if(c.getFirstName().equals(firstNameInput)) {		//Outputs the results if there is a match
							found.append(c.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {			//deletes the scrollPane
						public void actionPerformed(ActionEvent e) {
							
							SearchCustomer.remove(foundScroll);
						}
					});
					searchFirstName.setText("");			//Makes the textbox empty again
				}
			}
		});
		
		JButton searchByLastName = new JButton("Search");
		searchByLastName.setBackground(new Color(112, 196, 57));
		searchByLastName.setBounds(183, 253, 111, 21);
		SearchCustomer.add(searchByLastName);
		
		searchByLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchLastName.getText().equals(""))) {
					String lastNameInput = searchLastName.getText();

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchCustomer.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Customer c : customers) {
						if(c.getLastName().equals(lastNameInput)) {
							found.append(c.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchCustomer.remove(foundScroll);
						}
					});
					searchLastName.setText("");
				}
				
			}
		});
		
		JButton searchByEmail = new JButton("Search");
		searchByEmail.setBackground(new Color(112, 196, 57));
		searchByEmail.setBounds(545, 123, 111, 21);
		SearchCustomer.add(searchByEmail);
		
		searchByEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchEmail.getText().equals(""))) {
					String emailInput = searchEmail.getText();

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchCustomer.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Customer c : customers) {
						if(c.getEmail().equals(emailInput)) {
							found.append(c.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchCustomer.remove(foundScroll);
						}
					});
					searchEmail.setText("");
				}
				
			}
		});
		
		JButton searchByPhone = new JButton("Search");
		searchByPhone.setBackground(new Color(112, 196, 57));
		searchByPhone.setBounds(545, 253, 111, 21);
		SearchCustomer.add(searchByPhone);
		
		searchByPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchPhone.getText().equals(""))) {
					String phoneInput = searchPhone.getText();

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchCustomer.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Customer c : customers) {
						if(c.getPhoneNum().equals(phoneInput)) {
							found.append(c.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchCustomer.remove(foundScroll);
						}
					});
					searchPhone.setText("");
				}
				
			}
		});
		
		JButton searchByAddress = new JButton("Search");
		searchByAddress.setBackground(new Color(112, 196, 57));
		searchByAddress.setBounds(369, 361, 111, 21);
		SearchCustomer.add(searchByAddress);
		
		searchByAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(searchAddress.getText().equals(""))) {
					String addressInput = searchAddress.getText();

					JScrollPane foundScroll = new JScrollPane();
					foundScroll.setBounds(18, 25, 720, 430);
					foundScroll.setBorder(BorderFactory.createEmptyBorder());
					SearchCustomer.add(foundScroll,0);
					
					JButton back = new JButton("Back");
					back.setBounds(605, 400, 111, 29);
					foundScroll.add(back,0);
					
					JTextArea found = new JTextArea();
					found.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
					found.setBackground(new Color(112, 196, 57));
					foundScroll.setViewportView(found);
					found.setEditable(false);
					
					for(Customer c : customers) {
						if(c.getAddress().equals(addressInput)) {
							found.append(c.toString());
						}
					}
					
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							SearchCustomer.remove(foundScroll);
						}
					});
					searchAddress.setText("");
				}
			}
		});		
		
//=========================================================================================================================================================
//=========================================================================================================================================================
		
		//Displaying Rented Books of each customer
		JPanel rentedBooks = new JPanel();
		rentedBooks.setBackground(new Color(112, 196, 57));
		tabbedPane.addTab("Display Rented Books", null, rentedBooks, null);
		rentedBooks.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 38, 717, 407);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		rentedBooks.add(scrollPane);
		
		JTextArea displayOfRentedBooks = new JTextArea();
		scrollPane.setViewportView(displayOfRentedBooks);
		displayOfRentedBooks.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		displayOfRentedBooks.setEditable(false);
		displayOfRentedBooks.setBackground(new Color(112, 196, 56));
		
		//Outputting default information
		for(Customer c : customers) {
			displayOfRentedBooks.append("Customer: " + c.getFirstName() + " " + c.getLastName() + "\n");
			if(c.books.size() > 0) {
				for(Book b : c.books) {
					displayOfRentedBooks.append("Title: " + b.getTitle() + " 	Author: " + b.getAuthor() + "\n\n");
				}
			} else {
				displayOfRentedBooks.append("None\n");
			}
			displayOfRentedBooks.append("\n");
			
		}
		JButton update_1 = new JButton("Update");
		update_1.setBounds(217, 6, 326, 29);
		rentedBooks.add(update_1);
		
		update_1.addActionListener(new ActionListener() {			//Updates the information whenever it is pressed
			
			public void actionPerformed(ActionEvent e) {
				displayOfRentedBooks.setText("");					//Makes the textArea empty
				for(Customer c : customers) {						//Re-appends the information
					displayOfRentedBooks.append("Customer: " + c.getFirstName() + " " + c.getLastName() + "\n");
					if(c.books.size() > 0) {
						for(Book b : c.books) {
							displayOfRentedBooks.append("Title: " + b.getTitle() + " 	Author: " + b.getAuthor() + "\n\n");
						}
					}
					else {
						displayOfRentedBooks.append("None\n");	
					}
					displayOfRentedBooks.append("\n");
				}
			}
		});
	
	}
}