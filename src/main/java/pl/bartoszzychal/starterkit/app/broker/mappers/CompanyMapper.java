package pl.bartoszzychal.starterkit.app.broker.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.bartoszzychal.starterkit.app.broker.mappers.IF.CompanyMapperIF;
import pl.bartoszzychal.starterkit.app.broker.model.entity.CompanyEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.CompanyTo;
import pl.bartoszzychal.starterkit.app.broker.repository.CompanyRepository;

@Component
public class CompanyMapper implements CompanyMapperIF {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyTo map(CompanyEntity companyEntity) {
		return new CompanyTo(companyEntity.getName());
	}

	public CompanyEntity map(CompanyTo companyTo) {
		return companyRepository.findOne(companyTo.getName());
	}

}
