package app.linear.platform.u202216448.planning.infrastructure.persistence.jpa.converters;

import app.linear.platform.u202216448.planning.domain.model.valueobjects.CycleCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts cycle codes between the domain model and persistence column values.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Converter(autoApply = false)
public class CycleCodePersistenceConverter implements AttributeConverter<CycleCode, String> {

    @Override
    public String convertToDatabaseColumn(CycleCode attribute) {
        return attribute == null ? null : attribute.code();
    }

    @Override
    public CycleCode convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new CycleCode(dbData);
    }
}
