package com.fontys.logic.components;

        import com.fontys.dal.services.CompanyService;
        import lombok.Setter;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

@Component
public class CompanyComponent {
    @Setter
    private CompanyService service;

    public CompanyComponent() {
    }

    @Autowired
    public CompanyComponent(CompanyService service) {
        this.service = service;
    }
}
