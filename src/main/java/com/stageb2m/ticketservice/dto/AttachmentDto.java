package com.stageb2m.ticketservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AttachmentDto {

    private String filename;
    //Format de l'attachment : "pdf", "jpg", "png"...
    private String mimeType;
    //Format globale de l'attachment : "application/pdf", "image/jpeg", "image/png"...
    private String format;
}
