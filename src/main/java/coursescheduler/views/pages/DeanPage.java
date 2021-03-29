package coursescheduler.views.pages;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

/**
 * TODO: Javadoc.
 */
public class DeanPage extends JTabbedPane implements RolePage {
    DeanPage() {
        super();
        init();
    }

    @Override
    public void init() {
        // TODO: SubPage One.
        JPanel viewScheduleSubPage = new JPanel(false);
        JLabel filler = new JLabel("Page one goes here.");
        filler.setHorizontalAlignment(JLabel.CENTER);
        viewScheduleSubPage.setLayout(new GridLayout(1, 1));
        viewScheduleSubPage.add(filler);
        addTab("Tab 1", null, viewScheduleSubPage,"Tab 1 tooltip");
        setMnemonicAt(0, KeyEvent.VK_1);

        // TODO: SubPage Two.
        JPanel addCourseSubPage = new JPanel(false);
        JLabel filler2 = new JLabel("Page two goes here.");
        filler2.setHorizontalAlignment(JLabel.CENTER);
        addCourseSubPage.setLayout(new GridLayout(1, 1));
        addCourseSubPage.add(filler2);
        addTab("Tab 2", null, addCourseSubPage,"Tab 2 tooltip");
        setMnemonicAt(0, KeyEvent.VK_2);

        // TODO: SubPage Three.
        JPanel preliminaryCourseEnrollmentSubPage = new JPanel(false);
        JLabel filler3 = new JLabel("Page three goes here.");
        filler2.setHorizontalAlignment(JLabel.CENTER);
        preliminaryCourseEnrollmentSubPage.setLayout(new GridLayout(1, 1));
        preliminaryCourseEnrollmentSubPage.add(filler2);
        addTab("Tab 3", null, addCourseSubPage,"Tab 3 tooltip");
        setMnemonicAt(0, KeyEvent.VK_2);
    }
}
