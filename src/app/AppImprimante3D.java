package app;

import impression.FileAttente;
import impression.ListeSolides;
import solides.Solide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AppImprimante3D {

    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> listSolides;
    private FileAttente fileAttente;
    private ListeSolides solides;

    public AppImprimante3D() {
        fileAttente = new FileAttente();
        listModel = new DefaultListModel<>();
        solides = new ListeSolides();
        frame = new JFrame("Simulateur d'impression 3D et Exportateur STL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Layout
        frame.setLayout(new BorderLayout());

        // List for solids
        listSolides = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listSolides);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.SOUTH);

        // Load button
        JButton loadButton = new JButton("Charger CSV");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chargerSolides();
            }
        });
        panel.add(loadButton);

        // Print button
        JButton printButton = new JButton("Imprimer");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimer();
            }
        });
        panel.add(printButton);

        // Export button
        JButton exportButton = new JButton("Exporter STL");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exporterSTL();
            }
        });
        panel.add(exportButton);

        frame.setVisible(true);
    }

    private void chargerSolides() {
        JFileChooser fileChooser = new JFileChooser();
        if (solides.getSolides().size() > 0)
            JOptionPane.showMessageDialog(frame, "Un fichier a déjà été sélectionné. Impossible de sélectionner plus d'un fichier.");
        else {
            fileChooser.setDialogTitle("Sélectionner un fichier CSV");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV", "csv"));

            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    solides.chargerDepuisCSV(file);
                    // Ajouter chaque solide à la file d'attente et à la liste
                    for (Solide solide : solides.getSolides()) {
                        listModel.addElement(solide.toString());
                    }
                    // On trie les solides puis on remplit la file d'attente
                    solides.trier();
                    if (solides.getSolides().size() > 0) {
                        for (Solide s: solides.getSolides()) {
                            fileAttente.ajouterSolide(s);
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Solides chargés et ajoutés à la file d'attente.");

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "Erreur lors du chargement du fichier : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void imprimer() {
        if (fileAttente.estVide()) {
            JOptionPane.showMessageDialog(frame, "La file d'attente est vide. Ajoutez des solides à imprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!fileAttente.estVide()) {
                        Solide solide = fileAttente.retirerSolide();
                        if (solide != null) {
                            // Simulation de l'impression
                            System.out.println("Impression du solide : " + solide);
                            try {
                                Thread.sleep(1000); // Simuler un délai d'impression
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Impression terminée.");
                }
            }).start();
        }
    }

    private void exporterSTL() {
        try {
            solides.exporterTousSTL(ListeSolides.pathOut);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppImprimante3D();
            }
        });
    }
}
