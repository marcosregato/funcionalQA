package util;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class Robo {

    public void listInfo() {
        try {
            for (int x = 0; x <= 10; x++) {
                Thread.sleep(1000);
            }

            Robot robot = new Robot();
            robot.mouseMove(400, 650);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            // second click
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        } catch (Exception e) {
            System.out.println("Exception listInfo class ObjetoTela == > " + e.getMessage());
        }
    }

}
