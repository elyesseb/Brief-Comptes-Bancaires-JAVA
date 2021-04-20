package comptebancaire.metier;

import java.util.List;

import comptebancaire.model.Compte;
import comptebancaire.model.Operation;

public interface BesoinsMetier {
    public void consultationCompte();
    public void deposer(Compte compte, Operation operation);
    public void retirer(Compte compte, Operation operation);
    //public void virement(int num_compte1, int num_compte2, float montant);
    public void listOperation();
}
