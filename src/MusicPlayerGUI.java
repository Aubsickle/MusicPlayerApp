import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MusicPlayerGUI extends JFrame {

    public static final Color FRAME_COLOR = Color.BLUE;
    public static final Color TEXT_COLOR = Color.WHITE;

    public MusicPlayerGUI(){
        // calls JFrame constructor to configure GUI and set Title Header
        super("Music Player");

        //set the width and height
        setSize(400, 600);

        //end process when Application is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //launch Application in Center
        setLocationRelativeTo(null);

        //prevent default layout and resizing
        setResizable(false);
        setLayout(null);

        //change colors
        getContentPane().setBackground(FRAME_COLOR);


        addGuiComponents();

    }

    private void addGuiComponents(){

        addToolbar();

        //load album img
        JLabel songImage = new JLabel(loadImage("src/assets/record.png"));
        songImage.setBounds(0, 50, getWidth() - 20, 225);
        add(songImage);

        //show song title
        JLabel songTitle = new JLabel("Song Title");
        songTitle.setBounds(0, 285, getWidth() - 10, 30);
        songTitle.setFont(new Font("Arial", Font.BOLD, 22));
        songTitle.setForeground(TEXT_COLOR);
        songTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(songTitle);

        //show song artist
        JLabel songArtist = new JLabel("Artist");
        songArtist.setBounds(0, 315, getWidth() - 10, 30);
        songArtist.setFont(new Font("Arial", Font.BOLD, 18));
        songArtist.setForeground(TEXT_COLOR);
        songArtist.setHorizontalAlignment(SwingConstants.CENTER);
        add(songArtist);

        //show playback slider
        JSlider playbackSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        playbackSlider.setBounds(getWidth()/2 - 300/2, 365, 300, 40);
        playbackSlider.setBackground(null);
        add(playbackSlider);

    }

    private void addToolbar(){
        JToolBar toolbar = new JToolBar();
        toolbar.setBounds(0, 0, getWidth(), 20);

        toolbar.setFloatable(false);

        //add drop down menu
        JMenuBar menuBar = new JMenuBar();
        toolbar.add(menuBar);

        //add song button
        JMenu songMenu = new JMenu("Song");
        menuBar.add(songMenu);

        //add select song button in song drop down
        JMenuItem loadSong = new JMenuItem("Load Song");
        songMenu.add(loadSong);

        //add playlist button
        JMenuItem playlistMenu = new JMenu("Playlist");
        menuBar.add(playlistMenu);


        //create and load playlist buttons in playlist dropdown
        JMenuItem createPlaylist = new JMenuItem("Create Playlist");
        playlistMenu.add(createPlaylist);

        JMenuItem loadPlaylist = new JMenuItem("Load Playlist");
        playlistMenu.add(loadPlaylist);


        add(toolbar);
    }

    private ImageIcon loadImage(String imagePath){
        try{
            //read the image file
            BufferedImage image = ImageIO.read(new File(imagePath));

            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //if cant find img
        return null;
    }

}