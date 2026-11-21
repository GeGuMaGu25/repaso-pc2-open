package app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.converters;

import app.linear.platform.u202216448.planning.domain.model.valueobjects.TeamId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

/**
 * Converts team IDs between the domain model and persistence column values.
 * The UUID is stored as a string.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Converter(autoApply = false)
public class TeamIdPersistenceConverter implements AttributeConverter<TeamId, String> {

    @Override
    public String convertToDatabaseColumn(TeamId attribute) {
        return attribute == null ? null : attribute.value().toString();
    }

    @Override
    public TeamId convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new TeamId(UUID.fromString(dbData));
    }
}
