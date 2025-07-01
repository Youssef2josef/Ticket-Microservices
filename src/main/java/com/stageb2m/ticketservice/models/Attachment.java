package com.stageb2m.ticketservice.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    private String filename;
    // Format de l'attachment : "pdf", "jpg", "png"...
    private String format;
    // URL de l'attachment
    private byte[] content;
}