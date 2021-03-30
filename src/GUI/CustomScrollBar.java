package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

/**
 * This class provides custom scroll bar for better UI.
 * @author Aryan
 * @version 1.0
 */
public class CustomScrollBar {
    /**
     * This method gets component as parameter.
     * @param cmp
     * @return JScrollPane
     */
    public JScrollPane makeUI(Component cmp) {
        cmp.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(
                cmp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setComponentZOrder(scrollPane.getVerticalScrollBar(), 0);
        scrollPane.setComponentZOrder(scrollPane.getViewport(), 1);
        scrollPane.getVerticalScrollBar().setOpaque(false);

        scrollPane.setLayout(new ScrollPaneLayout() {
            /**
             * provides the lay out of the scroll panel.
             * @param parent
             */
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollPane = (JScrollPane)parent;

                Rectangle availR = scrollPane.getBounds();
                availR.x = availR.y = 0;

                Insets insets = parent.getInsets();
                availR.x = insets.left;
                availR.y = insets.top;
                availR.width  -= insets.left + insets.right;
                availR.height -= insets.top  + insets.bottom;

                Rectangle vsbR = new Rectangle();
                vsbR.width  = 12;
                vsbR.height = availR.height;
                vsbR.x = availR.x + availR.width - vsbR.width;
                vsbR.y = availR.y;

                if(viewport != null) {
                    viewport.setBounds(availR);
                }
                if(vsb != null) {
                    vsb.setVisible(true);
                    vsb.setBounds(vsbR);
                }
            }
        });
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            private final Dimension d = new Dimension();
            @Override protected JButton createDecreaseButton(int orientation) {
                return new JButton() {
                    @Override public Dimension getPreferredSize() {
                        return d;
                    }
                };
            }
            @Override protected JButton createIncreaseButton(int orientation) {
                return new JButton() {
                    @Override public Dimension getPreferredSize() {
                        return d;
                    }
                };
            }
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {}
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                Color color = null;
                JScrollBar sb = (JScrollBar)c;
                if(!sb.isEnabled() || r.width>r.height) {
                    return;
                }else if(isDragging) {
                    color = new Color(169, 169, 169);
                }else if(isThumbRollover()) {
                    color = Color.WHITE;
                }else {
                    color = Color.GRAY;
                }
                g2.setPaint(color);
                g2.fillRoundRect(r.x,r.y,r.width,r.height,10,10);
                g2.setPaint(Color.WHITE);
                g2.drawRoundRect(r.x,r.y,r.width,r.height,10,10);
                g2.dispose();
            }
            @Override
            protected void setThumbBounds(int x, int y, int width, int height) {
                super.setThumbBounds(x, y, width, height);
                scrollbar.repaint();
            }
        });
        return scrollPane;
    }

    /**
     * this method makes a scroll panel.
     * @param component
     * @return JScrollPane
     */
    public static JScrollPane createScrollPanel(Component component) {
        JScrollPane cmp;
        cmp = new CustomScrollBar().makeUI(component);
        return cmp;
    }
}