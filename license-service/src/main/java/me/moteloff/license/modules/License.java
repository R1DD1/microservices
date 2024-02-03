package me.moteloff.license.modules;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data @ToString
@Entity @Table(name="license")
public class License extends RepresentationModel<License> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String productName;
    private String licenseType;
    private String comment;

    public License withComment(String comment) {
        this.comment = comment;
        return this;
    }
}
