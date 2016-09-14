/*
 * Decompiled with CFR 0_115.
 */
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TitlesFrame
extends JFrame {
    public TitlesFrame() {
        this.initUI();
    }

    private void initUI() {
        this.setTitle("\u041a\u0440\u0438\u0432\u044b\u0435 \u0444\u0438\u0433\u0443\u0440\u044b");
        this.setDefaultCloseOperation(3);
// when creating TitlesPanel set the parameters for the job according to the embodiment
        this.add(new TitlesPanel(34));
// sets the size of the form
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);
            }
        });
    }

}

