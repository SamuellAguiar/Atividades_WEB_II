package br.edu.ufop.web.sales.domain.usecase;

import br.edu.ufop.web.sales.domain.EventDomain;
import br.edu.ufop.web.sales.exception.UseCaseException;
import org.springframework.stereotype.Component;

@Component
public class CreateEventUseCase {

    private EventDomain eventDomain;

    public void setEventDomain(EventDomain eventDomain) {
        this.eventDomain = eventDomain;
    }

    public void validate() {
        if (eventDomain.getPrice() != null && eventDomain.getPrice() < 0) {
            throw new UseCaseException("Price cannot be negative.");
        }
        if (eventDomain.getDescription() == null || eventDomain.getDescription().isEmpty()) {
            throw new UseCaseException("Description is required.");
        }
    }
}