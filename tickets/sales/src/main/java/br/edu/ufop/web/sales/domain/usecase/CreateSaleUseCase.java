package br.edu.ufop.web.sales.domain.usecase;

import br.edu.ufop.web.sales.domain.SaleDomain;
import br.edu.ufop.web.sales.exception.UseCaseException;
import org.springframework.stereotype.Component;

@Component
public class CreateSaleUseCase {

    private SaleDomain saleDomain;

    public void setSaleDomain(SaleDomain saleDomain) {
        this.saleDomain = saleDomain;
    }

    public void validate() {
        if (saleDomain.getUserId() == null) {
            throw new UseCaseException("User ID is required for a sale.");
        }

        if (saleDomain.getEvent() == null) {
            throw new UseCaseException("Event is required for a sale.");
        }
    }
}