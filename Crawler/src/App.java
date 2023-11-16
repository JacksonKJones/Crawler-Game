import javax.swing.*;

class App {

    private static void initWindow() {
        // create a window frame and set the title in the toolbar
        JFrame window = new JFrame("Crawl, SURVIVE");
        // when the window is closed, stop the application
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a the jpanel to draw on and initialize the game loop
        Dungeon dungeon = new Dungeon();
        // add the jpanel to the window
        window.add(dungeon);
        // passes keyboard inputs to jpanel
        window.addKeyListener(dungeon);

        // prevents user from resizing the window
        window.setResizable(false);
        // fit the window size around the components
        window.pack();
        // open window in the center of the screen
        window.setLocationRelativeTo(null);
        // display the window
        window.setVisible(true);

    }

    public static void main(String[] args) {
        // When main runs it will call initWindow() once and invokeLater() will prevent graphics processing from blocking GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initWindow();
            }
        });
    }
}