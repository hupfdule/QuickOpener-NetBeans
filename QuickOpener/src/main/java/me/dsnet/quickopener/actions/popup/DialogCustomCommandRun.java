/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.actions.popup;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import me.dsnet.quickopener.actions.RunCommand;
import org.netbeans.api.options.OptionsDisplayer;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 *
 * @author SessonaD
 */
@NbBundle.Messages("CTL_DialogCustomCommandRunPreview=")
public class DialogCustomCommandRun extends javax.swing.JDialog {

    public static final int CHARSNUMBER = 80;

    /**
     * Creates new form DialogCustomCommand
     */
    public DialogCustomCommandRun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        reinitModel();
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(400);
        jTable2.getColumnModel().getColumn(0).setMinWidth(100);
        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updatePreview();
            }

        });
        jTable2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    executeSelectedCommand();
                }
            }
        });
        //select first command if available
        updatePreview();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doClose();
            }
        });
    }

    private void executeSelectedCommand() {
        String selectedCommand = getSelectedCommand();
        if (null != selectedCommand) {
            boolean ok = new RunCommand(selectedCommand).actionPerformed();
            if (ok) {
                doClose();
            }
        }
    }

    private void updatePreview() {
        String command = getSelectedCommand();
        if (null != command) {
            lblPreviewCommand.setText(Bundle.CTL_DialogCustomCommandRunPreview() + new RunCommand(command).getCommandWithReplacedPlaceholders());
        } else {
            lblPreviewCommand.setText(Bundle.CTL_DialogCustomCommandRunPreview());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblPreviewCommand = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.title")); // NOI18N
        setIconImage(ImageUtilities.loadImage("me/dsnet/quickopener/icons/run.png"));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.cancelButton.text")); // NOI18N
        cancelButton.setFocusPainted(false);
        cancelButton.setRequestFocusEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.jTable2.columnModel.title0")); // NOI18N
            jTable2.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.jTable2.columnModel.title1")); // NOI18N
            jTable2.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.jTable2.columnModel.title2")); // NOI18N
            jTable2.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.jTable2.columnModel.title3")); // NOI18N
        }

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setLabelFor(jTable2);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.jLabel3.text")); // NOI18N
        jLabel3.setToolTipText(org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.jLabel3.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(DialogCustomCommandRun.class, "DialogCustomCommandRun.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPreviewCommand.setEditable(false);
        lblPreviewCommand.setBorder(null);
        jScrollPane2.setViewportView(lblPreviewCommand);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, jButton1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose();
    }//GEN-LAST:event_closeDialog

    public String getSelectedCommand() {
        final int thisrow = jTable2.getSelectedRow();
        if (-1 != thisrow) {
            final int row = jTable2.getRowSorter().convertRowIndexToModel(thisrow);
            String command = (String) jTable2.getModel().getValueAt(row, 1);
            return command;
        }
        return null;

    }

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 2) {
            executeSelectedCommand();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        OptionsDisplayer.getDefault().open("Advanced" + "/QuickOpener", true);
        reinitModel();
        jTable2.requestFocusInWindow();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void doClose() {
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogCustomCommandRun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DialogCustomCommandRun dialog = new DialogCustomCommandRun(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane lblPreviewCommand;
    // End of variables declaration//GEN-END:variables

    private void reinitModel() {
        jTable2.setModel(new PropertyTableModel("command"));

        //select first command if available
        if (jTable2.getModel().getRowCount() >= 1) {
            jTable2.changeSelection(0, 0, false, false);
        }
    }
}
