package tp.banque;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class BanqueApp extends JFrame {
    private JList<String> numerosJList;
    private JLabel compteLabel, releveLabel;
    private JTextArea releveArea;

    private List<Compte> comptes;

    public BanqueApp(List<Compte> comptes) {
        this.comptes = comptes;
        setTitle("Application Bancaire");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Construction des éléments Swing
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Compte c : comptes) {
            listModel.addElement(String.valueOf(c.Getnuméro()));
        }

        numerosJList = new JList<>(listModel);
        compteLabel = new JLabel("Nom : - | Solde : -");
        releveLabel = new JLabel("Relevé des opérations");
        releveLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        releveArea = new JTextArea();
        releveArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        releveArea.setEditable(false);

        // Panels
        JScrollPane listScrollPane = new JScrollPane(numerosJList);
        JPanel comptePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        comptePane.add(compteLabel);

        JSplitPane northPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, comptePane);
        JSplitPane centerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, releveLabel, new JScrollPane(releveArea));

        getContentPane().add(northPane, BorderLayout.NORTH);
        getContentPane().add(centerPane, BorderLayout.CENTER);

        // Action listener sur la liste
        numerosJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = numerosJList.getSelectedIndex();
                if (index >= 0) {
                    Compte c = comptes.get(index);
                    compteLabel.setText("Nom : " + c.Getnom() + " | Solde : " + c.Getsolde());
                    releveLabel.setText("Relevé des opérations - " + c.typeDeCompte());
                    releveArea.setText(c.relevé());
                }
            }
        });
    }

    // Génération de comptes + opérations
    public static List<Compte> createSomeComptesBancaires() {
        List<Compte> comptes = List.of(
                new CompteCourant("Karim", 7000, 1000),
                new CompteEpargne("Nora", 6000, 0.05),
                new CompteCourant("Paul", 5000, 500),
                new CompteEpargne("Mohamed", 4000, 0.1),
                new CompteCourant("Virginie", 4000, 500)
        );

        Random rand = new Random();
        for (Compte c : comptes) {
            int nb = rand.nextInt(5) + 3;
            for (int i = 0; i < nb; i++) {
                int type = rand.nextBoolean() ? Opération.DEPOT : Opération.RETRAIT;
                double montant = 100 + rand.nextInt(1000);
                c.ajouterop(new Opération(type, montant, new Date()));
            }
        }
        return comptes;
    }
    public static void main(String[] args) {
        List<Compte> comptes = createSomeComptesBancaires();
        SwingUtilities.invokeLater(() -> {
            new BanqueApp(comptes).setVisible(true);
        });
    }
}