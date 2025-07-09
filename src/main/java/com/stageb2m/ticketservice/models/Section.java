package com.stageb2m.ticketservice.models;

import java.util.Arrays;

public enum Section {
    developpement("Développement"),
    support("Support"),
    comptabilite("Comptabilité"),
    ressourcesHumaines("Ressources Humaines"),
    marketing("Marketing"),
    direction("Direction"),
    informatique("Informatique"),
    devOps("DevOps"),
    réseaux("Réseaux");
    private final String label;

    Section(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Section fromLabel(String label) {
        if (label == null) return support;
        return Arrays.stream(Section.values())
                .filter(s -> s.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElse(support);
    }
}