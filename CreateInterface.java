import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.awt.event.*;

public class CreateInterface extends JFrame {

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    static FileNameExtensionFilter jpgFilter;
    static FileNameExtensionFilter imageFilter;

    static BufferedImage newPhoto;
    static BufferedImage newPhoto2;

    static String imagePathForFinishedButton;

    static BufferedImage finishedButtonImageTemp;

    static BufferedImage completeBufferedImageTemp;

    static BufferedImage pieceButtonImageTemp;

    static String imagePathForPieceButton;

    static JLabel completedShownLocationLabel2;

    private javax.swing.JButton completedFindButton;
    private javax.swing.JButton completedInfoButton;
    private javax.swing.JLabel completedShownLocationLabel;
    private javax.swing.JLabel finishedImagePreviewLabel;
    private javax.swing.JButton finishedInfoButton;
    private javax.swing.JLabel finishedNameOfPuzzleLabel;
    private javax.swing.JLabel finishedTitleLabel;
    private javax.swing.JButton finishedUploadButton;
    private javax.swing.JButton finishedViewImageButton;
    private javax.swing.JSeparator horizontalSeperator;
    private javax.swing.JLabel locationTitleLabel;
    private javax.swing.JMenu fileMenuInBar;
    private javax.swing.JMenu helpMenuInBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField nameOfPuzzleTextField;
    private javax.swing.JLabel pieceImagePreviewLabel;
    private javax.swing.JButton pieceInfoButton;
    private javax.swing.JLabel pieceNameOfPieceLabel;
    private javax.swing.JLabel pieceTitleLabel;
    private javax.swing.JButton pieceUploadButton;
    private javax.swing.JButton pieceViewImageButton;
    private javax.swing.JButton saveFinishedNameButton;
    private javax.swing.JButton savePieceNameButton;
    private javax.swing.JSeparator verticalSeperator;

    private JMenuItem fileOpenOption;
    private JMenuItem helpOption;

    private JButton completedFullSizeButton;

    static Color nimbusBase;
    static Color nimbusBlueGrey;
    static Color control;

    static int newPhotoWidth;
    static int newPhotoHeight;

    static int xCoord;
    static int yCoord;

    static int xCoord2;
    static int yCoord2;

    static int pieceWidth;
    static int pieceHeight;

    
    static ArrayList<Integer> xCoordsArrayList = new ArrayList<Integer>();
    static ArrayList<Integer> yCoordsArrayList = new ArrayList<Integer>();

    //Constructor method 
    public CreateInterface() throws IOException {
        initComponents();
    }


    private void initComponents() throws IOException {

        finishedTitleLabel = new javax.swing.JLabel();
        pieceTitleLabel = new javax.swing.JLabel();
        finishedUploadButton = new javax.swing.JButton();
        finishedInfoButton = new javax.swing.JButton();

        finishedImagePreviewLabel = new javax.swing.JLabel();

        finishedNameOfPuzzleLabel = new javax.swing.JLabel();
        nameOfPuzzleTextField = new javax.swing.JTextField();
        saveFinishedNameButton = new javax.swing.JButton();
        horizontalSeperator = new javax.swing.JSeparator();
        verticalSeperator = new javax.swing.JSeparator();
        finishedViewImageButton = new javax.swing.JButton();
        locationTitleLabel = new javax.swing.JLabel();
        completedFindButton = new javax.swing.JButton();
        completedInfoButton = new javax.swing.JButton();
        pieceUploadButton = new javax.swing.JButton();
        pieceInfoButton = new javax.swing.JButton();
        pieceNameOfPieceLabel = new javax.swing.JLabel();
        savePieceNameButton = new javax.swing.JButton();
        completedFullSizeButton = new javax.swing.JButton();

        pieceImagePreviewLabel = new javax.swing.JLabel();

        pieceViewImageButton = new javax.swing.JButton();
        completedShownLocationLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenuInBar = new javax.swing.JMenu();
        helpMenuInBar = new javax.swing.JMenu();
        fileOpenOption = new javax.swing.JMenuItem();
        helpOption = new javax.swing.JMenuItem();

        completedShownLocationLabel2 = new JLabel();

        

        // setting the window to close upon pressing 'x', make the screen match the monitor size and set the title for the window
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setTitle("Jigsaw Helper");
        setMinimumSize(screenSize);

        // setting the styling for the finishedTitleLabel
        finishedTitleLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24));
        finishedTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finishedTitleLabel.setText("The Finished Puzzle");
        finishedTitleLabel.setBackground(Color.GREEN);
        finishedTitleLabel.setForeground(new Color(255, 255, 255));

        // setting the styling for the pieceTitleLabel
        pieceTitleLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); 
        pieceTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pieceTitleLabel.setText("The Individual Piece");
        pieceTitleLabel.setForeground(new Color(255, 255, 255));

        // setting the styling for the finishedUploadButton
        finishedUploadButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14)); 
        finishedUploadButton.setText("Upload");
        finishedUploadButton.addActionListener(new java.awt.event.ActionListener() {

            // actionPerformed method to give finishedUploadButton its function
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                //using the getFile method to aquire the file path from the user
                String imagePath = getFile();

                // try/catch clause to attempt to retrieve file using path
                try {
                    newPhoto = ImageIO.read(new File(imagePath));

                    // setting the size of the image fit in the display label based on its relative size
                    if ((newPhoto.getWidth() > 1200) && (newPhoto.getHeight() > 1200)) {
                        newPhotoWidth = newPhoto.getWidth() / 4;
                        newPhotoHeight = newPhoto.getHeight() / 4;
                    } else {
                        newPhotoWidth = newPhoto.getWidth() / 2;
                        newPhotoHeight = newPhoto.getHeight() / 2;
                    }
                    ImageIcon lol = new ImageIcon(resizeImage(newPhoto, 150, 150));
                    finishedImagePreviewLabel.setIcon(lol);
                    imagePathForFinishedButton = imagePath;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // setting the styling for the finishedInfoButton
        finishedInfoButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14));
        finishedInfoButton.setText("Information");
        finishedInfoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override

            // actionPerformed method to give finishedInfoButton its function
            public void actionPerformed(ActionEvent e) {
                JFrame finishedInfoPane = new JFrame();
                JOptionPane.showMessageDialog(finishedInfoPane,
                        "Click on the 'Upload' button to upload a new jigsaw you need some help with!" + "\n"
                                + "Images must be no bigger than 1200x1200" + "\n"
                                + "Click on the 'Click Here' button to see the piece you have uploaded in its full size!",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // setting the styling for the finishedNameOfPuzzleLabel
        finishedNameOfPuzzleLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14));
        finishedNameOfPuzzleLabel.setText("Name This Puzzle:");

        // setting the styling for the nameOfPuzzleTextField
        nameOfPuzzleTextField.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14));

        // setting the styling for the saveFinishedNameButton
        saveFinishedNameButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14)); 
        saveFinishedNameButton.setText("Save");
        
        // setting orientation for the verticalSeperator
        verticalSeperator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        // setting the styling for the finishedViewImageButton
        finishedViewImageButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 12)); 
        finishedViewImageButton.setText("Click Here To See Full Size Image");
        finishedViewImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                // creating new JFrame for image
                JFrame preview1 = new JFrame();

                // try/catch clause to attempt to retieve file and add into a new frame 
                try {
                    finishedButtonImageTemp = ImageIO.read(new File(imagePathForFinishedButton));

                    ImageIcon lol3 = new ImageIcon(finishedButtonImageTemp);

                    JLabel label1 = new JLabel(lol3);                          

                    preview1.getContentPane().add(label1);
                    preview1.setSize(1200, 1200);
                    preview1.setVisible(true);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // setting the styling for the locationTitleLabel
        locationTitleLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24));
        locationTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        locationTitleLabel.setText("The Location!!!");
        locationTitleLabel.setForeground(new Color(255, 255, 255));

        // setting the styling for the completedFindButton
        completedFindButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14));
        completedFindButton.setText("Find Piece");
        // THIS MIGHT BE WHERE THE INTERFACE AND THE ALGORITHIM LINK
        completedFindButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(imagePathForFinishedButton);
                System.out.println(imagePathForPieceButton);

                try {
                    LinkedHashMap<int[], Double> sortedMap = LocationAlgorithm.launch(imagePathForFinishedButton, imagePathForPieceButton);
                    int[] positionOfPiece  = (int[]) sortedMap.keySet().toArray()[0];                    
                    System.out.println("x: " + positionOfPiece [0]);
                    System.out.println("y: " + positionOfPiece [1]);
                    System.out.println(sortedMap.get(positionOfPiece));

                    // most likely position
                    xCoord = positionOfPiece [0];
                    yCoord = positionOfPiece [1];

                    // putting the locations and scores for x into arrayList
                    sortedMap.keySet().forEach(key -> {
                        xCoordsArrayList.add(key[0]);
                    });
            
                    // putting the locations and scores for y into arrayList
                    sortedMap.keySet().forEach(key -> {
                        yCoordsArrayList.add(key[1]);
                    });
                                 
                       
                    // System.out.println(xCoordsArrayList);
                    // System.out.println(yCoordsArrayList);

                    double sum = 0;
                    double sum2 = 0;
                    
                    if (sortedMap.size() <10) {
                        for (int i = 0; i < sortedMap.size(); i++) {
                            sum += xCoordsArrayList.get(i);
                        }
                        sum = sum/sortedMap.size();
                            
                        for (int i = 0; i < sortedMap.size(); i++) {
                            sum2 += yCoordsArrayList.get(i);
                        }
                        sum2 = sum2/sortedMap.size();
    
                        // Coordiantes of mean of top locations 
                        xCoord2 = (int) sum;
                        yCoord2 = (int) sum2;

                    } else {
                        for (int i = 0; i < 10; i++) {
                            sum += xCoordsArrayList.get(i);
                        }
                        sum = sum/10;
                            
                        for (int i = 0; i < 10; i++) {
                            sum2 += yCoordsArrayList.get(i);
                        }
                        sum2 = sum2/10;
    
                        // Coordiantes of mean of top 10 locations
                        xCoord2 = (int) sum;
                        yCoord2 = (int) sum2;
                        
                    }


                    System.out.println(xCoord2);
                    System.out.println(yCoord2);


                    ImageIcon completedImageDisplayed = new ImageIcon(newPhoto);
                    completedShownLocationLabel.setIcon(completedImageDisplayed);

                    // showing the correct part of the finished image where box is drawn
                    if (yCoord <= 400) {
                        completedShownLocationLabel.setVerticalAlignment(JLabel.TOP);
                    } else if (yCoord > 400 && yCoord <= 800) {
                        completedShownLocationLabel.setVerticalAlignment(JLabel.CENTER);
                    } else {
                        completedShownLocationLabel.setVerticalAlignment(JLabel.BOTTOM);
                    }

                    drawLocationRed(newPhoto, xCoord, yCoord, pieceWidth, pieceHeight);
                    // drawLocationGreen(newPhoto, 340, 295, 292, 268); // TEST 1
                    // drawLocationGreen(newPhoto, 1, 550, 273, 230);  // TEST 2
                    // drawLocationGreen(newPhoto, 80, 255, 221, 214);  // TEST 3
                    //drawLocationGreen(newPhoto, 825, 2, 190, 150);  // TEST 4
                    // drawLocationGreen(newPhoto, 825, 2, 190, 150);  // TEST 5 FORCED NO EDGE 
                    // drawLocationGreen(newPhoto, 585, 185, 237, 205);  // TEST 6 
                    //drawLocationGreen(newPhoto, 525, 105, 126, 109); // TEST 7  
                    // drawLocationGreen(newPhoto, 300, 405, 244, 248); // TEST 8
                    // drawLocationGreen(newPhoto, 275, 20, 236, 193); // TEST 9
                    // drawLocationGreen(newPhoto, 275, 20, 236, 193); // TEST 10 FORCED NO EDGE
                    // drawLocationGreen(newPhoto, 218, 150, 286, 303); // TEST 11
                    // drawLocationGreen(newPhoto, 0, 530, 188, 174); // TEST 12
                    // drawLocationGreen(newPhoto, 135, 330, 330, 385); // TEST 13
                    //drawLocationGreen(newPhoto, 535, 380, 260, 210); // TEST 14
                
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // setting the styling for the completedFullSizeButton
        completedFullSizeButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14));
        completedFullSizeButton.setText("Click Here To See All Possible Locations");
        completedFullSizeButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent evt) {

                // new frame to host the image
                JFrame preview2 = new JFrame();
                
                // try/catch clause to attempt to retieve file and add into a new frame 
                try {
                    completeBufferedImageTemp = ImageIO.read(new File(imagePathForFinishedButton));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ImageIcon lol4 = new ImageIcon(completeBufferedImageTemp);
                JLabel label2 = new JLabel(lol4);
                // panel2.add(label2);
                preview2.getContentPane().add(label2);
                preview2.setSize(1200, 1200);
                preview2.setVisible(true);

                
                drawLocationRed(completeBufferedImageTemp, xCoord, yCoord, pieceWidth, pieceHeight);
                drawLocationBlue(completeBufferedImageTemp, xCoord2, yCoord2, pieceWidth, pieceHeight);
                //drawLocationGreen(completeBufferedImageTemp, 340, 295, 292, 268); // TEST 1
                //drawLocationGreen(completeBufferedImageTemp, 1, 550, 273, 230);  // TEST 2                
                //drawLocationGreen(completeBufferedImageTemp, 80, 255, 221, 214);  // TEST 3
                //drawLocationGreen(completeBufferedImageTemp, 825, 2, 190, 150);  // TEST 4
                //drawLocationGreen(completeBufferedImageTemp, 825, 2, 190, 150);  // TEST 4 FORCED NO EDGE
                //drawLocationGreen(completeBufferedImageTemp, 585, 185, 237, 205);  // TEST 6
                //drawLocationGreen(completeBufferedImageTemp, 525, 105, 126, 109); // TEST 7 
                //drawLocationGreen(completeBufferedImageTemp, 300, 405, 244, 248); // TEST 8
                //drawLocationGreen(completeBufferedImageTemp, 275, 20, 236, 193); // TEST 9
                //drawLocationGreen(completeBufferedImageTemp, 275, 20, 236, 193); // TEST 10 FORCED EDGE 
                //drawLocationGreen(completeBufferedImageTemp, 218, 150, 286, 303); // TEST 11
                //drawLocationGreen(completeBufferedImageTemp, 0, 530, 188, 174); // TEST 12
                //drawLocationGreen(completeBufferedImageTemp, 135, 330, 330, 385); // TEST 13
                //drawLocationGreen(completeBufferedImageTemp, 535, 380, 260, 210); // TEST 14
            }

        });

        // setting the styling for the completedInfoButton
        completedInfoButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14));
        completedInfoButton.setText("Information");
        completedInfoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override

            // actionPerformed method to give completedInfoButton its function
            public void actionPerformed(ActionEvent e) {
                JFrame completedInfoPane = new JFrame();
                JOptionPane.showMessageDialog(completedInfoPane,
                        "Click on the 'Find Piece' button to find the location of the piece currently loaded!" + "\n"
                                + "Interface shows most likely location" + "\n"
                                + "Click on 'Possible Locations' button to see all locations the piece may be! ",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // setting the styling for the pieceUploadButton
        pieceUploadButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14));
        pieceUploadButton.setText("Upload");
        pieceUploadButton.addActionListener(new java.awt.event.ActionListener() {

            // actionPerformed method to give pieceUploadButton its function
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //using the getFile method to aquire the file path from the user
                String imagePath = getFile();

                // try/catch clause to attempt to retrieve file using path and fitting image in the display label
                try {
                    newPhoto2 = ImageIO.read(new File(imagePath));
                    pieceWidth = newPhoto2.getWidth();
                    pieceHeight = newPhoto2.getHeight();
                    ImageIcon lol2 = new ImageIcon(newPhoto2);
                    pieceImagePreviewLabel.setIcon(lol2);
                    imagePathForPieceButton = imagePath;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // setting the styling for the pieceInfoButton
        pieceInfoButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 14));
        pieceInfoButton.setText("Information");
        pieceInfoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pieceInfoPane = new JFrame();
                JOptionPane.showMessageDialog(pieceInfoPane,
                        "Click on the 'Upload' button to upload a new piece you want to find!" + "\n"
                                + "Click on the 'Click Here' button to see the piece you have uploaded in its full size!",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // setting the styling for the pieceNameOfPieceLabel
        pieceNameOfPieceLabel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14));
        pieceNameOfPieceLabel.setText("Name This Piece:");

        
        // setting the styling for the savePieceNameButton
        savePieceNameButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); 
        savePieceNameButton.setText("Save");

        // setting the styling for the pieceViewImageButton
        pieceViewImageButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", Font.BOLD, 12));
        pieceViewImageButton.setText("Click Here To See Full Size Image");
        pieceViewImageButton.addActionListener(new java.awt.event.ActionListener() {

            // actionPerformed method to give pieceViewImageButton its function
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFrame preview2 = new JFrame();

                // try/catch clause to attempt to retrieve file using path and fitting image in the new frame
                try {
                    pieceButtonImageTemp = ImageIO.read(new File(imagePathForPieceButton));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    resizeImage(pieceButtonImageTemp, 1000, 1000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JLabel label1 = new JLabel(new ImageIcon(pieceButtonImageTemp));
                preview2.getContentPane().add(label1);
                preview2.setSize(1000, 1000);
                preview2.setVisible(true);

            }
        });

        // setting the text for the File option and adding to the JMenu
        fileMenuInBar.setText("File");
        jMenuBar1.add(fileMenuInBar);
        fileOpenOption.setText("Open New Window");
        fileMenuInBar.add(fileOpenOption);

        // setting functionality of open option in the menu
        fileOpenOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {

                    //the method used to create a new interface instance
                    public void run() {
                        try {
                            new CreateInterface().setVisible(true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        // setting the text for the Help option and adding to the JMenu
        helpMenuInBar.setText("Help");
        jMenuBar1.add(helpMenuInBar);
        helpOption.setText("Click On The 'New' Option In The Menu Bar To Open Another Window!");
        helpMenuInBar.add(helpOption);

        // adding JMenu to frame
        setJMenuBar(jMenuBar1);

        // creating a new GroupLayout and putting each of the components in the correct place
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(finishedUploadButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(finishedInfoButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(116, 116, 116))
                                        .addComponent(finishedTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 920,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(finishedImagePreviewLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(142, 142, 142)
                                                        .addComponent(finishedViewImageButton)
                                                        .addGap(219, 219, 219)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(verticalSeperator, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(274, 274, 274)
                                                                .addComponent(pieceImagePreviewLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(151, 151, 151)
                                                                .addComponent(pieceUploadButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(144, 144, 144)
                                                                .addComponent(pieceViewImageButton)
                                                                .addGap(266, 266, 266))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pieceInfoButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(174, 174, 174))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(pieceTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        855, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .addComponent(horizontalSeperator, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(514, 514, 514)
                                                .addComponent(completedFindButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(116, 116, 116)
                                                .addComponent(completedFullSizeButton)
                                                .addGap(127, 127, 127)
                                                .addComponent(completedInfoButton,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(locationTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1845,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(357, 357, 357)
                                                .addComponent(completedShownLocationLabel,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 1200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] { finishedUploadButton, pieceUploadButton });

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(finishedTitleLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(finishedUploadButton)
                                                                        .addComponent(finishedInfoButton))
                                                                .addGap(35, 35, 35)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(finishedImagePreviewLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                100,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(finishedViewImageButton)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(pieceTitleLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(pieceInfoButton)
                                                                        .addComponent(pieceUploadButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(pieceImagePreviewLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                100,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(pieceViewImageButton))))
                                                .addGap(32, 32, 32)
                                                .addComponent(horizontalSeperator,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(verticalSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 253,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(completedInfoButton)
                                        .addComponent(completedFindButton)
                                        .addComponent(completedFullSizeButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(completedShownLocationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        layout.linkSize(javax.swing.SwingConstants.VERTICAL,
                new java.awt.Component[] { finishedUploadButton, pieceUploadButton });

        pack();
    }

    public static String getFile() {
        // default string for image path is empty so it can be later changed to the user's choice
        String imagePath = " ";

        // only allowing png files to be selected
        jpgFilter = new FileNameExtensionFilter("png files (*.png)", "png");
        imageFilter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());

        // selecting file and retrieving file path
        final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
        fc.setCurrentDirectory(new File("C:/Users/danie/Pictures"));
        fc.setFileFilter(jpgFilter);
        fc.setDialogTitle("Upload Photo of Finished Jigsaw");
        fc.addChoosableFileFilter(imageFilter);
        fc.setAcceptAllFileFilterUsed(false);
        int returnValue = fc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath();
        }
        ;

        // final string of image's path for use in new file methods
        return imagePath;
    }

    // method to resize a given BufferedImage
    public static BufferedImage resizeImage(BufferedImage image, int width, int height) throws IOException {
        // creates a scaled version of the BufferedImage to the desired size
        Image newResizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        
        // invoking method to make Image a BufferedImage
        BufferedImage bufferedImageReturned = convertToBufferedImage(newResizedImage);

        // returns Image
        return bufferedImageReturned;
    }

    // method to change a normal Image into a BufferedImage
    public static BufferedImage convertToBufferedImage(Image image) {
        // new BufferedImage of standard
        BufferedImage bufferedImageNew = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // creating the BufferedImage out of the normal Image supplied to the method
        Graphics2D graphics2d = bufferedImageNew.createGraphics();
        graphics2d.drawImage(image, 0, 0, null);
        graphics2d.dispose();

        // the returned BufferedImage
        return bufferedImageNew;
    }

    // method to draw red square around piece location
    public static void drawLocationRed(BufferedImage imageDrawnOn, int xCoord, int yCoord, int width, int height) {

        // creating Graphics2D object to draw on the square of location
        Graphics2D g2d = imageDrawnOn.createGraphics();

        // setting drawn position box to red 
        g2d.setColor(Color.RED);

        // drawing at the x and y coordinates the algorithm has determined and been fed into method
        g2d.drawRect(xCoord, yCoord, width, height);
        g2d.dispose();
    }

    // method to draw blue square around piece location
    public static void drawLocationBlue(BufferedImage imageDrawnOn, int xCoord, int yCoord, int width, int height) {

        // creating Graphics2D object to draw on the square of location
        Graphics2D g2d = imageDrawnOn.createGraphics();

        // setting drawn position box to blue 
        g2d.setColor(Color.BLUE);

        // drawing at the x and y coordinates the algorithm has determined and been fed into method
        g2d.drawRect(xCoord, yCoord, width, height);
        g2d.dispose();
    }

    public static void drawLocationGreen(BufferedImage imageDrawnOn, int xCoord, int yCoord, int width, int height) {

        // creating Graphics2D object to draw on the square of location
        Graphics2D g2d = imageDrawnOn.createGraphics();

        // setting drawn position box to blue 
        g2d.setColor(Color.GREEN);

        // drawing at the x and y coordinates the algorithm has determined and been fed into method
        g2d.drawRect(xCoord, yCoord, width, height);
        g2d.dispose();
    }

    public static void main(String[] args) {

        //creating colours for the interface appearance 
        UIManager.put("nimbusBase", new Color(00, 00, 00));
        UIManager.put("nimbusBlueGrey", new Color(102, 225, 255));
        UIManager.put("control", new Color(16, 16, 16));
        UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));

        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        //running the application by invoking the constructor
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CreateInterface().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
