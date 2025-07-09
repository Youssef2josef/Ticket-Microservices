package com.stageb2m.ticketservice.models;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Choix {
    reclamation("Reclamation"),
    tache("Tâche");

    private final String label;

    Choix(String label) {
        this.label = label;
    }


    public static Choix fromLabel(String label) {
        if (label == null) return reclamation; // valeur par défaut
        return Arrays.stream(Choix.values())
                .filter(c -> c.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElse(reclamation); // valeur par défaut si pas trouvé
    }
}
