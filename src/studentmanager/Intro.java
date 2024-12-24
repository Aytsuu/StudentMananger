// This file creates the intro of the student manager project

package studentmanager;
import java.awt.*;
import java.util.*;


public class Intro extends javax.swing.JFrame{
    
    public Intro(){
        initComponents();
        setBackground(new Color(0,0,0,0)); // Sets frame opacity to 0
        setLocationRelativeTo(null); // Sets the frame location to center
        
        // Hides the labels when this file is executed
        s.setVisible(false); 
        t.setVisible(false); 
        u.setVisible(false); 
        d.setVisible(false); 
        e.setVisible(false);
        n.setVisible(false);
        t1.setVisible(false);
        managerText.setVisible(false);
        line.setVisible(false);
	        
        animateIn(); // Calling the method animateIn
        animateOut(); // Calling the method animateOut
    } 
    
    // This method creates the entry effect of each labels
    public void animateIn(){      
        Timer timer = new Timer(); // Instantiating predefined class Timer
        
        // Using the predefined method schedule to set a delay (in milliseconds) in the execution of a block of code
        timer.schedule(new TimerTask(){    
            public void run(){ 
                s.setVisible(true);
            }
        }, 500);
        timer.schedule(new TimerTask(){      
            public void run(){
                t.setVisible(true);
            }
        }, 600);
        timer.schedule(new TimerTask(){      
            public void run(){
                u.setVisible(true);
            }
        }, 700);
        timer.schedule(new TimerTask(){      
            public void run(){
                d.setVisible(true);
            }
        }, 800);
        timer.schedule(new TimerTask(){      
            public void run(){
                e.setVisible(true);
            }
        }, 900);
        timer.schedule(new TimerTask(){      
            public void run(){
                n.setVisible(true);
            }
        }, 1000);
        timer.schedule(new TimerTask(){      
            public void run(){
                t1.setVisible(true);
            }
        }, 1200);
        timer.schedule(new TimerTask(){      
            public void run(){
                managerText.setVisible(true);
            }
        }, 1400);
        timer.schedule(new TimerTask(){      
            public void run(){
                line.setVisible(true);
            }
        }, 1600);
    }
    
    // This method creates the exit effect of each labels
    public void animateOut(){   
        Timer timer = new Timer(); // Instantiating predefined class Timer
        
        // Using the predefined method schedule to set a delay (in milliseconds) in the execution of a block of code
        timer.schedule(new TimerTask(){      
            public void run(){
                line.setVisible(false);
            }
        }, 2500);
        timer.schedule(new TimerTask(){      
            public void run(){
                managerText.setVisible(false);
            }
        }, 2700);
        timer.schedule(new TimerTask(){      
            public void run(){
                t1.setVisible(false);
            }
        }, 2900);
        timer.schedule(new TimerTask(){      
            public void run(){
                n.setVisible(false);
            }
        }, 3000);
        timer.schedule(new TimerTask(){      
            public void run(){
                e.setVisible(false);
            }
        }, 3100);
        timer.schedule(new TimerTask(){      
            public void run(){
                d.setVisible(false);
            }
        }, 3200);
        timer.schedule(new TimerTask(){      
            public void run(){
                u.setVisible(false);
            }
        }, 3300);
        timer.schedule(new TimerTask(){      
            public void run(){
                t.setVisible(false);
            }
        }, 3400);
        timer.schedule(new TimerTask(){      
            public void run(){
                s.setVisible(false);
            }
        }, 3500);
        timer.schedule(new TimerTask(){      
            public void run(){
                new Frame().setVisible(true);
                setVisible(false);    
            }
        }, 3500);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new studentmanager.Panel();
        managerText = new javax.swing.JLabel();
        s = new javax.swing.JLabel();
        t = new javax.swing.JLabel();
        u = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        e = new javax.swing.JLabel();
        n = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        line = new studentmanager.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        managerText.setFont(new java.awt.Font("Segoe UI Black", 3, 120)); // NOI18N
        managerText.setForeground(new java.awt.Color(51, 51, 51));
        managerText.setText("MANAGER");
        panel2.add(managerText, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 690, 140));

        s.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 60)); // NOI18N
        s.setForeground(new java.awt.Color(51, 51, 51));
        s.setText("S");
        panel2.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 50, 90));

        t.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 60)); // NOI18N
        t.setForeground(new java.awt.Color(51, 51, 51));
        t.setText("T");
        panel2.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 50, 90));

        u.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 60)); // NOI18N
        u.setForeground(new java.awt.Color(51, 51, 51));
        u.setText("U");
        panel2.add(u, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 60, 90));

        d.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 60)); // NOI18N
        d.setForeground(new java.awt.Color(51, 51, 51));
        d.setText("D");
        panel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 60, 90));

        e.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 60)); // NOI18N
        e.setForeground(new java.awt.Color(51, 51, 51));
        e.setText("E");
        panel2.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 60, 90));

        n.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 60)); // NOI18N
        n.setForeground(new java.awt.Color(51, 51, 51));
        n.setText("N");
        panel2.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 60, 90));

        t1.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 60)); // NOI18N
        t1.setForeground(new java.awt.Color(51, 51, 51));
        t1.setText("T");
        panel2.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 60, 90));

        line.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout lineLayout = new javax.swing.GroupLayout(line);
        line.setLayout(lineLayout);
        lineLayout.setHorizontalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel2.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 430, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel d;
    private javax.swing.JLabel e;
    private studentmanager.Panel line;
    private javax.swing.JLabel managerText;
    private javax.swing.JLabel n;
    private studentmanager.Panel panel2;
    private javax.swing.JLabel s;
    private javax.swing.JLabel t;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel u;
    // End of variables declaration//GEN-END:variables
}
