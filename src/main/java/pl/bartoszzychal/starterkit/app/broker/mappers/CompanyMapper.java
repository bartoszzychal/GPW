package pl.bartoszzychal.starterkit.app.broker.mappers;

import java.util.Collection;
import java.util.stream.Collectors;

import pl.bartoszzychal.starterkit.app.broker.model.entity.CompanyEntity;
import pl.bartoszzychal.starterkit.app.broker.model.to.CompanyTo;

public class CompanyMapper {
	public static CompanyTo map(CompanyEntity companyEntity) {
		return new CompanyTo(companyEntity.getName());
	}

	public static CompanyEntity map(CompanyTo companyTo) {
		return new CompanyEntity(companyTo.getName());
	}

	public static Collection<CompanyEntity> map2Entity(Collection<CompanyTo> companyTos) {
		return companyTos.stream().map(CompanyMapper::map).collect(Collectors.toList());
	}

	public static Collection<CompanyTo> map2To(Collection<CompanyEntity> companyEntity) {
		return companyEntity.stream().map(CompanyMapper::map).collect(Collectors.toList());
	}
}
