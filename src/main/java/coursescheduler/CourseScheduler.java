package coursescheduler;

import static java.lang.Thread.sleep;
import com.google.common.collect.ImmutableList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;

/**
 * Entry-point for Course Scheduler desktop application.
 */
final class CourseScheduler {
    public static void main(String[] args) {
        // Panels
        JPanel pOne = panel("pOne", Color.red);
        JPanel pTwo = panel("pTwo", Color.orange);
        JPanel pThree = panel("pThree", Color.green);
        JPanel pFour = panel("pFour", Color.darkGray);

        // Main frame setup
        JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());
        frame.setSize(new Dimension(1000, 1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        int seconds = 3;
        int cycles = 3;

        frame.setVisible(true);
        pOne.setVisible(true);
        PanelController<JPanel> pageController = new BaseFrameManager(frame);

        ImmutableList<JPanel> pages = ImmutableList.of(pOne, pTwo, pThree, pFour).asList();
        // demo
        while (cycles-- > 0) {
            for (JPanel page : pages) {
                pageController.updatePage(page);
                delay(seconds);
            }
        }
    }

    private static void delay(int seconds) {
        try {
            sleep(1000 * seconds); // Sleep to be able to see page switch.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static JPanel panel(String labelName, Color color) {
        JPanel panel = new JPanel(new CardLayout());
        panel.setSize(new Dimension(1000, 1000));
        Label label = new Label(labelName);
        panel.add(label);
        panel.setBackground(color);
        return panel;
    }
}
