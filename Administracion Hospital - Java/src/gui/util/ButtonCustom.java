/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.util;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Jhandry
 */
public class ButtonCustom extends JButton {

    public ButtonCustom() {
        setBackground(new java.awt.Color(62, 63, 65));
        setForeground(Color.white);
        setFont(new java.awt.Font("Arial Black", 0, 14));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEntra(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseSale(evt);
            }
        });
    }
    
    private void mouseEntra(java.awt.event.MouseEvent evt) {                                      
        setBackground(new Color (44,41,24));
    }                                     

    private void mouseSale(java.awt.event.MouseEvent evt) {                                     
        setBackground(new Color (62,63,65));
    }
    
}
