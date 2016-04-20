package pl.bartoszzychal.starterkit.app.broker.mappers.IF;

import pl.bartoszzychal.starterkit.app.broker.model.entity.CompanyEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.CompanyTo;

public interface CompanyMapperIF {
	 CompanyTo map(CompanyEntity companyEntity);
	 CompanyEntity map(CompanyTo companyTo);
}
