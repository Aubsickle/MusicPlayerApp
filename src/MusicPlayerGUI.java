import javax.swing.*;

public class MusicPlayerGUI extends JFrame {
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

        addGuiComponents();

    }

    private void addGuiComponents(){
        addToolbar();
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

}