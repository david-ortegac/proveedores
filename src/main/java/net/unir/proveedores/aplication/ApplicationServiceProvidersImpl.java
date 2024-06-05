package net.unir.proveedores.aplication;

import net.unir.proveedores.adapter.restful.v1.mappers.AdapterProviderMapper;
import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.domain.ProvidersRepositoryDomain;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceProvidersImpl implements ApplicationServiceProvider {

    @Autowired
    private ProvidersRepositoryDomain repositoryDomain;

    @Autowired
    private AdapterProviderMapper mapper;

    @Override
    public ProviderDomainDTO getProvidersById(Long id) {
        return repositoryDomain.getById(id);
    }

    @Override
    public List<ProviderAdapterDTO> getAll() {
        return mapper.fromDomainToAdapterList(repositoryDomain.getAll());
    }

    @Override
    public Long getCountProviders() {
        return repositoryDomain.getProvidersCount();
    }
}
