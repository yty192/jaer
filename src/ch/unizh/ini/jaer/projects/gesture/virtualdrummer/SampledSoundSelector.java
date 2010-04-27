/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DrumSelector.java
 *
 * Created on Apr 22, 2010, 3:54:35 PM
 */
package ch.unizh.ini.jaer.projects.gesture.virtualdrummer;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
/**
 * Controller for selection of sampled sound.
 * @author tobi
 */
public class SampledSoundSelector extends javax.swing.JPanel{
    private SampledSoundPlayer drumSound = null;
    static Logger log = Logger.getLogger("SampledSoundPlayer");
    private ArrayList<String> names;

    /** Creates new form DrumSelector.
     * @param player the DrumSound to control.
     */
    public SampledSoundSelector (SampledSoundPlayer player){
        drumSound = player;
        names = SampledSoundPlayer.getSoundFilePaths();
        ArrayList<String> displayNames = new ArrayList();
        for ( String n:names ){
            try{
                String sn = n.substring(n.lastIndexOf('/') + 1);
                displayNames.add(sn);
            } catch ( Exception e ){
                log.warning(e.toString());
            }
        }
        initComponents();
        instrCB.setModel(new DefaultComboBoxModel(displayNames.toArray()));
        instrCB.setSelectedIndex(player.getSoundNumber());
        TitledBorder b = (TitledBorder)getBorder();
        b.setTitle("Drum #" + player.getDrumNumber());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings ("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        instrCB = new javax.swing.JComboBox();
        playBut = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Drum sound");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${drumSound.program}"), instrCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        instrCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrCBActionPerformed(evt);
            }
        });

        playBut.setText("Play");
        playBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(playBut))
                    .addComponent(instrCB, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(instrCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playBut))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void instrCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrCBActionPerformed
        try{
            int ind = instrCB.getSelectedIndex();
            drumSound.setFile(ind);
            drumSound.play();
        } catch ( Exception e ){
            log.warning(e.toString());
        }
    }//GEN-LAST:event_instrCBActionPerformed

    private void playButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButActionPerformed
        if ( drumSound != null ){
            drumSound.play();
        }
    }//GEN-LAST:event_playButActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox instrCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton playBut;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
